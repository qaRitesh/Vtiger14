package com.mondh.vtiger.TestScript;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class RunnerClass {

//	priority,dependsOnMethods,enabled,alwaysRun [ @BeforeMethod,@AfterMethod ][@BeforeClass,@AfterClass]
//	[@BeforeTest,@AfterTest] [@BeforeSuite,@AfterSuite]
	 
	@BeforeSuite
	public void beforeSuite() {
		ExtentReports	extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter("test-output/VtigerExtentReport.html");
		extent.attachReporter(spark);
		ExtentTest exteText=extent.createTest("testcase1");
		exteText.log(Status.INFO, "testcase");
		extent.flush();
		System.out.println("Before TestScript Suite");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("DataBase Connect");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before_Class");
		
	}
	
	@BeforeGroups
	public void beforegroup() {
		System.out.println("before_group");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before_Method");
		
	}
//methods:	
	@Test(priority = 1,enabled = true,dependsOnMethods = {"string2"},alwaysRun = true)
	public void string1() {
		System.out.println("it is String1");
	}
	
	@Test(priority = 2)
	public void string2() {
		System.out.println("it is String2");
	}
	
	@Test(priority = 3)
	public void string3() {	
		System.out.println("it is String3");
	}
//methods end
	
	@AfterMethod
	public void aftermethod() {
		System.out.println("After_method");
	}
	
	@AfterGroups
	public void aftergroup() {
		System.out.println("after_group");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After_Class");
	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("DataBase DisConnect");
	}
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("After TestScript Suite");
	}
	
//		
//	@Test(priority = 4,alwaysRun = true)
//	public void string4() {
//		System.out.println("it is String4");
//	}
	@Test
	public static void main() throws IOException {
		InputStream	excelFillPath=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Book1.xlsx");
		Workbook workBook=new XSSFWorkbook(excelFillPath);
		Sheet	sheetObj=workBook.getSheet("sheet1");
			for(int i=0;i<=sheetObj.getLastRowNum();i++) {
					Row rowObj=sheetObj.getRow(i);
				for(int j=0;j<=rowObj.getLastCellNum()-1;j++) {
					Cell cellObj=rowObj.getCell(j,MissingCellPolicy.RETURN_BLANK_AS_NULL);
					String stringcellValue=null;
					if(cellObj.getCellType().STRING==CellType.STRING) {
						stringcellValue=cellObj.getStringCellValue();
					}else {
					Double	doubleData=cellObj.getNumericCellValue();
					Integer	intData=doubleData.intValue();
					stringcellValue	=intData.toString();
					}
					System.out.print(stringcellValue+",");
				}
				System.out.println();
			}
	}
	
}
