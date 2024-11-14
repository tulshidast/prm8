package omayoblog.testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import b8.utility.Utility;
import omayoblog.pages.HomePage;
import omayoblog.pages.Selenium143Page;

public class VerifySelenium143Page extends BaseTest {

	// Page constant
	private static final String OMAYO_QAFOX_COM = "omayo (QAFox.com)";

	HomePage homePage;
	Selenium143Page selenium143Page;

	@Test
	public void verifySelenium143Page() {
		homePage = new HomePage(driver);
		String parentWindowHandle = homePage.clickOnSelenium143Link();
		selenium143Page = new Selenium143Page(driver);
		String actualWhatIsSeleniumLinkText = selenium143Page.getWhatIsSeleniumLinkText();

		assertEquals(actualWhatIsSeleniumLinkText, "What is Selenium?");

		Utility.switchToAnotherWindow(driver, parentWindowHandle);

		assertEquals(driver.getTitle(), OMAYO_QAFOX_COM);
	}

}
