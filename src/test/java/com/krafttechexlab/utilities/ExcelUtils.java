package com.krafttechexlab.utilities;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;

import java.io.FileInputStream;


/*
 This is a utility for reading from writing to excel files.
 it works with xls and xlsx files.
 */
public class ExcelUtils {

    private Sheet workSheet;
    private Workbook workBook;
    private String path;

    public ExcelUtils(String path, String sheetName){
        this.path =path;
        try {
            FileInputStream excelFile = new FileInputStream(path);

            workBook =WorkbookFactory.create(excelFile);
            workSheet = workBook.getSheet(sheetName);
            Assert.assertNotNull(workSheet,"Sheet: \""+sheetName+"\" does not exist\n");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public String getCellData(int rowNum, int colNum) {
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            String cellData = cell.toString();
            return cellData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
