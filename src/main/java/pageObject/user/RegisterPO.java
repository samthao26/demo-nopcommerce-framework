package pageObject.user;

import org.testng.annotations.Test;
import PageUIs.user.UserRegisterUI;
import commons.BasePage;
import org.openqa.selenium.WebDriver;


public class RegisterPO extends BasePage{
	WebDriver driver;


public RegisterPO(WebDriver driver) {
	this.driver = driver;
	
	}

public void clickToGenderFemaleRadio() {
	waitForElementClickable(driver, UserRegisterUI.GENDER_FAMALE_RADIO);
	clickToElement(driver, UserRegisterUI.GENDER_FAMALE_RADIO);
	
}

public boolean isRegisteredSucessMessageDisplayed() {
	waitForElementVisible(driver, UserRegisterUI.REGISTER_SUCESS_MESAGER);
	return isElementDisplayed(driver, UserRegisterUI.REGISTER_SUCESS_MESAGER);
}

public String getErrorMessageByFieldName(String fileName) {
	waitForElementVisible(driver, UserRegisterUI.ERROR_MESSAGE_BY_FILE_NAME, fileName);
	return getTextElement(driver, UserRegisterUI.ERROR_MESSAGE_BY_FILE_NAME, fileName);
}

public boolean isErrorMessageForExistingEmailDisplayed(){
	waitForElementVisible(driver, UserRegisterUI.ERROR_MESSAGE_VALIDATION);
	return isElementDisplayed(driver, UserRegisterUI.ERROR_MESSAGE_VALIDATION);
}
public void ClickToContinueButton() {
	waitForElementVisible(driver, UserRegisterUI.CONTINUE_BUTTON);
	clickToElement(driver, UserRegisterUI.CONTINUE_BUTTON);
}

public void clickToGenderMaleRadio() {
	waitForElementClickable(driver, UserRegisterUI.GENDER_MALE_RADIO);
	clickToElement(driver, UserRegisterUI.GENDER_MALE_RADIO);
	
}

}

