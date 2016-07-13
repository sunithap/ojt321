package com.stockAcc.Examples;

	import java.io.Closeable;
import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


	
import com.stockAcc.Examples.stockMaster;

	public class keyworddriven {


		public static void main(String[] args) throws IOException 
		{
			stockMaster sm=new stockMaster();
			String res = null;
			String xlpath="D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Testdata\\keyword.xlsx";
			String xlout="D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Testdata\\keyout.xlsx";
			FileInputStream fi=new FileInputStream(xlpath);
			
			XSSFWorkbook wb=new XSSFWorkbook(fi);
			XSSFSheet ws=wb.getSheet("TestCase");
			XSSFSheet ws1=wb.getSheet("TestSteps");
			XSSFSheet ws2=wb.getSheet("Testdata");
			
			int tcRc=ws.getLastRowNum();
			int tsRc=ws1.getLastRowNum();
			//test cases
			for (int i = 1; i <= tcRc; i++)
			{
				String exe=ws.getRow(i).getCell(2).getStringCellValue();
				if (exe.equalsIgnoreCase("Y"))
				{
					String tcId=ws.getRow(i).getCell(0).getStringCellValue();
					
					//test steps
					for (int j = 1; j <= tsRc ; j++) 
					{
						String tsTcid=ws1.getRow(j).getCell(0).getStringCellValue();
						
						if (tcId.equalsIgnoreCase(tsTcid))
						{
							String key=ws1.getRow(j).getCell(3).getStringCellValue();
							
							switch (key) {
							case "sLanch":
								res=sm.stockAcc_Launch("http://webapp.qedgetech.com");
								break;
							case "sLogin":
								res=sm.stockAcc_Login("admin", "master");
								break;
							case "sLogout": 	
								res=sm.stockAcc_Logout();
								break;
							case "sSupplier":
								String supname=ws2.getRow(1).getCell(0).getStringCellValue();
								String add=ws2.getRow(1).getCell(1).getStringCellValue();
								String city=ws2.getRow(1).getCell(2).getStringCellValue();
								String cntry=ws2.getRow(1).getCell(3).getStringCellValue();
								String cperson=ws2.getRow(1).getCell(4).getStringCellValue();
								String pno=ws2.getRow(1).getCell(5).getStringCellValue();
								String email=ws2.getRow(1).getCell(6).getStringCellValue();
								String mno=ws2.getRow(1).getCell(7).getStringCellValue();
								String notes=ws2.getRow(1).getCell(8).getStringCellValue();
								res=sm.stockAcc_SupplierCreation(supname, add, city, cntry, cperson, pno, email, mno, notes);
								break;
							case "sCat":
								String catname=ws2.getRow(1).getCell(9).getStringCellValue();
								res=sm.stockAcc_stockcatCreation(catname);
								break;
							case "sUom":
								String Uid=ws2.getRow(1).getCell(10).getStringCellValue();
								String Udesc=ws2.getRow(1).getCell(11).getStringCellValue();
								res=sm.stockAcc_UnitofMcreation(Uid, Udesc);
								break;
							default:
								System.out.println("Pass a Valid Keyword");
								break;
							}
							//result updation in test steps sheet
							ws1.getRow(j).createCell(4).setCellValue(res);
							//result updation in test case sheet
							if (!ws1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"))
							{
								ws.getRow(i).createCell(3).setCellValue(res);
							}
							else
							{
								ws.getRow(i).createCell(3).setCellValue("Fail");
							}
							
							
						}
						
						
						
					}
					
				}
				else
				{
					ws.getRow(i).createCell(3).setCellValue("BLOCKED");
				}
			}
			FileOutputStream fo=new FileOutputStream(xlout);
			wb.write(fo);
			((Closeable) wb).close();

		}


	}


