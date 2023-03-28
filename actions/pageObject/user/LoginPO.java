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
	public void inputToEmailTextbox(String emailAdress) {
		waitForElementVisible(driver, UserLoginUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginUI.EMAIL_TEXTBOX, emailAdress);
	}
	public void inputToPasswordTextbox(String userPassword) {
		waitForElementVisible(driver, UserLoginUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginUI.PASSWORD_TEXTBOX, userPassword);
	}
	public void clickToLoginButton() {
		waitForElementInvisible(driver, UserLoginUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginUI.LOGIN_BUTTON);
	}
}
