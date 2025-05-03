package com.loginPageTest;

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
import com.utility.AddValues;
import com.utility.Excel_Reader;
import com.utility.HightlightColour;
import com.utility.TestUtil;
import com.utility.WriteValuesInExcel;

public class HighlightDifferentCaseNameTest extends TestBase {

	GetDifferentCaseName loginPage;

	GetDifferentCaseNameTest log;

	WriteValuesInExcel excel;

	FileOutputStream fo;
	
	AddValues value;
	
	HightlightColour colour;

List<String> user1 = new ArrayList<>();

List<String> user2 = new ArrayList<>();

List<String> user3 = new ArrayList<>();

List<String> user4 = new ArrayList<>();

List<String> user5 = new ArrayList<>();

	public HighlightDifferentCaseNameTest() {
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

		String currentWorkingDirectory = System.getProperty("user.dir");
		// String configFilePath = currentWorkingDirectory + "/resources/config.txt";

		Excel_Reader reader = new Excel_Reader(currentWorkingDirectory + prop.getProperty("Login"));

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

			user1.add(casename.getText());

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

				user1.add(casename.getText());

			}

			nextButton = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button = Boolean.parseBoolean(nextButton);
		} // first user

		
	

		

//			System.out.println("The Case Count of user name " + uname1 + " " + "is" + "=>" + names.size());

		// System.out.println("===========================================================");

		driver.close();

	}

	// =====================User One Closed===============//
	@Test(priority = 2)
	public void getDifferentCaseFileName2() throws InterruptedException, IOException {

		String currentWorkingDirectory = System.getProperty("user.dir");
		// String configFilePath = currentWorkingDirectory + "/resources/config.txt";

		Excel_Reader reader = new Excel_Reader(currentWorkingDirectory + prop.getProperty("Login"));

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

			user2.add(casename.getText());

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

				user2.add(casename.getText());

			}

			nextButton2 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button2 = Boolean.parseBoolean(nextButton2);
		}

	
//		System.out.println("The Case Count of user name " + uname2 + " " + "is" + "=>" + names2.size());
		// System.out.println("===========================================================");

		driver.close();
	}

	// =============================user two done=================//
	@Test(priority = 3)
	public void getDifferentCaseFileName3() throws InterruptedException, IOException {
		String currentWorkingDirectory = System.getProperty("user.dir");
		// String configFilePath = currentWorkingDirectory + "/resources/config.txt";

		Excel_Reader reader = new Excel_Reader(currentWorkingDirectory + prop.getProperty("Login"));

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

			user3.add(casename.getText());

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

				user3.add(casename.getText());

			}

			nextButton3 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button3 = Boolean.parseBoolean(nextButton3);
		}
		
//		System.out.println("The Case Count of user name " + uname3 + " " + "is" + "=>" + names3.size());
		// System.out.println("===========================================================");

		driver.close();
	}

//		// =============================user Three done=================//
	@Test(priority = 4)
	public void getDifferentCaseFileName4() throws InterruptedException, IOException {
		String currentWorkingDirectory = System.getProperty("user.dir");
		// String configFilePath = currentWorkingDirectory + "/resources/config.txt";

		Excel_Reader reader = new Excel_Reader(currentWorkingDirectory + prop.getProperty("Login"));

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

			user4.add(casename.getText());

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

				user4.add(casename.getText());

			}

			nextButton4 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button4 = Boolean.parseBoolean(nextButton4);
		}

		
//		System.out.println("The Case Count of user name " + uname4 + " " + "is" + "=>" + names4.size());

		// System.out.println("===========================================================");

		driver.close();

	}

	// ===============User four done=============//
	// initialization();
	@Test(priority = 5)
	public void getDifferentCaseFileName5() throws InterruptedException, IOException {
		String currentWorkingDirectory = System.getProperty("user.dir");
		// String configFilePath = currentWorkingDirectory + "/resources/config.txt";

		Excel_Reader reader = new Excel_Reader(currentWorkingDirectory + prop.getProperty("Login"));
		
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

			user5.add(casename.getText());

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

				user5.add(casename.getText());

			}

			nextButton5 = driver.findElement(By.xpath("//button[@aria-label='Next page']"))
					.getDomAttribute("aria-disabled");
			button5 = Boolean.parseBoolean(nextButton5);

		}
		
		

