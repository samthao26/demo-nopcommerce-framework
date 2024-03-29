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

	

	public Object getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginUI.EMAIL_ERROR_MESSAGE);
		return getTextElement(driver, UserLoginUI.EMAIL_ERROR_MESSAGE );
	}

	public boolean isUnccessfulErrorMessageByTextDisplayed(String textMessage) {
		waitForElementClickable(driver, UserLoginUI.DYNAMIC_UNCCESSFUL_ERROR_MESSAGE_BY_TEXT, textMessage);
		return isElementDisPlayed(driver, UserLoginUI.DYNAMIC_UNCCESSFUL_ERROR_MESSAGE_BY_TEXT, textMessage);
	}
}
