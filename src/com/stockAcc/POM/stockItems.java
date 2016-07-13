package com.stockAcc.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class stockItems {

	@FindBy(linkText="Stock Categories")
	WebElement stockcategories;
	@FindBy(linkText="Unit of Measurement")
	
	WebElement unitofmeasurement;
	
	
	@FindBy(xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")
	WebElement stockadding;
	
	@FindBy(id="x_Category")
	WebElement xcategory;
			
	
	public void stockcatclick()
	{
		stockcategories.click();
		
	}
	public void uomclick()
	{
		unitofmeasurement.click();
	}
	
	public void stockaddclick()
	{
		stockadding.click();
		
	}
	
	public void stock_add()
	{
		
		xcategory.sendKeys("trhrhrh");
		
		
		
	}
}
