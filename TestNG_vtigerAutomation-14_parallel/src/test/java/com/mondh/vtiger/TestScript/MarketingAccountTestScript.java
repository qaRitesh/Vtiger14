package com.mondh.vtiger.TestScript;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountCreateAccountPage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountInformationPage;
import com.mondh.vtiger.genericyCodes.DataUtile;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class MarketingAccountTestScript extends BaseTest {

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;
	DataUtile data=new DataUtile();

	
	@DataProvider()
	public Object[][] getData() {
		
		List<Map<String,String>>testCaseDataMapList=data.getAllTestCaseData("VT001",1);
		int matchingTcIDCount=testCaseDataMapList.size();
		
		Object[][] dim2Arr=new Object[matchingTcIDCount][1];
		
		for(int i=0;i<=matchingTcIDCount-1;i++) {
			dim2Arr[i][0] =testCaseDataMapList.get(i);
	}
	return dim2Arr;
	}
	
	
	
//Create_Account:	
	@Test(priority =1 , groups = { "Smoke"},dataProvider = "getData")
	public void verifyVT001CreateAccounts(Map<String,String>testCaseDataMap) throws Exception {
		gm.getExtTest().log(Status.INFO,"verifyVT001CreateAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		comm.createButton();
		// marketingCreatePage:
		MarketingAccountCreateAccountPage marketingCreatePage = new MarketingAccountCreateAccountPage(gm);
	//		Map<String,String>testCaseDataMap=(Map<String,String>) data;
			
			marketingCreatePage.fillAccountInformationDeatils(testCaseDataMap);
			comm.topSaveButton();
			// AccountInformationPage:
			MarketingAccountInformationPage marketinginformations = new MarketingAccountInformationPage(gm);
			marketinginformations.goToMarketingAccountSubmodule();
			comm.checkDataStoreorNot("Account Name", testCaseDataMap);
		gm.getExtTest().log(Status.INFO,"verifyVT001CreateAccounts TestCase Completed");

	}

//updata_data:	
	@Test(priority = 2, groups = { "Smoke"})
	public void verifyVT002UpdateAccounts() throws Exception {
		gm.getExtTest().log(Status.INFO,"verifyVT002UpdateAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		String	oldDataClickItem=data.getRowDataByTestcase("rajaBhai");
		gm.tableItemClick("//table[@class='lvt small']", 3, oldDataClickItem);
		// updata_data:
		MarketingAccountInformationPage marketinginformations = new MarketingAccountInformationPage(gm);
		marketinginformations.clickTopUpdateBT();
		MarketingAccountCreateAccountPage marketingAccounPage = new MarketingAccountCreateAccountPage(gm);
		Map<String,String>testCaseDataMap=data.getTestCaseData("VT002", 2);
		marketingAccounPage.updateAccountName(testCaseDataMap);
		comm.topSaveButton();
		// check_Update:
		marketinginformations.goToMarketingAccountSubmodule();
		comm.checkUpdateData("Account Name", testCaseDataMap);
		gm.getExtTest().log(Status.INFO,"verifyVT002UpdateAccounts TestCase Completed");
		
	}

//Search_Data:	
	@Test(priority = 3, groups = {"Smoke"})
	public void verifyVT003SearchAccounts() throws Exception {
		gm.getExtTest().log(Status.INFO,"verifyVT003SearchAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
//MarketingAccount_LeandingPage:	
		comm.goToMarketingAccountSubmodule();
		String	searchItem=data.getRowDataByTestcase("Bhairaja");
		comm.searchTextBox(searchItem);
		String	searchBaseeOption=data.getRowDataByTestcase("Account Name");
		comm.selectOptionsVisibleText(searchBaseeOption);
		comm.searchNowButton();
		comm.checkSearchOptionBaseData(searchBaseeOption, searchItem);

		gm.getExtTest().log(Status.INFO,"verifyVT003SearchAccounts TestCase Completed");

	}

//Delete_Data:
	@Test(priority = 4,groups = {"Smoke"})
	public void verifyVT004DeleteAccount() throws InterruptedException {
		gm.getExtTest().log(Status.INFO,"verifyVT004DeleteAccounts TestCase Started");
		comm = new CommonReusableCode(gm);
		// MarketingAccount_LeandingPage:
		comm.goToMarketingAccountSubmodule();
		String deleteItem=data.getRowDataByTestcase("Bhairaja");
		gm.tableItemClick("//table[@class='lvt small']", 3, deleteItem);
		Thread.sleep(5000);
		MarketingAccountInformationPage marketinginfro = new MarketingAccountInformationPage(gm);
		marketinginfro.clickTopDeleteBT();
		gm.AlertAccepted();
		
		comm.checkDeleteDataOrNot("Account Name", deleteItem);
		gm.getExtTest().log(Status.INFO,"verifyVT004DeleteAccounts TestCase Completed");
		
	}

}
