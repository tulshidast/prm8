package omayoblog.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Selenium143Page {

	WebDriver driver;

	public Selenium143Page(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='What is Selenium?']")
	WebElement whatIsSeleniumLink;

	// this method is required to click on link
	public String getWhatIsSeleniumLinkText() {
		return whatIsSeleniumLink.getText();
	}

}
