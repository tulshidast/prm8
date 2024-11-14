package seleniumpractices;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendTextOnAlert {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		driver.manage().window().maximize();

		driver.switchTo().frame("iframeResult");

		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		Alert alt = driver.switchTo().alert();

		alt.sendKeys("Java");

		alt.accept();

	}

}
