package omayoblog.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import b8.utility.Utility;

public class HomePage {

	// webdriver instance
	WebDriver driver;

	// this is constructor to initialize page factory
	public HomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//table[@id='table1']//tr//td")
	List<WebElement> tableData;

	@FindBy(css = "#selenium143")
	WebElement selenium143Link;

	public ArrayList<String> getTableData() {

		ArrayList<String> tableActualData = new ArrayList<String>();

		for (WebElement td : tableData) {
			tableActualData.add(td.getText());
		}
		return tableActualData;
	}

	// updates
	public String clickOnSelenium143Link() {

		selenium143Link.click();
		return Utility.switchToAnotherWindow(driver);
		

	}

}
