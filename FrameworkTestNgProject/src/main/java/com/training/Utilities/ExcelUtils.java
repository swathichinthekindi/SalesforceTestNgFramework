package com.training.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook ExcelWbook;
    static XSSFSheet ExcelWsheet;
    static XSSFRow Row;
    static XSSFCell Cell;
    
    public static Object[][] getTableArray(String filePath, String SheetName, int testcase) throws IOException{
    	int ci = 0,cj = 0;
    	String[][] tabArray = null;
    	FileInputStream ExcelFIle = new FileInputStream(filePath);
    	ExcelWbook = new XSSFWorkbook(ExcelFIle);
    	ExcelWsheet = ExcelWbook.getSheet(SheetName);
    //	int totalRows = ExcelWsheet.getLastRowNum();
    	int totalRows = 1;
    	int totalColms = 2;
    //	for(int i=1; i<=totalRows; i++,ci++)
    	//we are not initializing'i' row because we don't want all the rows to (testcases to) run,i need only one testcase thats why we are providing '1
    	
    	
    	tabArray = new String[totalRows][totalColms];/// declaring an two-D array
    	for (int j=1; j<=totalColms; j++,cj++) {
    		tabArray[ci][cj] = getCellData(testcase,j);
    		System.out.println(tabArray[ci][cj] +" ");
    	}
    	
		return tabArray;
		
    	
    	
    }
    
    public static  String getCellData(int RowNum, int ColNum) {
    	Cell = ExcelWsheet.getRow(RowNum).getCell(ColNum);
    	String CellData =Cell.getStringCellValue();
		return CellData;
    	
    }

}
