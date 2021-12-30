package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ObjectArrays;

public class TestNGDataProviderPractice 
{
	
	@Test(dataProvider = "getData")
	public void readDataFromDataProviderTest(String Name, int qty)
	{
		System.out.println("Mobile Name ------->"+Name+"===Mobile Quantity-------->"+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr = new Object[5][2];
		objArr[0][0] = "Iphone X";
		objArr[0][1] = "10";
		
		objArr[1][0] = "Samsung M51";
		objArr[1][1] = "15";
		
		objArr[2][0] = "Redmi";
		objArr[2][1] = "20";
		
		objArr[3][0] = "Vivo";
		objArr[3][1] = "5";
		
		objArr[4][0] = "One Plus 9T";
		objArr[4][1] = "25";
		
		
		return objArr;
		
	}
}
