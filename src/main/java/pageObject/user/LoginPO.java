package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserLoginUI;
import commons.BasePage;
import commons.BaseTest;

public class LoginPO extends BasePage{
WebDriver driver;
	public LoginPO (WebDriver driver) {
		this.driver = driver;
	}
	public boolean getErrorLoginMessage() {
		// TODO Auto-generated method stub
		return false;
	}
}
