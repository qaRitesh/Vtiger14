package com.mondh.vtiger.OR_Marketing.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;

@Getter
public class MarketingAccountCreateAccountPage_OR extends CommonReusableCode{

	public  MarketingAccountCreateAccountPage_OR(WebUtil wD) {
		super(wD);
		PageFactory.initElements(wD.getDriver(),this);
	}
	
//-----------------------------------------------Account Information--------------------------------------------
	//@CacheLookup
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement accountNameTB;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='website']")
	private WebElement websiteTB;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='tickersymbol']")
	private WebElement tickersymbolTB;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='phone']")
	private WebElement phoneTB;

	//@CacheLookup
	@FindBy(xpath="//input[@id='fax']")
	private WebElement faxTB;
	
	//@CacheLookup
	@FindBy(xpath = "//input[@id='email1']")
	private WebElement email;
//----------------------------------------Address Information------------------------------------------	

	//@CacheLookup
	@FindBy(xpath = "//textarea[@name='bill_street']")
	private WebElement billAddress;
	
	//@CacheLookup
	@FindBy(xpath = "//input[@id='bill_city']")
	private WebElement billCity;
	
	//@CacheLookup
	@FindBy(xpath = "//input[@id='bill_state']")
	private WebElement billsate;
	
	//@CacheLookup
	@FindBy(xpath="//input[@id='bill_code']")
	private WebElement billpostCode;
	
}
