package com.mondh.vtiger.Marketing.Accounts;

import java.util.Map;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Marketing.Accounts.MarketingAccountCreateAccountPage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingAccountCreateAccountPage extends MarketingAccountCreateAccountPage_OR{

	private WebUtil gm;
	
	public MarketingAccountCreateAccountPage(WebUtil wD) {
		super(wD);
		this.gm=wD;
	}

	
	public void fillAccountInformationDeatils(Map<String,String> testCaseDataMap) throws InterruptedException{
		String randomName=RandomString.make(5);
		
		gm.inputData(getAccountNameTB(),testCaseDataMap.get("Account Name"));
		gm.inputData(getWebsiteTB(),testCaseDataMap.get("WebSite"));
		gm.inputData(getTickersymbolTB(),testCaseDataMap.get("TicketSymbol"));
		gm.inputData(getFaxTB(),testCaseDataMap.get( "Fax"));
		gm.inputData(getEmail(),testCaseDataMap.get("Email"));
		gm.inputData(getPhoneTB(),testCaseDataMap.get("Phone"));
		Thread.sleep(3000);
	}
	
	public void enterAddressInformation() {
		
	}
	
	public void enterDescriptionnformation() {
		
	}
	
	public void updateAccountName(Map<String,String> testCaseDataMap) {
		gm.inputData(getAccountNameTB(),testCaseDataMap.get("New Account Name"));
	}
	
	
}
