package b8.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static String getProperty(String key) throws IOException {

		File file = new File("src/test/resources/commondata.properties");
		FileInputStream fileInputStream = new FileInputStream(file);

		Properties properties = new Properties();

		properties.load(fileInputStream);

		return properties.getProperty(key);

	}

	public static ArrayList<Object> readExcelData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {

		ArrayList<Object> data = new ArrayList<Object>();

		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new File(excelFilePath));

		XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);

		int lastNumberRow = xssfSheet.getLastRowNum();

		for (int i = 1; i <= lastNumberRow; i++) {
			XSSFRow xssfRow = xssfSheet.getRow(i);

			int lastCellNumber = xssfRow.getLastCellNum();

			for (int j = 0; j < lastCellNumber; j++) {

				XSSFCell xssfCell = xssfRow.getCell(j);

				int cellType = xssfCell.getCellType();

				if (cellType == Cell.CELL_TYPE_NUMERIC) {
					data.add(xssfCell.getNumericCellValue());
				}
				if (cellType == Cell.CELL_TYPE_STRING) {
					data.add(xssfCell.getStringCellValue());
				}

			}

		}
		return data;
	}

	/**
	 * This method is used to switch on window other than parent/current focused
	 * window.
	 * 
	 * @param driver pass driver as WebDriver instance.
	 * 
	 * @return String It return parent window handle.
	 * 
	 */
	public static String switchToAnotherWindow(WebDriver driver) {
		String currentWindowHandle = driver.getWindowHandle();

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {
			if (!(handle.equals(currentWindowHandle))) {
				driver.switchTo().window(handle);
			}
		}
		return currentWindowHandle;

	}

	public static void switchToAnotherWindow(WebDriver driver, String windowHandle) {

		driver.switchTo().window(windowHandle);

	}

}
