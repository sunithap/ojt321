package com.stockAcc.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
		public static String u="admin";
		public static String p="master";
		@FindBy(id="username")
		WebElement username;
		
		@FindBy(id="password")
		WebElement password;
		
		@FindBy(id="btnsubmit")
		WebElement submit;
		
		@FindBy(id="btnreset")
		WebElement reset;
		
		public void stock_Login(String u,String p)
		{
			username.clear();
			username.sendKeys(u);
			password.clear();
			password.sendKeys(p);
			
			submit.click();
		}

		/*public void stock_Reset()
		{
			reset.click();
			
		}*/
		
		
	}


