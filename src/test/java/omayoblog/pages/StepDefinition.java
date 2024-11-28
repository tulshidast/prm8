package omayoblog.pages;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import b8.utility.Utility;
import b8.utility.WebDriverFactory;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {

	WebDriver driver;
	org.apache.log4j.Logger logger;

	@Given("launch application")
	public void launchApplication() {
		driver = WebDriverFactory.getDriver();
		try {
			driver.get(Utility.getProperty("url"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		logger = LogManager.getLogger(StepDefinition.class);
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
	}

	@When("^user enters \"(.*)\" in username text field$")
	public void enterUserName(String uname) {
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(uname);
	}

	@And("user enters password in password text field")
	public void enterPassword() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Admin");
	}

	@And("user click on login button")
	public void clickOnLoginBtn() {
		driver.findElement(By.xpath("//input[@name='submit']")).click();
	}

	@Then("user logged in successfully")
	public void verifyUserLoggedInSuccessfully() {
		String msg = driver.findElement(By.xpath("//h3[text()='Login Successfully']")).getText();
		Assert.assertEquals(msg, "Login Successfully");
	}

	@And("quite browser")
	public void tearDown() {
		driver.quit();
	}

}
