package seleniumpractices;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();
//		driver.manage().window().fullscreen();
//		driver.manage().window().minimize();

		// Find the first WebElement using the given method.
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("test");

		// Thread.sleep(3000);

		// Find all elements within the current page using the given mechanism.
		List<WebElement> searchFields = driver.findElements(By.xpath("//input[@name='q']"));
		searchFields.get(0).clear();

		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//div[contains(text(),'Simple theme. Powered by')]//a[contains(@href,'blogger') and text()='Blogger']"))
				.click();

		// driver.findElement(By.xpath("//a[text()='Open a popup window']")).click();

		// Close the current window, quitting the browser if it's the last window
		// currently open
		// driver.close();

		// https://omayo.blogspot.com/
		String currentlyOpenedUrl = driver.getCurrentUrl();
		System.out.println("Current url = " + currentlyOpenedUrl);
		System.out.println("#################################################");

		// Get the source of the last loaded page.
		String htmlCode = driver.getPageSource();
		System.out.println(htmlCode);

		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		// omayo (QAFox.com)
		System.out.println("Current page title = " + driver.getTitle());

		// Return an opaque handle to this window that uniquely identifies it within
		// this driver instance
		String currentlyFocussedWindow = driver.getWindowHandle();

		System.out.println("Current focused window handle = " + currentlyFocussedWindow);

		// return set of window handles which is related to all tabs or windows opened
		// by current webdriver session
		Set<String> windowsHandles = driver.getWindowHandles();

		System.out.println("All opened windows or tabs handles by current browser session");
		for (String s : windowsHandles) {
			System.out.println(s);
		}

		System.out.println("All opened windows or tabs handles by current browser session");

		// Quits this driver, closing every associated window/tab.
		driver.quit();
	}

}
