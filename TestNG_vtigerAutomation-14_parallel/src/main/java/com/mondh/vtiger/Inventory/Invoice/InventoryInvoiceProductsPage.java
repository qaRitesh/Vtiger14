package com.mondh.vtiger.Inventory.Invoice;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Inventory.Invoice.InventoryInvoiceProductsPage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryInvoiceProductsPage extends InventoryInvoiceProductsPage_OR {

	private WebUtil wt;
	public InventoryInvoiceProductsPage(WebUtil wt) {
		super(wt);
		this.wt=wt;
	}

	CommonReusableCode comm;
	
	private String moveProductsWindow="http://localhost:8888/index.php?module=Products&action=Popup&html=Popup_picker&select=enable&form=HelpDeskEditView&popuptype=inventory_prod&curr_row=1&return_module=Invoice&currencyid=1";
	
	public void searchAndSelectProducts() {
		comm=new CommonReusableCode(wt);
			wt.getswitchTowindowByUrlContains(moveProductsWindow);
			comm.searchTextBox("iPhone");
			comm.selectOptionsVisibleText("Product Name");
			wt.clickButton(getSearchNowBT());
	       wt.clickButton(getClikeiteam());
	       
	}
	
	
	
}
