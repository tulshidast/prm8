package seleniumpractices;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import b8.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleMultipleWindows {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.getProperty("appurl"));

		driver.manage().window().maximize();

		WebElement teaxtField = driver.findElement(By.cssSelector("#ta1"));
		teaxtField.sendKeys("Welcome to pune");

		driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();

		String parentWindow = driver.getWindowHandle();

		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (handle.equals(parentWindow)) {
				continue;
			} else {
				driver.switchTo().window(handle);
			}
		}

		String newWindowTitle = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();

		System.out.println(newWindowTitle);

		driver.close();

		driver.switchTo().window(parentWindow);

		teaxtField.clear();

		driver.quit();
	}

}
