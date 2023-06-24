package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.AddressPO;
import pageObject.user.CustomerInforPO;
import pageObject.user.HomePO;
import pageObject.user.LoginPO;
import pageObject.user.MyAccountPO;
import pageObject.user.RegisterPO;
import pageObject.user.UserPageGeneratorManager;
import utilities.DataUtil;

public class User_03_MyAccount extends BaseTest{
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
		
		fakeData = DataUtil.getData();
		
		emailAdress = generateEmail();
		
		editEmail = fakeData.getEditEmailAddress();
		
		firstName = fakeData.getFirstName();
		
		editFirstName = fakeData.getEditFirstName();
		
		lastName = fakeData.getLastName();
		
		editLastName = fakeData.getEditLastName();
		
		dateOfBirthDay = "1";
		
		editDateOfBirthDay = "3";
		
		dateOfBirthMonth = "March";
		
		editDateOfBirthMonth = "Jun";
		
		dateOfBirthYear = "1989";
		
		editDateOfBirthYear = "1990";
		
		companyName = fakeData.getCompanyName();
		
		editCompanyName = fakeData.getEditCompanyName();
		
		userPassword = fakeData.getPassword();
		
		editUserPassword = fakeData.getEditPassword();
		
		country = fakeData.getCountry();
		
		state = fakeData.getState();
		
		city = fakeData.getCityName();
		
		log.info("Pre-condition Step 01: Open Home page");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition Step 02: Verify home page is displayed");
		verifyTrue(homePage.isHomePageSliderDispayed());
		
		log.info("Pre-condition Step 03: Navigate to Register page");
		homePage.clickToHeaderLink(driver, "register");
		registerPage = UserPageGeneratorManager.getRegisterPage(driver);
		
		log.info("Pre-condition Step 04: Select gender with value is Female");
		registerPage.clickToGenderFemaleRadio();
		
		log.info("Pre-condition Step 05: Input FirstName to textbox with value is:" + firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Pre-condition Step 06: Input LastName to textbox with value is:" + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Pre-condition Step 07: Select Date of birthDay with value is:" + dateOfBirthDay);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", dateOfBirthDay);
		
		log.info("Pre-condition Step 08: Select Date of birth month with value is:" + dateOfBirthMonth);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", dateOfBirthMonth);
		
		log.info("Pre-condition Step 09: Select Date of birth year with value is:" + dateOfBirthYear);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", dateOfBirthYear);
		
		log.info("Pre-condition Step 010: Input email to textbox with value is:" + emailAdress);
		registerPage.inputToTextboxByID(driver, "Email", emailAdress);
		
		log.info("Pre-condition Step 11: Input Company to textbox with value is:" + companyName);
		registerPage.inputToTextboxByID(driver, "Company", companyName);
		
		log.info("Pre-condition Step 12: Input Password to textbox with value is:" + userPassword);
		registerPage.inputToTextboxByID(driver, "Password", userPassword);
		
		log.info("Pre-condition Step 13: Input ConfirmPassword to textbox with value is:" + userPassword);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userPassword);
		
		log.info("Pre-condition Step 14: Click to Register button");
		registerPage.clickToButtonByTextName(driver, "Register");
		
		log.info("Pre-condition Step 15: Verify sucess register mesage is displayed");
		verifyTrue(registerPage.isRegisteredSucessMessageDisplayed());
		
