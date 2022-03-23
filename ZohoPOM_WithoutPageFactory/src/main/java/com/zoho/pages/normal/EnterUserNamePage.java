package com.zoho.pages.normal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;

public class EnterUserNamePage extends ZohoBasePage{

	@FindBy(xpath=Constants.username_xpath)
	WebElement enteruserid;
	@FindBy(xpath=Constants.nextbutton_xpath)
	WebElement nextbutton;
	
	public ZohoPage submitUsername(String userID) {
		log("entering userID in name field "+userID);
		getDriver().type(Constants.username_xpath, userID);
		//enteruserid.sendKeys(userID);
		log("clicking Next Button");
		getDriver().click(Constants.nextbutton_xpath);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new EnterPasswordPage();

      }
      }
