package b8.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

	public static WebDriverFactory webDriverFactory;

	static WebDriver driver;

	private WebDriverFactory() {

	}

	private void initalizeBrowser(String browser) {

		switch (browser) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		case "edge": {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		case "firefox": {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		default:
			throw new IllegalArgumentException(browser + "Please pass valid browser");
		}

	}

	private static WebDriver initWebDriverFactory() {

		if (webDriverFactory == null) {
			synchronized (WebDriverFactory.class) {
				webDriverFactory = new WebDriverFactory();
			}
		}

		if (driver == null) {
			try {
				webDriverFactory.initalizeBrowser(Utility.getProperty("browser"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;

	}

	public static WebDriver getDriver() {
		return initWebDriverFactory();
	}
}
