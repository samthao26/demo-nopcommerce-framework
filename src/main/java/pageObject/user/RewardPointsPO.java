package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserChangePasswordUI;
import commons.BasePage;

public class RewardPointsPO extends BasePage{
	WebDriver driver;
	public RewardPointsPO (WebDriver driver) {
		this.driver=driver;
	}

	public ChangePasswordPO openChangePasswordPage(WebDriver driver) {
		waitForElementClickable(driver, UserChangePasswordUI.CHANGE_PASSWORD_IN_SIDE2);
		clickToElement(driver, UserChangePasswordUI.CHANGE_PASSWORD_IN_SIDE2);
		return UserPageGeneratorManager.getChangePasswordPage(driver);
	}

}
