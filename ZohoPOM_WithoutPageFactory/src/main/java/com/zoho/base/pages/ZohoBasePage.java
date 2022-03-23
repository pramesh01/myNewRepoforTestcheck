package com.zoho.base.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public  class ZohoBasePage implements ZohoPage {
	
	public ZohoBasePage() {
		System.out.println("**********************ZohoBasePage Constructor***********************");
		//PageFactory.initElements(getCurrentDriver(),this);
		getSession().setCurrentPage(this);
	}

	public ZohoPage openBrowser(String browser) {
		System.out.println("from ZohoBasePage..openBrowser");
		return null;
		
	}

	public ZohoPage gotoHomePage() {
		System.out.println("zohoBasePage called..gottoHomePage");
		return null;
		
	}
	
	public WebConnector validateTitle() {
		//return null;
		//System.out.println("zohoBasePage called..gottoHomePage");
	return getSession().getcon();
		
	}
	
	public ZohoPage gotoEnterUsernamepage() {
		return null;
	}
	public void gotoRegisterPage() {
		
		
	}

	public ZohoPage submitUsername(String userID) {
		return null;
		
		
	}

	public WebConnector validator(String expTitle) {
		//return getSession().getcon();
		return null;
		
		
	}

	public WebConnector quit() {
		return getSession().getcon();
		
	}

	public void getTotalwindows() {
		
		
	}

	public void createDeal() {
		
		
	}
    public void Logout() {
		
	}
	
    public ZohoTestSession getSession()  {
	return  (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
    }
    
     public WebConnector getDriver() {
    	return getSession().getcon();
    	
    }
     
     public EventFiringWebDriver getCurrentDriver() {
		return getSession().getcon().getCurrentDriver();
    	 
     }
     
     public void waitforElementLoad() {
    	 
     }

	public WebConnector validator(boolean stopExecution) {
        System.out.println("Validation String has been Passed ... but not with the getTitle");
		getSession().getcon().setStopExecution(stopExecution);
        return getSession().getcon();
		//return null;
	}

	public WebConnector validator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void log(String message) {
		getSession().log(message);
	}

	public ZohoPage submitPassword(String password) {
		
		return null;
	}
	
	
}
