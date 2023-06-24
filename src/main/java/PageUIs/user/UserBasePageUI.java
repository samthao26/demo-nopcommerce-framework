package PageUIs.user;

public class UserBasePageUI {

public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";	
public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
public static final String DYNAMIC_SIDERBAR_BY_NAME = "//div[@class='side-2']//a[text()='%$']";
public static final String DYNAMIC_HEADER_LINK ="//a[@class='ico-%s']";
public static final String DYNAMIC_BUTTON_BY_TEXT = "//button[contains(text(),'%s')]";
public static final String DYNAMIC_PAGE_TITLE_BY_TEXT =  "//div[@class='page-title']//h1[text()='%s']";
public static final String DYNAMIC_INFOR_BY_FILE_NAME = "//ul[@class='info']//li[@class='%$' and contains(string(), '%$')]";
}
