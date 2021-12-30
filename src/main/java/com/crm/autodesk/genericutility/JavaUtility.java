package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Praveen
 *
 */

public class JavaUtility 
{
	
	/**
	 * It's used to generate random number
	 * @return int data
	 */
	public int getRanDomNumber()
	{
		Random random= new Random();
		int intRandom=random.nextInt(10000);
		return intRandom;
		
	}
	
	/**
	 * Used to get System Date and Time in IST format
	 * @return date and time
	 */
	public String getSystemDateAndTime()
	{
		Date date=new Date();
		return date.toString();
		
	}
	
	/**
	 * Used to get System Date in YYYY MM DD format
	 * @return System date
	 */
	public String getSystemDateWithFormat()
	{
		Date date=new Date();
		String dateAndTime=date.toString();
		
		String YYYY = dateAndTime.split(" ")[5];
		String DD = dateAndTime.split(" ")[2];
		int MM = date.getMonth()+1;
		
		String finalFormat = YYYY +"-"+MM+"-"+DD;
		return finalFormat;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
