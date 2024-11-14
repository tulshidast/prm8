package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		// Thread.sleep(10000);

		// explicit wait

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#delayedText"))));

		System.out.println(driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

		WebElement myButton = driver.findElement(By.cssSelector("#myBtn"));

		System.out.println("my button after click on try it and before waiting = " + myButton.isEnabled());

		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		wait.until(ExpectedConditions.attributeContains(myButton, "disabled", "true"));

		System.out.println("my button after click on try it and after waiting = " + myButton.isEnabled());

		System.out.println("attribute value = " + myButton.getAttribute("disabled"));

//		String text = driver.findElement(By.cssSelector("#delayedText")).getText();
//
//		System.out.println(text);

	}

}
