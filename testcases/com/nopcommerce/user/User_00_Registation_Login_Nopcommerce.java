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

public class User_00_Registation_Login_Nopcommerce extends BaseTest {
	
@Parameters({"browser", "appUrl"})

@BeforeClass 
	public void beforeClass(String browserName, String appUrl) {
	driver = getBrowserDriver(browserName, appUrl);
	emailAdress = generateEmail();
	userPassword = "12345678";
	
}
@Test 
	public void User_00_Register_TO_System() {
	homePage = new HomePO(driver);
	homePage.clickToRegisterLink();
	registerPage = new RegisterPO(driver);
	registerPage.clickToGenderFemaleRadio();
	registerPage.inputToFirstNameTextbox("Andrea");
	registerPage.inputToLastNameTextbox("Hull");
	registerPage.selectDayOfBirthDropdown("1");
	registerPage.selectMonthOfBirthDropdown("March");
	registerPage.selectYearOfBirthDropdown("2000");
	registerPage.inputToEmailTextbox(emailAdress);
	registerPage.inputToCompanyNameTextbox("Automation Group");
	registerPage.inputToPasswordTextbox(userPassword);
	registerPage.inputToConfirmPasswordTextbox(userPassword);
	registerPage.clickToRegisterButton();
	Assert.assertEquals(registerPage.getRegisteredSucessMessage(), "Your registration completed");
	
	

}
@Test
	public void User_01_Login_To_System() {
	loginPage = registerPage.clickToLoginLink();
	loginPage.inputToEmailTextbox(emailAdress);
	loginPage.inputToPasswordTextbox(userPassword);
	homePage = loginPage.clickToLoginButton();  
	Assert.assertTrue(homePage.isMyAccountLinkDisPlayed());
	customeInforPage = homePage.clickToMyAccountLink();
	Assert.assertTrue(customeInforPage.isFemaleGenderSelected());
	Assert.assertEquals(customeInforPage.getFirstNameTextboxAttribute(), "Andrea");
	Assert.assertEquals(customeInforPage.getLastNameTextboxAttribute(), "Hull");
	Assert.assertEquals(customeInforPage.getDayOfBirthDropdow(), "1");
	Assert.assertEquals(customeInforPage.getMonthOfBirthDropdown(), "March");
	Assert.assertEquals(customeInforPage.getyearOfBirthDropdown(), "2000");
	Assert.assertEquals(customeInforPage.getEmailTextbox(), emailAdress);
	Assert.assertEquals(customeInforPage.getCompanyNameTextbox(), "Automation Group");
	
	
}

@ Test
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
	String emailAdress, userPassword;
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
