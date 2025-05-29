package com.mondh.vtiger.AccountName;

import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.OR_AccountName.AccountNamePage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class AccountNamePage extends AccountNamePage_OR {

	private WebUtil gm;

	public AccountNamePage(WebUtil wD) {
		super(wD);
		this.gm = wD;

	}

	CommonReusableCode comm;

	public void accountSelect(String text,String columnName) {
		comm = new CommonReusableCode(gm);
		comm.searchTextBox(text);
		comm.selectOptionsVisibleText(columnName);
		gm.clickButton(getSearchNowBT());
		gm.clickButton(getClickiteam());
	}
}
