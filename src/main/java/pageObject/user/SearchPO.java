package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserShippingAndReturnUI;
import commons.BasePage;

public class SearchPO extends BasePage {
	WebDriver driver;
	public SearchPO (WebDriver driver) {
		this.driver = driver;
	}

	public ShippingAndReturnPO openShippingAndReturnPage(WebDriver driver) {
		waitForElementClickable(driver, UserShippingAndReturnUI.SHIPPING_AND_RETURN_IN_FOOTER_LINK);
		clickToElement(driver, UserShippingAndReturnUI.SHIPPING_AND_RETURN_IN_FOOTER_LINK);
		return UserPageGeneratorManager.getShippingAndReturnPage(driver);
	}

}
