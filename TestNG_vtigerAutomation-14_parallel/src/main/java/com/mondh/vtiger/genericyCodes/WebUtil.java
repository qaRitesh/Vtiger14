
package com.mondh.vtiger.genericyCodes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang3.exception.ExceptionContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.utility.RandomString;

@Getter
@Setter
public class WebUtil {

	// generic methods: -Application independent methods.
	// multiple time use.
	private WebUtil() {

	}

	private WebDriver driver;
	private static WebUtil webUtil;
	private ExtentTest extTest;
	private Properties prop;

//Functionality ==== locater.	
	// Object:
	public static WebUtil getObject() {
		if (webUtil == null) {
			webUtil = new WebUtil();
		}
		return webUtil;
	}

	// EctentTest Object pass:
//	public void setExtentTestObject(ExtentTest extTest) {
//		this.extTest=extTest;
//	}

//	before using lombok jar:
//	public WebDriver getDriver() {
//        return this.driver;
//    }

//--------------------------------------WebDriver() methods---------------------------------	
//LunchBrowers:	
	public void lunchbrower(String browser) {
		if (browser.equalsIgnoreCase("ChromeBrowser")) {
			ChromeOptions cp = new ChromeOptions();
			cp.addArguments("start-maximized");
		//	cp.addArguments("--headless");
			driver = new ChromeDriver(cp);
			System.out.println("Chrome Browser Launched Successfully.");
		} else if (browser.equalsIgnoreCase("FirfoxBrowser")) {
			FirefoxOptions cp = new FirefoxOptions();
			cp.addArguments("start-maximized");
			driver = new FirefoxDriver(cp);
			System.out.println("Firefox Browser Launched Successfully.");
		} else if (browser.equalsIgnoreCase("EdgeBrowser")) {
			EdgeOptions cp = new EdgeOptions();
			cp.addArguments("start-maximized");
			driver = new EdgeDriver(cp);
			System.out.println("Microsoft Edge Browser Launched Successfully.");
		} else {
			System.out.println("Broswer can't be Launch:");
		}

	}

// URl:
	public void openUrl(String Url) {
		try {
			driver.get(Url);
			System.out.println("The given url:- " + Url + " has opened Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The given url:- " + Url + " hasn't opened Successfully");
		}
	}

//titles:
	public String CurrentTitle() {
		String title = null;
		try {
			title = driver.getTitle();
			extTest.log(Status.INFO, "Current Tab Title.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Current Tab Title not find.");
		}
		return title;
	}

//CurrentUrl:
	public String getCurrentUrl() {
		String cUrl = null;
		try {
			cUrl = driver.getCurrentUrl();
			extTest.log(Status.INFO, "Current Tab Url.");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Current Tab Url not find.");
		}
		return cUrl;
	}

//PageSource_Code:
	public String pageSourcecode() {
		String screenPs = null;
		try {
			screenPs = driver.getPageSource();
			extTest.log(Status.INFO, "Home Screen Html Scoure code ");
		} catch (StaleElementReferenceException e) {
			screenPs = driver.getPageSource();
			extTest.log(Status.INFO, "Home Screen Html Scoure code ");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.INFO, "Home Screen Html Scoure code  not find.");
		}
		return screenPs;
	}

//windowhandlevalue:
	public String getWindowHandleValue() {

		String handleValue = driver.getWindowHandle();
		return handleValue;
	}

//-----------------------------TimeWate:----------------------------------------------
	
						//implicitlyWait:	
	public void impliCityTimewait(int waiteSecondTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waiteSecondTime));
	}
	
						//ExplicityWate:
	
//visibility:	
	public void explicityVisibility(WebElement we,int timeWateSecond){
		
		WebDriverWait	explicityW=new WebDriverWait(driver, Duration.ofSeconds(timeWateSecond));
		explicityW.until(ExpectedConditions.visibilityOf(we));
		extTest.log(Status.INFO, "Explicity time under Element is Visibli. ");
	}
	
//Invisibility:	
		public void explicityInvisibility(WebElement we,int timeWateSecond){
			
			WebDriverWait	explicityW=new WebDriverWait(driver, Duration.ofSeconds(timeWateSecond));
			explicityW.until(ExpectedConditions.invisibilityOf(we));
			extTest.log(Status.INFO, "Explicity time under Element is InVisibli. ");
		}	
	
//Enabled:	
		public void explicityEnabled(WebElement we,int timeWateSecond){
			
			WebDriverWait	explicityW=new WebDriverWait(driver, Duration.ofSeconds(timeWateSecond));
			explicityW.until(ExpectedConditions.elementToBeClickable(we));
			extTest.log(Status.INFO, "Explicity time under Element is Enabled. ");
		}
		
//Disabled:	
		public void explicityDisabled(WebElement we,int timeWateSecond){
					
					WebDriverWait	explicityW=new WebDriverWait(driver, Duration.ofSeconds(timeWateSecond));
					explicityW.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(we)));
					extTest.log(Status.INFO, "Explicity time under Element is Disabled. ");
		}		
	
//TextInElement:	
		public void explicityTextInElement(WebElement we,int timeWateSecond,String text){
							
				WebDriverWait	explicityW=new WebDriverWait(driver, Duration.ofSeconds(timeWateSecond));
				explicityW.until(ExpectedConditions.textToBePresentInElement(we,text));
				extTest.log(Status.INFO, "Explicity time under Element is TextInElement. ");
		}		
	
		
								//Fluent wate:
		public void fluentWate(int timeout) {
			FluentWait	flt=new FluentWait<WebDriver>(driver);
			flt.pollingEvery(Duration.ofMillis(100));
			flt.withTimeout(Duration.ofSeconds(timeout));
			flt.ignoring(NoSuchElementException.class);
		}
		
//============================================================================================		

		//Lunch Driver Close:
	public void driverClose() {
		driver.close();
		extTest.log(Status.INFO, "Lunch Driver are Close.");
	}

//Lunch Browser Quit:
	public void driverQuit() {
		driver.quit();
		extTest.log(Status.INFO, "Lunch Driver are Quit.");

	}

