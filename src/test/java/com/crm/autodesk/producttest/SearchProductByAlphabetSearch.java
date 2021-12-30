package com.crm.autodesk.producttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class SearchProductByAlphabetSearch 
{

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");
		

		String prodName = eLib.getDataFromExcel("org", 13, 2);
		String searchText = eLib.getDataFromExcel("org", 13, 3);

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

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.className("detailedViewTextBox")).sendKeys(prodName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actName = driver.findElement(By.className("lvtHeaderText")).getText();
		if(actName.contains(prodName))
		{
			System.out.println(prodName + "==> is successfully created.." );
		}
		else
		{
			System.out.println(prodName + "==> is not created.." );
		}

		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.name("search_text")).sendKeys(searchText);

		WebElement we=driver.findElement(By.id("bas_searchfield"));
		Select sel=new Select(we);
		sel.selectByIndex(1);

		driver.findElement(By.xpath("(//input[@class='crmbutton small create'])[1]")).click();
		String pName = driver.findElement(By.linkText(prodName)).getText();
		System.out.println(pName);
		if(pName.contains(prodName))
		{
			System.out.println("matching products displayed..PASS" );
		}
		else
		{
			System.out.println("matching products not displayed..FAIL" );
		}
		wLib.mouseOverOnElemnet(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
	}

}

