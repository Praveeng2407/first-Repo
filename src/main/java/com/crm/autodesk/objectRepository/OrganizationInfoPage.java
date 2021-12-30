package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage
{
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement successfulMsg;
	
	public WebElement getSuccessfulMsg() 
	{
		return successfulMsg;
	}
	

	

}
