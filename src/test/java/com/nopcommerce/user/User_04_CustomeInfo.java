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

public class User_04_CustomeInfo extends BaseTest{
	@Parameters({"browser", "appUrl"})
	@BeforeClass
	public void BeforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAdress = generateEmail();
		firstName = "Andrea";
		lastName = "Hull";
		dateOfBirthDay = "1";
		dateOfBirthMonth = "March";
		dateOfBirthYear = "1989";
		companyName = "Automation Group";
		userPassword = "12345678";
		
		log.info("Pre-condition Step 01: Open Home page");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition Step 02: Verify home page is displayed");
		verifyTrue(homePage.isHomePageSliderDispayed());
		
		log.info("Pre-condition Step 03: Navigate to Register page");
		homePage.clickToHeaderLink(driver, "Register");
		registerPage = UserPageGeneratorManager.getRegisterPage(driver);
		
		log.info("Pre-condition Step 04: Select gender with value is Female");
		registerPage.clickToGenderFemaleRadio();
		
		log.info("Pre-condition Step 05: Input FirstName to textbox with value is:" + firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);
		
		log.info("Pre-condition Step 06: Input LastName to textbox with value is:" + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);
		
		log.info("Pre-condition Step 07: Select Date of birthDay with value is:" + dateOfBirthDay);
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", dateOfBirthDay);
		
		log.info("Pre-condition Step 07: Select Date of birth month with value is:" + dateOfBirthMonth);
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", dateOfBirthMonth);
		
		log.info("Pre-condition Step 07: Select Date of birth year with value is:" + dateOfBirthYear);
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", dateOfBirthYear);
		
		log.info("Pre-condition Step 08: Input email to textbox with value is:" + emailAdress);
		registerPage.inputToTextboxByID(driver, "Email", emailAdress);
		
		log.info("Pre-condition Step 09: Input Company to textbox with value is:" + companyName);
		registerPage.inputToTextboxByID(driver, "Company", companyName);
		
		log.info("Pre-condition Step 010: Input Password to textbox with value is:" + userPassword);
		registerPage.inputToTextboxByID(driver, "Password", userPassword);
		
		log.info("Pre-condition Step 11: Input ConfirmPassword to textbox with value is:" + userPassword);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", userPassword);
		
		log.info("Pre-condition Step 12: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-condition Step 13: Verify sucess register mesage is displayed");
		verifyEquals(registerPage.getRegisteredSucessMessage(), "Your registration completed");
		
		log.info("Pre-condition Step 14: Click to contiue button");
		registerPage.clickToButtonByText(driver, "Continue");
		homePage= UserPageGeneratorManager.getHomePage(driver);
		
		log.info("Pre-condition Step 14: Navigate to login page");
		homePage.clickToHeaderLink(driver, "Log in");
		loginPage = UserPageGeneratorManager.getLoginPage(driver);

		log.info("Pre-condition Step 15: Input email to textbox with value is:" + emailAdress);
		loginPage.inputToTextboxByID(driver, "Email", emailAdress);
		
		log.info("Pre-condition Step 16: Input Password to textbox with value is:" + userPassword);
		loginPage.inputToTextboxByID(driver, "Password", userPassword);
		
		log.info("re-condition Step 17: Navigate to home page ");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = UserPageGeneratorManager.getHomePage(driver);
		verifyTrue(homePage.isHomePageSliderDispayed());
		
		log.info("re-condition Step 18: Navigate to Myaccount page ");
		homePage.clickToHeaderLink(driver, "My account");
		
		
	}
	@Test
	public void MyAccount_01_Change_Custome_Info() {
		log.info()
		
		
	}
	
	WebDriver driver;
	String emailAdress ,firstName,lastName,companyName, userPassword,dateOfBirthDay, dateOfBirthMonth, dateOfBirthYear ;
	HomePO homePage;
	RegisterPO registerPage;
	MyAccountPO myAccountPage;
	LoginPO loginPage;
	
}
