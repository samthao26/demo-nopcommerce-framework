package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserSearchUI;
import commons.BasePage;

public class ChangePasswordPO extends BasePage{
	WebDriver driver;
	public ChangePasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public SearchPO openSearchPage(WebDriver driver) {
		waitForElementClickable(driver, UserSearchUI.SEARCH_IN_FOOTER_LINK);
		clickToElement(driver, UserSearchUI.SEARCH_IN_FOOTER_LINK);
		return UserPageGeneratorManager.getSearchPage(driver);
	}

}
