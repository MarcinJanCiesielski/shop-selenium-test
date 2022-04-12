package pl.mjc.shop.selenium.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {
    
    public static Object[][] readExcelData(String fileName) throws IOException {
        File file = new File("src/test/resources/" + fileName);
        FileInputStream inputStream = new FileInputStream(file);
        
        Workbook workbook;
        
        String ext = fileName.substring(fileName.indexOf("."));
        if(ext.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        else if(ext.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        }
        else {
            workbook = new XSSFWorkbook(inputStream);
        }
        
        Sheet sheet = workbook.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][colCount];
        for(int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);
            for(int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).getStringCellValue();
            }
        }
        return data;
    }
}
