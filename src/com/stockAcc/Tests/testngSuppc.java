package com.stockAcc.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stockAcc.Examples.testngMaster;

public class testngSuppc extends testngMaster
{
	
	
		@Test
		public void stock_Suupcre()
		{
			expval="Add succeeded";
			driver.findElement(By.linkText("Suppliers")).click();
			driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
			driver.findElement(By.id("x_Supplier_Name")).sendKeys(supname);
			driver.findElement(By.id("x_Address")).sendKeys(add);
			driver.findElement(By.id("x_City")).sendKeys(city);
			driver.findElement(By.id("x_Country")).sendKeys(cntry);
			driver.findElement(By.id("x_Contact_Person")).sendKeys(cperson);
			driver.findElement(By.id("x_Phone_Number")).sendKeys(pno);
			driver.findElement(By.id("x__Email")).sendKeys(email);
			driver.findElement(By.id("x_Mobile_Number")).sendKeys(mno);
			driver.findElement(By.id("x_Notes")).sendKeys(notes);
			driver.findElement(By.id("btnAction")).click();
			driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
			Sleeper.sleepTight(5000);
			actval=driver.findElement(By.xpath("//*[@class='ajs-dialog']/div[3]/div/div")).getText();
			
			driver.findElement(By.xpath("//div[@class='ajs-footer']/div[2]/button")).click();
			Assert.assertEquals(actval, expval,"Supplier creation not successfull");
		}

	}


