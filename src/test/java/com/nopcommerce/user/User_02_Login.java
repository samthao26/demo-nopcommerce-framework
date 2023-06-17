package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import PageUIs.user.UserBasePageUI;
import commons.BaseTest;
import pageObject.user.HomePO;
import pageObject.user.LoginPO;
import pageObject.user.RegisterPO;
import pageObject.user.UserPageGeneratorManager;
import utilities.DataUtil;

public class User_02_Login extends BaseTest {
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		fakeData = DataUtil.getData();
		
		emailAdress = fakeData.getEmailAddress();
		invalidEmailAddress = "1234@asdf#!";
		notRegisteredEmail = "abc" + generateFakeNumber() + ".com";
		firstName = "Andrea";
		lastName = "Hull";
		dateOfBirthDay = "1";
		dateOfBirthMonth = "March";
		dateOfBirthYear = "1989";
		companyName = fakeData.getCompanyName();
		userPassword = fakeData.getPassword();
		inCorrectPassword = "123456";
		
		log.info("Pre-condition - Step 01: Open Home page");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition - Step 02: Verify Home page is displayed");
		Assert.assertTrue(homePage.isHomePageSliderDispayed());
		
		log.info("Pre-condition - Step 03: Click to Register link");
		homePage.clickToHeaderLink(driver, "register");
		registerPage= UserPageGeneratorManager.getRegisterPage(driver);
		
		log.info("Pre-condition -Step02: Click to female gender");
		registerPage.clickToGenderFemaleRadio();
		
		log.info("Pre-condition - Step03: Enter to firstName textbox with value: " + firstName);
		registerPage.inputToTextboxByID(driver,"FirstName",firstName);
		
		log.info("Pre-condition - Step04: Enter to lastName textbox with value: " + lastName);
		registerPage.inputToTextboxByID(driver,"LastName",lastName);
		
		log.info("Pre-condition - Step05: Select to Date Of Birth Day with value: " + dateOfBirthDay );
		registerPage.selectDropdownByName(driver,"DateOfBirthDay", dateOfBirthDay);
		
		log.info("Pre-condition - Step06: Select to Date Of Birth Month with value: " + dateOfBirthMonth );
		registerPage.selectDropdownByName(driver,"DateOfBirthMonth",dateOfBirthMonth);
		
		log.info("Pre-condition - Step07: Select to Date Of Birth Year with value: " + dateOfBirthYear );
		registerPage.selectDropdownByName(driver,"DateOfBirthYear", dateOfBirthYear);
		
		log.info("Pre-condition - Step08: Enter to Email textbox with value: " + emailAdress);
		registerPage.inputToTextboxByID(driver, "Email", emailAdress);
		
		log.info("Pre-condition - Step 09: Enter to company name textbox with value: " + companyName);
		registerPage.inputToTextboxByID(driver,"Company",companyName);
		
		log.info("Pre-condition - Step 10: Enter to Password textbox with value: " + userPassword);
		registerPage.inputToTextboxByID(driver,"Password",userPassword);
		
		log.info("Pre-condition - Step 11: Enter to Confrim Password textbox with value:" + userPassword);
		registerPage.inputToTextboxByID(driver,"ConfirmPassword", userPassword);
		
		log.info("Pre-condition - Step 12: Click to Register button");
		registerPage.clickToButtonByTextName(driver,"Register");
		
		log.info("Pre-condition - Step 13: Verify displayed sucess message: 'Your registration completed'");
		verifyTrue(registerPage.isRegisteredSucessMessageDisplayed());
		
		log.info("Pre-condition - Step 14: Click to log out link");
		registerPage.clickToHeaderLink(driver, "logout");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition - Step 15: Verify HomePage displayed ");
		Assert.assertTrue(homePage.isHomePageSliderDispayed());
		