//myFindElement:
	/*
	 * public WebElement myFindElement(WebElement weObj, String elementName) {
	 * 
	 * WebElement webObj = null;
	 * 
	 * try { webObj = driver.findElement(By.xpath(xpath));
	 * System.out.println(elementName + " is find sucessfully."); } catch
	 * (NoSuchElementException e) { WebDriverWait wt = new WebDriverWait(driver,
	 * Duration.ofSeconds(20));
	 * wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	 * webObj = driver.findElement(By.xpath(xpath)); System.out.println(elementName
	 * + " is find suceefully."); throw e; } catch (InvalidSelectorException e) {
	 * e.printStackTrace(); System.out.println(elementName +
	 * " is not found successfully."); throw e; } catch (NullPointerException e) {
	 * driver = new ChromeDriver();
	 * 
	 * System.out.println("Brower has launched");
	 * 
	 * driver.get("http://localhost:8888");
	 * System.out.println("Browser has launched this link http://localhost:8888");
	 * 
	 * webObj = driver.findElement(By.xpath(xpath)); System.out.println(elementName
	 * + " is found sucessfully"); throw e; } catch (Exception e) {
	 * e.printStackTrace(); System.out.println(elementName +
	 * " is not found successfully."); throw e; } return webObj; }
	 */

//myFindElements:
	/*
	 * public List<WebElement> myFindElements(WebElement weObj, String elementName)
	 * {
	 * 
	 * List<WebElement> webObjs = null;
	 * 
	 * try { webObjs = driver.findElements(By. (weObj));
	 * System.out.println(elementName + " is find sucessfully."); } catch
	 * (NoSuchElementException e) { WebDriverWait wt = new WebDriverWait(driver,
	 * Duration.ofSeconds(20));
	 * wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(weObj)));
	 * webObjs = driver.findElements(By.xpath(weObj));
	 * System.out.println(elementName + " is find sucessfully."); throw e; } catch
	 * (InvalidSelectorException e) { e.printStackTrace();
	 * System.out.println(elementName + " is not found successfully."); throw e; }
	 * catch (NullPointerException e) { driver = new ChromeDriver();
	 * System.out.println("Brower has launched");
	 * 
	 * driver.get("http://localhost:8888");
	 * System.out.println("Browser has launched this link http://localhost:8888");
	 * 
	 * webObjs = driver.findElements(By.xpath(weObj));
	 * System.out.println(elementName + " is found sucessfully"); throw e; } catch
	 * (Exception e) { e.printStackTrace(); System.out.println(elementName +
	 * " is not found successfully."); throw e; } return webObjs; }
	 */

//getTextListFindelements:
	/*
	 * public List<String> getTextListFindelements(WebElement weObj, String
	 * elementName) {
	 * 
	 * List<WebElement> weList = myFindElements(weObj, elementName); // datastore.
	 * List<String> ListName = new ArrayList<String>(); for (int i = 0; i <=
	 * weList.size() - 1; i++) { WebElement wetext = weList.get(i); String textName
	 * = wetext.getText(); ListName.add(textName); } return ListName; }
	 */

//findElements count:
	/*
	 * public int getfindElementCount(WebElement weObj, String elementName) {
	 * 
	 * List<WebElement> weListColumn = myFindElements(weObj, elementName); int
	 * itemcount = 0; itemcount = weListColumn.size();
	 * 
	 * return itemcount; }
	 */

//allCheckBoxClick: 
	/*
	 * public void allCheckBoxClick(WebElement weObj, String Name) {
	 * List<WebElement> weListCheckboxes = myFindElements(weObj, Name);
	 * 
	 * try { for (int i = 0; i <= weListCheckboxes.size() - 1; i++) { WebElement
	 * weCheckBox = weListCheckboxes.get(i); if (weCheckBox.isSelected() == false) {
	 * weCheckBox.click(); } } } catch (StaleElementReferenceException e) {
	 * weListCheckboxes = myFindElements(weObj, Name); for (int i = 0; i <=
	 * weListCheckboxes.size() - 1; i++) { WebElement weCheckBox =
	 * weListCheckboxes.get(i); if (weCheckBox.isSelected() == false) {
	 * weCheckBox.click(); } } } catch (Exception e) { e.printStackTrace();
	 * System.out.println("Failed: " + Name + " checkBox can't click Successfuly.");
	 * } }
	 */

//uncheckAllcheckBox:		
	/*
	 * public void uncheckAllcheckBox(WebElement weObj, String elementName) {
	 * List<WebElement> weListCheckboxes = myFindElements(weObj, elementName);
	 * 
	 * try { for (int i = 0; i <= weListCheckboxes.size() - 1; i++) { WebElement
	 * weCheckBox = weListCheckboxes.get(i); if (weCheckBox.isSelected() == true) {
	 * weCheckBox.click(); } } } catch (StaleElementReferenceException e) {
	 * weListCheckboxes = myFindElements(weObj, elementName); for (int i = 0; i <=
	 * weListCheckboxes.size() - 1; i++) { WebElement weCheckBox =
	 * weListCheckboxes.get(i); if (weCheckBox.isSelected() == true) {
	 * weCheckBox.click(); } } } catch (Exception e) { e.printStackTrace();
	 * System.out.println("Failed: " + elementName +
	 * " unCheckBox can't been Successfuly."); } }
	 */

//---------------------------------WebElement method ()------------------------------------

//clear:	
	public void clearTextBox(WebElement weObj) {

		String elementName = weObj.getAccessibleName();
		try {
			weObj.clear();
			extTest.log(Status.INFO, elementName + " TextBox clear successfully ");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;

		} catch (StaleElementReferenceException e) {
			weObj.clear();
			extTest.log(Status.INFO, elementName + " TextBox clear successfully ");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " textbox can't clear");
		}
	}

// mySendValue:
	public WebElement inputData(WebElement weObj, String inputvalue) {

		String elementName = weObj.getAccessibleName();
		// send values:
		try {
			weObj.clear();
			weObj.sendKeys(inputvalue);
			extTest.log(Status.INFO, inputvalue + " value entered in " + elementName + " textbox successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("argument[0].value='" + inputvalue + "'", weObj);
			extTest.log(Status.INFO, inputvalue + " value entered in" + elementName + " textbox successfully");
		} catch (StaleElementReferenceException e) {
			weObj.sendKeys(inputvalue);
			extTest.log(Status.INFO, inputvalue + " value entered in" + elementName + " textbox successfully");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, inputvalue + "value not entered in" + elementName + "textbox successfully");
		}
		return weObj;
	}

