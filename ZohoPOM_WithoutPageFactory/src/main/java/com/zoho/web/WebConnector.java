package com.zoho.web;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import com.zoho.base.pages.ZohoPage;
import com.zoho.session.ZohoTestSession;

public interface WebConnector extends ZohoWebConnector{
	
void openBrowser(String bName);
void navigate(String url);
void quit();
EventFiringWebDriver getCurrentDriver();
void waitforElementLoad();
ZohoTestSession getSession();
boolean isStopExecution();
void setStopExecution(boolean stopExecution);
void assertAll();
SoftAssert getSoftAssert();
void setSoftAssert(SoftAssert softAssert);
void log(String message);
ZohoPage validateTitle(String expectedTitle);
void fail(String message);
ZohoPage validateElementPresent(By Locator);
ZohoPage submitUsername(String userID);
void click(String object);
void type(String objectKey,String data);
void select(String objectKey,String data);
void clear(String objectKey);
public By getObject(String ObjectKey);

}
