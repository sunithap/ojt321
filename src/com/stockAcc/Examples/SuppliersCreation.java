package com.stockAcc.Examples;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;


public class SuppliersCreation {

	
	public static void main(String[] args) {
		//String expsupplierno=" Supplier-00000000280";
		
		ProfilesIni pi=new ProfilesIni();
		FirefoxProfile fp=pi.getProfile("stockAcc");
		WebDriver driver=new FirefoxDriver(fp);
		driver.get("http://webapp.qedgetech.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		
		WebElement stockcreate= driver.findElement(By.linkText("Suppliers"));
		Actions act=new Actions(driver);
		
		act.moveToElement(stockcreate).build().perform();
		driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_Supplier_Number']")).sendKeys("stockacc123456");
		driver.findElement(By.id("x_Supplier_Name")).sendKeys("abcde");
		driver.findElement(By.id("x_Address")).sendKeys("ameerpet");
		driver.findElement(By.id("x_City")).sendKeys("hyd");
		driver.findElement(By.id("x_Country")).sendKeys("India");
		driver.findElement(By.id("x_Contact_Person")).sendKeys("sgeog");
		
		driver.findElement(By.id("x_Phone_Number")).sendKeys("574589999");
		driver.findElement(By.id("x__Email")).sendKeys("askasjdas@gmail.com");
		driver.findElement(By.id("x_Mobile_Number")).sendKeys("456347777");
		driver.findElement(By.id("x_Notes")).sendKeys("sdfgsdgfdg");
		
		driver.findElement(By.id("btnAction")).click();
		//driver.findElement(By.id("btnCancel")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
		
		
		
		
	}

}
