package seleniumpractices;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorStratergies {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();

		WebElement textAreaField = driver.findElement(By.id("ta1"));

		textAreaField.sendKeys("welcome to selenium");

		WebElement searchThisBlog = driver.findElement(By.name("q"));
		searchThisBlog.sendKeys("selenium");
		Thread.sleep(5000);
		searchThisBlog.clear();
		
	 	List<WebElement> tableElements = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td"));

        for(WebElement elm:tableElements)
        {
        	System.out.println(elm.getText());
        }

		String text = driver.findElement(By.className("title")).getText();

		System.out.println(text);

		WebElement pageTitle = driver.findElement(By.tagName("h1"));

		System.out.println(pageTitle.getText());

		WebElement pageOneLink = driver.findElement(By.linkText("Page One"));

		pageOneLink.click();

		driver.findElement(By.partialLinkText("ytestingblo")).click();
		
		

	}

}
