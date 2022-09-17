package org.tyss.universalUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods for csv file and property file
 * @author Gajesh Naik
 *
 */
public final class FileUtility 
{
	private Properties properties;
	/**
	 * This method is used to initialize the property file
	 * @param filePath
	 */
	public void initializePropertyFile(String filePath)
	{


		FileInputStream fis=null;
		try 
		{
			fis = new FileInputStream(filePath);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		properties=new Properties();
		try
		{
			properties.load(fis);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}


	}
	/**
	 * This method is used to fetch the data from property file	
	 * @param key
	 */
	public String getDataFromProperties(String key)
	{
		return properties.getProperty(key);
	}
}
