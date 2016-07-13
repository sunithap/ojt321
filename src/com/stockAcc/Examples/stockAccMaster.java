package com.stockAcc.Examples;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class stockAccMaster
{
	public String expval1="supplier-00000000266";
	public static WebDriver driver;
	public static String expval,expval2,actval;
	public static String url="http://webapp.qedgetech.com";
	public FileInputStream fi;
	public Properties pr = null;
	public static List<WebElement> cols;
	
	/*Function Name:stockAcc_Launch
	 * Arguments: url
	 * Description: It will launch the stockaccounting application
	 * created date:18/6/2016
	 * Author:Sharath
	 * Return Type: String 
	 */
	
public String stockAcc_Launch(String url) throws IOException
	{
	
	fi=new FileInputStream("D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Properties\\config.properties");
		
	pr=new Properties();
	pr.load(fi);
	
	
	
	expval="btnsubmit";
	
	driver=new FirefoxDriver();
	//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunitha\\Desktop\\chromedriver.exe");
		//ChromeDriver driver =new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		actval=driver.findElement(By.id(pr.getProperty("login"))).getAttribute("id");
		
		if (expval.equalsIgnoreCase(actval))
		{
			return "Pass";
		}
		else
		{
			return "Fail";
			
		}
	}	

public String stockAcc_logintest(String Uname, String Pwd) throws IOException{
	//List<WebElement> cols;
 	fi=new FileInputStream("D:\\Stock Accounting\\stockAcc\\src\\com\\stockAcc\\Properties\\config.properties");
	
	pr=new Properties();
	pr.load(fi);
	expval2="Administrator";
	Boolean flag=false;
	int cnt=0;
	//driver=new FirefoxDriver();
	//driver.get(url);
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.findElement(By.id(pr.getProperty("uname"))).clear();
	driver.findElement(By.id(pr.getProperty("uname"))).sendKeys(Uname);
	driver.findElement(By.id(pr.getProperty("pword"))).clear();
	driver.findElement(By.id(pr.getProperty("pword"))).sendKeys(Pwd);
	driver.findElement(By.id("btnsubmit")).click();
	actval = driver.findElement(By.xpath(pr.getProperty("adm"))).getText();
	driver.findElement(By.linkText("Suppliers")).click();
	
	List<WebElement> rows= driver.findElements(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr"));
	System.out.println(rows.size());
	String s= driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/span[2]")).getText();
	System.out.println(s);
	String[] split= s.split(" ");
	System.out.println(split.length);
	System.out.println(split[0]+"-----" +split[1]+"----" +split[2]);
	int pnt=Integer.parseInt(split[2]);
	System.out.println(pnt);
	String sid=null; 
	 //System.out.println(cols.size());
	do{
	for(int i=0;i<rows.size();i++)
	{
		
	 cols= rows.get(i).findElements(By.tagName("td"));
	 //System.out.println(cols.size());
	 sid= cols.get(5).getText();
	 //System.out.println("supplier no is"+cols.get(5).getText());
	 
	 if (sid.equalsIgnoreCase(expval1)) {
		System.out.println("Pass for supplierno" +sid);
		flag=true;
		break;
		
	}
	 if(flag==false)
	 {
		 driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/form/div[2]/div/div/div[2]/a[1]/span")).click();
		 Sleeper.sleepTightInSeconds(5);
		 driver.findElement(By.xpath(".//*[@id='tbl_a_supplierslist']/tbody/tr"));
	 
	 
	 }
	 else
	 {
		 System.out.println("Pass");
		 
		 break;
	 }
	
	cnt++;
	} 
	
	}while(cnt<=pnt);
	//System.out.println(cols.size());
	 //System.out.println(sid);
	
	
	if (expval2.equalsIgnoreCase(actval))
	{
		return "Pass";
	}
	else
	{
		return "Fail";
	}
	
	
}


public void stockAcc_Logout()
{
	driver.findElement(By.xpath(".//*[@id='mi_logout']/a")).click();
	
	
	
}
public void stockAcc_Close()
{
	driver.close();
}

/*public String UnitofMcreation(String Uid1,String Udesc1)
{
	
	
	//driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	String Uid1=driver.findElement(By.id("x_UOM_ID")).sendKeys("6");
	String Udesc1= driver.findElement(By.id("x_UOM_Description")).sendKeys("ngdfjf");
	
	driver.findElement(By.id("btnAction")).click();
	
	//driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
	//driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();
	
}*/

}



	

