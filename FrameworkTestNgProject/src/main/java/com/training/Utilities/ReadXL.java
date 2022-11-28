package com.training.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXL {
     static XSSFWorkbook ExcelWbook;
     static XSSFSheet ExcelWsheet;
     static XSSFRow Row;
     static XSSFCell Cell;
	public static void main(String[] args) throws IOException {
    String FilePath ="C:\\Users\\swath\\Downloads\\ExelSheetfile.xlsx"; // path
		 FileInputStream ExelFIle = new FileInputStream(FilePath); // passing the file in InputStream
		
		ExcelWbook = new XSSFWorkbook(ExelFIle); //passing inputFile to the WBOOK
		ExcelWsheet = ExcelWbook.getSheet("Login");  //assigning the ExcelSheet here.
		int totalRows = ExcelWsheet.getLastRowNum();
		int totalCols = 3;
		
		for(int i =1; i<=totalRows; i++) {
			 for(int j=1; j<=totalCols; j++) {
				 Cell  = ExcelWsheet.getRow(i).getCell(j);
					System.out.println( Cell );
			 
			 }
			 System.out.println();
		}
		
//		XSSFCell  rowColm = ExcelWsheet.getRow(1).getCell(1);
//		System.out.println("The rowColm excelSheet is: " +rowColm );
//		
//		System.out.println(totalRows); // it will display the totalRows;
//		System.out.println();
	}

}
