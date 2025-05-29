package com.mondh.vtiger.TestScript;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.Inventory.Invoice.InventoryInvoiceCreateInvoicePage;
import com.mondh.vtiger.Inventory.Products.InventoryProductsCreatePage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountCreateAccountPage;
import com.mondh.vtiger.Marketing.Accounts.MarketingAccountInformationPage;
import com.mondh.vtiger.Marketing.Contacts.MarketingContactCreateContactsPage;
import com.mondh.vtiger.genericyCodes.DataUtile;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryInvoiceTestScript extends BaseTest{

	private WebUtil gm = WebUtil.getObject();
	private CommonReusableCode comm;
	DataUtile data=new DataUtile();
	
	@Test
	public void verifyVT005CreateInvoice(String accountName,String website,String tickersymbol,String fax,String email,String phone) throws InterruptedException {
	
		System.out.println("verifyVT005CreateInvoice TestCase Started");
		
		comm=new CommonReusableCode(gm);	
//marketing Accounts:		
		comm.goToMarketingAccountSubmodule();
		comm.createButton();		
		MarketingAccountCreateAccountPage marketingCreatePage = new MarketingAccountCreateAccountPage(gm);
		Map<String,String>testCaseDataMap=data.getTestCaseData("VT001", 2);
		marketingCreatePage.fillAccountInformationDeatils(testCaseDataMap);	
		comm.topSaveButton();
		Thread.sleep(5000);
//Marketing Contacts:
		MarketingAccountInformationPage marketininfro=new MarketingAccountInformationPage(gm);
		marketininfro.goToMarketingContactsSubmodule();
		comm.createButton();	
		MarketingContactCreateContactsPage marketingCreateContact=new MarketingContactCreateContactsPage(gm);
		marketingCreateContact.fillCreateInformation();
		comm.topSaveButton();
		Thread.sleep(5000);
		
//inventory products:
		comm.goToInventoryProductsSubmodule();
		comm.createButton();
		InventoryProductsCreatePage inventoryProductsCreate=new InventoryProductsCreatePage(gm);
		inventoryProductsCreate.productInformation();
						
//Inventory Invoice:
		comm.goToInventoryInvoiceSubmodule();
		comm.createButton();	
		InventoryInvoiceCreateInvoicePage inventorycreate= new InventoryInvoiceCreateInvoicePage(gm);
		inventorycreate.invoiceInformation();
		inventorycreate.addresssInfirmation();	
		inventorycreate.itemDetails();	
		comm.topSaveButton();
	
		System.out.println("verifyVT005CreateInvoice TestCase Completed");	
		
	
		}
	
	
	
	
}
