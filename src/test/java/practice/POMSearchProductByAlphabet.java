package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;
import com.crm.autodesk.objectRepository.CreateNewProductPage;
import com.crm.autodesk.objectRepository.HomePage;
import com.crm.autodesk.objectRepository.LoginPage;
import com.crm.autodesk.objectRepository.ProductInformationPage;
import com.crm.autodesk.objectRepository.ProductPage;

public class POMSearchProductByAlphabet 
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

		//Login to app
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//click on products
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();
		
		//click on createNewProduct Lookup
		ProductPage pp = new ProductPage(driver);
		pp.getCreateProductLookup().click();
		
		//create new product
		CreateNewProductPage cnp = new CreateNewProductPage(driver);
		cnp.createProduct(prodName);
		
		//validation
		ProductInformationPage pip = new ProductInformationPage();
		String actMsg = pip.getSuccessfulMsg().getText();
		System.out.println(actMsg);
		
		if(actMsg.contains(prodName))
		{
			System.out.println(prodName + "==> is successfully created..PASS" );
		}
		else
		{
			System.out.println(prodName + "==> is not created..FAIL" );
		}

		hp.logout(driver);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
