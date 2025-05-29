package com.mondh.vtiger.genericyCodes;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class IRetryAnalyzreTestCase implements IRetryAnalyzer{

	private static final int    maxTry = 3;
	private   int    count  = 0;
	
	@Override
	public boolean retry(ITestResult iTestResult) {
		if (iTestResult.isSuccess ()==false) {
	           if (this.count < maxTry) {
	               this.count++;
	               return true;
	           }
	       }
	       return false;
		
	}
	

	

}