//myButtonClick:
	public void clickButton(WebElement weObj) {

		String elementName = weObj.getAccessibleName();

		// click:
		try {
			weObj.click();
			extTest.log(Status.INFO, elementName + " Click successfully.");
		} catch (ElementClickInterceptedException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("argument[0].click()", weObj);
			extTest.log(Status.INFO, elementName + " Click successfully.");
		} catch (StaleElementReferenceException e) {
			weObj.click();
			extTest.log(Status.INFO, elementName + " Click successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " not click successfully.");
		}
	}

//myGetText:
	public String getText(WebElement weObj) {

		String elementName = weObj.getAccessibleName();
		String innerText = null;
		try {
			innerText = weObj.getText();
			extTest.log(Status.INFO, innerText + " -innertext of " + elementName + " got successfully.");
		} catch (StaleElementReferenceException e) {
			innerText = weObj.getText();
			extTest.log(Status.INFO, innerText + " -innertext of " + elementName + " got successfully.");

		} catch (Exception e) {
			extTest.log(Status.FAIL, innerText + " not  Found.");
			throw e;
		}
		return innerText;
	}

//getsize:
	public void getsize(WebElement weObj) {
		String elementName = weObj.getAccessibleName();

		try {
			Dimension size = weObj.getSize();
			int h = size.height;
			int w = size.width;
			extTest.log(Status.INFO, elementName + " height is " + h + " and width is " + w);

		} catch (StaleElementReferenceException e) {

			Dimension size = weObj.getSize();
			int h = size.height;
			int w = size.width;
			extTest.log(Status.INFO, elementName + " height is " + h + " and width is " + w);
		} catch (Exception e) {

			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " height and width can't find successfully");
		}
	}

//getLocation:
	public void getLocation(WebElement weObj) {
		String elementName = weObj.getAccessibleName();

		try {
			Point location = weObj.getLocation();
			int x = location.getX();
			int y = location.getY();
			extTest.log(Status.INFO, elementName + "  screen size x position  is " + x + " and y posyion is " + y);

		} catch (StaleElementReferenceException e) {
			Point location = weObj.getLocation();
			int x = location.getX();
			int y = location.getY();
			extTest.log(Status.INFO, elementName + "  screen size x position  is " + x + " and y posyion is " + y);

		} catch (Exception e) {

			e.printStackTrace();
			extTest.log(Status.INFO, elementName + "  postion can't find successfully");
		}
	}

//isEnabled:
	public boolean isEnabled(WebElement weObj) {

		String elementName = weObj.getAccessibleName();
		Boolean auctal = null;
		try {
			auctal = weObj.isEnabled();
			if (auctal == true) {
				extTest.log(Status.PASS, elementName + " it is Enebal your screen");
			} else {
				extTest.log(Status.FAIL, elementName + " it is Enebal your screen");
			}

		} catch (StaleElementReferenceException e) {
			auctal = weObj.isEnabled();
			if (auctal == true) {
				extTest.log(Status.PASS, elementName + " it is Enebal your screen");
			} else {
				extTest.log(Status.FAIL, elementName + " it is Enebal your screen");
			}
		} catch (Exception e) {

			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " it is Enebal your screen");
		}
		return auctal;
	}

//isDisplayed:
	public boolean isDisplayed(WebElement weObj) {

		String elementName = weObj.getAccessibleName();
		Boolean auctal = null;
		try {
			auctal = weObj.isDisplayed();
			if (auctal == true) {
				extTest.log(Status.PASS, elementName + " it is Displayed Ui your screen");
			} else {
				extTest.log(Status.FAIL, elementName + " it is Displayed Ui your screen");
			}

		} catch (StaleElementReferenceException e) {

			auctal = weObj.isEnabled();
			if (auctal == true) {
				extTest.log(Status.PASS, elementName + " it is Displayed Ui your screen");
			} else {
				extTest.log(Status.FAIL, elementName + " it is Displayed Ui your screen");
			}
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " it is Displayed Ui your screen");
		}
		return auctal;
	}

//isSelected:
	public boolean getisSelected(WebElement weObj) {

		String elementName = weObj.getAccessibleName();
		Boolean auctal = null;
		try {
			auctal = weObj.isSelected();
			if (auctal == true) {
				extTest.log(Status.PASS, elementName + " checkbox is  unchecked");
			} else {
				extTest.log(Status.FAIL, elementName + " checkbox is not  unchecked");
			}

		} catch (StaleElementReferenceException e) {
			auctal = weObj.isEnabled();
			if (auctal == true) {
				extTest.log(Status.PASS, elementName + " checkbox is  unchecked");
			} else {
				extTest.log(Status.FAIL, elementName + " checkbox is not  unchecked");
			}
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " checkbox is not  unchecked");
		}
		return auctal;
	}

//getAttributevalue:
	public String getAttributevalue(WebElement weObj, String valueText, String attributType) {

		String elementName = weObj.getAccessibleName();
		String attributeValue = null;
		try {
			attributeValue = weObj.getAttribute(attributType);
			if (attributeValue.equalsIgnoreCase(valueText)) {
				extTest.log(Status.PASS,
						elementName + " " + attributType + "attribute value is " + valueText + " correct");
			} else {
				extTest.log(Status.FAIL,
						elementName + " " + attributType + "attribute value is " + valueText + " can't correct");
			}
		} catch (StaleElementReferenceException e) {
			attributeValue = weObj.getAttribute("value");
			if (attributeValue.equalsIgnoreCase(valueText)) {
				extTest.log(Status.PASS,
						elementName + " " + attributType + "attribute value is " + valueText + " correct");
			} else {
				extTest.log(Status.FAIL,
						elementName + " " + attributType + "attribute value is " + valueText + " can't correct");
			}
		} catch (Exception e) {

			e.printStackTrace();
			extTest.log(Status.FAIL,
					elementName + " " + attributType + "attribute value is " + valueText + " can't correct");
		}
		return attributeValue;
	}

//--------------------------ReandomString() Class ------------------------------------	
//randamString:
	public String getRandomStringName() {
		RandomString randomString = new RandomString();
		String string = randomString.make();
		return string;
	}

