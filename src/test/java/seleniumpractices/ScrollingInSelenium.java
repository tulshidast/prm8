package seleniumpractices;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import b8.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingInSelenium {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get(Utility.getProperty("appurl"));

		driver.manage().window().maximize();

		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;

//		javascriptExecutor.executeScript("window.scrollBy(0,1000)", "");
//
//		Thread.sleep(3000);
//
//		javascriptExecutor.executeScript("window.scrollBy(0,-300)", "");

//		Thread.sleep(3000);
//		javascriptExecutor.executeScript("window.scrollBy(100,0)", "");
//
//		Thread.sleep(3000);
//
//		javascriptExecutor.executeScript("window.scrollBy(-100,0)", "");

//		Thread.sleep(3000);
//
//		javascriptExecutor.executeScript("window.scrollBy(100,1000)", "");

//		Thread.sleep(3000);
//		
//		javascriptExecutor.executeScript("window.scrollBy(document.body.scrollWidth,0)");

//		Thread.sleep(3000);
//		
//		javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");

//		Thread.sleep(3000);
//		
//		WebElement btn2=driver.findElement(By.cssSelector("#but2"));
//		
//		javascriptExecutor.executeScript("arguments[0].scrollIntoView();", btn2);

		// driver.findElement(By.xpath("//div[@id='Attribution1']//a[contains(@href,'logger')]")).click();

		javascriptExecutor.executeScript("arguments[0].scrollIntoView();",
				driver.findElement(By.cssSelector("#checkbox2")));

		Thread.sleep(4000);

		javascriptExecutor.executeScript("arguments[0].click();", driver.findElement(By.cssSelector("#checkbox2")));

	}

}
