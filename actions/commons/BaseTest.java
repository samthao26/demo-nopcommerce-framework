package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	 WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	 String osName = System.getProperty("os.name");
	 
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
	 
	 protected int getRandomNumber() {
		 return new Random().nextInt(99999);
	 }
}
