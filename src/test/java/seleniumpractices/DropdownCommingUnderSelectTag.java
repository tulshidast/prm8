package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownCommingUnderSelectTag {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement singleSelectDropdown = driver.findElement(By.cssSelector("select#drop1"));

		Select select = new Select(singleSelectDropdown);

		List<WebElement> option = select.getAllSelectedOptions();

		// option.get(0).getText();

		for (WebElement elm : option) {

			System.out.println(elm.getText());
		}

		System.out.println("###########################################");
		System.out.println(select.getFirstSelectedOption().getText());

		System.out.println("##############################################");

		List<WebElement> allOptionsFromDropdown = select.getOptions();

		for (WebElement option1 : allOptionsFromDropdown) {
			System.out.println(option1.getText());
		}

		System.out.println("#######################################");

		System.out.println(select.isMultiple());

		System.out.println("#########################################");

		select.selectByIndex(3);

		Thread.sleep(3000);

		select.selectByValue("def");

		Thread.sleep(3000);

		select.selectByVisibleText("Older Newsletters");
	}

}
