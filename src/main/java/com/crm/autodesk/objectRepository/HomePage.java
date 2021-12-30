package com.crm.autodesk.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText ="Organizations")
	private WebElement organizationLnk;
	
	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}
	
	@FindBy(linkText ="Contacts")
	private WebElement contactsLnk;
	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	public WebElement getProductsLink() 
	{
		return productsLink;
	}

	@FindBy(linkText ="Sign Out")
	private WebElement signOutLnk;


	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	public void logout(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(administratorImg).perform();
		signOutLnk.click();
	}

}
