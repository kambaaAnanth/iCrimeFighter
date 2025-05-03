package com.loginPageTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.CaseList;
import com.pages.GetDifferentCaseName;
import com.testBase.TestBase;
import com.utility.Excel_Reader;
import com.utility.TestUtil;
import com.utility.WriteValuesInExcel;

public class GetDifferentCaseNameTest extends TestBase {

	
	
	GetDifferentCaseName loginPage;

	GetDifferentCaseNameTest log;

	WriteValuesInExcel excel;

	FileOutputStream fo;

	List<String> totalCase = new ArrayList<>();

	public GetDifferentCaseNameTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new GetDifferentCaseName();
	}

	@Test(dataProvider = "CrendentialSupplier",priority = 1)
	public void loginTest(String username, String password) throws InterruptedException {

		loginPage.doClickOnEmailTextBox();

		Thread.sleep(3000);

		loginPage.enterEmail(username+Keys.ENTER);

		//Thread.sleep(3000);

		//loginPage.doClickContinueButton();

		Thread.sleep(3000);

		loginPage.doClickOnPasswordTextBox();

		Thread.sleep(3000);

		loginPage.enterPassword(password+Keys.ENTER);

		//Thread.sleep(3000);

		//loginPage.doClickLoginButton();

		Thread.sleep(7000);

//		String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
//		
//		String totalCount = records.substring(records.indexOf("f") + 1).trim();
//
//		System.out.println("Old Website total record is " + totalCount);

		loginPage.doClickNumberOfItemSelect();

		Thread.sleep(3000);

		loginPage.selectNumberOfRecordSelectPerPage();

		Thread.sleep(3000);

		List<WebElement> caseNames = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

		//List<String> names = new ArrayList<String>();
		for (WebElement casename : caseNames) {

			totalCase.add(casename.getText());

		}
		String nextButton = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
				.getDomAttribute("aria-disabled");

		boolean button = Boolean.parseBoolean(nextButton);

		// System.out.println(button);

		while (button != true) {

			// Thread.sleep(10000);

			driver.findElement(By.xpath("//button[@aria-label='Next page']")).click();

			Thread.sleep(3000);

			caseNames = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

			for (WebElement casename : caseNames) {

				totalCase.add(casename.getText());

			}

			nextButton = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button = Boolean.parseBoolean(nextButton);
		}

		

		System.out.println("Total Number of case in the List is  => " + totalCase.size());

	}
	
	@Test(priority = 2)
	public void getTotalCaseFileName() throws IOException {
		
		String currentWorkingDirectory = System.getProperty("user.dir");

		int rowNum = 0;

		// int cellNum=0;

		Workbook wb = new XSSFWorkbook();

		fo = new FileOutputStream(currentWorkingDirectory+prop.getProperty("differentCaseName"));

		Sheet sheet = wb.createSheet(prop.getProperty("caseName"));

		Map<String, Integer> countMap = new HashMap<>();
		for (String name : totalCase) {
			countMap.put(name, countMap.getOrDefault(name, 0) + 1);
		}

		// List<String> result = new ArrayList<>();

		for (String name : totalCase) {
			if (countMap.get(name) == 1) {
				Row row = sheet.createRow(rowNum++);

				Cell cell = row.createCell(0);

				cell.setCellValue(name);
			}
		}

//        result = new ArrayList<>(new LinkedHashSet<>(result));
//
//        System.out.println(result);

		 wb.write(fo);
		 
		 
		 System.out.println("SUCCESFULLY STORED THE DIFFERENT CASE NAMES IN CASELIST.XLSX FILE");

		driver.close();
	}

	@DataProvider(name = "CrendentialSupplier")
	public Object[][] readData() throws IOException {
		
		String currentWorkingDirectory = System.getProperty("user.dir");

		File file = new File(currentWorkingDirectory+prop.getProperty("Login"));

		FileInputStream input = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(input);

		XSSFSheet sheet = wb.getSheet(prop.getProperty("sheetName"));

		int rowCount = sheet.getLastRowNum();

		int columnCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][columnCount];

		for (int r = 0; r < rowCount; r++) {

			XSSFRow row = sheet.getRow(r + 1);

			for (int c = 0; c < columnCount; c++) {

				XSSFCell cell = row.getCell(c);
				CellType celltype = cell.getCellType();

				switch (celltype) {
				case STRING:
					data[r][c] = cell.getStringCellValue();
					break;
				case NUMERIC:
					data[r][c] = Integer.parseInt(cell.getStringCellValue());
					break;

				case BOOLEAN:
					data[r][c] = cell.getBooleanCellValue();
					break;

				}
			}

		}

		return data;
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}

		driver.quit();

	}
}// class
