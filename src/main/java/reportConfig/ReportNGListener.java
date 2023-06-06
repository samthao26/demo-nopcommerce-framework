package reportConfig;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportNGListener extends BaseTest implements ITestListener {
	String projectImgPath = GlobalConstants.PROJECT_PATH + "/screenshotReportNG/";

	    @Override
	    public void onStart(ITestContext arg0) {
	        Reporter.log("About to begin executing Class " + arg0.getName(), true);
	    }

	    // This belongs to ITestListener and will execute, once the whole Test is finished

	    @Override
	    public void onFinish(ITestContext arg0) {
	        Reporter.log("About to end executing Class " + arg0.getName(), true);
	    }
	    // This belongs to ITestListener and will execute before each test method

	    @Override
	    public void onTestStart(ITestResult arg0) {
	        Reporter.log("Testcase " + arg0.getName() + " started successfully", true);
	    }

	    // This belongs to ITestListener and will execute only on the event of successfull test method
	    public void onTestSuccess(ITestResult arg0) {
	        Reporter.log("Testcase " + arg0.getName() + " passed successfully", true);
	    }

	    // This belongs to ITestListener and will execute only on the event of fail test

	

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");

			Object testClass = result.getInstance();
			WebDriver driver = ((BaseTest) testClass).getDriver();

			String screenshotPath = captureScreenshot(driver, result.getName());
			Reporter.getCurrentTestResult();
			Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
			Reporter.setCurrentTestResult(null);
		} catch (NoSuchSessionException e) {
			e.printStackTrace();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public String captureScreenshot(WebDriver driver, String screenshotName) {
		String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		return screenshotBase64;
	}

}
