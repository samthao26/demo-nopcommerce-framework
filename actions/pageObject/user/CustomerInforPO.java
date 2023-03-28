package pageObject.user;

import org.openqa.selenium.WebDriver;

import PageUIs.user.CustomerInforUI;
import commons.BasePage;


public class CustomerInforPO extends BasePage{
	WebDriver driver;
	
	
	
	public CustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isFemaleGenderSelected() {
		waitForElementVisible(driver, CustomerInforUI.FEMALE_GENDER);
		return isElementSelected(driver, CustomerInforUI.FEMALE_GENDER);
	}
	public String getFirstNameTextboxAttribute() {
		waitForElementVisible(driver, CustomerInforUI.FIRSTNAME_TEXBOX);
		return getAttributeValue(driver, CustomerInforUI.FIRSTNAME_TEXBOX,"value");
	}
	public String getLastNameTextboxAttribute() {
		waitForElementVisible(driver, CustomerInforUI.LASTNAME_TEXTBOX);
		return getAttributeValue(driver, CustomerInforUI.LASTNAME_TEXTBOX, "value");
	}
	public String getDayOfBirthDropdow() {
		waitForElementVisible(driver, CustomerInforUI.DAY_OF_BIRTH_DROPDOWN);
		return getSelectOptionInDropdown(driver, CustomerInforUI.DAY_OF_BIRTH_DROPDOWN);
	}
	public String getMonthOfBirthDropdown() {
		waitForElementVisible(driver, CustomerInforUI.MONTH_OF_BIRTH_DROPDOWN);
		return getSelectOptionInDropdown(driver, CustomerInforUI.MONTH_OF_BIRTH_DROPDOWN);
	}
	public String getyearOfBirthDropdown() {
		waitForElementVisible(driver, CustomerInforUI.YEAR_OF_BIRTH_DROPDOWN);
		return getSelectOptionInDropdown(driver, CustomerInforUI.YEAR_OF_BIRTH_DROPDOWN);
	}
	public String getEmailTextbox() {
		waitForElementVisible(driver, CustomerInforUI.EMAIL_TEXBOX);
		return getAttributeValue(driver, CustomerInforUI.EMAIL_TEXBOX, "value");
	}
	public String getCompanyNameTextbox() {
		waitForElementVisible(driver, CustomerInforUI.COMPANY_TEXBOX);
		return getAttributeValue(driver, CustomerInforUI.COMPANY_TEXBOX, "value");
	}
	public AddressPO openAddreses(WebDriver driver) {
		
		return null;
	}
}