//randomString lenght:
	public String getRandomStringNameBySetlenght(int num) {
		RandomString randomString = new RandomString();
		String string = randomString.make(num);
		return string;
	}

// ========================== Table =========================================
//RowCount:
	/* this method return number of row in */
	public int getRowCount(String Name) {

		List<WebElement> weListColumn = driver.findElements(By.xpath(Name + "//tr"));
		int itemcount = 0;

		itemcount = weListColumn.size();
		extTest.log(Status.INFO, "Total " + itemcount + " Row ");

		return itemcount;
	}

//ColumnHearderCount:
	/* this method return number of Column in */

	public int getColumnHeaderCount(String ame) {

		List<WebElement> weListColumn = driver.findElements(By.xpath(ame + "//tr[1]//td"));
		int itemcount = 0;
		itemcount = weListColumn.size();
		extTest.log(Status.INFO, "Total " + itemcount + " Columns ");

		return itemcount;
	}

//ColumnNameList:

	/* in this method we want all the column header name in a list<String> */
	public List<String> getHeaderRowNameList(String Name) {

		List<WebElement> weListColumn = driver.findElements(By.xpath(Name + "//tr[1]//td"));
		// datastore.
		List<String> ListColumnName = new ArrayList<String>();
		for (int i = 0; i <= weListColumn.size() - 1; i++) {
			WebElement weColumnHearder = weListColumn.get(i);
			String columnName = weColumnHearder.getText();
			ListColumnName.add(columnName);
		}
		return ListColumnName;
	}

//getColumnNumberByColumnName:			
	/* this method returns column number on the basis of column name */
	public int getColumnHeaderNumberByColumnHeaderName(String weObj, String ColumnName) {

		List<WebElement> ListColumnName = driver.findElements(By.xpath(weObj + "//tr[1]//td"));
		int columnNumber = 0;
		for (int i = 0; i <= ListColumnName.size() - 1; i++) {
			WebElement weColumn = ListColumnName.get(i);
			String ColumnName1 = weColumn.getText();
			if (ColumnName1.equalsIgnoreCase(ColumnName) == true) {
				columnNumber = i + 1;
				break;
			}
		}
		return columnNumber;
	}

//	getRowListByRowNumber	
	/* this method return row data in list on the row number */
	public List<String> getRowListByRowNumber(String Name, int Nubmer) {

		List<WebElement> weListRow = driver.findElements(By.xpath(Name + "//tr[" + (Nubmer + 1) + "]//td"));
		List<String> rowDataList = new ArrayList<String>();

		for (int i = 0; i <= weListRow.size() - 1; i++) {
			WebElement weRowData = weListRow.get(i);
			String data = weRowData.getText();
			rowDataList.add(data);
		}
		return rowDataList;
	}

//columnDataList By columnNo:		
	/* this method return column dataList on the basis of Column number */
	public List<String> getColumnDataListByColumnNumber(String Name, int columnNumber) {
		List<WebElement> columnList = driver.findElements(By.xpath(Name + "//tr//td[" + columnNumber + "]"));

		List<String> cloumnNameList = new ArrayList<>();
		for (int i = 1; i <= columnList.size() - 1; i++) {
			WebElement columnText = columnList.get(i);
			String text = columnText.getText();
			cloumnNameList.add(text);
		}
		return cloumnNameList;
	}

//columnDataList By columnName:			
	/* this method return column dataList on the basis of Column number */
	public List<String> getColumnDataListByColumnName(String Name, String columnName) {

		/*
		 * List<WebElement>ListColumnName=myFindElements(Xpath+"//tr[1]//td", Name); int
		 * columnNumber=-1; for(int i=0;i<=ListColumnName.size()-1;i++) { WebElement
		 * weColumn=ListColumnName.get(i); String ColumnName=weColumn.getText();
		 * if(ColumnName.equalsIgnoreCase(columnName)==true) { columnNumber=i+1; break;
		 * } }
		 * 
		 * List<WebElement>
		 * columnList=myFindElements(Xpath+"//tr//td["+columnNumber+"]", Name);
		 * 
		 * List<String>cloumnNameList=new ArrayList<>(); for(int
		 * i=0;i<=columnList.size()-1;i++) { WebElement columnText=columnList.get(i);
		 * String text=columnText.getText(); cloumnNameList.add(text); } return
		 * cloumnNameList;
		 */

		int columnNo = getColumnHeaderNumberByColumnHeaderName(Name, columnName);
		List<String> columnDataList = getColumnDataListByColumnNumber(Name, columnNo);

		return columnDataList;
	}

//getRowNumberByRowid:
	/* this method return row number on the rowid */
	public int getRowNumberByRowid(String Name, String RowId, String columnName) {

		List<String> columnDataList = getColumnDataListByColumnName(Name, columnName);
		int rowno = -1;

		for (int i = 0; i <= columnDataList.size() - 1; i++) {
			String uniqueColumnData = columnDataList.get(i);

			if (uniqueColumnData.equalsIgnoreCase(RowId)) {
				rowno = i + 1;
				break;
			}
		}
		return rowno;
	}

//getRowDataListByRowId:	
	/* this method return RowDataList on the uniqueRowID */
	public List<String> getRowDataListByRowId(String Name, String uniqueData, String columnName) {

		int columnNo = getRowNumberByRowid(Name, uniqueData, columnName);
		List<String> listRowData = getRowListByRowNumber(Name, columnNo);

		return listRowData;
	}

//AllDataText:		
	/* this method return all DataText in list formating */
	public List<String> getAllDataPrint(String Name) {

		List<WebElement> AllData = driver.findElements(By.xpath(Name));
		List<String> DataText = new ArrayList<>();

		for (int i = 0; i <= AllData.size() - 1; i++) {
			WebElement allText = AllData.get(i);
			String allText1 = allText.getText();
			DataText.add(allText1);
		}
		return DataText;
	}

//tableitemClick:
	public void tableItemClick(String tableName, int columnNo, String clicktext) {
		WebElement tablealue = driver
				.findElement(By.xpath(tableName + "//tr//td[" + columnNo + "]/a[text()='" + clicktext + "']"));
		String elementName = tablealue.getAccessibleName();
		tablealue.click();
		extTest.log(Status.INFO, clicktext + " ElementName Click");
	}

