package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HowToHandleDatePicker {

	public static void main(String[] args) {

		HowToHandleDatePicker handleDatePicker = new HowToHandleDatePicker();
		handleDatePicker.selectDate("2023", "April", "12", "02", "AM");

	}

	/**
	 * This method is used to select start date from date picker page.
	 * 
	 * @param year  pass year as String.
	 * 
	 * @param month
	 * @param date
	 * @param time
	 * @param amp
	 * 
	 */

	public void selectDate(String year, String month, String date, String time, String amp) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// Load a new web page in the current browser window.
		driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");

		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("div#datepicker input[id='datetimepicker1']:nth-child(1)")).click();
		driver.findElement(By.xpath("(//input[@aria-label='Year'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@aria-label='Year'])[1]")).sendKeys(year);

		Select select = new Select(
				driver.findElement(By.xpath("(//select[@class='flatpickr-monthDropdown-months'])[1]")));

		select.selectByVisibleText(month);

		List<WebElement> dates = driver.findElements(By.xpath(
				"(//div[@class='dayContainer'])[1]//span[not(@class='flatpickr-day prevMonthDay') and not(@class='flatpickr-day nextMonthDay')]"));

		for (WebElement currentDate : dates) {
			if (currentDate.getText().equals(date)) {
				currentDate.click();
				break;
			}

		}

		driver.findElement(By.xpath("(//input[@aria-label='Hour'])[1]")).clear();
		driver.findElement(By.xpath("(//input[@aria-label='Hour'])[1]")).sendKeys(time);

		WebElement amPm = driver.findElement(By.xpath("(//span[@title='Click to toggle'])[1]"));

		if (!(amPm.getText().equals(amp))) {
			amPm.click();
		}

		driver.findElement(By.xpath("//h1[text()='Date Picker']")).click();
	}

}
