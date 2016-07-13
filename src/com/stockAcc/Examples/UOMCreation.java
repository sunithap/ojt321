package com.stockAcc.Examples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;

public class UOMCreation {

	
	public static void main(String[] args) throws Exception {
		
		ProfilesIni pr=new ProfilesIni();
		FirefoxProfile fp=pr.getProfile("stockAcc");
		WebDriver driver=new FirefoxDriver(fp);
		driver.get("http://webapp.qedgetech.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		
		WebElement stockcat= driver.findElement(By.linkText("Stock Items"));
		Actions act=new Actions(driver);
		
		act.moveToElement(stockcat).build().perform();
		driver.findElement(By.linkText("Unit of Measurement")).click();
		
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.id("x_UOM_ID")).sendKeys("6");
		driver.findElement(By.id("x_UOM_Description")).sendKeys("ngdfjf");
		
		driver.findElement(By.id("btnAction")).click();
		
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		
		
		
		
		
		
		
		
		
		
		
	}

}
