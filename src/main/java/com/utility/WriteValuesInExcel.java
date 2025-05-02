package com.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testBase.TestBase;

public class WriteValuesInExcel extends TestBase {
	
	FileOutputStream fo;
	
	public void writeExcelValue(String filename ,String cellNmae,String casenamelist) throws IOException {
		
		int rowNum=0;
		
		//int cellNum=0;
		
		  Workbook wb=new XSSFWorkbook();
			
			fo=new FileOutputStream(filename);
			
			Sheet sheet=wb.createSheet(cellNmae);
			
	         Row row=sheet.createRow(rowNum++);
			
			
			  Cell cell=row.createCell(0);
			  
			  cell .setCellValue(casenamelist);
			 
			  wb.write(fo);
	}

}
