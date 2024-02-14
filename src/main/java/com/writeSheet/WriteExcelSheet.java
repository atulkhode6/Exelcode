package com.writeSheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class WriteExcelSheet {
	
      public static Sheet sh=null;
      public static Row row=null;
      public static Cell c=null;
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis=new FileInputStream("TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		
		if(sh!=wb.getSheet("JBK"))
			sh=wb.getSheet("JBK");
			else
			sh=wb.createSheet("JBK");
		
		
		if(row!=sh.getRow(4))
			row=sh.getRow(4);
			else
			row=sh.createRow(4);
		

		if(c!=sh.getRow(4).getCell(3))
			c=sh.getRow(4).getCell(3);
			else
		  c=sh.getRow(4).createCell(3);
		
		c.setCellValue("selenium Testing");
		FileOutputStream fos= new FileOutputStream("TestData.xlsx");
	wb.write(fos);
	wb.close();
	fos.close();
	
	
		
		
		
		
		
		
	}

	public static void writeExcelCell(String filename, String sheetname,int rowNum,int col ,String data)  throws Exception {
		
		 Sheet sh=null;
		 Row row=null;
		 Cell c=null;  
		
		FileInputStream fis=new FileInputStream(filename);
		Workbook wb=WorkbookFactory.create(fis);

		if(sh!=wb.getSheet(sheetname))
			sh=wb.getSheet(sheetname);
			else
			sh=wb.createSheet(sheetname);
		
		
		if(row!=sh.getRow(rowNum))
			row=sh.getRow(rowNum);
			else
			row=sh.createRow(4);
		

		if(c!=sh.getRow(rowNum).getCell(col))
			c=sh.getRow(rowNum).getCell(col);
			else
		  c=sh.getRow(4).createCell(3);
		
		c.setCellValue(data);
		FileOutputStream fos= new FileOutputStream(filename);
	wb.write(fos);
	wb.close();
	fos.close();
	
		
		
		
		
	}
	
@Test
public void test01()throws Exception{
	
	writeExcelCell("Testdata.xlsx", "jbk1",4,3, "The KiranAcadamy");
	writeExcelCell("Testdata.xls", "jbk1",4,3, "The KiranAcadamy");
	
	   
	
	
}

	
}
