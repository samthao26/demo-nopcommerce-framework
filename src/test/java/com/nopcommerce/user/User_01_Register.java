package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.user.HomePO;
import pageObject.user.RegisterPO;
import pageObject.user.UserPageGeneratorManager;
import utilities.DataUtil;

public class User_01_Register extends BaseTest {
	
@Parameters({"browser", "appUrl"})
@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
	driver = getBrowserDriver(browserName, appUrl);
	fakeData = DataUtil.getData();
	emailAdress = fakeData.getEmailAddress();
	invalidEmailAddress = "1234@asdf#!";
	firstName = "Andrea";
	lastName = "Hull";
	companyName = "Automation Group";
	userPassword = fakeData.getPassword();
	less6Password = "1";
	
	log.info("Pre-condition - Step 01: Open Home page");
	homePage = UserPageGeneratorManager.getHomePage(driver);
	
	log.info("Pre-condition - Step 02: Verify Home page is displayed");
	Assert.assertTrue(homePage.isHomePageSliderDispayed());
	log.info("Pre-condition - Step 03: Click to Register link");
	homePage.clickToHeaderLink(driver, "register");
	registerPage= UserPageGeneratorManager.getRegisterPage(driver);
	
}
@Test
public void Register_01_Register_With_Empty_Data() {
	log.info("Register_01 - Step01: Click to Register button");
	registerPage.clickToButtonByTextName(driver,"Register" );
	
	log.info("Register_01 - Step 02: Verify error message displayed at all required fields");
	verifyEquals(registerPage.getErrorMessageByFieldName("FirstName"), "First name is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("LastName"), "Last name is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("Email"), "Email is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("Password"), "Password is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("ConfirmPassword"), "Password is required.");
	
}
@Test
public void Register_02_Register_With_Invalid_Email() {
	log.info("Register_02 -Step01: Refresh page");
	registerPage.refreshCurrentPage(driver);
	
	log.info("Register_02 - Step02: Enter to Email textbox with value: " + invalidEmailAddress);
	registerPage.inputToTextboxByID(driver,"Email",invalidEmailAddress);
	
	log.info("Register_02 - Step 03: Click to Register button");
	registerPage.clickToButtonByTextName(driver, "Register");
	
	log.info("Register_02 - Step 04: Verify error message 'Wrong email' displayed at field Email");
	verifyEquals(registerPage.getErrorMessageByFieldName("Email"), "Wrong email");
}
@Test
public void Register_03_Register_With_Password_Less_Than_Six_Character() {
	
	log.info("Register_03 - Step 02: Enter to Password textbox with value:" + less6Password );
	registerPage.inputToTextboxByID(driver, "Password", less6Password);
	
	log.info("Register_03 - Step 04: Click to Register button");
	registerPage.clickToButtonByTextName(driver, "Register");
	
	log.info("Register_03 - Step 05: Verify displayed error message: 'Password must meet the following rules: must have at least 6 characters'");
	verifyEquals(registerPage.getErrorMessageByFieldName("Password"), "Password must meet the following rules:\nmust have at least 6 characters");
}
@Test
public void Register_04_Register_With_Comfirm_Password_Not_Match() {
	log.info("Register_04 -Step01: Refresh page");
	registerPage.refreshCurrentPage(driver);
	
	log.info("Register_04 - Step 02: Enter to Password textbox with value: " + userPassword);
	registerPage.inputToTextboxByID(driver,"Password",userPassword);
	
	log.info("Register_04 - Step 03: Enter to Confrim Password textbox with value: 3456789 ");
	registerPage.inputToTextboxByID(driver,"ConfirmPassword", "3456789");
	
	log.info("Register_04 - Step 04: Click to Register button");
	registerPage.clickToButtonByTextName(driver, "Register");
	
	log.info("Register_04 - Step 04: Verify displayed errorr message: ''The password and confirmation password do not match.'");
	verifyEquals(registerPage.getErrorMessageByFieldName("ConfirmPassword"), "The password and confirmation password do not match.");
}
@Test
public void Register_05_Register_With_Valid_Data() {
	log.info("Register_05 - Step01: Refresh page");
	registerPage.refreshCurrentPage(driver);
	
	log.info("Register_05 - Step02: Click to female gender");
	registerPage.clickToGenderFemaleRadio();
	
	log.info("Register_05 - Step03: Enter to firstName textbox with value: " + firstName);
	registerPage.inputToTextboxByID(driver,"FirstName",firstName);
	
	log.info("Register_05 - Step04: Enter to lastName textbox with value: " + lastName);
	registerPage.inputToTextboxByID(driver,"LastName",lastName);
	
	log.info("Register_05 - Step05: Select to Date Of Birth Day with value: 1 " );
	registerPage.selectDropdownByName(driver,"DateOfBirthDay","1");
	
	log.info("Register_05 - Step06: Select to Date Of Birth Month with value: March " );
	registerPage.selectDropdownByName(driver,"DateOfBirthMonth","March");
	
	log.info("Register_05 - Step07: Select to Date Of Birth Year with value:1989 " );
	registerPage.selectDropdownByName(driver,"DateOfBirthYear","1989");
	
	log.info("Register_05 - Step08: Enter to Email textbox with value: " + emailAdress);
	registerPage.inputToTextboxByID(driver,"Email",emailAdress);
	
	log.info("Register_05 - Step 09: Enter to companyName textbox with value: " + companyName);
	registerPage.inputToTextboxByID(driver,"Company",companyName);
	
	log.info("Register_05 - Step 10: Enter to Password textbox with value: " + userPassword);
	registerPage.inputToTextboxByID(driver,"Password",userPassword);
	
	log.info("Register_05 - Step 11: Enter to Confrim Password textbox with value:" + userPassword);
	registerPage.inputToTextboxByID(driver,"ConfirmPassword", userPassword);
	
	log.info("Register_05 - Step 12: Click to Register button");
	registerPage.clickToButtonByTextName(driver, "Register");
	
	log.info("Register_05 - Step 13: Verify displayed sucess message: 'Your registration completed'");
	verifyTrue(registerPage.isRegisteredSucessMessageDisplayed());
}
@Test
public void Register_06_Register_With_Existing_Email() {
	log.info("Register_06 - Step 1: Click to contiune button");
	registerPage.ClickToContinueButton();
	homePage= UserPageGeneratorManager.getHomePage(driver);

	log.info("Register_06 - Step 2: Verify HomePage slider displayed");
	verifyTrue(homePage.isHomePageSliderDispayed());
	
	//log.info("Register_03 - Step 09: Click to Logout link");
//	registerPage.clickToHeaderLink(driver, "logout");
//	homePage = UserPageGeneratorManager.getHomePage(driver);

	log.info("Register_06 - Step 3: Click to Register link");
	homePage.clickToHeaderLink(driver, "register");
	registerPage= UserPageGeneratorManager.getRegisterPage(driver);

	log.info("Register_06 - Step04: Enter to firstName textbox with value: " + firstName);
	registerPage.inputToTextboxByID(driver,"FirstName",firstName);
	
	log.info("Register_06 - Step05: Enter to lastName textbox with value: " + lastName);
	registerPage.inputToTextboxByID(driver,"LastName",lastName);
	
	log.info("Register_06 - Step06: Enter to Email textbox with value: " + emailAdress);
	registerPage.inputToTextboxByID(driver,"Email",emailAdress);
	
	log.info("Register_06 - Step 07: Enter to Password textbox with value: " + userPassword);
	registerPage.inputToTextboxByID(driver,"Password",userPassword);
	
	log.info("Register_06 - Step 08: Enter to Confrim Password textbox with value:" + userPassword);
	registerPage.inputToTextboxByID(driver,"ConfirmPassword", userPassword);
	
	log.info("Register_06 - Step 09: Click to Register button");
	registerPage.clickToButtonByTextName(driver, "Register");
	
	log.info("Register_06 - Step 10: Verify displayed errorr message: 'The specified email already exists'");
	verifyTrue(registerPage.isErrorMessageForExistingEmailDisplayed());
}



WebDriver driver;
String projectPath = System.getProperty("user.dir");
String emailAdress, firstName, lastName, companyName, userPassword,less6Password,invalidEmailAddress;
HomePO homePage; 
DataUtil fakeData;
RegisterPO registerPage;
	
}

  
