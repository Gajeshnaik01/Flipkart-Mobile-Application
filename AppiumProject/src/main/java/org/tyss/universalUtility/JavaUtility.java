package org.tyss.universalUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains java reusable methods
 * @author Gajesh Naik
 *
 */
public final class JavaUtility 
{
	
	/**
	 * This method is used to generate randomNumbers
	 * @return
	 */

	public int getRandomNumber()
	{
		Random randomNumber=new Random();
		return randomNumber.nextInt(1000);
	}
	/**
	 * This method is used to generate randomNumbers
	 * @return
	 */
	public int getRandomNumber(int bound)
	{
		Random randomNumber=new Random();
		return randomNumber.nextInt(bound);
	}
	/**
	 * This method is used to convert string to long Data Type
	 * @param stringData
	 * @return
	 */

	public long convertStringToLong(String stringData)
	{
		return Long.parseLong(stringData);
	}
	/**
	 * This method is used to print the values in console
	 * @param value
	 */

	public void printStatement(String value)
	{
		System.out.println(value);
	}
	/**
	 * This method is used to split the given String 
	 * @param value
	 * @param stratergy
	 * @return
	 */
	public String[] splitString(String value,String stratergy)
	{
		String[] data = value.split(stratergy);
		return data;
	}
	
	/**
	 * This method is used to get the current date
	 * @param Strategy
	 * @return
	 */
	public String getCurrentDate(String Strategy)
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat(Strategy);
		String currentDate = sdf.format(date);
		return currentDate;
	}	
}	


