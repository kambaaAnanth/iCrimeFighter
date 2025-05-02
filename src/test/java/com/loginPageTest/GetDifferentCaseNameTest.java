package com.loginPageTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
import org.testng.annotations.Test;

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
	
	List<String> totalCase=new ArrayList<>();

	public GetDifferentCaseNameTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		Thread.sleep(1000);
		initialization();
		loginPage = new GetDifferentCaseName();
	}

	@Test(priority = 1)

	public void getDifferentCaseFileName1() throws InterruptedException, IOException {

		Excel_Reader reader = new Excel_Reader(prop.getProperty("TestData"));

//		int rowNum = reader.getRowCount(prop.getProperty("sheetName"));
//
//		for (int rownum = 2; rownum <= rowNum; rowNum++) {

			String uname1 = reader.getCellData(prop.getProperty("sheetName"), "Username", 2);

			String pword1 = reader.getCellData(prop.getProperty("sheetName"), "Password", 2);

			// System.out.println(uname + pword);

			Thread.sleep(3000);

			loginPage.doClickOnEmailTextBox();

			Thread.sleep(3000);

			loginPage.enterEmail(uname1 + Keys.ENTER);

			// Thread.sleep(3000);

			// loginPage.doClickContinueButton();

			Thread.sleep(3000);

			loginPage.doClickOnPasswordTextBox();

			Thread.sleep(3000);

			loginPage.enterPassword(pword1 + Keys.ENTER);

			// Thread.sleep(3000);

			// loginPage.doClickLoginButton();

			Thread.sleep(7000);

//			String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
//			
//			String totalCount = records.substring(records.indexOf("f") + 1).trim();
			//
//			System.out.println("Old Website total record is " + totalCount);

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
			} // first user

//			for (String name : names) {
//
//				System.out.println(name);
//			}

