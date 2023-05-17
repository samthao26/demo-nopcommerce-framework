package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserDownloadableProductsUI;
import commons.BasePage;

public class OrderPO extends BasePage {
	WebDriver driver;
	
	public OrderPO(WebDriver driver) {
		this.driver = driver;
	}

	public DownloadableProductsPO openDownloadableProductsPage(WebDriver driver) {
		waitForElementClickable(driver, UserDownloadableProductsUI.DOWNLOADABLE_PRODUCTS_IN_SIDE2);
		clickToElement(driver, UserDownloadableProductsUI.DOWNLOADABLE_PRODUCTS_IN_SIDE2);
		return UserPageGeneratorManager.getDownloadableProductsPage(driver);
	}

}
