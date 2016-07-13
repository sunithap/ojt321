package com.stockAcc.Examples;

import java.io.IOException;

public class logintest {

	
	public static void main(String[] args) throws IOException{

		stockAccMaster sm=new stockAccMaster();
				
		String res=sm.stockAcc_Launch("http://webapp.qedgetech.com");
		System.out.println(res);
		
		 res=sm.stockAcc_logintest("admin","master");
		System.out.println(res);
	
		
		
		
	}
}
