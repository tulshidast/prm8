package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropdownNotCommingUnderSelectTag {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		// Thread.sleep(5000);

		// driver.switchTo().alert().dismiss();
		HandleDropdownNotCommingUnderSelectTag h = new HandleDropdownNotCommingUnderSelectTag();
		h.selectCountry("Oman");
	}

	public void selectCountry(String country) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://www.airvistara.com/in/en");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//img[contains(@src,'arrow-purple')]")).click();

		// driver.findElement(By.xpath("//ul[@id='country-scroll']//li//span[text()='" +
		// country + "']")).click();

		List<WebElement> countries = driver.findElements(By.xpath("//ul[@id='country-scroll']//li//span"));

		for (WebElement con : countries) {
			if (con.getText().equals(country)) {
				con.click();
				break;
			}
		}
	}

}
