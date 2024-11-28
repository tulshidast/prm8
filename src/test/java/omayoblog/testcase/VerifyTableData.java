package omayoblog.testcase;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import omayoblog.pages.HomePage;

public class VerifyTableData extends BaseTest {

	HomePage homePage;

	@Test
	public void verifyTableData() throws IOException {

		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("htmlreport.html");

		ExtentReports extentReports = new ExtentReports();

		extentReports.attachReporter(extentSparkReporter);

		ExtentTest test1 = extentReports.createTest("verify Table Data");

		homePage = new HomePage(driver);

		ArrayList<String> expectResult = new ArrayList<String>();
		expectResult.add("Kishore");
		expectResult.add("22");
		expectResult.add("Delhi");
		expectResult.add("Manish");
		expectResult.add("25");
		expectResult.add("Pune");
		expectResult.add("Praveen");
		expectResult.add("29");
		expectResult.add("Bangalore");
		expectResult.add("Dheepthi");
		expectResult.add("31");
		expectResult.add("Mumbai");

		test1.info("before getting table data");
		logger.debug("before getting table data");

		ArrayList<String> tableData = homePage.getTableData();

		logger.error("after getting table data");
		test1.info("after getting table data");
		Assert.assertEquals(tableData, expectResult);
		extentReports.flush();

	}

}
