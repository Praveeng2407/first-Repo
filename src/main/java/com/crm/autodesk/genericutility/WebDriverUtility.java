package com.crm.autodesk.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Praveen
 *
 */

public class WebDriverUtility 
{

	/**
	 * wait for page to load before identifying any synchronized element in DOM [HTML-Document]
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) 
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * wait for page to load before identifying any assychronized [java scripts actions] element in DOM [HTML-Docuent]
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) 
	{
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}

	/**
	 * It's used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 */
	public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * It's used to wait for element to be clickable in GUI , & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 * @param pollingTime in the form second
	 * @throws Throwable 
	 */
	public void waitForElementWithCumtomTimeOut(WebDriver driver, WebElement element, int pollingTime) throws Throwable {
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	/**
	 * It's used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) 
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();

		while (it.hasNext())
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) 
			{
				break;
			}
		}
	}

	/**
	 * It's used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}

	/**
	 * It's used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}

	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	public void swithToFrame(WebDriver driver , int index) 
	{
		driver.switchTo().frame(index);
	}

	/**
	 * It's used to Switch to Frame Window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	public void swithToFrame(WebDriver driver , String id_name_attribute) 
	{
		driver.switchTo().frame(id_name_attribute);
	}

	/**
	 * It's used to select the value from the dropDwon  based on index
	 * @param driver
	 * @param index
	 */
	public void select(WebElement element , int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	/**
	 * It's used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param value
	 */
	public void select(WebElement element , String text) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	/**
	 * It's used to place mouse cursor on specified element
	 * @param driver
	 * @param elemnet
	 */
	public void mouseOverOnElemnet(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}

	/**
	 * It's used to right click  on specified element

	 * @param driver
	 * @param elemnet
	 */
	public void rightClickOnElement(WebDriver driver , WebElement elemnet)
	{
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}

	/**
	 * It's used for Executing javaScript
	 * @param driver
	 * @param javaScript
	 */
	public void executeJavaScript(WebDriver driver , String javaScript) 
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
	}
	
	/**
	 * It's used for WaitAndClick
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException
	{
		int count = 0;
		while(count<20) 
		{
			try 
			{
				element.click();
				break;
			}
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	/**
	 * It's used to takeScreenShot
	 * @param driver
	 * @param screenshotName
	 * @throws Throwable
	 */
	public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable 
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshot/"+screenshotName+".PNG");
		Files.copy(src, dest);
	}

	/**
	 * pass enter Key appertain in to Browser
	 * @param driver
	 */
	public void passEnterKey(WebDriver driver) 
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	} 



}


