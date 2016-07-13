package com.maven;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;





public class test {
	
	@Test
	public void a() throws IOException
	{
		WebDriver d=new FirefoxDriver();
		d.get("http://google.com");
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\sunitha\\mymaven\\src\\test\\java\\com\\maven\\googlepage.png"));
		
	}

}
