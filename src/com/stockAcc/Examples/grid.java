package com.stockAcc.Examples;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class grid {
	
		@Parameters("browser")
		@Test
		public void demo(String br) throws MalformedURLException
		{
			DesiredCapabilities cap=null;
			
			if (br.equalsIgnoreCase("firefox")) 
			{
				cap=DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
			}
			else if (br.equalsIgnoreCase("chrome"))
			{
				cap=DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
			}
			else if (br.equalsIgnoreCase("ie"))
			{
				cap=DesiredCapabilities.internetExplorer();
				cap.setBrowserName("internet explorer");
				cap.setPlatform(Platform.WINDOWS);
			}
			
			
			
			WebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			
			boolean flag=false;
			String date="18/february/2017";
			String[] datesplit=date.split("/");
			String day=datesplit[0];
			String month=datesplit[1];
			String year=datesplit[2];
			
			
			driver.get("http://cleartrip.com");
			driver.manage().window().maximize();
			
			driver.findElement(By.id("DepartDate")).click();
			
			String calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
			
			while (!year.equals(calyear)) 
			{
				driver.findElement(By.className("nextMonth ")).click();
				calyear=driver.findElement(By.className("ui-datepicker-year")).getText();
			}
			
			String calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
			
			
			while (!month.equalsIgnoreCase(calmonth))
			{
				driver.findElement(By.className("nextMonth ")).click();
				calmonth=driver.findElement(By.className("ui-datepicker-month")).getText();
			}
			
			List<WebElement> rows=driver.findElements(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr"));
			
			for (int i = 0; i < rows.size(); i++)
			{
				List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
				
				for (int j = 0; j < cols.size(); j++) 
				{
					String calday=cols.get(j).getText();
					if (day.equals(calday))
					{
						cols.get(j).click();
						flag=true;
						break;
						
						
					}
					
				}
				if (flag==true)
				{
					break;
					
				}
				
				
			}
			
		}

	}



