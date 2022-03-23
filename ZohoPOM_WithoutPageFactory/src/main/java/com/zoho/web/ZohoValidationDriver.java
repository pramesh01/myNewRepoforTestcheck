package com.zoho.web;

import java.sql.Time;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public abstract class ZohoValidationDriver implements WebConnector {

	EventFiringWebDriver driver;
	boolean stopExecution;
	Properties prop;
	SoftAssert softAssert=new SoftAssert();
	
	public SoftAssert getSoftAssert() {
		return softAssert;
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	public ZohoPage validateTitle(String expTitle) {
		//System.out.println("ZohoValidationDriver title will be ->"+driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), expTitle);
		//Assert.assertEquals("Pramesh", expTitle);
		//System.out.println("Status of the validateTitle is ->"+isStopExecution());
		log("expected title is "+expTitle);
		//log("actual title is "+driver.getTitle());
		if(!expTitle.equals("Pramesh")) {
			fail("Title don't matched.failed that's why");
			//softAssert.fail("since title do not matched thats why it failed.");
			//if(isStopExecution())
				//softAssert.assertAll();
		}
		System.out.println("validate Title status is "+isStopExecution());
		return getSession().getCurrentPage();
	}

	public void validateLogin() {
		System.out.println("ZohoValidationDriver validate Login.");
		
	}
	public ZohoPage validateElementPresent(By locator) {
		if(!isElementPresent(locator))
			fail("element is not found."+locator);
		return getSession().getCurrentPage();
	}
	
	public boolean isElementPresent(By locator) {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}catch(Exception e) {
			return false;
		}
		return false;
	}
	
	 public ZohoTestSession getSession()  {
			return  (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
		    }
	
	public boolean isStopExecution() {
		return stopExecution;
	}

	public void setStopExecution(boolean stopExecution) {
		this.stopExecution = stopExecution;
	}
	public void assertAll() {
		softAssert.assertAll();
	}
	
	public void log(String message) {
		getSession().log(message);
	}
	public void fail(String message) {
		//fail in extent reports.
		getSession().failTest(message);
		
		//fail in testng
		softAssert.fail(message);
		if(isStopExecution())
			softAssert.assertAll();
	}
	
	public By getObject(String objectKey) {
		log("finding the locator "+objectKey);
		By locatorStrat = null;
		
		if(objectKey.endsWith("_id"))
			locatorStrat= By.id(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_xpath"))
			locatorStrat= By.xpath(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_name"))
			locatorStrat= By.name(prop.getProperty(objectKey));
		else if(objectKey.endsWith("_css"))
			locatorStrat= By.cssSelector(prop.getProperty(objectKey));

		return locatorStrat;
	
	}

}
