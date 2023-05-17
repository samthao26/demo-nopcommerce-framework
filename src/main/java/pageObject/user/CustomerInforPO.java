package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.UserAddressUI;
import PageUIs.user.UserCustomerInforUI;
import commons.BasePage;


public class CustomerInforPO extends BasePage{
	WebDriver driver;
	
	
	
	public CustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isFemaleGenderSelected() {
		waitForElementVisible(driver, UserCustomerInforUI.FEMALE_GENDER);
		return isElementSelected(driver, UserCustomerInforUI.FEMALE_GENDER);
	}
	public String getFirstNameTextboxAttribute() {
		waitForElementVisible(driver, UserCustomerInforUI.FIRSTNAME_TEXBOX);
		return getAttributeValue(driver, UserCustomerInforUI.FIRSTNAME_TEXBOX,"value");
	}
	public String getLastNameTextboxAttribute() {
		waitForElementVisible(driver, UserCustomerInforUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, UserCustomerInforUI.LASTNAME_TEXTBOX, "value");
	}
	public String getDayOfBirthDropdow() {
		waitForElementVisible(driver, UserCustomerInforUI.DAY_OF_BIRTH_DROPDOWN);
		return getSelectOptionInDropdown(driver, UserCustomerInforUI.DAY_OF_BIRTH_DROPDOWN);
	}
	public String getMonthOfBirthDropdown() {
		waitForElementVisible(driver, UserCustomerInforUI.MONTH_OF_BIRTH_DROPDOWN);
		return getSelectOptionInDropdown(driver, UserCustomerInforUI.MONTH_OF_BIRTH_DROPDOWN);
	}
	public String getyearOfBirthDropdown() {
		waitForElementVisible(driver, UserCustomerInforUI.YEAR_OF_BIRTH_DROPDOWN);
		return getSelectOptionInDropdown(driver, UserCustomerInforUI.YEAR_OF_BIRTH_DROPDOWN);
	}
	public String getEmailTextbox() {
		waitForElementVisible(driver, UserCustomerInforUI.EMAIL_TEXBOX);
		return getAttributeValue(driver, UserCustomerInforUI.EMAIL_TEXBOX, "value");
	}
	public String getCompanyNameTextbox() {
		waitForElementVisible(driver, UserCustomerInforUI.COMPANY_TEXBOX);
		return getAttributeValue(driver, UserCustomerInforUI.COMPANY_TEXBOX, "value");
	}
	public AddressPO openAddreses(WebDriver driver) {
		waitForElementClickable(driver, UserAddressUI.ADDRESS_LINK_IN_SIDE2);
		clickToElement(driver, UserAddressUI.ADDRESS_LINK_IN_SIDE2);
		return UserPageGeneratorManager.getAddressPage(driver);
	}
}
