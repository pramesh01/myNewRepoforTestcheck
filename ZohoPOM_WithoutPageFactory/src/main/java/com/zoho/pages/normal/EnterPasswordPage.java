package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class EnterPasswordPage extends ZohoBasePage  {
	
	@FindBy(xpath=Constants.password_xpath)
	WebElement enterpassword;
	@FindBy(xpath=Constants.signinButton_xpath)
	WebElement submitbutton;
	
	public ZohoPage submitPassword(String password) {
		
		log("enterring pasword in to the field");
		enterpassword.sendKeys(password);
		log("clicking on final submit Button");
		submitbutton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log("Signin in successfully into the application ");
		
		return null;
		
		
	}
	
	

}
