package com.mondh.vtiger.CommonBasic;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.mondh.vtiger.OR_CommonBasic.CommonOR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class CommonReusableCode extends CommonOR {
	// Applications dependent methods
	// it uses generic methods to automate reusable functionality
//THE EXTEND COMMONCLASS  IN EACH PAGE CLASS.

	private WebUtil gm;

	public CommonReusableCode(WebUtil wD) {
		super(wD);	
		this.gm = wD;
	}

//vtiger Login_Page:	
	public void velidLogin(String username,String password) {
		gm.inputData(getUserNameTB(), username);
		gm.inputData(getPasswordTB(), password);
		gm.clickButton(getLoginBT());
	}

//properties base use:	
//	public void velidLogin() {
//		String	userN=gm.getPropertyData("userName");
//		gm.inputData(getUserNameTB(), userN);
//		String passwordN=gm.getPropertyData("passwordName");
//		gm.inputData(getPasswordTB(), passwordN);
//		gm.clickButton(getLoginBT());
//	}

	
	public void inVelidLogin() {
		gm.inputData(getUserNameTB(), "admin");
		gm.inputData(getPasswordTB(), "admin");
		gm.clickButton(getLoginBT());
	}

//pulseCreateButton:	
	public void createButton() {
		gm.clickButton(getCreateBT());

	}

//SalesModule:	
	public void goToSalesLeadsSubmodule() {
		gm.mousemoverToElement(getSalesMouseOver());
		gm.clickButton(getGoSalesLeadsSubmodule());
	}

	public void goToSalesAcountSubmodule() {
		gm.mousemoverToElement(getSalesMouseOver());
		gm.clickButton(getGoSalesAccountSubmodule());
	}

	public void goToSalesContactsSubmodule() {
		gm.mousemoverToElement(getSalesMouseOver());
		gm.clickButton(getGoSalesContactsSubmodule());
	}

//Marketing_Modules:
	public void goToMarketingCompaignsSubmodule() {
		gm.mousemoverToElement(getMarketingMouseOver());
		gm.clickButton(getGoMarketingCompaignsSubmodule());
	}

	public void goToMarketingAccountSubmodule() throws InterruptedException {
		Thread.sleep(3000);
		gm.mousemoverToElement(getMarketingMouseOver());
		gm.clickButton(getGoMarketingAccountSubmodule());
	}

	public void goToMarketingContactsSubmodule() {
		gm.mousemoverToElement(getMarketingMouseOver());
		gm.clickButton(getGomarketingContactsSubmodule());
	}

//Inventory_Modules:	
	public void goToInventoryProductsSubmodule() {
		gm.mousemoverToElement(getInventoryMouseOver());
		gm.clickButton(getGoInventoryProductsSubmodule());
	}

	public void goToInventoryInvoiceSubmodule() {
		gm.mousemoverToElement(getInventoryMouseOver());
		gm.clickButton(getGoInventoryInvoiceSubmodule());
	}

// SearchTextBox:
	public void searchTextBox(String searchtext) {
		gm.inputData(getSearchTB(), searchtext);
	}

// searchNowButton:
	public void searchNowButton() {
		gm.clickButton(getSearchNowBT());
	}

// selectoptionvisibaleText
	public void selectOptionsVisibleText(String OptionText) {
		gm.selectByVisibleText(getSelectvisibleText(), OptionText);
	}

//clicksaveButton:
	public void topSaveButton() {
		gm.clickButton(getSavceTopBT());
	}

//clickCancelButton:
	public void topCancelButton() {
		gm.clickButton(getCancleTopBT());
	}

//driverSignOuts:	
	public void userSignOut() {
		gm.clickButton(getSighOut());
	}

//checkDataStore:
	public void checkDataStoreorNot(String columnbas,Map<String,String> testCaseDataMap) {
		List<String> tableData = gm.getColumnDataListByColumnName("//table[@class='lvt small']", columnbas);
		String acutalString=null;
		for (int i = 0; i <= tableData.size() - 1; i++) {
				acutalString = tableData.get(i);
			 if(acutalString.equalsIgnoreCase(testCaseDataMap.get("Account Name"))) {
				 gm.getExtTest().log(Status.INFO,"PASS:the Acutal "+acutalString+" && Expected "+testCaseDataMap.get("Account Name"));
					break;
				}
		}
		Assert.assertEquals(acutalString, testCaseDataMap.get("Account Name"));
	}

//update_match:
	public void checkUpdateData(String columnbas,Map<String,String> testCaseDataMap) {
		List<String> tablecolumnList = gm.getColumnDataListByColumnName("//table[@class='lvt small']", columnbas);
		String we=null;
		for (int i = 0; i <= tablecolumnList.size() - 1; i++) {
			 we = tablecolumnList.get(i);
			if (we.equalsIgnoreCase(testCaseDataMap.get("New Account Name"))) {
				gm.getExtTest().log(Status.INFO,"Old your Data: " + testCaseDataMap.get("Old Account Name"));
				gm.getExtTest().log(Status.INFO,"New Upadte Data: " + testCaseDataMap.get("New Account Name"));
				break;
			}
		}
		Assert.assertEquals(we, testCaseDataMap.get("New Account Name"));
	}
	
//SearchOptionbase_findItemcheck:
	public void checkSearchOptionBaseData(String optionbaseSearch,String expectedString) {
		List<String> tablecolumnList =gm. getColumnDataListByColumnName("//table[@class='lvt small']", optionbaseSearch);
		String acutalString=null;
		for (int i = 0; i <= tablecolumnList.size() - 1; i++) {
			 acutalString = tablecolumnList.get(i);
			if (acutalString.equalsIgnoreCase(expectedString)) {
				gm.getExtTest().log(Status.INFO,"PASS:the Acutal "+acutalString+" && Expected "+expectedString);
				break;
			}
		}
		Assert.assertEquals(acutalString, expectedString);	
	}

//Delete_Data:
	public void checkDeleteDataOrNot(String columnName,String expectedString) {
		List<String> lastNameList = gm.getColumnDataListByColumnName("//table[@class='lvt small']", columnName);
		String acutalString=null;
		int num=0;
		for (int i = 0; i <= lastNameList.size() - 1; i++) {
			 acutalString = lastNameList.get(i);
			 if (acutalString.equalsIgnoreCase(expectedString)) {
				num=1;	
				 break;
				}
			}
		if(num==0) {
			gm.getExtTest().log(Status.INFO,"PASS:the Acutal Data not Store && Expected "+expectedString);						
		}else {
			gm.getExtTest().log(Status.FAIL,"Fail: the Acutal Data Store && Expected "+expectedString);
		}
		//Assert.assertEquals(acutalString, expectedString);	
	
//		SoftAssert sA=new SoftAssert();
//		sA.assertEquals(acutalString, expectedString);	
//		sA.assertAll();
		
//		System.out.println("hii");

	}
	
}
