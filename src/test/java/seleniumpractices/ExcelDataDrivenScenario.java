package seleniumpractices;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import b8.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataDrivenScenario {

	public static void main(String[] args) throws InvalidFormatException, IOException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		ArrayList<Object> dataFromExcel = Utility.readExcelData("src/test/resources/userdata.xlsx", "Sheet2");

		// Load a new web page in the current browser window.
		driver.get("https://demo.guru99.com/test/newtours/register.php");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(dataFromExcel.get(0).toString());

		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(dataFromExcel.get(1).toString());

		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(dataFromExcel.get(2).toString());

		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(dataFromExcel.get(3).toString());

	}

}
