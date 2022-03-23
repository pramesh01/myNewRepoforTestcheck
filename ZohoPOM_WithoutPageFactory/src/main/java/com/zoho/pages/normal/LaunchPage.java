package com.zoho.pages.normal;

import org.openqa.selenium.support.PageFactory;

import com.zoho.base.pages.ZohoBasePage;
import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public class LaunchPage extends ZohoBasePage{
	
	public ZohoPage openBrowser(String browser) {
	System.out.println("opening browser from LaunchPage.");
	
	//ZohoTestSession session=getSession();
	//session.getcon().openBrowser("browser");
	getDriver().openBrowser("browser");
	return this;
	}
	
    public ZohoPage gotoHomePage() {
	System.out.println("Zoho LaunchPage called for method gotoHomePage");
	//ZohoTestSession session=getSession();
	//session.getcon().navigate("https://www.zoho.com/index1.html");
	log("navigating to URL https://zoho.com");
	getDriver().navigate("website_url");
	//log("navigating to URL https://zoho.com");
	return new HomePage();
	
	}

}
