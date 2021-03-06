package mystore.qa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Sarang
 * This class having the method used
 * to interact with elements on webpage
 */
public class ElementActions {
	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public ElementActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(this.driver, AppConstants.DEFAULT_EXPLICIT_TIME_OUT);
		action = new Actions(this.driver);
	}

	/**
	 * Method to initialize WebElement using
	 * By locator
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("some exception occurred while creating the webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}
	
	/**
	 * Method to initialize list of WebElement using
	 * By locator
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElementsList(By locator) {
		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
		} catch (Exception e) {
			System.out.println("some exception occurred while creating the list of webelement : " + locator);
			System.out.println(e.getMessage());
		}
		return element;
	}

	/**
	 * This method perform .click operation
	 * on the WebElement
	 * @param locator
	 */
	public void doClick(By locator) {
		try {
			getElement(locator).click();
		} catch (Exception e) {
			System.out.println("Some excetion occured while clicking on webelement :" + locator);
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * This method perform .click operation
	 * on the WebElement
	 * @param element
	 */
	public void doClickOnWebElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Some excetion occured while clicking on webelement :" + element);
			System.out.println(e.getMessage());
		}
		
	}

	/**
	 * This method perform .click operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doActionsClick(By locator) {
		try {
			action.click(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("Some excetion occured while clicking on webelement by actions :" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method perform .clear operation
	 * on the WebElement
	 * @param locator
	 */
	public void doClearTextBox(By locator) {
		try {
//			WebElement element = getElement(locator);
//			element.sendKeys(Keys.BACK_SPACE);
			getElement(locator).clear();
		} catch (Exception e) {
			System.out.println("Some excetion occured while sending the text in webelement :" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method perform .sendKeys operation
	 * on the WebElement
	 * @param locator
	 */
	public void doSendKeys(By locator, String value) {
		try {
			getElement(locator).sendKeys(value);
		} catch (Exception e) {
			System.out.println("Some excetion occured while sending the text in webelement :" + locator);
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method perform .sendKeys operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doActionsSendKeys(By locator, String value) {
		try {
			action.sendKeys(getElement(locator), value).build().perform();
		} catch (Exception e) {
			System.out.println("Some excetion occured while sending the text in webelement by actions :" + locator);
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * This method perform moveTo operation
	 * using actions class
	 * on the WebElement
	 * @param locator
	 */
	public void doMoveToElement(By locator){
		try {
			action.moveToElement(getElement(locator)).build().perform();
		} catch (Exception e) {
			System.out.println("Some excetion occured while moving the webelement by actions :" + locator);
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method check the WebElement is displayed
	 * on the WebPage and return boolean value
	 * @param locator
	 */
	public boolean doIsDisplayed(By locator) {
		boolean flag = false;
		try {
			flag = getElement(locator).isDisplayed();
		} catch (Exception e) {
			System.out.println("Some excetion occured while checking webelement is displayed :" + locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}

	/**
	 * This method check the WebElement is selected
	 * on the WebPage and return boolean value
	 * @param locator
	 */
	public boolean doIsSelected(By locator) {
		boolean flag = false;
		try {
			flag = getElement(locator).isSelected();
		} catch (Exception e) {
			System.out.println("Some excetion occured while checking webelement is selected :" + locator);
			System.out.println(e.getMessage());
		}
		return flag;
	}
	
	/**
	 * This method fetches the text on the WebElement
	 * and return in form of String
	 * @param locator
	 */
	public String doGetText(By locator) {
		String text = null;
		try {
			text = getElement(locator).getText();
		} catch (Exception e) {
			System.out.println("Some excetion occured while getting text of the webelement :" + locator);
			System.out.println(e.getMessage());
		}
		return text;
	}
	
	/**
	 * This method fetches the text of current url 
	 * on the webpage and return in form of String
	 * @param locator
	 */
	public String doGetcurrentURL() {
		String text = null;
		try {
			text = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println("Some excetion occured while getting current URL text");
			System.out.println(e.getMessage());
		}
		return text;
	}
	
	/**
	 * This method waits for the presenceOfElementLocated
	 * condition of the WebElement
	 * @param locator
	 */
	public void waitForElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * This method waits for the frameToBeAvailableAndSwitchToIt
	 * condition of the frame on the WebElement
	 * @param locator
	 */
	public void waitForFramePresentAndSwitchToIt(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}
	
	/**
	 * This method switch to the parent frame
	 */
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method switch to the default/main frame
	 */
	public void switchToDefaultMainFrame() {
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method waits for the visibilityOf
	 * condition of the WebElement
	 * @param locator
	 */
	public void waitForElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	/**
	 * This method waits for the elementToBeClickable
	 * condition of the WebElement
	 * @param locator
	 */
	public void waitForElementClickable(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * This method fetches the title of current webpage 
	 * and return in form of String
	 * @param locator
	 * @return String pageTitle
	 */
	public String doGetPageTitle(String title) { 
		String text = null;
		try {
			wait.until(ExpectedConditions.titleIs(title));
			text = driver.getTitle();
		} catch (Exception e) {
			System.out.println("Some excetion occured while getting title of page");
			System.out.println(e.getMessage());
		}
		return text;
	}
	
	/**
	 * This method fetches window handles available
	 * for the current situation on the browser
	 * @param driver
	 * @return listOfString
	 */
	public List<String> getWindowList(WebDriver driver)
	{
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		return windowHandlesList;
	}
	
	/**
	 * This method switches to the given window id
	 * in the parameter
	 * @param driver
	 * @param windowNumber
	 */
	public void switchToWindowId(WebDriver driver, int windowNumber)
	{
		List<String> windowList = getWindowList(driver);
		driver.switchTo().window(windowList.get(windowNumber));
	}
	
	/**
	 * This method returns the list of WebElement
	 * having a specific tag name given as paramater
	 * @param htmlTagName
	 * @param driver
	 * @return
	 */
	public List<WebElement> getTagCount(String htmlTagName, WebDriver driver)
	{
		List<WebElement> tagList = driver.findElements(By.tagName(htmlTagName));
		return tagList;
	}
	
	/**
	 * This method waits until the url having
	 * the string snippet using urlContains method
	 * @param titlesnippet
	 */
	public void waitForUrl(String titlesnippet)
	{
		wait.until(ExpectedConditions.urlContains(titlesnippet));
	}
	
	/**
	 * This method waits until the title of webpage having
	 * the string snippet using titleContains method
	 * @param titlesnippet
	 */
	public void waitForTitle(String titlesnippet)
	{
		wait.until(ExpectedConditions.titleContains(titlesnippet));
	}
	
	/**
	 * This method select the value from the dropdown
	 * @param locator
	 * @param value
	 * @param numericValueFromExcelSheet
	 */
	public void doSelectValueFromDropDown(By locator, String value, boolean numericValueFromExcelSheet)
	{
		if(numericValueFromExcelSheet)
		{
			String val = value.replace('.', '0');
			int intValue = Integer.parseInt(val);
			int actVal = (intValue/100);
			String convertedVal = String.valueOf(actVal);
			Select sel = new Select(getElement(locator));
			sel.selectByValue(convertedVal);
		}
		else if(numericValueFromExcelSheet)
		{
			Select sel = new Select(getElement(locator));
			sel.selectByValue(value);
		}
	}
	
	/**
	 * This method will select the visible text value from the
	 * dropdown
	 * @param locator
	 * @param value
	 */
	public void doSelectByVisibleText(By locator, String value)
	{
		Select sel = new Select(getElement(locator));
		sel.selectByVisibleText(value);
	}
	
	/**
	 * This method select value from drop down on the basis
	 * of value of the parameter
	 * @param locator
	 * @param value
	 */
	public void doSelectValueFromDropDown(By locator, String value)
	{
		Select sel = new Select(getElement(locator));
		switch (value.toLowerCase()) {
		case "january":
			sel.selectByIndex(1);
			break;
		case "february":
			sel.selectByIndex(2);
			break;
		case "march":
			sel.selectByIndex(3);
			break;
		case "april":
			sel.selectByIndex(4);
			break;
		case "may":
			sel.selectByIndex(5);
			break;
		case "june":
			sel.selectByIndex(6);
			break;
		case "july":
			sel.selectByIndex(7);
			break;
		case "august":
			sel.selectByIndex(8);
			break;
		case "september":
			sel.selectByIndex(9);
			break;
		case "october":
			sel.selectByIndex(10);
			break;
		case "november":
			sel.selectByIndex(11);
			break;
		case "december":
			sel.selectByIndex(12);
			break;

		default:
			break;
		}
	}
	
}

