package com.qa.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.qa.testbase.TestBase;
public class TestUtil extends TestBase {
	
	public static Workbook workBook;
	public static Sheet sheet;
	public static FileInputStream fis;
	public static Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException
	{
		
		fis=new FileInputStream("D:\\contactdata.xlsx");
		workBook=WorkbookFactory.create(fis);
	sheet=workBook.getSheet(sheetName);
	
	int row=sheet.getLastRowNum();
	int col=sheet.getRow(0).getLastCellNum();
	
	Object[][]data=new Object[row][col];
	
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++)
			
		{
			
			data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			
		}
		
	}
	return data;
	
		
	}

}
