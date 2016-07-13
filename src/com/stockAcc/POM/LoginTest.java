package com.stockAcc.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTest {
		@Test
		public void login() throws InterruptedException
		{
			String u,p;
			WebDriver driver=new FirefoxDriver();
			driver.get("http://webapp.qedgetech.com");
			driver.manage().window().maximize();
			
			LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
			lp.stock_Login(lp.u, lp.p);
			//LoginPage lp1=PageFactory.initElements(driver, LoginPage.class);
			//lp1.stock_Reset();
			
			AdminHomePage ap=PageFactory.initElements(driver, AdminHomePage.class);
			
			stockItems si=PageFactory.initElements(driver, stockItems.class);
			ap.dashboardclick();
			Thread.sleep(5000);
			ap.stockitemclick();
			Thread.sleep(5000);
			
			
			si.stockcatclick();
			Thread.sleep(5000);
			
			ap.stockitemclick();
			Thread.sleep(5000);
			
			si.stockaddclick();
			Thread.sleep(5000);
			
			si.uomclick();
			Thread.sleep(5000);
			
			ap.suppliersclick();
			Thread.sleep(5000);
			
			
			ap.purchasesclick();
			Thread.sleep(5000);
			
			
			ap.customersclick();
			Thread.sleep(5000);
			
			
			ap.salesclick();
			Thread.sleep(5000);
			
			
			ap.outstandingsclick();
			Thread.sleep(5000);
			
			
			ap.administratorclick();
			Thread.sleep(5000);
			
			
			ap.settingsclick();
			Thread.sleep(5000);
			
			
			ap.logout1click();
			Thread.sleep(5000);
			
			
			
			
			
			
			driver.close();
			
			
		}
		
		
		

	}