//		System.out.println("The Case Count of user name " + uname5 + " " + "is" + "=>" + names5.size());

		// System.out.println("===========================================================");

		driver.close();

	}// Method
	
	@Test(priority = 6)
	
	public void addCaseNames() throws IOException {
		
	
		    	
		    //	String currentWorkingDirectory = System.getProperty("user.dir");
		        // Sample lists of data
//		        List<Integer> ages = List.of(30, 25, 35, 28, 32);
//		        List<String> cities = List.of("New York", "London", "Tokyo", "Paris", "Sydney");
//		        List<Double> salaries = List.of(60000.0, 55000.0, 70000.0, 62000.0, 68000.0);
//		        List<Boolean> isEmployed = List.of(true, true, false, true, true);

		        String outputFilePath = "C:\\Users\\Harshita\\OneDrive\\Desktop\\Output.xlsx";

		        try (Workbook workbook = new XSSFWorkbook()) {
		            Sheet sheet = workbook.createSheet("Case");

		            // Determine the maximum size of the lists
		            int u1 = user1.size();
		            int u2 = user2.size();
		            int u3 = user3.size();
		            int u4 = user4.size();
		            int u5 = user5.size();

		            // Create header row
		            Row headerRow = sheet.createRow(0);
		            headerRow.createCell(0).setCellValue("User1");
		            headerRow.createCell(1).setCellValue("User2");
		            headerRow.createCell(2).setCellValue("User3");
		            headerRow.createCell(3).setCellValue("User4");
		            headerRow.createCell(4).setCellValue("User5");
		            
		            for(int rowNum=0;rowNum<u1;rowNum++) {
		            	Row dataRow = sheet.createRow(rowNum + 1);
		            	if (rowNum < user1.size()) {
		                    dataRow.createCell(0).setCellValue(user1.get(rowNum));
		                }
		            }
		            
		            for(int rowNum=0;rowNum<u2;rowNum++) {
		            	Row dataRow = sheet.createRow(rowNum + 1);
		            	if (rowNum < user2.size()) {
		                    dataRow.createCell(0).setCellValue(user2.get(rowNum));
		                }
		            }
		            
		            for(int rowNum=0;rowNum<u3;rowNum++) {
		            	Row dataRow = sheet.createRow(rowNum + 1);
		            	if (rowNum < user3.size()) {
		                    dataRow.createCell(0).setCellValue(user3.get(rowNum));
		                }
		            }
		            
		            for(int rowNum=0;rowNum<u4;rowNum++) {
		            	Row dataRow = sheet.createRow(rowNum + 1);
		            	if (rowNum < user4.size()) {
		                    dataRow.createCell(0).setCellValue(user4.get(rowNum));
		                }
		            }
		            
		            for(int rowNum=0;rowNum<u5;rowNum++) {
		            	Row dataRow = sheet.createRow(rowNum + 1);
		            	if (rowNum < user5.size()) {
		                    dataRow.createCell(0).setCellValue(user5.get(rowNum));
		                }
		            }

		            // Populate data rows
//		            for (int rowNum = 0; rowNum < maxRows; rowNum++) {
//		                Row dataRow = sheet.createRow(rowNum + 1);
//
//		                // Add data for each list to separate columns
//		                
//		                if (rowNum < user2.size()) {
//		                    dataRow.createCell(1).setCellValue(user2.get(rowNum));
//		                }
//		                if (rowNum < user3.size()) {
//		                    dataRow.createCell(2).setCellValue(user3.get(rowNum));
//		                }
//		                if (rowNum < user4.size()) {
//		                    dataRow.createCell(3).setCellValue(user4.get(rowNum));
//		                }
//		                if (rowNum < user5.size()) {
//		                    dataRow.createCell(4).setCellValue(user5.get(rowNum));
//		                }
//		            }

		            // Auto-size columns
		            for (int i = 0; i < 5; i++) {
		                sheet.autoSizeColumn(i);
		            }

		            // Write the workbook to a file
		            try (FileOutputStream outputStream = new FileOutputStream(outputFilePath)) {
		                workbook.write(outputStream);
		            }

		            System.out.println("Excel file '" + outputFilePath + "' created successfully with five lists in separate columns.");

		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		        
		        colour.highlightDifferentValue(outputFilePath);
		        
		        System.out.println("Done");
		    }

	

//	@Test(priority = 6)
//	public void getTotalCaseFileName() throws IOException {
//
//		int rowNum = 0;
//
//		// int cellNum=0;
//
//		Workbook wb = new XSSFWorkbook();
//
//		fo = new FileOutputStream(prop.getProperty("TestData1"));
//
//		Sheet sheet = wb.createSheet(prop.getProperty("caseName"));
//
//		Map<String, Integer> countMap = new HashMap<>();
//		for (String name : totalCase) {
//			countMap.put(name, countMap.getOrDefault(name, 0) + 1);
//		}
//
//		// List<String> result = new ArrayList<>();
//
//		for (String name : totalCase) {
//			if (countMap.get(name) == 1) {
//				Row row = sheet.createRow(rowNum++);
//
//				Cell cell = row.createCell(0);
//
//				cell.setCellValue(name);
//			}
//		}
//
////        result = new ArrayList<>(new LinkedHashSet<>(result));
////
////        System.out.println(result);
//
//		 wb.write(fo);
//
//		driver.close();

	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			TestUtil.takeScreenshotAtEndOfTest(driver, result.getName());
		}

		driver.quit();

	}
}// class
