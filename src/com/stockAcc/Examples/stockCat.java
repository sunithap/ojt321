package com.stockAcc.Examples;

import com.stockAcc.Examples.stockCat;

public class stockCat {

	
	public static void main(String[] args) {
		
		
					
					stockMaster sm = new stockMaster();
					String res=sm.stockAcc_Launch("http://webapp.qedgetech.com");
					System.out.println(res);
					
					res=sm.stockAcc_Login("admin","master");
					System.out.println(res);
					
					res=sm.stockAcc_stockcatCreation("Furniture");
					System.out.println(res);
									
					res=sm.stockAcc_Logout();
					System.out.println(res); 
					
					sm.stockAcc_Close();
					
					
					
				}

		
		
		
	}

