package omayoblog.testcase;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import b8.utility.Utility;
import b8.utility.WebDriverFactory;

public class BaseTest {

	WebDriver driver;
	Logger logger;

	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException {
		driver = WebDriverFactory.getDriver();
		try {
			driver.get(Utility.getProperty("appurl"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger = LogManager.getLogger(BaseTest.class);
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
