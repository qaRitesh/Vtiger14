package com.mondh.vtiger.OR_CommonBasic;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;


@Getter
public class CommonOR {

	public CommonOR(WebUtil wD) {

		PageFactory.initElements(wD.getDriver(),this);
	
	}

	//@CacheLookup
	@FindBy(xpath ="//input[@name='user_name']")
	private WebElement userNameTB;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='user_password']")
	private WebElement passwordTB;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='Login']")
	private WebElement loginBT;
	
	
//SAVE & SignOut & Clance:
	//@CacheLookup
	@FindBy(xpath="(//input[@value='  Save  '])[1]")
	private WebElement savceTopBT;
	
	//@CacheLookup
	@FindBy(xpath="(//input[@value='  Cancel  '])[1]")
	private WebElement cancleTopBT;
	
	//@CacheLookup
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement sighOut;
	
//search TB&Bt:
	//@CacheLookup
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTB ;

	//@CacheLookup
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowBT ;
	
//selectVisibleText:
	//@CacheLookup
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement selectvisibleText;
	
//PluesIconCreateButton:	
	@FindBy(xpath="//img[contains(@title,'Create')]")
	private WebElement CreateBT;
	
//salesLeads:
	
	@FindBy(xpath="//a[text()='Sales']")
	private WebElement salesMouseOver;
	
	//@CacheLookup
	@FindBy(xpath="//a[contains(@href,'Sales') and @class='drop_down'and text()='Leads']")
	private WebElement goSalesLeadsSubmodule;
	
	//@CacheLookup
	@FindBy(xpath = "//a[contains(@href,'Sales') and @class='drop_down'and text()='Accounts'] ")
	private WebElement goSalesAccountSubmodule;
	
	//@CacheLookup
	@FindBy(xpath="//a[contains(@href,'Sales') and @class='drop_down'and text()='Contacts']")
	private WebElement goSalesContactsSubmodule; 
	
//marketing:
	//@CacheLookup
	@FindBy(xpath="//a[text()='Marketing']")
	private WebElement marketingMouseOver;
	
	//@CacheLookup
	@FindBy(xpath="//a[@class='drop_down' and text()='Campaigns']")
	private WebElement goMarketingCompaignsSubmodule;
	
	//@CacheLookup
	@FindBy(xpath="//a[contains(@href,'Marketing') and @class='drop_down' and text()='Accounts']")
	private WebElement goMarketingAccountSubmodule;
	
	//@CacheLookup
	@FindBy(xpath="//a[@class='drop_down' and text()='Contacts']")
	private WebElement gomarketingContactsSubmodule;
	
//Inventory:
	//@CacheLookup
	@FindBy(xpath="//a[text()='Inventory']")
	private WebElement inventoryMouseOver;
	
	//@CacheLookup
	@FindBy(xpath="//a[contains(@href,'Inventory') and @class='drop_down' and text()='Products']")
	private WebElement goInventoryProductsSubmodule;	
	
	//@CacheLookup
	@FindBy(xpath="//a[contains(@href,'Inventory') and @class='drop_down' and text()='Invoice']")
	private WebElement goInventoryInvoiceSubmodule;
	
	
	
	
	
	
	
}
