package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver launch() {

		System.setProperty("webdriver.chrome.driver",
				"I:\\Aravinsami\\sami codes\\CucumberExcel\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;

	}

	public static void enter(WebElement e, String s) {

		e.sendKeys(s);

	}

	public static void click(WebElement e) {
		e.click();
	}

	public static String data(int row, int cloumn) throws IOException {
		String value = null;
		File f = new File("I:\\Aravinsami\\sami codes\\CucumberExcel\\Excel\\Book1.xlsx");

		FileInputStream Is = new FileInputStream(f);

		Workbook w = new XSSFWorkbook(Is);

		Sheet s = w.getSheet("Sheet1");

		Row r = s.getRow(row);

		Cell c = r.getCell(cloumn);
		CellType type = c.getCellType();

		if (type == CellType.STRING) {

			value = c.getStringCellValue();

		} else if (type == CellType.NUMERIC) {

			if (DateUtil.isCellDateFormatted(c)) {

				Date d = c.getDateCellValue();

				SimpleDateFormat sd = new SimpleDateFormat("dd-mm-yy");
				value = sd.format(d);

			}

			else {

				double dd = c.getNumericCellValue();

				long l = (long) dd;
				value = String.valueOf(l);

			}

		}
		return value;

	}

}
