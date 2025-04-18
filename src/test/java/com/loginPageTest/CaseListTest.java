package com.loginPageTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.CaseList;

import com.testBase.TestBase;
import com.utility.TestUtil;


public class CaseListTest extends TestBase {
	
	CaseList loginPage;

	public CaseListTest(){
		super();
	}
	

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new CaseList();	
	}
	
	@Test(dataProvider="CrendentialSupplier")
	public void loginTest(String username,String password) throws InterruptedException {
	
		loginPage.doClickOnEmailTextBox();
		
		Thread.sleep(3000);
		
		loginPage.enterEmail(username);
		
		Thread.sleep(3000);
		
		loginPage.doClickContinueButton();
		
		Thread.sleep(3000);
		
		loginPage.doClickOnPasswordTextBox();
		
		Thread.sleep(3000);
		
		loginPage.enterPassword(password);
		
		Thread.sleep(3000);
		
		loginPage.doClickLoginButton();
		
		Thread.sleep(5000);
		
		String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
		
		String totalCount = records.substring(records.indexOf("f") + 1).trim();

		System.out.println("Old Website total record is " + totalCount);
	}
	
	@DataProvider(name="CrendentialSupplier")
	public Object[][] readData() throws IOException {

		File file = new File(prop.getProperty("TestData"));

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
	public void tearDown(ITestResult result) throws IOException{
		
		if (ITestResult.FAILURE == result.getStatus()) {

			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}
		driver.quit();
	}

}
