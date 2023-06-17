package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
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
		verifyEquals(myAccountPage.isPageTitleByTextDisplayed())
		
	}
	@Test
	public void MyAccount_01_Change_Custome_Info() {
		log.info("MyAccount_01 Step 04: Select gender with value is Male");
		registerPage.clickToGenderMaleRadio();
		
		log.info("MyAccount_01 Step 05: Input FirstName to textbox with value is:" + editFirstName);
		registerPage.inputToTextboxByID(driver, "FirstName", editFirstName);
		
		log.info("MyAccount_01 Step 06: Input LastName to textbox with value is:" + editLastName);
		registerPage.inputToTextboxByID(driver, "LastName", editLastName);
		
		log.info("MyAccount_01 Step 07: Select Date of birthDay with value is:" + editDateOfBirthDay);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", editDateOfBirthDay);
		
		log.info("MyAccount_01 Step 07: Select Date of birth month with value is:" + editDateOfBirthMonth);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", editDateOfBirthMonth);
		
		log.info("MyAccount_01 Step 07: Select Date of birth year with value is:" + editDateOfBirthYear);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", editDateOfBirthYear);
		
		log.info("MyAccount_01 Step 08: Input email to textbox with value is:" + editEmail);
		registerPage.inputToTextboxByID(driver, "Email", editEmail);
		
		log.info("MyAccount_01 Step 09: Input Company to textbox with value is:" + editCompanyName);
		registerPage.inputToTextboxByID(driver, "Company", editCompanyName);
		
		log.info("MyAccount_01 Step 12: Click to Save button");
		registerPage.clickToButtonByTextName(driver, "Save");
		
		log.info("My_Account_01 - Step 10: Verify new First Name with value: " + editFirstName);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "FirstName"), editFirstName);
		
		log.info("My_Account_01 - Step 10: Verify new Last Name with value: " + editLastName);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "LastName"), editLastName);
		
		log.info("My_Account_01 - Step 10: Verify new date of birth day with value" + editDateOfBirthDay);
		verifyEquals(myAccountPage.getValueselectDropdownByName(driver, "DateOfBirthDay"), editDateOfBirthDay);
		
		log.info("My_Account_01 - Step 10: Verify new month of birth with value" + editDateOfBirthMonth);
		verifyEquals(myAccountPage.getValueselectDropdownByName(driver, "DateOfBirthMonth"),editDateOfBirthMonth);
		
		log.info("My_Account_01 - Step 10: Verify new month of birth with value" + editDateOfBirthYear);
		verifyEquals(myAccountPage.getValueselectDropdownByName(driver, "DateOfBirthYear"),editDateOfBirthYear);
		
		log.info("My_Account_01 - Step 10: Verify new Email with value: " + editEmail);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "Email"), editEmail);
		
		log.info("My_Account_01 - Step 10: Verify new Company with value: " + editCompanyName);
		verifyEquals(myAccountPage.getValueInUserTextboxByID(driver, "Company"), editCompanyName);
		
	}
	
	WebDriver driver;
	String emailAdress ,editFirstName,firstName,editEmail, lastName,editLastName,companyName, 
	userPassword,dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear ,editDateOfBirthDay, editDateOfBirthMonth,
	editCompanyName, editDateOfBirthYear, editUserPassword;
	HomePO homePage;
	DataUtil fakeData;
	RegisterPO registerPage;
	MyAccountPO myAccountPage;
	LoginPO loginPage;
	
}
