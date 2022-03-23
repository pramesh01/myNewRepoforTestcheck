package com.zoho.web;

import org.openqa.selenium.By;

import com.zoho.base.pages.ZohoPage;

public interface ZohoWebConnector {
	
	void logout();
	ZohoPage validateTitle(String expectedTitle);
	void validateLogin();
	ZohoPage validateElementPresent(By locator);
	boolean isElementPresent(By locator);
	void log(String message);
	void fail(String message);
	ZohoPage submitUsername(String userID);
	void click(String object);
	//
	//void openBrowser(String bName);
	//void navigate(String url);
	//void quit();

}
