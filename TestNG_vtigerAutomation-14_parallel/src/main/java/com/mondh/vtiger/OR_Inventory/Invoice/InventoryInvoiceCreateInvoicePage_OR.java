package com.mondh.vtiger.OR_Inventory.Invoice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;

@Getter
public class InventoryInvoiceCreateInvoicePage_OR extends CommonReusableCode {

	public InventoryInvoiceCreateInvoicePage_OR(WebUtil weD){
		super(weD);
		PageFactory.initElements(weD.getDriver(),this);
	}
	
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='subject']")
	private WebElement subjectTB;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='customerno']")
	private WebElement customerNo;
	
	//@CacheLookup
	@FindBy(xpath="(//img[@title='Select'])[2]")
	private WebElement customerNameBT;
	
	//@CacheLookup
	@FindBy(xpath="(//img[@title='Select'])[3]")
	private WebElement accountNameBT;
	
	//@CacheLookup
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billAddressTB;
	
	//@CacheLookup
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingAddressTB;
	
	//@CacheLookup
	@FindBy(xpath="//img[@title='Products']")
	private WebElement productsBT;
	
	//@CacheLookup
	@FindBy(xpath="//input[@id='qty1']")
	private WebElement qtyTB;




	
	
	
	
}
