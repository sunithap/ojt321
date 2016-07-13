package com.stockAcc.Tests;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

		public class UOMdatadrivenNotepad {

			public static void main(String[] args) throws IOException
			{
				com.stockAcc.Examples.stockAccMaster sam=new com.stockAcc.Examples.stockAccMaster();
				String uIn="D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Testdata\\UOM.txt";
				String Uout="D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Results\\UOMOUT.txt";
				FileReader fi=new FileReader(uIn);
				BufferedReader br=new BufferedReader(fi);
				String x="";
				System.out.println(br.readLine());
//				System.out.println(br.readLine());
				
				FileWriter fw=new FileWriter(Uout);
				BufferedWriter bw=new BufferedWriter(fw);
				bw.write("Uid&Desc&Result");
				bw.newLine();
				sam.stockAcc_Launch("http://webapp.qedgetech.com");
				sam.stockAcc_logintest("admin", "master");
				while ((x=br.readLine())!=null)
				{
					System.out.println(x);
					String[] split=x.split("&");
					String Uid=split[0];
					String Udesc=split[1];
					System.out.println(Uid+"----------"+Udesc);
					//String res=sam.UnitofMcreation(Uid,Udesc);
					
					//bw.write(x+"&"+res);
					bw.newLine();
				}
				bw.close();
				br.close();
				sam.stockAcc_Logout();
				sam.stockAcc_Close();
			}


		

	}

