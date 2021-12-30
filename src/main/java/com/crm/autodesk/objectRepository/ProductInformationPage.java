package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage 
{
	public void ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "lvtHeaderText")
	private WebElement successfulMsg;
	
	public WebElement getSuccessfulMsg() 
	{
		return successfulMsg;
	}
	

}
