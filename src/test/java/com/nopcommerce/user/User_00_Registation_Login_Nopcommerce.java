package com.nopcommerce.user;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
	homePage.clickToRegisterLink();
	log.info("Register - Step 03: Navigate to 'Register' page ");
	registerPage =UserPageGeneratorManager.getRegisterPage(driver);
	log.info("Register - Step 04: Click to 'Female' gender ");
	registerPage.clickToGenderFemaleRadio();
	log.info("Register - Step 05: Enter to Firstname texbox with value is + 'firstName' + ");
	registerPage.inputToFirstNameTextbox(firstName);
	log.info("Register - Step 06: Enter to lastName textbox with value is + 'lastName'+ ");
	registerPage.inputToLastNameTextbox(lastName);
	log.info("Register - Step 07: Select to day of birth dropdown");
	registerPage.selectDayOfBirthDropdown("1");
	log.info("Register - Step 08: Select to month of birth dropdown");
	registerPage.selectMonthOfBirthDropdown("March");
	log.info("Register - Step 09: Select to year of birth dropdown");
	registerPage.selectYearOfBirthDropdown("2000");
	log.info("Register - Step 10 : Enter to Email textbox with value is + 'emailAdress'+");
	registerPage.inputToEmailTextbox(emailAdress);
	log.info("Register - Step 11 : Enter to companyName textbox with value is + 'companyName'+ ");
	registerPage.inputToCompanyNameTextbox(companyName);
	log.info("Register - Step 12 : Enter to confirm Userpassword textbox with value is + 'userPassword'+");
	registerPage.inputToPasswordTextbox(userPassword);
	log.info("Register - Step 13 : Enter to Userpassword textbox with value is + 'userPassword'+");
	registerPage.inputToConfirmPasswordTextbox(userPassword);
	log.info("Register- Step 14: Click to Register button");
	registerPage.clickToRegisterButton();
	log.info("Register - Step 15: Verify get registered sucess message");
	Assert.assertEquals(registerPage.getRegisteredSucessMessage(), "Your registration completed");
	
	

}

	public void User_01_Login_To_System() {
	loginPage = registerPage.clickToLoginLink();
	loginPage.inputToEmailTextbox(emailAdress);
	loginPage.inputToPasswordTextbox(userPassword);
	homePage = loginPage.clickToLoginButton();  
	Assert.assertTrue(homePage.isMyAccountLinkDisPlayed());
	customeInforPage = homePage.clickToMyAccountLink();
	Assert.assertTrue(customeInforPage.isFemaleGenderSelected());
	Assert.assertEquals(customeInforPage.getFirstNameTextboxAttribute(),"Andrea");
	Assert.assertEquals(customeInforPage.getLastNameTextboxAttribute(), "Hull");
	Assert.assertEquals(customeInforPage.getDayOfBirthDropdow(), "1");
	Assert.assertEquals(customeInforPage.getMonthOfBirthDropdown(), "March");
	Assert.assertEquals(customeInforPage.getyearOfBirthDropdown(), "2000");
	Assert.assertEquals(customeInforPage.getEmailTextbox(), emailAdress);
	Assert.assertEquals(customeInforPage.getCompanyNameTextbox(), "Automation Group");
	
	
}


	public void User_02_Swith_To_DiffirentPage() {
	addressPage = customeInforPage.openAddreses(driver);
	oderPage = addressPage.openOderPage(driver);
	downloadableProductsPage = oderPage.openDownloadableProductsPage(driver);
	backInStockSubscriptionsPage= downloadableProductsPage.openBackInStockSubscriptionsPage(driver);
	rewardPointsPage = backInStockSubscriptionsPage.openRewardPointsPage(driver);
	changePasswordPage = rewardPointsPage.openChangePasswordPage(driver);
	searchPage = changePasswordPage.openSearchPage(driver);
	shippingAndReturnPage = searchPage.openShippingAndReturnPage(driver);
	
	
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
