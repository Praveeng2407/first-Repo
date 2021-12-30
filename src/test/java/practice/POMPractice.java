package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectRepository.CreateNewOrganizationPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;
import com.crm.autodesk.objectRepository.OrganizationInfoPage;
import com.crm.autodesk.objectRepository.OrganizationPage;

public class POMPractice 
{
	public static void main(String[] args) throws Throwable {


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

		//Login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//click on organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLnk().click();

		//create organizations
		OrganizationPage op= new OrganizationPage(driver);
		op.getCreateOrgImg().click();


		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createOrg(orgName);

		//validation
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actMsg = oip.getSuccessfulMsg().getText();


		if(actMsg.contains(orgName))
		{
			System.out.println(orgName + "==> is successfully created..PASS" );
		}
		else
		{
			System.out.println(orgName + "==> is not created..FAIL" );
		}

		hp.logout(driver);
		driver.quit();

	}
}

