package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Xls_reader {
	
	@Test(dataProvider="CrendentialSupplier")
	public void loginTest(String username,String password) {
	
		System.out.println(username + "-----" + password);
		
	}
	
	@DataProvider(name="CrendentialSupplier")
	public Object[][] readData() throws IOException {

		File file = new File("C:\\Users\\Harshita\\OneDrive\\Desktop\\Testing.xlsx");

		FileInputStream input = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(input);

		XSSFSheet sheet = wb.getSheet("Login");

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

}
