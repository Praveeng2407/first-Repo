package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductPage 
{
	public CreateNewProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='productname']")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@name='unit_price']")
	private WebElement unitPriceEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void createProduct(String prodName)
	{
		productNameEdt.sendKeys(prodName);
		saveBtn.click();
	}
	
	public void createProduct(String prodName, String unitPrice)
	{
		productNameEdt.sendKeys(prodName);
		unitPriceEdt.clear();
		unitPriceEdt.sendKeys(unitPrice);
		saveBtn.click();
	}
	
	
	
}
