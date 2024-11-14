package seleniumpractices;

import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.CopyUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementMethods {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://omayo.blogspot.com/");

		driver.manage().window().maximize();

		WebElement button2 = driver.findElement(By.xpath("//button[@id='but2']"));

		WebElement table = driver.findElement(By.cssSelector("table#table1"));

		String txt = table.findElement(By.xpath("//td[text()='Kishore']")).getText();

		System.out.println(txt);

		System.out.println("########################################################");

		List<WebElement> tableData = table.findElements(By.xpath("//td"));

		for (WebElement td : tableData) {
			System.out.println(td.getText());
		}

		System.out.println("###########################");

		System.out.println(button2.getAttribute("contenteditable"));

		System.out.println("#######################################################");

		System.out.println(button2.getCssValue("border-width"));

		System.out.println(driver.findElement(By.xpath("//button[text()='Dropdown']")).getCssValue("background-color"));

		System.out.println("########################################");

		Point p = button2.getLocation();

		System.out.println(p.getX());

		System.out.println(p.getY());

		System.out.println("####################################################");

		File file = button2.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("src/test/resources/test.png"));

		System.out.println("###########################################");

		org.openqa.selenium.Dimension d = button2.getSize();

		System.out.println(d.height);
		System.out.println(d.width);

		System.out.println("###########################################");

		System.out.println(button2.getTagName());

		System.out.println("######################################");

		System.out.println(button2.isDisplayed());

		// Thread.sleep(10000);

		System.out.println(driver.findElement(By.cssSelector("#delayedText")).isDisplayed());

		System.out.println("############################################");

		System.out.println(driver.findElement(By.cssSelector("#but1")).isEnabled());
		System.out.println(button2.isEnabled());

		System.out.println("############################################################");

		System.out.println(driver.findElement(By.cssSelector("#radio1")).isSelected());

		System.out.println(driver.findElement(By.cssSelector("#checkbox1")).isSelected());
		
		System.out.println("########################################################");
		
		driver.findElement(By.xpath("//form[@name='form1']/button")).submit();

	}

}
