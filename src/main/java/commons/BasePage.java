package commons;

import java.util.List;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



import PageUIs.user.UserBasePageUI;
import pageObject.user.HomePO;

public class BasePage {
	public BasePage() {
		
	}
	private static BasePage basePage;
	public static BasePage getBasePage() {
		if(basePage==null) {
			basePage= new BasePage();
		}
		return basePage;
	}
	public void openUrl (WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	public String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	public void  sendKeyToAlert(WebDriver driver, String valueToSendKeys) {
		waitForAlertPresence(driver).sendKeys(valueToSendKeys);
	}
	public void SwithchTOWindowById(WebDriver driver, String parentID) {
		Set<String> allWindowIds= driver.getWindowHandles();
		for(String id: allWindowIds) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	public void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindowIds = driver.getWindowHandles();
		for(String id: allWindowIds) {
			driver.switchTo().window(id);
			String currentPageTitle = driver.getTitle();
			if(currentPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}
	public void closeAllWindowWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowIds= driver.getWindowHandles();
		for(String id: allWindowIds) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();				
			}
		}
		driver.switchTo().window(parentID);
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	public WebElement getElement(WebDriver driver, String locatorType, String ...dynamicValue) {
		return driver.findElement(byXpath(getDynamicLocator(locatorType, dynamicValue)));
	}
	public List<WebElement>getListWebElement(WebDriver driver, String locator){
		return driver.findElements(getByLocator(locator));
	}
	public By byXpath(String locator) {
		return By.xpath(locator);
	}
	public By getByLocator(String locatorType) {
		By by = null;
		if(locatorType.toUpperCase().startsWith("ID=")) {
			locatorType = locatorType.substring(3);
			by=By.id(locatorType);
		}else if(locatorType.toUpperCase().startsWith("CLASS=")) {
			locatorType = locatorType.substring(6);
			by=By.className(locatorType);
		}else if (locatorType.toUpperCase().startsWith("NAME=")) {
			locatorType = locatorType.substring(5);
			by =By.name(locatorType);
		}else if(locatorType.toUpperCase().startsWith("CSS=")) {
			locatorType = locatorType.substring(4);
			by=By.cssSelector(locatorType);
		} else if (locatorType.toUpperCase().startsWith("XPATH=")) {
			locatorType = locatorType.substring(6);
			by = By.xpath(locatorType);
	    } else if (locatorType.toUpperCase().startsWith("TAGNAME=")) {
	    	locatorType = locatorType.substring(8);
	    	by = By.tagName(locatorType);
		} else {
			throw new RuntimeException("---------> Your loactor is invalid! <---------");
		}
		return by;
		
	}
	String getDynamicXpath(String locatorType, String...dynamicValue) {
		if(locatorType.toUpperCase().startsWith("XPATH=")) {
			locatorType = String.format(locatorType, (Object[])dynamicValue);
		}
		return locatorType;
	}
	private String getDynamicLocator(String locatorType, String ...dynamicValues) {
		return  String.format(locatorType, (Object[])dynamicValues);
	}
	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, String locatorType, String...dynamicValues) {
		getElement(driver, getDynamicLocator(locatorType, dynamicValues)).click();
	}
	public void sendkeyToElement(WebDriver driver, String locator, String keyValueToSend) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(keyValueToSend);
	}
	public void sendkeyToElement(WebDriver driver, String locatorType, String value, String...dynamicValues) {
		getElement(driver, locatorType, dynamicValues).clear();
		getElement(driver, locatorType, dynamicValues).sendKeys(dynamicValues);
		
	}
	public String getAttributeValue(WebDriver driver, String locator, String attribuName) {	
		return getWebElement(driver, locator).getAttribute(attribuName);
	}
	public String getTextElement(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();
	}
	public String getTextElement(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, getDynamicXpath(locatorType, dynamicValues)).getText();
	}
	public void getElementSize(WebDriver driver, String locator) {
		getListWebElement(driver, locator).size();
	}
	public void getSelectItemInDropdownByText(WebDriver driver,String locator, String itemValue) {
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
	}
	public void getSelectItemInDropdownByText(WebDriver driver, String locatorType, String itemValue, String...dynamicValues) {
		new Select(getElement(driver, getDynamicLocator(locatorType, dynamicValues))).selectByVisibleText(itemValue);
	}
	public String getSelectOptionInDropdown(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try { 
			Thread.sleep(timeInSecond * 1000);
		}catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	
	public void checkToCheckboxRadio(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
			
			}
		}
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	public boolean isElementDisPlayed(WebDriver driver, String locatorType, String...dynamicValues) {
		return getElement(driver, locatorType, dynamicValues).isDisplayed();
	}
	
	public boolean isElementSelected (WebDriver driver, String locator) {
	   return getWebElement(driver, locator).isSelected();
	}
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
	public void switchToDefaulContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}	
	public void wiatForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));
	}
	public void waitForElementVisible(WebDriver driver, String locatorType, String...dynamicValues) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(byXpath(getDynamicLocator(locatorType, dynamicValues))));
	}
	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));	
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		 new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(byXpath(getDynamicLocator(locatorType, dynamicValues))));
	}
	
	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locatorType, String...dynamicValues) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(byXpath(getDynamicXpath(locatorType, dynamicValues))));
		
	}
	public void  waitForListElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}
	public void waitForElementPresent(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
	}
	
	public void waitForListElementPresent(WebDriver driver, String locator) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
	}
	public boolean waitForPageToBe(WebDriver driver, String pageUrl) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe(pageUrl));
	}
	public boolean waitForElementSelected(WebDriver driver, String locator) {
		return new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
	}
	
	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserBasePageUI.DYNAMIC_TEXTBOX_BY_ID, value,textboxID);
	}
	public void selectDropdownByName(WebDriver driver, String dropdownName, String itemText) {
		waitForElementVisible(driver, UserBasePageUI.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		getSelectItemInDropdownByText(driver,UserBasePageUI.DYNAMIC_DROPDOWN_BY_NAME,itemText, dropdownName);
	}

	public void clickToHeaderLink(WebDriver driver, String headerLink) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_HEADER_LINK, headerLink);
		clickToElement(driver, UserBasePageUI.DYNAMIC_HEADER_LINK, headerLink);
	}
	public void clickToButtonByText(WebDriver driver, String buttonTextName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonTextName);
		clickToElement(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonTextName );
		
	}
	
	public void  clickToButtonByTextName(WebDriver driver, String buttonTextName) {
		waitForElementClickable(driver, UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonTextName);
		clickToElement(driver,UserBasePageUI.DYNAMIC_BUTTON_BY_TEXT, buttonTextName);
	}
	
}
