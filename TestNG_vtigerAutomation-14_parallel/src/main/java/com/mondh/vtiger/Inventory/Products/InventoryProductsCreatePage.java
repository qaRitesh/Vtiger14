package com.mondh.vtiger.Inventory.Products;


import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Inventory.Products.InventoryProductsCreatePage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryProductsCreatePage extends InventoryProductsCreatePage_OR {

	private WebUtil gm;
	
	public InventoryProductsCreatePage(WebUtil wD) {
		super(wD);
		this.gm=wD;
	}

	public void productInformation() {
		
		
		gm.inputData(getProductNameTB(),"iPhone");
		gm.inputData(getPartNumberTB(),"2547896352");
		CommonReusableCode comm= new CommonReusableCode(gm);
		comm.topSaveButton();
	}
	
	
}
