package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserHomeUI;
import PageUIs.user.UserMyAccountUI;
import commons.BasePage;

public class HomePO extends BasePage{
		WebDriver driver;	
		
	public HomePO(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPO clickToRegisterLink() {
		waitForElementClickable(driver, UserHomeUI.REGISTER_LINK);
		clickToElement(driver, UserHomeUI.REGISTER_LINK);
		return UserPageGeneratorManager.getRegisterPage(driver);
	
	}
	public CustomerInforPO clickToMyAccountLink() {
		waitForElementClickable(driver, UserMyAccountUI.MY_ACCOUNT_LINK);
		clickToElement(driver,  UserMyAccountUI.MY_ACCOUNT_LINK );
		return UserPageGeneratorManager.getCustomerInforPage(driver);
	}
	public boolean isMyAccountLinkDisPlayed() {
		waitForElementVisible(driver, UserMyAccountUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserMyAccountUI.MY_ACCOUNT_LINK);
	}
	public boolean isHomePageSliderDispayed() {
		waitForElementVisible(driver, UserHomeUI.HOME_NIVO_SILDER);
		return isElementDisplayed(driver, UserHomeUI.HOME_NIVO_SILDER);
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver, UserHomeUI.LOGIN_LINK);
		clickToElement(driver, UserHomeUI.LOGIN_LINK);
		
	}
	
	
}
