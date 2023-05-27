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

public class User_01_Register extends BaseTest {
	
@Parameters({"browser", "appUrl"})
@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
	driver = getBrowserDriver(browserName, appUrl);
	emailAdress = generateEmail();
	firstName = "Andrea";
	lastName = "Hull";
	companyName = "Automation Group";
	userPassword = "12345678";
	homePage = UserPageGeneratorManager.getHomePage(driver);
	Assert.assertTrue(homePage.isHomePageSliderDispayed());
	homePage.clickToHeaderLink(driver, "Register");
	registerPage= UserPageGeneratorManager.getRegisterPage(driver);
}
@Test
public void User_01_Register_With_Empty_Data() {
	registerPage.clickToRegisterButton();
	verifyEquals(registerPage.getErrorMessageByFieldName("FirstName"), "First name is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("LastName"), "Last name is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("Email"), "Email is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("Password"), "Password is required.");
	verifyEquals(registerPage.getErrorMessageByFieldName("ConfirmPassword"), "Password is required.");
	
}
@Test
public void User_02_Register_With_Invalid_Email() {
	registerPage.refreshCurrentPage(driver);
	registerPage.inputToEmailTextbox("123%5w");
	registerPage.clickToRegisterButton();
	verifyEquals(registerPage.getErrorMessageByFieldName("Email"), "Wrong email");
}
@Test
public void User_03_Register_With_Password_Less_Than_Six_Character() {
	registerPage.refreshCurrentPage(driver);
	registerPage.inputToPasswordTextbox("123");
	registerPage.clickToRegisterButton();
	verifyEquals(registerPage.getErrorMessageByFieldName("Password"), "Password must meet the following rules:\nmust have at least 6 characters");
}
@Test 
public void User_04_Register_With_Comfirm_Password_Not_Match() {
	registerPage.refreshCurrentPage(driver);
	registerPage.inputToPasswordTextbox(userPassword);
	registerPage.inputToConfirmPasswordTextbox("3456789");
	registerPage.clickToRegisterButton();
	verifyEquals(registerPage.getErrorMessageByFieldName("ConfirmPassword"), "The password and confirmation password do not match.");
}
@Test
public void User_05_Register_With_Valid_Data() {
	registerPage.refreshCurrentPage(driver);
	registerPage.clickToGenderFemaleRadio();
	registerPage.inputToFirstNameTextbox(firstName);
	registerPage.inputToLastNameTextbox(lastName);
	registerPage.selectDayOfBirthDropdown("1");
	registerPage.selectMonthOfBirthDropdown("March");
	registerPage.selectYearOfBirthDropdown("1989");
	registerPage.inputToEmailTextbox(emailAdress);
	registerPage.inputToCompanyNameTextbox(companyName);
	registerPage.inputToPasswordTextbox(userPassword);
	registerPage.inputToConfirmPasswordTextbox(userPassword);
	registerPage.clickToRegisterButton();
	verifyEquals(registerPage.getRegisteredSucessMessage(), "Your registration completed");
	
}
@Test
public void User_06_Register_With_Existing_Email() {
	homePage = registerPage.clickToContinueButton();
	verifyTrue(homePage.isHomePageSliderDispayed());
	homePage.clickToHeaderLink(driver, "Register");
	registerPage= UserPageGeneratorManager.getRegisterPage(driver);
	registerPage.inputToFirstNameTextbox(firstName);
	registerPage.inputToLastNameTextbox(lastName);
	registerPage.inputToEmailTextbox(emailAdress);
	registerPage.inputToPasswordTextbox(userPassword);
	registerPage.inputToConfirmPasswordTextbox(userPassword);
	registerPage.clickToRegisterButton();
	verifyEquals(registerPage.getErrorMessage(), "The specified email already exists");
	
}




WebDriver driver;
String projectPath = System.getProperty("user.dir");
String emailAdress, firstName, lastName, companyName, userPassword;
HomePO homePage; 
RegisterPO registerPage;
	
}

  