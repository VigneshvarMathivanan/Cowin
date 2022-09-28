package com.cowin.cowin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Xlsx_reader {
	public static File f;
	public static FileInputStream fis;
	public static Workbook w;
	public static Sheet s;
	public static String value;
	

	public static void getParticularRow() throws IOException {
		System.out.println("PARTICULAR ROW: ");
          f = new File("C:\\Users\\91769\\eclipse-workspace\\Cowin\\Excel\\Cowin.xlsx");
          fis = new FileInputStream(f);
          w = new XSSFWorkbook(fis);
          s = w.getSheet("Sheet1");
         Row r =s.getRow(3);
         int cellNumber=r.getPhysicalNumberOfCells();
         for(int i=0;i<cellNumber;i++) {
        	 Cell c =r.getCell(i);
        	 CellType ct = c.getCellType();
        	 if(ct.equals(CellType.STRING)) {
        		 String str = c.getStringCellValue();
        		 System.out.print(str);
        		 }else if(ct.equals(CellType.NUMERIC)) {
        			 double d = c.getNumericCellValue();
        			 int h = (int)d;
        			 System.out.print(h);
        		 }System.out.print(" | ");
        	 
         }
	}
	
	private static void getParticularColumn() {
		System.out.println("===================");
		System.out.println("PARTICULAR COLUMN: ");
       int numberOfRows= s.getPhysicalNumberOfRows();
		for(int i=0;i<numberOfRows;i++) {
			Row r = s.getRow(i);
			Cell c = r.getCell(1);
			CellType ct = c.getCellType();
			if(ct.equals(CellType.STRING)) {
				String str = c.getStringCellValue();
				System.out.println(str);
			}else if(ct.equals(CellType.NUMERIC)) {
				double d = c.getNumericCellValue();
				int h = (int)d;
				System.out.println(h);
			}
		}
	}
	
	public static String particularData(String sheet,int row , int cell) throws IOException {
		 File f = new File("C:\\Users\\91769\\eclipse-workspace\\Cowin\\Excel\\Cowin.xlsx");
		 FileInputStream fis = new FileInputStream(f);
         Workbook w = new XSSFWorkbook(fis);
         Sheet s = w.getSheet(sheet);
		 Row r = s.getRow(row);
        Cell c = r.getCell(cell);
        CellType cellType = c.getCellType();
        if(cellType.equals(cellType.STRING)) {
        	 value = c.getStringCellValue();
        }else if (cellType.equals(CellType.NUMERIC)) {
        	double value1 = c.getNumericCellValue();
        	int num = (int)value1;
        	   value= Integer.toString(num);
        } 
        return value;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		getParticularRow();
		getParticularColumn();
	}
}
