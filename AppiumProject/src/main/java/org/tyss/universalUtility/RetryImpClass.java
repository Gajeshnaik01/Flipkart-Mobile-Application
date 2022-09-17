package org.tyss.universalUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{

	int count =0;
	int retrylimit=2;
	public boolean retry(ITestResult result) {
		while(count<retrylimit)
		{
			count++;
			return true;
		}
		return false;

	}



}