//-----------------------------------Actions:-----------------------------------------------		

//myMouseToElement:
	public void mousemoverToElement(WebElement weObj) {
		Actions mouseover = new Actions(driver);

		String elementName = weObj.getAccessibleName();
		// mouseover:
		try {
			mouseover.moveToElement(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouseover successfully.");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}",
					weObj);
			extTest.log(Status.INFO, elementName + " mouseover successfully.");

		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			mouseover.moveToElement(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouseover successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " mouseover not successfully.");
		}
	}

//mouseClick:
	public void mouseSendKeys(WebElement weObj) {
		Actions mouseClick = new Actions(driver);

		String elementName = weObj.getAccessibleName();
		// mouseClick:
		try {
			mouseClick.sendKeys(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouse Click successfully.");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("argument[0].value(" + weObj + ")", weObj);
			extTest.log(Status.INFO, elementName + " mouse Click successfully.");

		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			mouseClick.sendKeys(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouse Click successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " mouse click can't successfully.");
		}
	}

//mouseClick:
	public void mouseClick(WebElement weObj) {
		Actions mouseClick = new Actions(driver);

		String elementName = weObj.getAccessibleName();
		// mouseClick:
		try {
			mouseClick.click(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouse Click successfully.");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("argument[0].click()", weObj);
			extTest.log(Status.INFO, elementName + " mouse Click successfully.");

		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			mouseClick.click(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouse Click successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " mouse click can't successfully.");
		}
	}

//RightClick:
	public void mouseRightClick(WebElement weObj) {
		Actions mouseRClick = new Actions(driver);

		String elementName = weObj.getAccessibleName();
		// mouseClick:
		try {
			mouseRClick.contextClick(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouse right Click successfully.");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("    ", weObj);
			extTest.log(Status.INFO, elementName + " mouse right click successfully.");

		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			mouseRClick.contextClick(weObj).build().perform();
			extTest.log(Status.INFO, elementName + " mouse right Click successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + " mouse right click can't successfully.");
		}
	}

//mouseDrag and Drop:		
	public void mouseDragAndDrop(WebElement weObj1, WebElement weObj2) {
		Actions mouseDd = new Actions(driver);
		String elementName = weObj1.getAccessibleName();

		// Drag And Drop:
		try {
			mouseDd.dragAndDrop(weObj1, weObj2).build().perform();
			extTest.log(Status.INFO, elementName + " mouse Drag And Drop successfully.");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("var dropTarget = jQuery( " + weObj1 + "); jQuery( " + weObj2
					+ " ).simulate('drag', { dropTarget: dropTarget });");
			extTest.log(Status.INFO, elementName + " mouse Drag And Drop successfully.");

		} catch (StaleElementReferenceException e) {
			elementName = weObj1.getAccessibleName();
			mouseDd.dragAndDrop(weObj1, weObj2).build().perform();
			extTest.log(Status.INFO, elementName + " mouse Drag And Drop successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, elementName + "  Drag and Drop  can't successfully.");
		}
	}

//--------------------------------------Select----------------------------------------		
// getSelectedText:   Auto first option 

	public String getFirstSelectedText(WebElement weObj) {

		String elementName = weObj.getAccessibleName();
		Select selObj = new Select(weObj);
		WebElement weselectIntem;
		String acutalText = null;
		try {
			weselectIntem = selObj.getFirstSelectedOption();
			acutalText = weselectIntem.getText();
			extTest.log(Status.INFO, elementName + acutalText + " First Select Option ");
		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			weselectIntem = selObj.getFirstSelectedOption();
			acutalText = weselectIntem.getText();
			extTest.log(Status.INFO, elementName + acutalText + " Auto First Select Option ");
		} catch (Exception e) {
			extTest.log(Status.FAIL, elementName + acutalText + " can't First Select Option ");
			throw e;
		}
		return acutalText;
	}

//getoptionCount:
	public int getoptionCount(WebElement weObj) {

		String elementName = weObj.getAccessibleName();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(weObj));

		Select OptionCount = new Select(weObj);
		int itemcount = 0;
		try {
			List<WebElement> number = OptionCount.getOptions();
			itemcount = number.size();
			extTest.log(Status.INFO, elementName + " " + itemcount + " total Options");

		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			OptionCount = new Select(weObj);
			List<WebElement> number = OptionCount.getOptions();
			itemcount = number.size();
			extTest.log(Status.INFO, elementName + " " + itemcount + " total Options");

		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed can't find select Options");
		}
		return itemcount;
	}

//getTextListofAllOptions:
	public List<String> getTextListofAllOptions(WebElement weObj) {
		String elementName = weObj.getAccessibleName();

		Select OptionCount = new Select(weObj);
		List<String> listOptionText = new ArrayList<String>();
		List<WebElement> text = null;
		WebElement weText = null;
		String OptionsText = null;
		try {
			text = OptionCount.getOptions();
			for (int i = 0; i <= text.size() - 1; i++) {
				weText = text.get(i);
				OptionsText = weText.getText();
				listOptionText.add(OptionsText);
			}
		} catch (StaleElementReferenceException e) {
			text = OptionCount.getOptions();
			for (int i = 0; i <= text.size() - 1; i++) {
				weText = text.get(i);
				OptionsText = weText.getText();
				listOptionText.add(OptionsText);
			}
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed can't find select text Options");
		}
		return listOptionText;
	}

//MultipleSelectOrNot:		
	public void slectDDCheckMultipleorNot(WebElement weObj) {
		String elementName = weObj.getAccessibleName();
		Select sb = new Select(weObj);
		try {
			boolean result = sb.isMultiple();
			if (result == true) {
				extTest.log(Status.PASS, "Yes :This is multiple select Allow ");
			} else {
				extTest.log(Status.FAIL, "No :This is Single select Allow ");
			}
		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			boolean result = sb.isMultiple();
			if (result == true) {
				extTest.log(Status.PASS, "Yes :This is multiple select Allow ");
			} else {
				extTest.log(Status.FAIL, "No :This is Single select Allow ");
			}
		}
	}

//selectvisibletext:
	public void selectByVisibleText(WebElement weObj, String selectText) {
		String elementName = weObj.getAccessibleName();

		Select sb = new Select(weObj);
		try {
			sb.selectByVisibleText(selectText);
			extTest.log(Status.INFO, selectText + " innerText option select successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click()", weObj);
			WebElement weOption = driver.findElement(By.xpath("//option[text()='" + selectText + "']"));
			js.executeScript("argument[0].click()", weOption);
		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			sb = new Select(weObj);
			sb.selectByVisibleText(selectText);
			extTest.log(Status.INFO, selectText + " innerText option select successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed: " + selectText + " innerText option  not select successfully");
			throw e;
		}
	}

//selectvisibletextContains:
	public void selectByVisibleTextConatins(WebElement weObj, String selectText) {
		String elementName = weObj.getAccessibleName();

		Select sb = new Select(weObj);
		List<WebElement> options = sb.getOptions();
		int indexnumber = -1;
		try {
			for (int i = 0; i <= options.size() - 1; i++) {
				WebElement weoptions = options.get(i);
				String optiontext = weoptions.getText();
				boolean status = optiontext.contains(selectText);
				if (status == true) {
					indexnumber = i;
					break;
				}
			}
			sb.selectByIndex(indexnumber);
			extTest.log(Status.INFO, selectText + " innerText option select successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click()", weObj);

			WebElement weOption = driver.findElement(By.xpath("//option[text()='" + selectText + "']"));
			js.executeScript("argument[0].click()", weOption);
		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			for (int i = 0; i <= options.size() - 1; i++) {
				WebElement weoptions = options.get(i);
				String optiontext = weoptions.getText();
				boolean status = optiontext.equalsIgnoreCase(selectText);
				if (status == true) {
					indexnumber = i;
					break;
				}
			}
			sb.selectByIndex(indexnumber);
			extTest.log(Status.INFO, selectText + " innerText option select successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed: " + selectText + " innerText option  not select successfully");
			throw e;
		}
	}

//selectValue:

	public void myselectByValue(WebElement weObj, String selectTextvalue) {
		String elementName = weObj.getAccessibleName();
		Select sb = new Select(weObj);
		try {
			sb.selectByValue(selectTextvalue);
			extTest.log(Status.INFO, selectTextvalue + " attribute_value option select successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click()", weObj);

			WebElement weOption = driver.findElement(By.xpath("//option[text()='" + selectTextvalue + "']"));
			js.executeScript("argument[0].click()", weOption);
		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			sb = new Select(weObj);
			sb.selectByValue(selectTextvalue);
			extTest.log(Status.INFO, selectTextvalue + " attribute_value option select successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed: " + selectTextvalue + " attribute_value option  not select successfully");
			throw e;
		}
	}

//selectByValueConatins:

	public void myselectByValueConatins(WebElement weObj, String selectTextvalue) {
		String elementName = weObj.getAccessibleName();

		Select sb = new Select(weObj);
		List<WebElement> options = sb.getOptions();
		int indexnumber = -1;
		try {
			for (int i = 0; i <= options.size() - 1; i++) {
				WebElement weoptions = options.get(i);
				String optiontext = weoptions.getAttribute("value");
				boolean status = optiontext.contains(selectTextvalue);
				if (status == true) {
					indexnumber = i;
					break;
				}
			}
			sb.selectByIndex(indexnumber);
			extTest.log(Status.INFO, selectTextvalue + " attribute_value option select successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0].click()", weObj);

			WebElement weOption = driver.findElement(By.xpath("//option[text()='" + selectTextvalue + "']"));
			js.executeScript("argument[0].click()", weOption);
			System.out.println(selectTextvalue + " attribute_value option select successfully");

		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			for (int i = 0; i <= options.size() - 1; i++) {
				WebElement weoptions = options.get(i);
				String optiontext = weoptions.getAttribute("value");
				boolean status = optiontext.equalsIgnoreCase(selectTextvalue);
				if (status == true) {
					indexnumber = i;
					break;
				}
			}
			sb.selectByIndex(indexnumber);
			extTest.log(Status.INFO, selectTextvalue + " attribute_value option select successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed: " + selectTextvalue + " attribute_value option  not select successfully");
			throw e;
		}
	}

//selectIndex:
	// starting 0 number:
	public void selectByIndex(WebElement weObj, int selectvalueindex) {
		String elementName = weObj.getAccessibleName();

		Select sb = new Select(weObj);
		try {
			sb.selectByIndex(selectvalueindex);
			extTest.log(Status.INFO, selectvalueindex + " option selected successfully");
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("argument[0]", weObj);

			WebElement weOption = driver.findElement(By.xpath("//option[text()='" + selectvalueindex + "']"));
			js.executeScript("argument[0].click()", weOption);
		} catch (StaleElementReferenceException e) {
			elementName = weObj.getAccessibleName();
			sb = new Select(weObj);
			sb.selectByIndex(selectvalueindex);
			extTest.log(Status.INFO, selectvalueindex + " option selected successfully");
		} catch (Exception e) {
			extTest.log(Status.FAIL, "Failed: " + selectvalueindex + " option  not selected successfully");
			throw e;
		}
	}

//--------------------------------Switch_window----------------------------------					
// switchTowindowByTitle:
	public String getSwitchTowindowByTitle(String expectedTitle) {

		Set<String> windows = driver.getWindowHandles();
		String windowTitle = null;
		try {
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowTitle = driver.getTitle();
				if (windowTitle.equalsIgnoreCase(expectedTitle)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowTitle match & Your window driver has change.");
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			windows = driver.getWindowHandles();
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowTitle = driver.getTitle();

				if (windowTitle.equalsIgnoreCase(expectedTitle)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowTitle match & Your window driver has change.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"failed: Acutal and expected windowTitle can't be changed & your window driver has not been changed.");
		}
		return windowTitle;

	}

// switchTowindowByTitleConatins:
	public String getSwitchTowindowByTitleContains(String expectedTitle) {

		Set<String> windows = driver.getWindowHandles();
		String windowTitle = null;
		try {
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowTitle = driver.getTitle();
				if (windowTitle.contains(expectedTitle)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowTitle match & Your window driver has change.");
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			windows = driver.getWindowHandles();
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowTitle = driver.getTitle();
				if (windowTitle.contains(expectedTitle)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowTitle match & Your window driver has change.");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"failed: Acutal and expected windowTitle can't be changed & your window driver has not been changed.");
		}
		return windowTitle;

	}

//switchTowindowByUrl:
	public String getswitchTowindowByUrl(String expectedUrl) {

		Set<String> windows = driver.getWindowHandles();
		String windowUrl = null;
		try {
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowUrl = driver.getCurrentUrl();
				if (windowUrl.equalsIgnoreCase(expectedUrl)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowUrl match & Your window driver has change.");
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			windows = driver.getWindowHandles();
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowUrl = driver.getTitle();
				if (windowUrl.equalsIgnoreCase(expectedUrl)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowUrl match & Your window driver has change.");
					break;
				}
			}
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"failed: Acutal and expected windowUrl can't be changed & your window driver has not been changed.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"failed: Acutal and expected windowUrl can't be changed & your window driver has not been changed.");
		}
		return windowUrl;

	}

//switchTowindowByUrlContains:
	public String getswitchTowindowByUrlContains(String expectedUrl) {

		Set<String> windows = driver.getWindowHandles();
		String windowUrl = null;
		try {
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowUrl = driver.getCurrentUrl();
				if (windowUrl.contains(expectedUrl)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowUrl match & Your window driver has change.");
					break;
				}
			}
		} catch (StaleElementReferenceException e) {
			windows = driver.getWindowHandles();
			for (String handle : windows) {
				driver.switchTo().window(handle);
				windowUrl = driver.getTitle();
				if (windowUrl.contains(expectedUrl)) {
					extTest.log(Status.INFO,
							"Passed: Acutal and expected windowUrl match & Your window driver has change.");
					break;
				}
			}
		} catch (NoSuchWindowException e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"failed: Acutal and expected windowUrl can't be changed & your window driver has not been changed.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL,
					"failed: Acutal and expected windowUrl can't be changed & your window driver has not been changed.");
		}
		return windowUrl;

	}

//--------------------------------Frame----------------------------------		
//switchToFrameindex:
	public void switchToframeindex(int no) {

		try {
			driver.switchTo().frame(no);
			extTest.log(Status.INFO, "Pass: Inside the frame.");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().frame(no);
			extTest.log(Status.INFO, "Pass: Inside the frame.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed: can't been inside the frame.");
		}
	}

//switchToFrameName&Id:
	public void switchToframeNameId(String Nameid) {

		try {
			driver.switchTo().frame(Nameid);
			extTest.log(Status.INFO, "Pass: Inside the frame.");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().frame(Nameid);
			extTest.log(Status.INFO, "Pass: Inside the frame.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed: can't been inside the frame.");
		}
	}

//switchToFrameelementName:
	public void switchToframeByWebElement(WebElement weObj, String elementName) {

		try {
			driver.switchTo().frame(weObj);
			extTest.log(Status.INFO, "Pass: Inside the frame.");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().frame(weObj);
			extTest.log(Status.INFO, "Pass: Inside the frame.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed: can't been inside the frame.");
		}
	}

//switchToFrameExit&Class:
	public void switchToFramedefaultContent() {

		try {
			driver.switchTo().defaultContent();
			extTest.log(Status.INFO, "Pass: frame  Exit&Close.");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().parentFrame();
			extTest.log(Status.INFO, "Pass: frame  Exit&Close.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Failed: frame has not been Exit&Class.");
		}
	}

//switchToFrameExitChilde:
	public void switchToFrameParentFrame() {

		try {
			driver.switchTo().parentFrame();
			extTest.log(Status.INFO, "pass: childeframe Exit&Close.");
		} catch (StaleElementReferenceException e) {
			driver.switchTo().defaultContent();
			extTest.log(Status.INFO, "pass: childeframe Exit&Close.");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "failed: childeframe  can't been Exit&Close.");
		}
	}

//--------------------------------Alert----------------------------------		
//Alert Accepted:
	public void AlertAccepted() {
		try {
			driver.switchTo().alert().accept();
			extTest.log(Status.INFO, "Alert Accepted Successflly");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Alert not Accepted");
		}
	}

//Alert Dismiis:
	public void AlertDismiss() {
		try {
			driver.switchTo().alert().dismiss();
			extTest.log(Status.INFO, "Alert Dismiss Successflly");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Alert not Dismiss");
		}
	}

//Alert gettext:
	public String AlertGetText() {
		String text = null;
		try {
			text = driver.switchTo().alert().getText();
			extTest.log(Status.INFO, "Alert text find Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Alert text can't find successfully ");
		}
		return text;
	}

//getAllertText		
	public void AlerSendText(String sendtext) {
		try {
			driver.switchTo().alert().sendKeys(sendtext);
			extTest.log(Status.INFO, "Alert SendText  Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			extTest.log(Status.FAIL, "Alert SendText can't successfully ");
		}
	}

//----------------------myverifyString---------myverifynumber---------------------------------------------------------------	

	// myverifyString:
	public void VerifyNumber(String acutalNumber, String expectedNumber) {
		if (acutalNumber == expectedNumber) {
			extTest.log(Status.PASS, "Passed.Actual-- " + acutalNumber + " && Expected- " + expectedNumber);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + acutalNumber + " && Expected- " + expectedNumber);
		}
		Assert.assertEquals(acutalNumber, expectedNumber);
	}

	// myverifynumber:
	public void VerifyNumber(int acutalNumber, int expectedNumber) {
		if (acutalNumber == expectedNumber) {
			extTest.log(Status.PASS, "Passed.Actual-- " + acutalNumber + " && Expected- " + expectedNumber);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + acutalNumber + " && Expected- " + expectedNumber);
		}
		SoftAssert sa = new SoftAssert(); // Soft Assert
		sa.assertEquals(acutalNumber, expectedNumber);
		sa.assertAll(); // Handle,move next line && Show ERROR.
	}

	//verifyinnerText:
	public void VerifyInnerText(WebElement we, String expectedText) {
		String acutalText = we.getText();
		if (acutalText.equalsIgnoreCase(expectedText)) {
			extTest.log(Status.PASS, "Passed.Actual-- " + acutalText + " && Expected- " + expectedText);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + acutalText + "&& Expected- " + expectedText);
		}
		Assert.assertEquals(acutalText, expectedText); // Hard Assert:
	}

	// verifyTitle:
	public void verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			extTest.log(Status.PASS, "Passed.Actual-- " + actualTitle + " && Expected- " + expectedTitle);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + actualTitle + " && Expected- " + expectedTitle);
		}
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	// verifyURL:
	public void verifyUrl(String expectedUrl) {
		String actualUrl = driver.getCurrentUrl();
		if (actualUrl.equalsIgnoreCase(expectedUrl)) {
			extTest.log(Status.PASS, "Passed.Actual-- " + actualUrl + " && Expected- " + expectedUrl);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + actualUrl + " && Expected- " + expectedUrl);
		}
		Assert.assertEquals(actualUrl, expectedUrl);
	}

	// verifyEnabled:
	public void verifyisEnabled(WebElement we, boolean expectedisEnabled) {
		boolean actualisEnabled = we.isEnabled();
		if (actualisEnabled == expectedisEnabled) {
			extTest.log(Status.PASS, "Passed.Actual-- " + actualisEnabled + " && Expected- " + expectedisEnabled);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + actualisEnabled + " && Expected- " + expectedisEnabled);
		}
		Assert.assertEquals(actualisEnabled, expectedisEnabled);
	}

	// verifyDisplayed:
	public void verifyisDisplayed(WebElement we, boolean expectedisDisplayed) {
		boolean actualisDisplayed = we.isDisplayed();
		if (actualisDisplayed == expectedisDisplayed) {
			extTest.log(Status.PASS, "Passed.Actual-- " + actualisDisplayed + " && Expected- " + expectedisDisplayed);
		} else {
			extTest.log(Status.FAIL, "Failed.Actual-- " + actualisDisplayed + " && Expected- " + expectedisDisplayed);
		}
		Assert.assertEquals(actualisDisplayed, expectedisDisplayed);
	}

