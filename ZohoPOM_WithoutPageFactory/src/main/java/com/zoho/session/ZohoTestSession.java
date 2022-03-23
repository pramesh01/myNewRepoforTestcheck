package com.zoho.session;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.zoho.base.pages.Constants;
import com.zoho.base.pages.ZohoPage;
import com.zoho.pages.normal.LaunchPage;
import com.zoho.reports.ExtentManager;
import com.zoho.web.WebConnector;
import com.zoho.web.ZohoDriver;


public class ZohoTestSession {
WebConnector con;
ZohoPage currentPage;
ExtentReports reports;
ExtentTest test;

public ZohoTestSession() {
con = new ZohoDriver();
}

public void skipTest(String message){
test.log(Status.SKIP,message);
}

public ZohoPage getCurrentPage() {
	return currentPage;
}

public void setCurrentPage(ZohoPage currentPage) {
	this.currentPage = currentPage;
}

    public WebConnector getcon() {
	return con;
    }
    
	public void init(String testName) {
		if(Reporter.getCurrentTestResult().getAttribute("session")==null) 
		Reporter.getCurrentTestResult().getTestContext().setAttribute("session",this);
		
		reports=ExtentManager.getReports(Constants.Reports_Path);
		test=reports.createTest(testName);
		
		//ZohoPage page=new LaunchPage();
		//return new LaunchPage();
		
	}
	
	public void end() {
		reports.flush();
		getcon().assertAll();
	}
	
	public void generateReports() {
		if(reports !=null)
		reports.flush();
		
		//if(getcon()!=null)
			//getcon().quit();
	}
	
	
	public void log(String message) {
		test.log(Status.INFO,message);
		
	}
	
	public void failTest(String failureMessage) {
		//taking screenshots
				takeScreenShot();
		//fail in ExtentReports
		test.log(Status.FAIL, failureMessage);
	}
	
public void takeScreenShot() {
	Date d=new Date();
	String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
	// take screenshot
	File srcFile = ((TakesScreenshot) getcon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
	try {
	// get the dynamic folder name
	FileUtils.copyFile(srcFile, new File(ExtentManager.ScreenshotFolderPath+screenshotFile));
	//put screenshot file in reports
	test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.ScreenshotFolderPath+screenshotFile));
	} catch (IOException e)
	{
	e.printStackTrace();
	}
	}
}
