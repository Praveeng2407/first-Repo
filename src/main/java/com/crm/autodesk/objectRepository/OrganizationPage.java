package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.JavaUtility;

public class OrganizationPage extends JavaUtility
{
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgImg;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement enterOrgNameEdt;
	



	public WebElement getCreateOrgImg() 
	{
		return createOrgImg;
	}
	
	

}
