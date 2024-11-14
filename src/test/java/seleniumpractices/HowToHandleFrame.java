package seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleFrame {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement teaxtField = driver.findElement(By.cssSelector("#ta1"));
		teaxtField.sendKeys("Welcome to pune");

		WebElement frame = driver.findElement(By.xpath("//iframe[@id='navbar-iframe']"));

		driver.switchTo().frame(frame);

		driver.findElement(By.cssSelector("input#b-query")).sendKeys("Testing");

		driver.switchTo().defaultContent();

		teaxtField.clear();

	}

}
