package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://new-cp.gfau.augmont.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	@org.testng.annotations.Test
	public void test() {

		driver.findElement(By.linkText("Log In / Sign Up")).click();

		driver.findElement(By.cssSelector("#mobileNumber")).sendKeys("XXXXXXXXXXXXXX");

	}

	@AfterMethod
	public void terdown() {
		driver.quit();
	}

}