//		log.info("Pre-condition Step 16: Click to log out link");
//		registerPage.clickToHeaderLink(driver, "logout");
//		homePage= UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition Step 17: Navigate to login page");
		homePage.clickToHeaderLink(driver, "login");
		loginPage = UserPageGeneratorManager.getLoginPage(driver);

		log.info("Pre-condition Step 18: Input email to textbox with value is:" + emailAdress);
		loginPage.inputToTextboxByID(driver, "Email", emailAdress);
		
		log.info("Pre-condition Step 19: Input Password to textbox with value is:" + userPassword);
		loginPage.inputToTextboxByID(driver, "Password", userPassword);
		
		log.info("Pre-condition Step 20: Navigate to home page");     
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition Step 21: Navigate to MyAccount page");
		homePage.clickToHeaderLink(driver, "account");
		myAccountPage = UserPageGeneratorManager.getMyAccountPage(driver);
		
		log.info("Pre-condition - Step 22: Verify My Account page displayed");
		verifyTrue(myAccountPage.isPageTitleByTextDisplayed(driver, "My account - Customer info"));
		
	}
	@Test
	public void MyAccount_01_Change_Custome_Info() {
		log.info("MyAccount_01 Step 01: Select gender with value is Male");
		registerPage.clickToGenderMaleRadio();
		
		log.info("MyAccount_01 Step 02: Input FirstName to textbox with value is:" + editFirstName);
		registerPage.inputToTextboxByID(driver, "FirstName", editFirstName);
		
		log.info("MyAccount_01 Step 03: Input LastName to textbox with value is:" + editLastName);
		registerPage.inputToTextboxByID(driver, "LastName", editLastName);
		
		log.info("MyAccount_01 Step 04: Select Date of birthDay with value is:" + editDateOfBirthDay);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", editDateOfBirthDay);
		
		log.info("MyAccount_01 Step 05: Select Date of birth month with value is:" + editDateOfBirthMonth);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", editDateOfBirthMonth);
		
		log.info("MyAccount_01 Step 06: Select Date of birth year with value is:" + editDateOfBirthYear);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", editDateOfBirthYear);
		
		log.info("MyAccount_01 Step 07: Input email to textbox with value is:" + editEmail);
		registerPage.inputToTextboxByID(driver, "Email", editEmail);
		
		log.info("MyAccount_01 Step 08: Input Company to textbox with value is:" + editCompanyName);
		registerPage.inputToTextboxByID(driver, "Company", editCompanyName);
		
		log.info("MyAccount_01 Step 9: Click to Save button");
		registerPage.clickToButtonByTextName(driver, "Save");
		
		log.info("My_Account_01 - Step 10: Verify new First Name with value: " + editFirstName);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "FirstName"), editFirstName);
		
		log.info("My_Account_01 - Step 11: Verify new Last Name with value: " + editLastName);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "LastName"), editLastName);
		
		log.info("My_Account_01 - Step 12: Verify new date of birth day with value" + editDateOfBirthDay);
		verifyEquals(myAccountPage.getValueselectDropdownByName(driver, "DateOfBirthDay"), editDateOfBirthDay);
		
		log.info("My_Account_01 - Step 13: Verify new month of birth with value" + editDateOfBirthMonth);
		verifyEquals(myAccountPage.getValueselectDropdownByName(driver, "DateOfBirthMonth"),editDateOfBirthMonth);
		
		log.info("My_Account_01 - Step 14: Verify new month of birth with value" + editDateOfBirthYear);
		verifyEquals(myAccountPage.getValueselectDropdownByName(driver, "DateOfBirthYear"),editDateOfBirthYear);
		
		log.info("My_Account_01 - Step 15: Verify new Email with value: " + editEmail);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "Email"), editEmail);
		
		log.info("My_Account_01 - Step 16: Verify new Company with value: " + editCompanyName);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "Company"), editCompanyName);
		
		
		
	}
	@Test 
	public void My_Account_02_Change_Customer_Address() {
		log.info("My_Account_02 - Step 01: Click to Addresses link at sidebar");
		myAccountPage.openSiderBarPageByName(driver, "Addresses");
		addressPage = UserPageGeneratorManager.getAddressPage(driver);
		
		log.info("My_Account_02 - Step 02: Verify My Address page displayed");
		verifyTrue(addressPage.isPageTitleByTextDisplayed(driver, "My account - Addresses"));

		log.info("My_Account_02 - Step 03: Click to Add New button");
		addressPage.clickToButtonByText(driver, "Add new");
		
		log.info("MyAccount_02 Step 04: Input FirstName to textbox with value is:" + editFirstName);
		addressPage.inputToTextboxByID(driver, "Address_FirstName", editFirstName);
		
		log.info("MyAccount_02 Step 05: Input LastName to textbox with value is:" + editLastName);
		addressPage.inputToTextboxByID(driver, "Address_LastName", editLastName);
		

		log.info("MyAccount_01 Step 06: Input email to textbox with value is:" + editEmail);
		addressPage.inputToTextboxByID(driver, "Address_Email", editEmail);
		
		log.info("MyAccount_01 Step 07: Input Company to textbox with value is:" + editCompanyName);
		addressPage.inputToTextboxByID(driver, "Address_Company", editCompanyName);
		

		log.info("My_Account_02 - Step 08: Select option in Country dropdown in My address page with value: " + country);
		addressPage.selectDropdownByName(driver, "Address.CountryId", country);

		log.info("My_Account_02 - Step 09: Select option in State dropdown in My address page with value: " + state);
		addressPage.selectDropdownByName(driver, "Address.StateProvinceId", state);

		log.info("My_Account_02 - Step 10: Enter to City textbox in My address page with value: " + city);
		addressPage.inputToTextboxByID(driver, "Address_City", city);
		
		log.info("My_Account_02 - Step 11: Enter to  Address 1  textbox in My address page with value: " + firstAddress);
		addressPage.inputToTextboxByID(driver, "Address_Address1", firstAddress);
		
		log.info("My_Account_02 - Step 12: Enter to Address 2 textbox in My address page with value: " + secondAddress);
		addressPage.inputToTextboxByID(driver, "Address_Address2", secondAddress);
		
		log.info("My_Account_02 - Step 13: Enter to Postal Code textbox in My address page with value: " + zipCode);
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", zipCode);
		
		log.info("My_Account_02 - Step 14: Enter to Phone Number textbox in My address page with value: " + phoneNumber);
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);
		
		log.info("My_Account_02 - Step 15: Enter to Fax Number textbox in My address page with value: " + faxNumber);
		addressPage.inputToTextboxByID(driver, "Address_FaxNumber", faxNumber);
		
		log.info("MyAccount_02 Step 16: Click to Save button");
		addressPage.clickToButtonByTextName(driver, "Save");
		
		log.info("My_Account_02 - Step 17: Verify new infor added successfully");
		verifyTrue(addressPage.isInforDisplayedByName(driver, "name", editFirstName));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "email", editEmail));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "phone", phoneNumber));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "fax", faxNumber));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "company", editCompanyName));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "address1", firstAddress));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "address2", secondAddress));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "city-state-zip", city + ", " + state + ", " + zipCode));
		verifyTrue(addressPage.isInforDisplayedByName(driver, "country", country));
		
		
		
		
		
		
		
	}
	
	
	WebDriver driver;
	String emailAdress ,editFirstName,firstName,editEmail, lastName,editLastName,companyName, 
	userPassword,dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear ,editDateOfBirthDay, editDateOfBirthMonth,
	editCompanyName, editDateOfBirthYear, editUserPassword, country, state, city, firstAddress, secondAddress,zipCode,
	phoneNumber, faxNumber;
	HomePO homePage;
	DataUtil fakeData;
	RegisterPO registerPage;
	MyAccountPO myAccountPage;
	LoginPO loginPage;
	
	AddressPO addressPage;
	
}
