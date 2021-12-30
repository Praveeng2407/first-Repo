package com.crm.autodesk.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.mysql.cj.jdbc.Driver;

public class CreateOrgWithIndustries_Type
{

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		
		int randomNum = jLib.getRanDomNumber();
		
		String orgName = eLib.getDataFromExcel("org", 7, 2) + randomNum;
				
		WebDriver driver = null;

		if(BROWSER.equals("chrome"))
		{
			driver= new ChromeDriver();

		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
		wLib.select(driver.findElement(By.xpath("//select[@name='industry']")), eLib.getDataFromExcel("org", 7, 3));
		wLib.select(driver.findElement(By.xpath("//select[@name='accounttype']")), eLib.getDataFromExcel("org", 7, 4));
		
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();		
		String succMsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(succMsg.contains(orgName))
		{
			System.out.println(orgName + "==> is successfully created..PASS" );
		}
		else
		{
			System.out.println(orgName + "==> is not created..FAIL" );
		}
		
		wLib.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		


	}

}
