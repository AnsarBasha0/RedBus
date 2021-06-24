package com.qa.Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilityClass 
{
	public static FileInputStream fileloc;
	public static XSSFWorkbook Wbook;
	public static XSSFSheet Wsheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	// 1.get row count
	
	public static int getRowCount(String xFile,String xSheet) throws IOException
	{
		fileloc=new FileInputStream(xFile);
		Wbook=new XSSFWorkbook(fileloc);
		Wsheet=Wbook.getSheet(xSheet);
		int rowcount=Wsheet.getLastRowNum();
		return rowcount;
		
	}
	// 2.get the cell count
	public static int getCellCount(String xFile,String xSheet,int rowNum) throws IOException
	{
		fileloc=new FileInputStream(xFile);
		Wbook=new XSSFWorkbook(fileloc);
		Wsheet=Wbook.getSheet(xSheet);
		
		row=Wsheet.getRow(rowNum);
		int cellCount=row.getLastCellNum();
		return cellCount;
	}
	// 3.get cell data
	public static String getCellData(String xFile,String xSheet,int rowNum,int colNum) throws IOException
	{
		fileloc=new FileInputStream(xFile);
		Wbook=new XSSFWorkbook(fileloc);
		Wsheet=Wbook.getSheet(xSheet);
		
		row=Wsheet.getRow(rowNum);
		cell=row.getCell(colNum);
		
		
		DataFormatter datafor=new DataFormatter();
		String celldata=datafor.formatCellValue(cell);
		
		Wbook.close();
		fileloc.close();
		
		return celldata;
		}			
	
}
