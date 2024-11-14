package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleTebularData {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th"));

		for (WebElement header : tableHeaders) {
			System.out.print(header.getText() + " ");
		}

		System.out.println();

		System.out.println("###############################");

		System.out.println();

		int NumberOfRows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();

		for (int i = 1; i <= NumberOfRows; i++) {

			List<WebElement> columnData = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td"));

			for (WebElement column : columnData) {
				System.out.print(column.getText() + "    ");
			}
			System.out.println();
		}

	}

}
