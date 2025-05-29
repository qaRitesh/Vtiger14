package com.mondh.vtiger.TestScript;

import org.testng.annotations.Test;

import com.mondh.vtiger.genericyCodes.IRetryAnalyzreTestCase;
import com.mondh.vtiger.genericyCodes.WebUtil;


public class ListenerBase {
	
	private WebUtil	we= WebUtil.getObject();

	@Test(retryAnalyzer = IRetryAnalyzreTestCase.class)
	public void method1() {
		we.getPropertyData("userName");
		we.getPropertyData("passwordName");
		System.out.println("method1");
			
	}
	@Test
	public void method2() {
		System.out.println("method2");
	}
}
