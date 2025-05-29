package com.mondh.vtiger.OR_AccountName;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;

@Getter
public class AccountNamePage_OR extends CommonReusableCode {


	public AccountNamePage_OR(WebUtil wD) {
		super(wD);
		PageFactory.initElements(wD.getDriver(),this);
	}
	
	
//SearchNow:
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowBT;
	
	//@CacheLookup
		@FindBy(xpath="//a[text()='rajaBhai']")
		private WebElement clickiteam ;
}
