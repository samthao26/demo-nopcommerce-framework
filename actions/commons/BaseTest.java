package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.reporters.jq.Main;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	 WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	 String osName = System.getProperty("os.name");
	 protected final Logger log; 
	 protected BaseTest() {
		
		 log =LogManager.getLogger(getClass());
		 
	 }
	
	 
	 protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		 BrowserName browser = BrowserName.valueOf(browserName.toUpperCase());
		 switch(browser) {
			 case FIREFOX:
				 driver = WebDriverManager.firefoxdriver().create();
				 break;
			 case CHROME: 
				 driver = WebDriverManager.chromedriver().create();
				 break;
			 case EDGE:
				 driver =  WebDriverManager.edgedriver().create();
			 case OPERA:
				 driver = WebDriverManager.edgedriver().create();
				 break;
			 default:
				 throw new RuntimeException(" Please enter the correct Browser name!");
		 }
		 driver.manage().window().setSize(new Dimension(1366, 766));
		 driver.manage().window().setPosition(new Point(0, 0));
		 driver.get(appUrl);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 return driver; 
	 }
	 

		protected boolean verifyTrue(boolean condition) {
			boolean pass = true;
			try {
				if (condition == true) {
					System.out.println(" -------------------------- PASSED -------------------------- ");
				} else {
					System.out.println(" -------------------------- FAILED -------------------------- ");
				}
				Assert.assertTrue(condition);
			} catch (Throwable e) {
				pass = false;

				// Add lỗi vào ReportNG
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}
		protected boolean verifyFalse(boolean condition) {
			boolean pass = true;
			try {
				if (condition == false) {
					System.out.println(" -------------------------- PASSED -------------------------- ");
				} else {
					System.out.println(" -------------------------- FAILED -------------------------- ");
				}
				Assert.assertFalse(condition);
			} catch (Throwable e) {
				pass = false;
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}

		

		protected boolean verifyEquals(Object actual, Object expected) {
			boolean pass = true;
			try {
				Assert.assertEquals(actual, expected);
				System.out.println(" -------------------------- PASSED ---------------------- ---- ");
			} catch (Throwable e) {
				pass = false;
				System.out.println(" -------------------------- FAILED -------------------------- ");
				VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
				Reporter.getCurrentTestResult().setThrowable(e);
			}
			return pass;
		}
	 
	 protected String generateEmail() {
		 return new Random().nextInt(99999) + "@gmail.com";
	 }
}
