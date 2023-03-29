package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserRewardPointsUI;
import commons.BasePage;

public class BackInStockSubscriptionsPO extends BasePage {
	WebDriver driver;
	public BackInStockSubscriptionsPO(WebDriver driver) {
		this.driver = driver;
		
	}

	public RewardPointsPO openRewardPointsPage(WebDriver driver) {
		waitForElementClickable(driver, UserRewardPointsUI.REWARD_POITS_IN_SIDE2);
		clickToElement(driver,  UserRewardPointsUI.REWARD_POITS_IN_SIDE2);
		return UserPageGeneratorManager.getRewardPointsPage(driver);
	}

}
