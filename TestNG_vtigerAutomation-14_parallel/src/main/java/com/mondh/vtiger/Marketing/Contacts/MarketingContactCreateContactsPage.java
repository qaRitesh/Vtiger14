package com.mondh.vtiger.Marketing.Contacts;

import com.mondh.vtiger.AccountName.AccountNamePage;
import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Marketing.Contacts.MarketingContactCreateContactsPage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;


public class MarketingContactCreateContactsPage extends MarketingContactCreateContactsPage_OR{

	private WebUtil gm;
	
	public MarketingContactCreateContactsPage(WebUtil wD) {
		super(wD);
		this.gm=wD;
		
	}

	CommonReusableCode comm;

	private String moveAccountwindow="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form";
	private String movemarketingContacts="admin - Marketing - Contacts - vtiger CRM 5 - Commercial Open Source CRM";
		
	public void fillCreateInformation() throws InterruptedException {
		comm=new CommonReusableCode(gm);
		gm.inputData(getFirstNameTB(),"Munna");
		gm.inputData(getLastNameTB(),"Yadav");
		
		gm.clickButton(getSelectAccountNameTB());
		
		gm.getswitchTowindowByUrlContains(moveAccountwindow);
		AccountNamePage accountSelect=new AccountNamePage(gm);
		accountSelect.accountSelect("rajaBhai", "Account Name");
    	
		gm.getSwitchTowindowByTitle(movemarketingContacts);
	
	}
	
	
}
