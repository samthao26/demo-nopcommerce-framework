package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserHomeUI;
import commons.BasePage;

public class HomePO extends BasePage{
		WebDriver driver;	
	public HomePO(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterLink() {
		waitForElementClickable(driver, UserHomeUI.REGISTER_LINK);
		clickToElement(driver, UserHomeUI.REGISTER_LINK);
		
	
	}
	public void clickToMyAccountLink() {
		// TODO Auto-generated method stub
		
	}
	public boolean isMyAccountLinkDisPlayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
