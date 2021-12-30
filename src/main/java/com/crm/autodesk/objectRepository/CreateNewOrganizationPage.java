package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage 
{
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath = "//input[@name='//INPUT']")
	private WebElement contactLastNameEdt;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createContact(String lastname)
	{
		contactLastNameEdt.sendKeys(lastname);
	}
	
	
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
