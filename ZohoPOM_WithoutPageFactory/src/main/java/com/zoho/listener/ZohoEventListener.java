package com.zoho.listener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.Reporter;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public class ZohoEventListener extends AbstractWebDriverEventListener{

	public void beforeFindBy(By by,WebElement element,WebDriver driver) {
		
		System.out.println("Before Finding with locator..."+by);
		System.out.println("Before Finding webelemnt..."+element);
		System.out.println("Before Finding webDriver..."+driver);
		
		boolean error=false;
		if(error) {
			//getDriver().fail("element is not found please recheck again "+locator);
			getDriver().fail("element is not found please recheck again "+by);
			getDriver().assertAll();
		}
	}
public ZohoTestSession getSession()  {
return  (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
}
public WebConnector getDriver() {
	return getSession().getcon();
}
}
