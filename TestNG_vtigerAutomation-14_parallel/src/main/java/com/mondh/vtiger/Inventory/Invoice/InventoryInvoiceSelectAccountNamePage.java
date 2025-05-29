package com.mondh.vtiger.Inventory.Invoice;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_Inventory.Invoice.InventoryInvoiceSelectAccountNamePage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class InventoryInvoiceSelectAccountNamePage extends InventoryInvoiceSelectAccountNamePage_OR {

	private WebUtil gm;

	public InventoryInvoiceSelectAccountNamePage(WebUtil wD) {
		super(wD);
		this.gm = wD;
	}

	private String moverAccountwindow = "http://localhost:8888/index.php?module=Contacts&action=Popup&html=Popup_picker&popuptype=specific&form=EditView";

	CommonReusableCode comm;

	public void accountSearchAndAdd() {

		comm = new CommonReusableCode(gm);
		gm.getswitchTowindowByUrl(moverAccountwindow);
		comm.searchTextBox("rajaBhai");
		comm.selectOptionsVisibleText("Account Name");
		gm.clickButton(getSearchNowBT());
		gm.clickButton(getClikeiteam());
		gm.AlertAccepted();
	}

}
