package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserOrderUI;
import commons.BasePage;

public class AddressPO extends BasePage {
	WebDriver driver;
	
	public AddressPO (WebDriver driver) {
		this.driver = driver;
	}
	
	public OrderPO openOderPage(WebDriver driver) {
		waitForElementClickable(driver, UserOrderUI.ORDERS_FOOTER_LINK);
		clickToElement(driver, UserOrderUI.ORDERS_FOOTER_LINK);
		return UserPageGeneratorManager.getOrderPage(driver);
	}

}
