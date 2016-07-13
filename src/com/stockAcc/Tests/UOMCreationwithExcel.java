package com.stockAcc.Tests;

import java.io.FileInputStream;

import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.stockAcc.Examples.stockMaster;



public class UOMCreationwithExcel {
	

	public static void main(String[] args) throws IOException
		{
			String xlpath="D:\\ExcelOperations\\SA\\src\\com\\SA\\testdata\\testdata.xlsx";
			String uOut="D:\\ExcelOperations\\SA\\src\\com\\SA\\results\\uOut.xlsx";

			stockMaster sm=new stockMaster();
			
			
			FileInputStream fi=new FileInputStream(xlpath);
			
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet ws=wb.getSheet("Sheet1");
//			XSSFRow r=ws.getRow(0);
//			XSSFCell c=r.getCell(0);
//			System.out.println(c.getStringCellValue());
		
			int rc=ws.getLastRowNum();
			
			sm.stockAcc_Launch("http://webapp.qedgetech.com");
			sm.stockAcc_Login("admin", "master");
			
			
			for (int i = 1; i <= rc; i++) 
			{
				XSSFRow r=ws.getRow(i);
				XSSFCell c=r.getCell(0);
				XSSFCell c1=r.getCell(1);
				XSSFCell c2=r.createCell(2);
				String uid=c.getStringCellValue();
				String udesc=c1.getStringCellValue();
				System.out.println(uid+"--------"+udesc);
				String res=sm.stockAcc_UnitofMcreation(uid, udesc);
				c2.setCellValue(res);
				
			}
			
			FileOutputStream fo=new FileOutputStream(uOut);
			wb.write(fo);
			((Closeable) wb).close();
			
		}

	}



