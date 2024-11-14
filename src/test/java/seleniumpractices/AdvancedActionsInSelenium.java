package seleniumpractices;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdvancedActionsInSelenium {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		WebElement searchTextArea = driver.findElement(By.xpath("//textarea[@name='q']"));

		Actions actions = new Actions(driver);

		actions.click(searchTextArea).keyDown(searchTextArea, Keys.SHIFT).keyDown("m").keyUp(Keys.SHIFT).keyUp("m")
				.keyDown("o").keyUp("o").build().perform();

		WebElement googleIcon = driver.findElement(By.cssSelector("a.gb_A"));

		actions.moveToElement(googleIcon).build().perform();

		// actions.contextClick().build().perform();

		// actions.contextClick(searchTextArea).build().perform();

		Thread.sleep(5000);

		actions.doubleClick(searchTextArea).build().perform();

		driver.navigate().to("https://www.tutorialspoint.com/selenium/practice/droppable.php");

		WebElement source = driver.findElement(By.cssSelector("div#draggable"));
		WebElement target = driver.findElement(By.cssSelector("div#droppable"));

		//actions.dragAndDrop(source, target).build().perform();

		actions.clickAndHold(source).pause(Duration.ofSeconds(2)).moveToElement(target).release(target).build()
				.perform();

	}

}
