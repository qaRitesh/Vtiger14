package com.mondh.vtiger.OR_Marketing.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountInformationPage_OR extends CommonReusableCode {

	
	public MarketingAccountInformationPage_OR(WebUtil wD) {
		super(wD);
		PageFactory.initElements(wD.getDriver(), this);
	}
	
//marketing:
		//@CacheLookup
		@FindBy(xpath="//a[text()='Marketing']")
		private WebElement marketingMouseOver;
		
		//@CacheLookup   
//		@FindBy(xpath="//a[contains(@href,'Marketing') and @class='drop_down' and text()='Accounts']")
		@FindBy(xpath="//div[@id='Marketing_sub']//a[text()='Accounts']")
		private WebElement goMarketingAccountSubmodule;
	
		@FindBy(xpath="//td[@class='dvtTabCache']//input[@title='Edit [Alt+E]']")
		private WebElement topUpdateBT;
		
		@FindBy(xpath="//td[@class='dvtTabCache']//input[@title='Delete [Alt+D]']")
		private WebElement topDeleteBT;
}
