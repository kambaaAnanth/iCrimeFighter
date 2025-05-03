package com.utility;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HightlightColour {

    public void highlightDifferentValue(String excel) throws IOException {
        String filePath = excel; // Replace with the path to your Excel file
        String outputFilePath = "C:\\Users\\Harshita\\OneDrive\\Desktop\\Output.xlsx";

        // Specify the name or index of the sheet containing the data
        String sheetName = "Sheet1"; // Replace with your sheet name
        // OR use sheet index (0-based):
        // int sheetIndex = 0;

        // Specify the columns you want to compare (0-based index)
        int[] compareColumns = {0, 1, 2,3,4}; // Example: Compare columns A, B, and C

        // Specify the number of comparison groups (how many sets of columns to compare)
        int numberOfGroups = 10; // Example: Compare Column A with D, and Column B with E

        // Define the column indices for each comparison group
        // Each inner array represents a group of columns to compare within the same row
        int[][] columnGroupsToCompare = {
                {0, 1}, // Compare Column 0 (A) with Column 3 (D)
                {0, 2},
                {0,3},
                {0,4},
                {1,2},
                {1,3},
                {1,4},
                {2,3},
                {2,4},
                {3,4}// Compare Column 1 (B) with Column 4 (E)
                // Add more groups as needed
        };

        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream);
             Workbook outputWorkbook = new XSSFWorkbook()) {

            Sheet sourceSheet = workbook.getSheet(sheetName);
            if (sourceSheet == null) {
                System.err.println("Sheet '" + sheetName + "' not found.");
                return;
            }
            Sheet outputSheet = outputWorkbook.createSheet("Differences");

            int maxRows = sourceSheet.getLastRowNum();

            // Create a style for highlighting differences
            CellStyle differenceStyle = outputWorkbook.createCellStyle();
            differenceStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            differenceStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Iterate through each row
            for (int rowNum = 0; rowNum <= maxRows; rowNum++) {
                Row sourceRow = sourceSheet.getRow(rowNum);
                Row outputRow = outputSheet.createRow(rowNum);

                if (sourceRow != null) {
                    int maxCols = sourceRow.getLastCellNum();

                    // Copy all cells from the source sheet to the output sheet initially
                    for (int colNum = 0; colNum < maxCols; colNum++) {
                        Cell sourceCell = sourceRow.getCell(colNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);
                        Cell outputCell = outputRow.createCell(colNum);
                        if (sourceCell != null) {
                            copyCellValue(sourceCell, outputCell);
                        }
                    }

                    // Compare the specified column groups and highlight differences
                    for (int[] group : columnGroupsToCompare) {
                        if (group.length == 2) {
                            int colIndex1 = group[0];
                            int colIndex2 = group[1];

                            Cell cell1 = sourceRow.getCell(colIndex1, MissingCellPolicy.RETURN_BLANK_AS_NULL);
                            Cell cell2 = sourceRow.getCell(colIndex2, MissingCellPolicy.RETURN_BLANK_AS_NULL);
                            Cell outputCell1 = outputRow.getCell(colIndex1, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                            Cell outputCell2 = outputRow.getCell(colIndex2, MissingCellPolicy.CREATE_NULL_AS_BLANK);

                            String value1 = (cell1 != null) ? getCellValueAsString(cell1) : "";
                            String value2 = (cell2 != null) ? getCellValueAsString(cell2) : "";

                            if (!value1.equals(value2)) {
                                outputCell1.setCellStyle(differenceStyle);
                                outputCell2.setCellStyle(differenceStyle);
                            }
                        } else {
                            System.err.println("Invalid column group: " + java.util.Arrays.toString(group));
                        }
                    }
                }
            }

            // Auto-size columns in the output sheet
            for (int i = 0; i < outputSheet.getRow(0).getLastCellNum(); i++) {
                outputSheet.autoSizeColumn(i);
            }

            // Write the output workbook to a new file
            try (FileOutputStream fileOutputStream = new FileOutputStream(outputFilePath)) {
                outputWorkbook.write(fileOutputStream);
            }

            System.out.println("Differences within sheet '" + sheetName + "' highlighted and saved to " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyCellValue(Cell sourceCell, Cell targetCell) {
        switch (sourceCell.getCellType()) {
            case STRING:
                targetCell.setCellValue(sourceCell.getStringCellValue());
                break;
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(sourceCell)) {
                    targetCell.setCellValue(sourceCell.getDateCellValue());
                } else {
                    targetCell.setCellValue(sourceCell.getNumericCellValue());
                }
                break;
            case BOOLEAN:
                targetCell.setCellValue(sourceCell.getBooleanCellValue());
                break;
            case FORMULA:
                targetCell.setCellFormula(sourceCell.getCellFormula());
                break;
            case BLANK:
                targetCell.setCellType(CellType.BLANK);
                break;
            default:
                targetCell.setCellValue(getCellValueAsString(sourceCell));
                break;
        }
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                try {
                    return cell.getStringCellValue();
                } catch (Exception e) {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BLANK:
                return "";
            default:
                return "";
        }
    }
}