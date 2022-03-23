package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class HomePage extends ZohoBasePage{
	
	//@FindBy(xpath=Constants.signin_xpath)
	//WebElement loginLink;
	
	public ZohoPage gotoEnterUsernamepage() {
		log("forwarding control to user enter page.");
		getDriver().click(Constants.signin_xpath_key);
		return new EnterUserNamePage();
		
		
	}
}