//			System.out.println("The Case Count of user name " + uname1 + " " + "is" + "=>" + names.size());

		//	System.out.println("===========================================================");

		
		driver.close();

	}

	// =====================User One Closed===============//
	@Test(priority = 2)
	public void getDifferentCaseFileName2() throws InterruptedException, IOException {

		Excel_Reader reader = new Excel_Reader(prop.getProperty("TestData"));
		String uname2 = reader.getCellData(prop.getProperty("sheetName"), "Username", 3);

		String pword2 = reader.getCellData(prop.getProperty("sheetName"), "Password", 3);

		// System.out.println(uname + pword);

		Thread.sleep(3000);

		loginPage.doClickOnEmailTextBox();

		Thread.sleep(3000);

		loginPage.enterEmail(uname2 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickContinueButton();

		Thread.sleep(3000);

		loginPage.doClickOnPasswordTextBox();

		Thread.sleep(3000);

		loginPage.enterPassword(pword2 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickLoginButton();

		Thread.sleep(7000);

//			String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
//			
//			String totalCount = records.substring(records.indexOf("f") + 1).trim();
		//
//			System.out.println("Old Website total record is " + totalCount);

		loginPage.doClickNumberOfItemSelect();

		Thread.sleep(3000);

		loginPage.selectNumberOfRecordSelectPerPage();

		Thread.sleep(3000);

		List<WebElement> caseNames2 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

		//List<String> names2 = new ArrayList<String>();
		for (WebElement casename : caseNames2) {

			totalCase.add(casename.getText());

		}
		String nextButton2 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
				.getDomAttribute("aria-disabled");

		boolean button2 = Boolean.parseBoolean(nextButton2);

		// System.out.println(button);

		while (button2 != true) {

			// Thread.sleep(10000);

			driver.findElement(By.xpath("//button[@aria-label='Next page']")).click();

			Thread.sleep(3000);

			caseNames2 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

			for (WebElement casename : caseNames2) {

				totalCase.add(casename.getText());

			}

			nextButton2 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button2 = Boolean.parseBoolean(nextButton2);
		}

//		for (String name : names2) {
//
//			System.out.println(name);
//		}
//
//		System.out.println("The Case Count of user name " + uname2 + " " + "is" + "=>" + names2.size());
	//	System.out.println("===========================================================");

		driver.close();
	}

	// =============================user two done=================//
	@Test(priority = 3)
	public void getDifferentCaseFileName3() throws InterruptedException, IOException {
		Excel_Reader reader = new Excel_Reader(prop.getProperty("TestData"));

		String uname3 = reader.getCellData(prop.getProperty("sheetName"), "Username", 4);

		String pword3 = reader.getCellData(prop.getProperty("sheetName"), "Password", 4);

		// System.out.println(uname + pword);

		Thread.sleep(3000);

		loginPage.doClickOnEmailTextBox();

		Thread.sleep(3000);

		loginPage.enterEmail(uname3 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickContinueButton();

		Thread.sleep(3000);

		loginPage.doClickOnPasswordTextBox();

		Thread.sleep(3000);

		loginPage.enterPassword(pword3 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickLoginButton();

		Thread.sleep(7000);

//			String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
//			
//			String totalCount = records.substring(records.indexOf("f") + 1).trim();
		//
//			System.out.println("Old Website total record is " + totalCount);

		loginPage.doClickNumberOfItemSelect();

		Thread.sleep(3000);

		loginPage.selectNumberOfRecordSelectPerPage();

		Thread.sleep(3000);

		List<WebElement> caseNames3 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

		//List<String> names3 = new ArrayList<String>();
		for (WebElement casename : caseNames3) {

			totalCase.add(casename.getText());

		}
		String nextButton3 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
				.getDomAttribute("aria-disabled");

		boolean button3 = Boolean.parseBoolean(nextButton3);

		// System.out.println(button);

		while (button3 != true) {

			// Thread.sleep(10000);

			driver.findElement(By.xpath("//button[@aria-label='Next page']")).click();

			Thread.sleep(3000);

			caseNames3 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

			for (WebElement casename : caseNames3) {

				totalCase.add(casename.getText());

			}

			nextButton3 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button3 = Boolean.parseBoolean(nextButton3);
		}
//		for (String name : names3) {
//
//			System.out.println(name);
//		}
//
//		System.out.println("The Case Count of user name " + uname3 + " " + "is" + "=>" + names3.size());
	//	System.out.println("===========================================================");

		driver.close();
	}

//		// =============================user Three done=================//
	@Test(priority = 4)
	public void getDifferentCaseFileName4() throws InterruptedException, IOException {
		Excel_Reader reader = new Excel_Reader(prop.getProperty("TestData"));

		String uname4 = reader.getCellData(prop.getProperty("sheetName"), "Username", 5);

		String pword4 = reader.getCellData(prop.getProperty("sheetName"), "Password", 5);

		Thread.sleep(3000);

		loginPage.doClickOnEmailTextBox();

		Thread.sleep(3000);

		loginPage.enterEmail(uname4 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickContinueButton();

		Thread.sleep(3000);

		loginPage.doClickOnPasswordTextBox();

		Thread.sleep(3000);

		loginPage.enterPassword(pword4 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickLoginButton();

		Thread.sleep(7000);

//			String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
//			
//			String totalCount = records.substring(records.indexOf("f") + 1).trim();
		//
//			System.out.println("Old Website total record is " + totalCount);

		loginPage.doClickNumberOfItemSelect();

		Thread.sleep(3000);

		loginPage.selectNumberOfRecordSelectPerPage();

		Thread.sleep(3000);

		List<WebElement> caseNames4 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

		//List<String> names4 = new ArrayList<String>();
		for (WebElement casename : caseNames4) {

			totalCase.add(casename.getText());

		}
		String nextButton4 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
				.getDomAttribute("aria-disabled");

		boolean button4 = Boolean.parseBoolean(nextButton4);

		// System.out.println(button);

		while (button4 != true) {

			// Thread.sleep(10000);

			driver.findElement(By.xpath("//button[@aria-label='Next page']")).click();

			Thread.sleep(3000);

			caseNames4 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

			for (WebElement casename : caseNames4) {

				totalCase.add(casename.getText());

			}

			nextButton4 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button4 = Boolean.parseBoolean(nextButton4);
		}

//		for (String name : names4) {
//
//			System.out.println(name);
//		}
//
//		System.out.println("The Case Count of user name " + uname4 + " " + "is" + "=>" + names4.size());

		//System.out.println("===========================================================");

		driver.close();

	}

	// ===============User four done=============//
	// initialization();
	@Test(priority = 5)
	public void getDifferentCaseFileName5() throws InterruptedException, IOException {
		Excel_Reader reader = new Excel_Reader(prop.getProperty("TestData"));
		String uname5 = reader.getCellData(prop.getProperty("sheetName"), "Username", 6);

		String pword5 = reader.getCellData(prop.getProperty("sheetName"), "Password", 6);

		Thread.sleep(3000);

		loginPage.doClickOnEmailTextBox();

		Thread.sleep(3000);

		loginPage.enterEmail(uname5 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickContinueButton();

		Thread.sleep(3000);

		loginPage.doClickOnPasswordTextBox();

		Thread.sleep(3000);

		loginPage.enterPassword(pword5 + Keys.ENTER);

		// Thread.sleep(3000);

		// loginPage.doClickLoginButton();

		Thread.sleep(7000);

//			String records = driver.findElement(By.xpath("//*[@class='mat-mdc-paginator-range-label']")).getText();
//			
//			String totalCount = records.substring(records.indexOf("f") + 1).trim();
		//
//			System.out.println("Old Website total record is " + totalCount);

		loginPage.doClickNumberOfItemSelect();

		Thread.sleep(3000);

		loginPage.selectNumberOfRecordSelectPerPage();

		Thread.sleep(3000);

		List<WebElement> caseNames5 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

		//List<String> names5 = new ArrayList<String>();
		for (WebElement casename : caseNames5) {

			totalCase.add(casename.getText());

		}
		String nextButton5 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
				.getDomAttribute("aria-disabled");

		boolean button5 = Boolean.parseBoolean(nextButton5);

		// System.out.println(button);

		while (button5 != true) {

			// Thread.sleep(10000);

			driver.findElement(By.xpath("//button[@aria-label='Next page']")).click();

			Thread.sleep(3000);

			caseNames5 = driver.findElements(By.xpath("//mat-table//mat-row//mat-cell[3]"));

			for (WebElement casename : caseNames5) {

				totalCase.add(casename.getText());

			}

			nextButton5 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button5 = Boolean.parseBoolean(nextButton5);

		}

//		for (String name : names5) {
//
//			System.out.println(name);
//		}
//
//		System.out.println("The Case Count of user name " + uname5 + " " + "is" + "=>" + names5.size());

		//System.out.println("===========================================================");

		driver.close();

	}// Method
	@Test(priority = 6)
    public void getTotalCaseFileName() throws IOException {
    	
		ArrayList<String> listWithDuplicates = new ArrayList<>(totalCase);
        Set<String> uniqueSet = new HashSet<>(listWithDuplicates);
        ArrayList<String> uniqueList = new ArrayList<>(uniqueSet);
        
        System.out.println(uniqueList);
        
       for (String differentCases : uniqueList) {
    	   
    	   excel.writeExcelValue(prop.getProperty("TestData"), prop.getProperty("caseName"), differentCases);
		
	}
       
       driver.close();
    }
	
	

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}

		driver.quit();

	}
}// class
