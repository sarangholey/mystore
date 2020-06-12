package mystore.qa.pages;

import java.util.ArrayList;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import mystore.qa.util.CommonUtil;
import mystore.qa.util.ElementActions;
import mystore.qa.util.JavaScriptUtil;

/**
 * 
 * @author Sarang
 *
 */
public class LandingPage {

	WebDriver driver;
	Properties prop;
	ElementActions elementActions;
	JavaScriptUtil javaScriptUtil;

	// constructor
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
		javaScriptUtil = new JavaScriptUtil(this.driver);
	}

	// Page Objects
	By signInLinkButton = By.xpath("//a[@title='Log in to your customer account']");

	By emailIdTextBox = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");
	By errorMessage = By.xpath("//div[@id='create_account_error']//li");

	By urPersonalInfoText = By.xpath("//form[@id='account-creation_form']//h3[contains(text(),'Your personal information')]");
	By maleGenderButton = By.id("id_gender1");
	By femaleGenderButton = By.id("id_gender2");
	By custfirstNameTextBox = By.id("customer_firstname");
	By custlastNameTextBox = By.id("customer_lastname");
	By emailTextBox = By.id("email");
	By passwordTextBox = By.id("passwd");
	By daysDropDown = By.id("days");
	By monthsDropDown = By.id("months");
	By yearsDropDown = By.id("years");
	By firstNameTextBox = By.id("firstname");
	By lastNameTextBox = By.id("lastname");
	By companyNameTextBox = By.id("company");
	By address1TextBox = By.id("address1");
	By address2TextBox = By.id("address2");
	By cityTextBox = By.id("city");
	By stateDropDown = By.id("id_state");
	By zipCodeTextBox = By.id("postcode");
	By additionalInfoTextBox = By.id("other");
	By homePhoneTextBox = By.id("phone");
	By mobileNumberTextBox = By.id("phone_mobile");
	By formSubmitButton = By.id("submitAccount");

	By usersNameText = By.xpath("//a[@title='View my customer account']/span");
	By signOutLinkButton = By.xpath("//a[contains(text(),'Sign out')]");

	By loginUsernameField = By.id("email");
	By loginPasswordField = By.id("passwd");
	By signInButton = By.id("SubmitLogin");

	By womanSection = By.xpath("//a[contains(@title,'Women')]");
	By tshirtLinkText = By.xpath("(//li/a[contains(@title,'T-shirts')])[1]");
	By tshirtImage = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/img");
	By quickViewIconText = By.xpath("//div[@class='product-image-container']//span[contains(text(),'Quick view')]");
	By productDetailsFrame = By.xpath("//iframe[contains(@id,'fancybox')]");
	By productQuantityInc = By.xpath("//p[@id='quantity_wanted_p']//i[@class='icon-plus']");
	By addToCartButton = By.xpath("//button[@name='Submit']/span");

	By addedProductTotalCost = By.xpath("//div/span[@class='ajax_block_cart_total']");
	By proceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");

	By summaryPageTotal = By.xpath("//span[@id='total_price']");

	By proceedToCheckoutSummary = By.xpath("//a[@title='Proceed to checkout']/span[text()='Proceed to checkout']");
	By proceedToCheckoutAddress = By.xpath("//button[@name='processAddress']");

	By iAgreeCheckBox = By.xpath("//div[@id='uniform-cgv']//input[@id='cgv']");
	By proceedToCheckoutShipping = By.xpath("//button[@name='processCarrier']");

	By payByBankWireButton = By.xpath("//a[@title='Pay by bank wire']");

	By iConfirmMyOrderButton = By.xpath("//button[@type='submit']/span[contains(text(),'I confirm my order')]");

	By orderConfermationText = By.xpath("//div[@id='center_column']/h1[contains(text(),'Order confirmation')]");
	By orderConfirmPrice = By.xpath("//div[@id='center_column']/div[@class='box']/span/strong");
	By orderReferenceNumberBulkText = By.xpath("//div[@id='center_column']/div[@class='box']");

	By userNameButton = By.xpath("//a[@title='View my customer account']");

	By orderHistoryButton = By.xpath("//a[@title='Orders']");

	By recentOrderNumber = By.xpath("//tr[@class='first_item ']//a");


	// Page Methods

	/**
	 * This method creates user with following parameters
	 * @param newEmailID
	 * @param userGender
	 * @param custfirstName
	 * @param custlastName
	 * @param password
	 * @param dayValue
	 * @param monthValue
	 * @param yearValue
	 * @param firstName
	 * @param lastName
	 * @param companyName
	 * @param address1
	 * @param address2
	 * @param cityName
	 * @param stateName
	 * @param zipCodeNumber
	 * @param aditionalInfo
	 * @param homePhoneNumber
	 * @param mobileNumber
	 * @return new users name
	 */
	public String createAcount(String newEmailID, String userGender, String custfirstName, String custlastName, String password, String dayValue,
			String monthValue, String yearValue, String firstName, String lastName, String companyName, String address1, String address2,
			String cityName, String stateName, String zipCodeNumber, String aditionalInfo, String homePhoneNumber, String mobileNumber)
	{
		// Create An Account Page
		elementActions.waitForElementClickable(signInLinkButton);
		elementActions.doClick(signInLinkButton);
		elementActions.waitForElementVisible(emailIdTextBox);
		elementActions.doSendKeys(emailIdTextBox, newEmailID);
		elementActions.doClick(createAccountButton);

		// Personal Information Page
		if(userGender.contains("male"))
		{
			elementActions.waitForElementClickable(maleGenderButton);
			elementActions.doClick(maleGenderButton);
		}
		else if (userGender.contains("female")) {
			elementActions.waitForElementClickable(femaleGenderButton);
			elementActions.doClick(femaleGenderButton);
		}
		else {
			System.out.println("please provide correct gender");
		}
		elementActions.doSendKeys(custfirstNameTextBox, custfirstName);
		elementActions.doSendKeys(custlastNameTextBox, custlastName);
		elementActions.doSendKeys(passwordTextBox, password);
		elementActions.doSelectValueFromDropDown(daysDropDown, dayValue, true);
		elementActions.doSelectValueFromDropDown(monthsDropDown, monthValue);
		elementActions.doSelectValueFromDropDown(yearsDropDown, yearValue, true);
		elementActions.doSendKeys(firstNameTextBox, firstName);
		elementActions.doSendKeys(lastNameTextBox, lastName);
		elementActions.doSendKeys(companyNameTextBox, companyName);
		elementActions.doSendKeys(address1TextBox, address1);
		elementActions.doSendKeys(address2TextBox, address2);
		elementActions.doSendKeys(cityTextBox, cityName);
		elementActions.doSelectByVisibleText(stateDropDown, stateName);
		elementActions.doSendKeys(zipCodeTextBox, zipCodeNumber);
		elementActions.doSendKeys(additionalInfoTextBox, aditionalInfo);
		elementActions.doSendKeys(homePhoneTextBox, homePhoneNumber);
		elementActions.doSendKeys(mobileNumberTextBox, mobileNumber);
		elementActions.doClick(formSubmitButton);

		elementActions.waitForElementVisible(usersNameText);
		String newUsersName = elementActions.doGetText(usersNameText);
		elementActions.doClick(signOutLinkButton);
		return newUsersName;
	}

	
	/**
	 * This method login the user to the application
	 * @param username
	 * @param password
	 */
	public void loginToAccount(String username, String password)
	{
		elementActions.waitForElementClickable(signInLinkButton);
		elementActions.doClick(signInLinkButton);
		elementActions.doSendKeys(loginUsernameField, username);
		elementActions.doSendKeys(loginPasswordField, password);
		elementActions.doClick(signInButton);	
	}

	/**
	 * This method purchase a product with desired quantity and validate the reference number
	 * for the placed order is same with the number of latest order in the order history section
	 * @param quantity
	 * @return
	 */
	public boolean purchaseProductFromWomanSection(String quantity)
	{
		elementActions.waitForElementClickable(womanSection);
		elementActions.doMoveToElement(womanSection);
		elementActions.doActionsClick(tshirtLinkText);
		elementActions.doMoveToElement(tshirtImage);
		elementActions.doMoveToElement(quickViewIconText);
		elementActions.doActionsClick(quickViewIconText);
		elementActions.waitForFramePresentAndSwitchToIt(productDetailsFrame);
		elementActions.waitForElementClickable(productQuantityInc);
		for (int i = 0; i < (Integer.parseInt(quantity)-1); i++) {
			elementActions.doClick(productQuantityInc);
		}
		elementActions.doClick(addToCartButton);
		elementActions.switchToParentFrame();
		elementActions.waitForElementVisible(addedProductTotalCost);
		ArrayList<String> values= new ArrayList<String>();
		String totalProductCost = elementActions.doGetText(addedProductTotalCost);
		System.out.println("After adding products cost on popup :- "+ totalProductCost);
		values.add(totalProductCost);
		elementActions.doClick(proceedToCheckout);
		System.out.println("Total Product cost on summary page is :- "+ elementActions.doGetText(summaryPageTotal));
		values.add(elementActions.doGetText(summaryPageTotal));
		if(values.get(0).equals(values.get(1)))
		{
			elementActions.doClick(proceedToCheckoutSummary);
		}
		else {
			try {
				throw new Exception("Product price not match on summary & checkout page");
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}
		elementActions.waitForElementClickable(proceedToCheckoutAddress);
		elementActions.doClick(proceedToCheckoutAddress);

		elementActions.waitForElementClickable(proceedToCheckoutShipping);
		javaScriptUtil.clickElementByJS(elementActions.getElement(iAgreeCheckBox));
		elementActions.doClick(proceedToCheckoutShipping);

		elementActions.waitForElementClickable(payByBankWireButton);
		elementActions.doClick(payByBankWireButton);

		elementActions.waitForElementClickable(iConfirmMyOrderButton);
		elementActions.doClick(iConfirmMyOrderButton);


		elementActions.waitForElementVisible(orderConfermationText);
		System.out.println("Final Page price displayed as :- "+elementActions.doGetText(orderConfirmPrice));

		String orderRefNum = elementActions.doGetText(orderReferenceNumberBulkText);
		System.out.println("Order ref no :- " + (orderRefNum.substring(216, 225)));
		String refNumFinalPage = orderRefNum.substring(216, 225);
		System.out.println("Order ref no contains characters :- " + (refNumFinalPage));

		elementActions.doClick(userNameButton);

		elementActions.waitForElementClickable(orderHistoryButton);
		elementActions.doClick(orderHistoryButton);

		elementActions.waitForElementVisible(recentOrderNumber);
		String latestOrderNumber = elementActions.doGetText(recentOrderNumber);
		System.out.println("Lastest order number in \"Order Histroy\" section is :- " + latestOrderNumber);
		System.out.println("Lastest order number in \"Order Histroy\" section contains characters :- " + (latestOrderNumber.length()));

//		ArrayList<String> orderReferenceNoList = new ArrayList<String>();
//		orderReferenceNoList.add(orderRefNum);
//		orderReferenceNoList.add(latestOrderNumber);
		
//		return orderReferenceNoList;
		// validating order reference no from order confirmation page with recent order history table
		if (refNumFinalPage.equals(latestOrderNumber)) {
			return true;
		}
		else {
			return false;
		}

	}

}
