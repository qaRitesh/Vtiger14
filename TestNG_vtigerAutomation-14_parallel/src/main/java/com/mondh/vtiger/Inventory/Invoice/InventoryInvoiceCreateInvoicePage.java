package com.mondh.vtiger.Inventory.Invoice;


import com.mondh.vtiger.OR_Inventory.Invoice.InventoryInvoiceCreateInvoicePage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryInvoiceCreateInvoicePage extends InventoryInvoiceCreateInvoicePage_OR {
	private WebUtil gm;
	
	 public InventoryInvoiceCreateInvoicePage(WebUtil wD) {
		super(wD);
		this.gm=wD;
		
	}

		private String inventoryInvoiceCreatePage="admin - Inventory - Invoice - vtiger CRM 5 - Commercial Open Source CRM";

	 
	public void invoiceInformation() throws InterruptedException{
		
		
		gm.inputData(getSubjectTB(),"MCA");
		gm.inputData(getCustomerNo(), "9478523695");
		
    	gm.clickButton(getCustomerNameBT());
    	InventoryInvoiceSelectContactsNamePage contactNameAdd=new InventoryInvoiceSelectContactsNamePage(gm);
    	contactNameAdd.contactSearchAndAdd();
    	Thread.sleep(5000);
    	gm.getSwitchTowindowByTitle(inventoryInvoiceCreatePage);
    	gm.clickButton(getAccountNameBT());   	
    	InventoryInvoiceSelectAccountNamePage accountNameAdd=new InventoryInvoiceSelectAccountNamePage(gm);
    	accountNameAdd.accountSearchAndAdd();	
    	gm.getSwitchTowindowByTitle(inventoryInvoiceCreatePage);

	}	
    	
   public void addresssInfirmation() {
	 
   		gm.inputData(getBillAddressTB(),"Uttar pradesh");
    	gm.inputData(getShippingAddressTB(), "Bhadohi");

   }
   
   
   public void itemDetails() {
	
	   gm.clickButton(getProductsBT());
	   InventoryInvoiceProductsPage inventoryinvoiceproducts=new InventoryInvoiceProductsPage(gm);
	   inventoryinvoiceproducts.searchAndSelectProducts();
	   
	   gm.getSwitchTowindowByTitle(inventoryInvoiceCreatePage);
	   gm.inputData(getQtyTB(), "500");
		
   }
   
   
   
	}
	

