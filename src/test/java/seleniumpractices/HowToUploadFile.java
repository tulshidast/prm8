package seleniumpractices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToUploadFile {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

		WebElement fileUploader = driver.findElement(By.cssSelector("#uploadfile"));
		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", fileUploader);

		Thread.sleep(5000);

		fileUploader.sendKeys("C:/Users/Admin/Downloads/Core Java.pptx");
	}

}
