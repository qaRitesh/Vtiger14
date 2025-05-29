package com.mondh.vtiger.OR_Marketing.Contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;

public class MarketingContactCreateContactsPage_OR extends CommonReusableCode{

	public MarketingContactCreateContactsPage_OR(WebUtil wD) {
		super(wD);
		PageFactory.initElements(wD.getDriver(),this);
	}
	
	@Getter
	//@CacheLookup
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstNameTB;
	
	@Getter
	//@CacheLookup
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastNameTB;
	
	@Getter
	//@CacheLookup
	@FindBy(xpath="(//img[@title='Select'])[1]")
	private WebElement selectAccountNameTB;
	
	@Getter
	//@CacheLookup
	@FindBy(xpath="//a[text()='rajaBhai']")
	private WebElement clickiteam ;

	
	

	
	
	
	
}
