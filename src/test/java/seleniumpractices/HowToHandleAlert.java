package seleniumpractices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleAlert {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#prompt")).click();

		Alert alt = driver.switchTo().alert();

		System.out.println(alt.getText());

		alt.sendKeys("Testing");

		Thread.sleep(5000);

		alt.accept();

		WebElement teaxtField = driver.findElement(By.cssSelector("#ta1"));
		teaxtField.sendKeys("Welcome to pune");

	}

}
