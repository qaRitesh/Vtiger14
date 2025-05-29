package com.mondh.vtiger.OR_Inventory.Products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mondh.vtiger.CommonBasic.CommonReusableCode;
import com.mondh.vtiger.genericyCodes.WebUtil;

import lombok.Getter;

public class InventoryProductsCreatePage_OR extends CommonReusableCode {

	public InventoryProductsCreatePage_OR(WebUtil wD) {
		super(wD);
		PageFactory.initElements(wD.getDriver(),this);
	}
	
	@Getter
//	@CacheLookup
	@FindBy (xpath="//input[@name='productname']")
	private WebElement productNameTB;
	
	@Getter
//	@CacheLookup
	@FindBy(xpath="//input[@name='productcode']")
	private WebElement partNumberTB;

	

	
	
}