//----------------------- takeScreenShort ------------------------------------------
////takeScreenShort:		
	public String takeScreenShort(String testCaseName, String dataFormat) {
		// find-date formation == dd_MM_yyyy hh:mm:ss a
		DateFormat df = new SimpleDateFormat(dataFormat);
		String dateTime = df.format(new Date());

		TakesScreenshot tss = (TakesScreenshot) driver;
		File snapShortsourceFileobj = tss.getScreenshotAs(OutputType.FILE);
		File snapShortDestinationFileobj = new File("test-output\\" + testCaseName + dateTime + ".png");
		try {
			Files.copy(snapShortsourceFileobj, snapShortDestinationFileobj);
		} catch (IOException e) {
			e.printStackTrace();
		}
//							TimeZone.setDefault(SimpleTimeZone.UTC_TIME);
		return snapShortDestinationFileobj.getAbsolutePath();
	}

//--------------------------------------Exceldata-Read---------------------------------------

	public void excelDataReadXLSXFile(String fillPath) throws IOException {

		InputStream excelFillPath = new FileInputStream(System.getProperty("user.dir") + fillPath);
		Workbook workBook = new XSSFWorkbook(excelFillPath);
		Sheet sheetObj = workBook.getSheet("sheet1");
		for (int i = 0; i <= sheetObj.getLastRowNum(); i++) {
			Row rowObj = sheetObj.getRow(i);
			for (int j = 0; j <= rowObj.getLastCellNum() - 1; j++) {
				Cell cellObj = rowObj.getCell(j, MissingCellPolicy.RETURN_BLANK_AS_NULL);
				String stringcellValue = null;
				if (cellObj.getCellType().STRING == CellType.STRING) {
					stringcellValue = cellObj.getStringCellValue();
				} else {
					Double doubleData = cellObj.getNumericCellValue();
					Integer intData = doubleData.intValue();
					stringcellValue = intData.toString();
				}
				System.out.print(stringcellValue + ",");
			}
			System.out.println();
		}
	}

	public void excelDataReadXLSFile(String fillPath) throws IOException {

		InputStream excelFillPath = new FileInputStream(System.getProperty("user.dir") + fillPath);
		Workbook workBook = new HSSFWorkbook(excelFillPath);
		Sheet sheetObj = workBook.getSheet("sheet1");
		for (int i = 0; i <= sheetObj.getLastRowNum(); i++) {
			Row rowObj = sheetObj.getRow(i);
			for (int j = 0; j <= rowObj.getLastCellNum() - 1; j++) {
				Cell cellObj = rowObj.getCell(j, MissingCellPolicy.RETURN_BLANK_AS_NULL);
				String stringcellValue = null;
				if (cellObj.getCellType().STRING == CellType.STRING) {
					stringcellValue = cellObj.getStringCellValue();
				} else {
					Double doubleData = cellObj.getNumericCellValue();
					Integer intData = doubleData.intValue();
					stringcellValue = intData.toString();
				}
				System.out.print(stringcellValue + ",");
			}
			System.out.println();
		}
	}
