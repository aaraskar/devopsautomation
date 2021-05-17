package com.qa.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer {
	
	int counter=1;
	int retryLimit=2;

	@Override
	public boolean retry(ITestResult arg0) {
		
		if(counter<retryLimit)
		{
			counter++;
			return true;
		}
		else
			return false;
	}

}
