package com.crm.autodesk.genericutility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	ExcelUtility Elib = new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	WebDriver driver;
	
	@BeforeSuite
	public void dbConnection()
	{
		System.out.println("*****DB connection connection*****");
	}
	
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		 String BROWSER = fLib.getPropertyKeyValue("browser");
		 
		
	}

}
