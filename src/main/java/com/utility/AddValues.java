package com.utility;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.testBase.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AddValues extends TestBase {
	
	
	
	

    public void addCaseFilesInExcel(List<String> userA,List<String> userB, List<String> userC,List<String> userD,List<String> user5) {
    	
    	String currentWorkingDirectory = System.getProperty("user.dir");
        // Sample lists of data
//        List<Integer> ages = List.of(30, 25, 35, 28, 32);
//        List<String> cities = List.of("New York", "London", "Tokyo", "Paris", "Sydney");
//        List<Double> salaries = List.of(60000.0, 55000.0, 70000.0, 62000.0, 68000.0);
//        List<Boolean> isEmployed = List.of(true, true, false, true, true);

        String outputFilePath = "C:\\Users\\Harshita\\OneDrive\\Desktop\\Output.xlsx";

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Case");

            // Determine the maximum size of the lists
            int maxRows = Math.max(userA.size(), Math.max(userB.size(), Math.max(userC.size(), Math.max(userD.size(), user5.size()))));

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("User1");
            headerRow.createCell(1).setCellValue("User2");
            headerRow.createCell(2).setCellValue("User3");
            headerRow.createCell(3).setCellValue("User4");
            headerRow.createCell(4).setCellValue("User5");

            // Populate data rows
            for (int rowNum = 0; rowNum < maxRows; rowNum++) {
                Row dataRow = sheet.createRow(rowNum + 1);

                // Add data for each list to separate columns
                if (rowNum < userA.size()) {
                    dataRow.createCell(0).setCellValue(userA.get(rowNum));
                }
                if (rowNum < userB.size()) {
                    dataRow.createCell(1).setCellValue(userB.get(rowNum));
                }
                if (rowNum < userC.size()) {
                    dataRow.createCell(2).setCellValue(userC.get(rowNum));
                }
                if (rowNum < userD.size()) {
                    dataRow.createCell(3).setCellValue(userD.get(rowNum));
                }
                if (rowNum < user5.size()) {
                    dataRow.createCell(4).setCellValue(user5.get(rowNum));
                }
            }

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
    }

}
