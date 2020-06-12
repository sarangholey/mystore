package mystore.qa.tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import mystore.qa.base.BasePage;
import mystore.qa.pages.LandingPage;
import mystore.qa.util.ExcelUtil;

/**
 * 
 * @author Sarang
 * 
 */
public class LandingPageTest {

private static Logger logger = LogManager.getLogger(LandingPageTest.class);
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LandingPage landingPage;
	SoftAssert softassert;
	
	@BeforeMethod
	public void setupLandingPageTest()
	{
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		landingPage = new LandingPage(driver);
		softassert = new SoftAssert();
	}
	
	@Test(dataProvider = "UserData", priority = 1)
	public void createAcountTest(String newEmailID, String userGender, String custfirstName, String custlastName, String password, String dayValue,
			String monthValue, String yearValue, String firstName, String lastName, String companyName, String address1, String address2,
			String cityName, String stateName, String zipCodeNumber, String aditionalInfo, String homePhoneNumber, String mobileNumber)
	{
		logger.info("createAcountTest Started");
		String createdUsersName = landingPage.createAcount(newEmailID, userGender, custfirstName, custlastName, password, dayValue, monthValue, yearValue, firstName, lastName, companyName, address1, address2, cityName, stateName, zipCodeNumber, aditionalInfo, homePhoneNumber, mobileNumber);
		Assert.assertEquals(createdUsersName, (custfirstName + " " + custlastName));
		logger.info("createAcountTest Passed");
	}
	
	//@Test(dataProvider = "UserCredentials", dependsOnMethods = "createAcountTest", priority = 2)
	@Test(dataProvider = "UserCredentials", priority = 2)
	public void orderConfiramtionTest(String username, String password)
	{
		logger.info("orderConfiramtionTest Started");
		landingPage.loginToAccount(username, password);
		boolean actualvalue = landingPage.purchaseProductFromWomanSection("2");
		Assert.assertEquals(actualvalue, true, "The order numbers failed to match from final order confirmation page with order history page");
		logger.info("orderConfiramtionTest Passed");
	}
		
	@DataProvider
	public Object[][] UserData()
	{
		Object[][] userData = ExcelUtil.getTestData("newuserinfo");
		return userData;
	}

	@DataProvider
	public Object[][] UserCredentials()
	{
		Object[][] userData = ExcelUtil.getTestData("usercredentials");
		return userData;
	}
	
	
	@AfterMethod
	public void tearDownLandingPageTest()
	{
		driver.quit();
	}
	
}
