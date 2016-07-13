package com.stockAcc.Examples;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

	
	public class testngMaster 
	{
		public WebDriver driver;
		public FileInputStream fi;
		public Properties pr;
		public static String url="http://webapp.qedgetech.com";
		public static String expval,actval;
		public static String uname="admin",pwd="master";
		public static String supname="ssssss",add="ameerpet",city="hyderabad",cntry="India";
		public static String cperson="fdasf",pno="4555756",email="ajhsl@gmail.com";
		public static String mno="4564645454",notes="suppliers creation";
		public static String Uid="furniture", Udesc="uom description";
		
		@BeforeSuite
		public void stock_Launch() throws IOException
		{
			
			String prPath="D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Properties\\config.properties";
			fi=new FileInputStream(prPath);
			pr=new Properties();
			pr.load(fi);
			
			if (pr.getProperty("br").equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
				
			}
			else if (pr.getProperty("br").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunitha\\Desktop\\chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if (pr.getProperty("br").equalsIgnoreCase("ie"))
			{
				System.setProperty("webdriver.ie.driver", "C:\\Users\\sunitha\\Desktop\\IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				
			}
			expval="Login";
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			actval=driver.findElement(By.id(pr.getProperty("login"))).getText();
			Assert.assertEquals(actval, expval,"Launch Failed");
			
			
		}
		
		@AfterSuite
		public void stock_Close()
		{
			driver.close();
		}
		
		
		@BeforeTest
		public void stock_login()
		{
			expval="administrator";
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(pwd);
			driver.findElement(By.id("btnsubmit")).click();
			actval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
			Assert.assertEquals(actval, expval,"Login Failed");
		}
		@AfterTest
		public void stock_Logout()
		{
			expval="login";
			driver.findElement(By.id("logout")).click();
			Sleeper.sleepTight(5000);
			List<WebElement> button=driver.findElements(By.tagName("button"));
			for (int i = 0; i < button.size(); i++) 
			{
				String text=button.get(i).getText();
				if (text.equalsIgnoreCase("ok!"))
				{
					button.get(i).click();
					break;
					
				}
				
			}
			actval=driver.findElement(By.id("btnsubmit")).getText();
			Assert.assertEquals(actval, expval,"Logout Failed");
		}

	}

