package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Praveen
 *
 */
public class FileUtility
{
	
	/**
	 * It's used to read the data from commondata.properties File based on Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */
    public String getPropertyKeyValue(String key) throws Throwable {
    	 FileInputStream fis = new FileInputStream("./data/commondata.properties");
    	 Properties pobj = new Properties();
    	 pobj.load(fis);
    	 String value = pobj.getProperty(key);
		return value;


    }
}
