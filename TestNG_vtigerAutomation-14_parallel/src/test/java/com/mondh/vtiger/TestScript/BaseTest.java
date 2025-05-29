package com.mondh.vtiger.TestScript;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class BaseTest {

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;	
	private ExtentReports extent;
	private ExtentTest extTest;
	
	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() {
		gm.loadProperties("Data");
		
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("test-output/VtigerExtentReport.html");
		extent.attachReporter(spark);
		System.out.println("Before TestScript Suite");
	}
	
//	@BeforeTest(alwaysRun = true)
//	public void beforeTest() {		
//		System.out.println("DataBase Connect");
//	}
//	

//LunchBrower:	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void beforeClass(String browser) {
		gm.lunchbrower(browser);
		gm.impliCityTimewait(60);
		gm.openUrl("http://localhost:8888");
		
	}
	
//before_group:	
	@BeforeGroups(groups = {"Smoke"},alwaysRun = true)
	public void beforegroup() {
		System.out.println("Smoke_Group");
	}
	@BeforeGroups(groups = {"Regression"},alwaysRun = true)
	public void beforegroup1() {
		System.out.println("After_Group");
	}

//Login:
	@Parameters({"username","password"})
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(String userName,String password,Method mt) {	
		extTest=extent.createTest(mt.getName());
		gm.setExtTest(extTest);
		comm=new CommonReusableCode(gm);		
		comm.velidLogin(userName,password);
	}
	
//	properties base use:
//		@BeforeMethod(alwaysRun = true)
//		public void beforeMethod(Method mt) {	
//			extTest=extent.createTest(mt.getName());
//			gm.setExtTest(extTest);
//			comm=new CommonReusableCode(gm);	
//			comm.velidLogin();
//		}

//SignOut:	
	@AfterMethod( alwaysRun = true)
	public void afterMethod(ITestResult result,Method mt) {	
		
		if(result.getStatus()==result.FAILURE) {
		String	snapShort=gm.takeScreenShort(mt.getName(), "dd-MM-yyyy hh_mm_ss a");
		gm.getExtTest().addScreenCaptureFromPath(snapShort);
		}
		comm.userSignOut();
		extent.flush();
	}
	
//After_Group:	
	@AfterGroups(groups = {"Smoke"},alwaysRun = true)
	public void aftergroup() {
		extTest.log(Status.INFO," After_group");
	}

//DriverQite():	
	@AfterClass(alwaysRun = true)
	public void afterClass() {		
		gm.driverQuit();
	}
	
//	
//	@AfterTest(alwaysRun = true)
//	public void afterTest() {
//		System.out.println("DataBase DisConnect");
//	}
//	
	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		extTest.log(Status.INFO," After TestScript Suite");
		extent.flush();
	}
	
	
}
