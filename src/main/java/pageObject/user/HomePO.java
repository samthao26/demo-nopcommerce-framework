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
	public boolean isMyAccountLinkDisPlayed() {
		waitForElementVisible(driver, UserMyAccountUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserMyAccountUI.MY_ACCOUNT_LINK);
	}
	public boolean isHomePageSliderDispayed() {
		waitForElementVisible(driver, UserHomeUI.HOME_NIVO_SILDER);
		return isElementDisplayed(driver, UserHomeUI.HOME_NIVO_SILDER);
	}
	
	
	
}
