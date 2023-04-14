package pageObject.user;

import org.testng.annotations.Test;
import PageUIs.user.UserRegisterUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;


public class RegisterPO extends BasePage{
	WebDriver driver;


public RegisterPO(WebDriver driver) {
	this.driver = driver;
		// TODO Auto-generated constructor stub
	}

public void clickToGenderFemaleRadio() {
	waitForElementClickable(driver, UserRegisterUI.GENDER_FAMALE_RADIO);
	clickToElement(driver, UserRegisterUI.GENDER_FAMALE_RADIO);
	
}

public void inputToFirstNameTextbox(String firstName) {
	waitForElementVisible(driver, UserRegisterUI.FIRSTNAME_TEXTBOX);
	sendkeyToElement(driver, UserRegisterUI.FIRSTNAME_TEXTBOX, firstName);
	
}

public void inputToLastNameTextbox(String lastName) {
	waitForElementVisible(driver, UserRegisterUI.LASTNAME_TEXTBOX);
	sendkeyToElement(driver, UserRegisterUI.LASTNAME_TEXTBOX, lastName);
}

public void selectDayOfBirthDropdown(String day) {
	waitForElementVisible(driver, UserRegisterUI.DAY_OF_BIRTH_DROPDOWN);
	getSelectItemInDropdown(driver, UserRegisterUI.DAY_OF_BIRTH_DROPDOWN, day);
}

public void selectMonthOfBirthDropdown(String month) {
	waitForElementVisible(driver, UserRegisterUI.MONTH_OF_BIRTH_DROPDOWN);
	getSelectItemInDropdown(driver, UserRegisterUI.MONTH_OF_BIRTH_DROPDOWN, month);
}

public void selectYearOfBirthDropdown(String year) {
	waitForElementVisible(driver, UserRegisterUI.YEAR_OF_BIRTH_DROPDOWN);
	getSelectItemInDropdown(driver, UserRegisterUI.YEAR_OF_BIRTH_DROPDOWN, year);
}

public void inputToEmailTextbox(String emailAddress) {
	waitForElementVisible(driver, UserRegisterUI.EMAIL_TEXTBOX);
	sendkeyToElement(driver, UserRegisterUI.EMAIL_TEXTBOX, emailAddress);
}

public void inputToCompanyNameTextbox(String companyName) {
	waitForElementVisible(driver, UserRegisterUI.COMPANY_TEXTBOX);
	sendkeyToElement(driver, UserRegisterUI.COMPANY_TEXTBOX, companyName);
}

public void inputToPasswordTextbox(String userPassword) {
	waitForElementVisible(driver, UserRegisterUI.PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserRegisterUI.PASSWORD_TEXTBOX, userPassword);
}

public void inputToConfirmPasswordTextbox(String userPassword) {
	waitForElementVisible(driver, UserRegisterUI.CONFIRM_PASSWORD_TEXTBOX);
	sendkeyToElement(driver, UserRegisterUI.CONFIRM_PASSWORD_TEXTBOX, userPassword);
}

public void clickToRegisterButton() {
	waitForElementClickable(driver, UserRegisterUI.REGISTER_BUTTON);
	clickToElement(driver, UserRegisterUI.REGISTER_BUTTON);
}

public String getRegisteredSucessMessage() {
	waitForElementVisible(driver, UserRegisterUI.REGISTER_SUCESS_MESAGER);
	
	return getTextElement(driver, UserRegisterUI.REGISTER_SUCESS_MESAGER);
}

public LoginPO clickToLoginLink() {
	waitForElementClickable(driver, UserRegisterUI.LOGIN_LINK);
	clickToElement(driver, UserRegisterUI.LOGIN_LINK);
	return UserPageGeneratorManager.getLoginPage(driver);
}

}

