package com.bobchosbar.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	
	public ExcelDataProvider() {
		try {
			File file = new File("./TestData/testdata.xlsx");
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			
		}catch(Exception e) {
			System.out.println("Unable to read excel file: " +e.getMessage() );
		}
	}

	public String getStringData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName, int row, int col) {
		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
