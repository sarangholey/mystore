package mystore.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
/**
 * @author Sarang
 *	This class holding up
 *	Browser and Properties file initialization
 *	Code with take screenshot method
 */
public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
	
	/**
	 * @author Sarang
	 * This method is for WebDriver initialization
	 * with different browser configurations
	 * @return
	 */
	public WebDriver init_driver(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		System.out.println("Running on ----> " + browserName + " browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			if(prop.getProperty("headless").equalsIgnoreCase("yes"))
			{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
			}
			else {
				tlDriver.set(new ChromeDriver());
			}
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{	
			if(prop.getProperty("headless").equalsIgnoreCase("yes"))
			{
				FirefoxOptions fb = new FirefoxOptions();
				fb.addArguments("--headless");
				tlDriver.set(new FirefoxDriver(fb));
			}
			else {
				tlDriver.set(new FirefoxDriver());
			}
			
		}
		else {
			System.out.println(browserName + " is not found, please pass browser name as chrome or firefox");
		}
		
		if(prop.getProperty("maximize").equals("yes")) {
			getDriver().manage().window().maximize();
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("ImplicitWait")), TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("PageLoadTimeout")), TimeUnit.SECONDS);
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	
	/**
	 * @author Sarang
	 * This method returns a properties class object
	 * with initialized config.properties file 
	 * @return
	 */
	public Properties init_prop()
	{
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("Config.properties file not found please give correct path");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException occured while loading the config.properties file");
			e.printStackTrace();
		}
		
		return prop;
	}
		
	/**
	 * @author Sarang
	 * This method takes screenshot and returns 
	 * the path of the captured file
	 */
	public String getScreenshot() {
		
		final String OUTPUT_FOLDER = System.getProperty("user.dir") + "/screenshots/";
		
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		Path pathofFolder = Paths.get(OUTPUT_FOLDER);
		// if directory exists?
		if (!Files.exists(pathofFolder)) {
			try {
				Files.createDirectories(pathofFolder);
			} catch (IOException e) {
				// fail to create directory
				e.printStackTrace();
			}
		}
		File destination = new File(path);

		try {
			
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
		
}

