package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitInSelenium {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement elm = driver.findElement(By.cssSelector("#delayedText"));

		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(10)).ignoring(TimeoutException.class);

		fluentWait.until(ExpectedConditions.visibilityOf(elm));

		System.out.println(driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

	}

}
