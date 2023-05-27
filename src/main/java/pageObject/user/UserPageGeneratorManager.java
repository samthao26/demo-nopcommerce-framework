package pageObject.user;

import org.openqa.selenium.WebDriver;

public class UserPageGeneratorManager {
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	public static HomePO getHomePage (WebDriver driver) {
		return new HomePO(driver);
	}
	public static OrderPO getOrderPage(WebDriver driver) {
		return new OrderPO(driver);
		
	}
	
	public static RegisterPO getRegisterPage(WebDriver driver) {
	
		return new RegisterPO(driver); 
	}
	public static AddressPO getAddressPage (WebDriver driver) {
		return new AddressPO(driver);
	
	}
	public static BackInStockSubscriptionsPO getBackInStockSubscriptionsPage (WebDriver driver) {
		return new BackInStockSubscriptionsPO(driver);
		
	}
	public static ChangePasswordPO getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPO(driver);
	}
	public static CustomerInforPO getCustomerInforPage(WebDriver driver) {
		return new CustomerInforPO(driver);
	}
	public static DownloadableProductsPO getDownloadableProductsPage(WebDriver driver) {
		return new DownloadableProductsPO(driver);
	}
	public static RewardPointsPO getRewardPointsPage(WebDriver driver) {
		return new RewardPointsPO(driver);
	}
	public static SearchPO getSearchPage(WebDriver driver) {
		return new SearchPO(driver);
	}
	public static ShippingAndReturnPO getShippingAndReturnPage(WebDriver driver) {
		return new ShippingAndReturnPO(driver);
	}
	public static MyAccountPO getMyAccountPage(WebDriver driver) {
		return new MyAccountPO(driver);
	}
		
}
