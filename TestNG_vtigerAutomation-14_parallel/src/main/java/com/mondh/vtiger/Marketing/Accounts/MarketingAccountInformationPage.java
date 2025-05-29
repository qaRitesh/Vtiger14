package com.mondh.vtiger.Marketing.Accounts;

import org.checkerframework.framework.qual.JavaExpression;
import org.openqa.selenium.JavascriptExecutor;

import com.mondh.vtiger.OR_Marketing.Accounts.MarketingAccountInformationPage_OR;
import com.mondh.vtiger.genericyCodes.WebUtil;

public class MarketingAccountInformationPage extends MarketingAccountInformationPage_OR {

	public WebUtil gm;
	public MarketingAccountInformationPage(WebUtil wd) {
		super(wd);
		this.gm=wd;
	}

	public void goToMarketingAccountSubmodule() throws InterruptedException{
		Thread.sleep(5000);

		gm.mousemoverToElement(getMarketingMouseOver());	
		gm.clickButton(getGoMarketingAccountSubmodule());
			
//		JavascriptExecutor  js= (JavascriptExecutor)gm.getDriver();
//		js.executeScript("if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}", getMarketingMouseOver());
//		js.executeScript("argument[0].click()", getGoMarketingAccountSubmodule());
	
	}
	
	public void clickTopUpdateBT() {
		gm.clickButton(getTopUpdateBT());
	}
	
	public void clickTopDeleteBT() {
		gm.clickButton(getTopDeleteBT());
	}
	
	
	
	
	
}
