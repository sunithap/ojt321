package com.stockAcc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void a()
	{
		WebDriver d=new FirefoxDriver();
		d.get("http://google.com");
		
		
	}

}