		log.info("Pre-condition - Step 16: Click to Login link");
		homePage.clickToHeaderLink(driver, "login");
		loginPage = UserPageGeneratorManager.getLoginPage(driver);
	}
		
	@Test 
		public void Login_01_Login_With_Empty_Data(){

		log.info("Login_01 - Step01: Input with empty email");
		loginPage.inputToTextboxByID(driver, "Email", "");
		
		log.info("Login_01 - Step02: Input with empty password");
		loginPage.inputToTextboxByID(driver, "Password", "");
		
		log.info("Login_01 - Step03: Click to Login button");
		loginPage.clickToButtonByTextName(driver, "Log in");
		
		log.info("Login_01 - Step 03: Verify displayed error message 'Please enter your email'");
		verifyEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
			
		
	}
	@Test 
		public void Login_02_Login_With_Invalid_Email() {
		
		log.info("Login_02 - Step01: Input to Email textbox with value: " + invalidEmailAddress);
		loginPage.inputToTextboxByID(driver, "Email", invalidEmailAddress);
		
		log.info("Login_02 - Step 02: Click to Login button");
		loginPage.clickToButtonByTextName(driver, "Log in");
		
		log.info("Login_02 - Step 03: Verify displayed error message 'Wrong email'");
		verifyEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}
	@Test
	public void Login_03_Login_With_Not_Registered_Email() {
		log.info("Login_02 - Step01: Input to Email textbox with value: " + notRegisteredEmail);
		loginPage.inputToTextboxByID(driver, "Email", notRegisteredEmail);
		
		log.info("Login_03 - Step 02: Input to Password textbox with value: " + userPassword);
		loginPage.inputToTextboxByID(driver, "Password", userPassword);
		
		log.info("Login_03 - Step 03: Click to Login button");
		loginPage.clickToButtonByTextName(driver, "Log in");
		
		log.info("Login_03 - Step 04: Verify displayed error message 'Login was unsuccessful. Please correct the errors and try again. No customer account found'");
		verifyFalse(loginPage.isUnccessfulErrorMessageByTextDisplayed("Login was unsuccessful. Please correct the errors and try again. No customer account found"));
	}

	public void Login_04_Login_With_Registered_Email_And_Empty_Password() {
		log.info("Login_04 - Step 01: Input to Email textbox with value: " + emailAdress);
		loginPage.inputToTextboxByID(driver, "Email", emailAdress);

		log.info("Login_04 - Step 02: Input empty Password textbox");
		loginPage.inputToTextboxByID(driver, "Password", "");

		log.info("Login_04 - Step 03: Click to Login button");
		loginPage.clickToButtonByTextName(driver, "Log in");

		log.info("Login_04 - Step 04: Verify displayed error message 'The credentials provided are incorrect'");
		verifyTrue(loginPage.isUnccessfulErrorMessageByTextDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void Login_05_Login_With_Registered_Email_And_Wrong_Password() {
		log.info("Login_05 - Step 01: Input to Email textbox with value: " + emailAdress);
		loginPage.inputToTextboxByID(driver, "Email", emailAdress);

		log.info("Login_05 - Step 02: Input to Password textbox with value: " + inCorrectPassword);
		loginPage.inputToTextboxByID(driver, "Password", inCorrectPassword);

		log.info("Login_05 - Step 03: Click to Login button");
		loginPage.clickToButtonByTextName(driver, "Log in");

		log.info("Login_05 - Step 04: Verify displayed error message 'The credentials provided are incorrect'");
		verifyTrue(loginPage.isUnccessfulErrorMessageByTextDisplayed("The credentials provided are incorrect"));
	}

	@Test
	public void Login_06_Login_With_Registered_Email_And_Correct_Password() {
		log.info("Login_06 - Step 01: Input to Email textbox with value: " + emailAdress);
		loginPage.inputToTextboxByID(driver, "Email", emailAdress);

		log.info("Login_06 - Step 02: Input to Password textbox with value: " + userPassword);
		loginPage.inputToTextboxByID(driver, "Password", userPassword);

		log.info("Login_06 - Step 03: Click to Login button");
		loginPage.clickToButtonByTextName(driver, "Log in");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		

		log.info("Login_06 - Step 04: Verify HomePage displayed");
		verifyTrue(homePage.isHomePageSliderDispayed());
	}
	
	
	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAdress, firstName, lastName, dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear,companyName, userPassword,invalidEmailAddress, notRegisteredEmail, inCorrectPassword;
	DataUtil fakeData;
	HomePO homePage;
	RegisterPO registerPage;
	LoginPO loginPage;
}
