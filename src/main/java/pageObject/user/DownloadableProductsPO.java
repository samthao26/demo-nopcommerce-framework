package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserBackInStockSubscriptionsUI;
import commons.BasePage;

public class DownloadableProductsPO extends BasePage {
	WebDriver driver;
	
	public DownloadableProductsPO(WebDriver driver) {
		this.driver=driver;
	}

	public BackInStockSubscriptionsPO openBackInStockSubscriptionsPage(WebDriver driver) {
		waitForElementClickable(driver, UserBackInStockSubscriptionsUI.BACK_IN_STOCK_SUBSCRIPTION_IN_SIDE2);
		clickToElement(driver, UserBackInStockSubscriptionsUI.BACK_IN_STOCK_SUBSCRIPTION_IN_SIDE2);
		return UserPageGeneratorManager.getBackInStockSubscriptionsPage(driver);
	}

}