//	public void cvsDataRead(String fillPath) throws IOException {
//					
//			InputStream	excelFillPath=new FileInputStream(System.getProperty("user.dir")+fillPath);
//				Workbook workBook=new XSSFWorkbook(excelFillPath);
//					Sheet	sheetObj=workBook.getSheet("sheet1");
//						for(int i=0;i<=sheetObj.getLastRowNum();i++) {
//								Row rowObj=sheetObj.getRow(i);
//							for(int j=0;j<=rowObj.getLastCellNum()-1;j++) {
//								Cell cellObj=rowObj.getCell(j,MissingCellPolicy.RETURN_BLANK_AS_NULL);
//									String stringcellValue=null;
//								if(cellObj.getCellType().STRING==CellType.STRING) {
//									stringcellValue=cellObj.getStringCellValue();
//								  }else {
//									Double	doubleData=cellObj.getNumericCellValue();
//									Integer	intData=doubleData.intValue();
//									stringcellValue	=intData.toString();
//								  }
//								System.out.print(stringcellValue+",");
//							}
//						System.out.println();
//					}	
//		}

//-------------------------------------.properties_files-----------------------------------------

	public void loadProperties(String propertiesFile) {
		InputStream file = null;
		try {
			file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\" + propertiesFile + ".properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPropertyData(String keyName) {
		String data = prop.getProperty(keyName);
		return data;
	}

}
