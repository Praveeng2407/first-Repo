package com.crm.autodesk.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactWithOrgTest 
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
		
		String orgName = eLib.getDataFromExcel("org", 4, 2) + randomNum;
		String lastName = eLib.getDataFromExcel("org", 1, 2) + randomNum;
		 


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
		
		//Step 2: navigate to organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 3: click on "create organization" Button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 4: Enter all the details &create new organization
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Wait for the element to be active
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
		
		//Step 5: navigate to contact module
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step 6: click on "create contact" button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		//step 7: enter all the details & create new contact
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		wLib.swithToWindow(driver, "Accounts");
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(orgName)).click();
		
		wLib.swithToWindow(driver, "Contacts");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
	
		//Step 8: verify contact name in header of the msg
		String actSuc_msg = driver.findElement(By.className("dvHeaderText")).getText();
		if(actSuc_msg.contains(lastName))
		{
			System.out.println(lastName + "==> contact is successfully created..PASS" );
		}
		else
		{
			System.out.println(lastName + "==> contact is not created..FAIL" );
		}
		
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName.contains(orgName))
		{
			System.out.println(orgName + "==> is verified in contact page" );
		}
		else
		{
			System.out.println(orgName + "==> is not verified in contact page" );
		}
		
		//Step 9: logout
		wLib.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
	}
		

}
