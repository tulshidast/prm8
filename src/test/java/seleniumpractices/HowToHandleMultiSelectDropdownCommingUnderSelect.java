package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleMultiSelectDropdownCommingUnderSelect {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		Select select = new Select(driver.findElement(By.cssSelector("#multiselect1")));

		List<WebElement> options = select.getOptions();
		for (WebElement elm : options) {
			System.out.println(elm.getText());
		}

		System.out.println("##################################");

		select.selectByIndex(2);
		select.selectByValue("audix");
		select.selectByVisibleText("Volvo");

		System.out.println(select.getFirstSelectedOption().getText());

		System.out.println("#######################################");

		List<WebElement> selectedOptions = select.getAllSelectedOptions();

		for (WebElement elm : selectedOptions) {
			System.out.println(elm.getText());
		}

		System.out.println("############################");

		System.out.println(select.isMultiple());

		System.out.println("################################");

		select.deselectAll();

		Thread.sleep(3000);

		select.selectByIndex(2);
		select.selectByValue("audix");
		select.selectByVisibleText("Volvo");

		Thread.sleep(5000);

		select.deselectByVisibleText("Hyundai");
		select.deselectByIndex(3);
		select.deselectByValue("volvox");

	}

}
