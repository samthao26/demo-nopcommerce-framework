package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import commons.BaseTest;
import pageObject.user.AddressPO;
import pageObject.user.BackInStockSubscriptionsPO;
import pageObject.user.ChangePasswordPO;
import pageObject.user.CustomerInforPO;
import pageObject.user.DownloadableProductsPO;
import pageObject.user.HomePO;
import pageObject.user.LoginPO;
import pageObject.user.OrderPO;
import pageObject.user.RegisterPO;
import pageObject.user.RewardPointsPO;
import pageObject.user.SearchPO;
import pageObject.user.ShippingAndReturnPO;
import pageObject.user.UserPageGeneratorManager;


@Listeners()
public class User_00_Registation_Login_Nopcommerce extends BaseTest {
	
@Parameters({"browser", "appUrl"})

@BeforeClass 
	public void beforeClass(String browserName, String appUrl) {
	driver = getBrowserDriver(browserName, appUrl);
	
	homePage = UserPageGeneratorManager.getHomePage(driver);
	emailAdress = generateEmail();
	userPassword = "12345678";
	firstName = " Andrea";
	lastName = "Hull"; 
	companyName = "Automation Group";
}
@Test 
	public void User_00_Register_TO_System() {
	log.info("Register - Step 01: Navigate to 'Home' page");
	homePage = UserPageGeneratorManager.getHomePage(driver);
	
	log.info("Register - Step 02: Click to 'Register' link ");
	homePage.clickToHeaderLink(driver, "register");
	
	log.info("Register - Step 03: Navigate to 'Register' page ");
	registerPage =UserPageGeneratorManager.getRegisterPage(driver);
	
	log.info("Register - Step 04: Click to 'Female' gender ");
	registerPage.clickToGenderFemaleRadio();
	
	log.info("Register - Step 05: Enter to Firstname texbox with value is" + firstName);
	registerPage.inputToFirstNameTextbox(firstName);
	
	log.info("Register - Step 06: Enter to lastName textbox with value is" + lastName);
	registerPage.inputToLastNameTextbox(lastName);
	
	log.info("Register - Step 07: Select to day of birth dropdown");
	registerPage.selectDayOfBirthDropdown("1");
	
	log.info("Register - Step 08: Select to month of birth dropdown");
	registerPage.selectMonthOfBirthDropdown("March");
	
	log.info("Register - Step 09: Select to year of birth dropdown");
	registerPage.selectYearOfBirthDropdown("2000");
	
	log.info("Register - Step 10 : Enter to Email textbox with value is" + emailAdress);
	registerPage.inputToEmailTextbox(emailAdress);
	
	log.info("Register - Step 11 : Enter to companyName textbox with value is" + companyName);
	registerPage.inputToCompanyNameTextbox(companyName);
	
	log.info("Register - Step 12 : Enter to confirm Userpassword textbox with value is" + userPassword);
	registerPage.inputToPasswordTextbox(userPassword);
	
	log.info("Register - Step 13 : Enter to Userpassword textbox with value is" + userPassword);
	registerPage.inputToConfirmPasswordTextbox(userPassword);
	
	log.info("Register- Step 14: Click to Register button");
	registerPage.clickToRegisterButton();
	
	log.info("Register - Step 15: Verify get registered sucess message");
	Assert.assertEquals(registerPage.getRegisteredSucessMessage(), "Your registration completed");
	
	

}
@Test
	public void User_01_Login_To_System() {

	log.info("User_01 - Step 01: Click to 'Register' link ");
	loginPage = registerPage.clickToLoginLink();
	
	log.info("User_01 - Step 02: Enter to Email textbox with value is + 'emailAdress'+");
	loginPage.inputToTextboxByID(driver, "Email", emailAdress);
	
	log.info("User_01 - Step 02: Enter to Email textbox with value is + 'userPassword'+");
	loginPage.inputToTextboxByID(driver, "Password", userPassword);
	
	log.info("User_01 - Step 01: Click to 'Login' button ");
	loginPage.clickToButtonByText(driver, "Log in");  
	homePage = UserPageGeneratorManager.getHomePage(driver);
	
	log.info("User_01 - Step 01: Verify MyAccount link is disPlayed");
	Assert.assertTrue(homePage.isMyAccountLinkDisPlayed());
	
	log.info("User_01 - Step 01: Click to 'MyAccount' link ");
	homePage.clickToHeaderLink(driver, "My account");
	customeInforPage = UserPageGeneratorManager.getCustomerInforPage(driver);
	
	log.info("User_01 - Step 01: Verify FemaleGender is selected");
	Assert.assertFalse(customeInforPage.isFemaleGenderSelected());
	
	verifyEquals(customeInforPage.getFirstNameTextboxAttribute(),"Andrea");
	verifyEquals(customeInforPage.getLastNameTextboxAttribute(), "Hull");
	verifyEquals(customeInforPage.getDayOfBirthDropdow(), "1");
	verifyEquals(customeInforPage.getMonthOfBirthDropdown(), "March");
	verifyEquals(customeInforPage.getyearOfBirthDropdown(), "2000");
	verifyEquals(customeInforPage.getEmailTextbox(), emailAdress);
	verifyEquals(customeInforPage.getCompanyNameTextbox(), "Automation Group");
}

@Test
	public void User_02_Swith_To_DiffirentPage() {
	log.info("User_02_Login Step 01:Navigate to 'Addreses' page ");
	customeInforPage.openAddreses(driver);
	addressPage = UserPageGeneratorManager.getAddressPage(driver);
	
	log.info("User_02_Login Step 01:Navigate to 'Oder' page ");
	addressPage.openOderPage(driver);
	oderPage = UserPageGeneratorManager.getOrderPage(driver);
	
	log.info("User_02_Login Step 01:Navigate to 'DownloadableProducts' page ");
	oderPage.openDownloadableProductsPage(driver);
	downloadableProductsPage = UserPageGeneratorManager.getDownloadableProductsPage(driver);
	
	log.info("User_02_Login Step 01:Navigate to 'BackInStockSubscriptions' page ");
	downloadableProductsPage.openBackInStockSubscriptionsPage(driver);
	
	backInStockSubscriptionsPage= UserPageGeneratorManager.getBackInStockSubscriptionsPage(driver);
	log.info("User_02_Login Step 01:Navigate to 'RewardPoints' page ");
	backInStockSubscriptionsPage.openRewardPointsPage(driver);
	rewardPointsPage = UserPageGeneratorManager.getRewardPointsPage(driver);
	
	log.info("User_02_Login Step 01:Navigate to 'ChangePassword' page ");
	rewardPointsPage.openChangePasswordPage(driver);
	changePasswordPage = UserPageGeneratorManager.getChangePasswordPage(driver);
	
	log.info("User_02_Login Step 01:Navigate to 'Search' page ");
	changePasswordPage.openSearchPage(driver);
	searchPage = UserPageGeneratorManager.getSearchPage(driver);
	
	log.info("User_02_Login Step 01:Navigate to 'ShippingAndReturn' page ");
	searchPage.openShippingAndReturnPage(driver);
	shippingAndReturnPage = UserPageGeneratorManager.getShippingAndReturnPage(driver);
}
@AfterClass 	
	public void afterClass() {
	driver.quit();
}

	
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String emailAdress, userPassword, firstName, lastName, companyName;
	HomePO homePage;
	RegisterPO registerPage;
	LoginPO loginPage;
	CustomerInforPO customeInforPage;
	AddressPO addressPage;
	OrderPO oderPage;
	DownloadableProductsPO downloadableProductsPage; 
	BackInStockSubscriptionsPO backInStockSubscriptionsPage;
	RewardPointsPO rewardPointsPage;
	ChangePasswordPO changePasswordPage;
	SearchPO searchPage;
	ShippingAndReturnPO shippingAndReturnPage;

}
