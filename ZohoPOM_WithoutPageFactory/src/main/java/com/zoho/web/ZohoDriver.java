package com.zoho.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.zoho.base.pages.ZohoPage;
import com.zoho.listener.ZohoEventListener;
import com.zoho.session.ZohoTestSession;

public class ZohoDriver extends ZohoValidationDriver{

	EventFiringWebDriver driver;
	
	public ZohoDriver() {
		System.out.println("Inside ZohoDriver constructor.");
		try {
		prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties");
		prop.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println(prop.get("website_url"));
	}
	
	public void logout() {
		
		
	}

	public void openBrowser(String bName) {
		//System.out.println("Zoho Driver openBrowser ");
		//WebDriver driver=new ChromeDriver();
		log("opening the browser "+bName);
		driver=new EventFiringWebDriver(new ChromeDriver());
		driver.register(new ZohoEventListener());
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//driver.manage().window().maximize();
	    }
	
	    public void navigate(String urlKey) {
	    	String url=prop.getProperty(urlKey);
	    	log("navigate to URl "+url);
		    driver.get(url);
	    }
	    
	    public void quit() {
	    	try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	driver.quit();
		
	    }
	    
	    public EventFiringWebDriver getCurrentDriver() {
		return driver;
	    	
	    }
	    
	    public void waitforElementLoad() {
	    	
	    }
	    public ZohoTestSession getSession()  {
	    	return  (ZohoTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	        }

		public ZohoPage validateElementPresent(String locatorType, String locator) {
			// TODO Auto-generated method stub
			return null;
		}

		public ZohoPage submitUsername(String userID) {
			
			return null;
		}
		
		public void click(String objectKey) {
			driver.findElement(getObject(objectKey)).click();
			//driver.findElement(By.xpath(prop.getProperty(objectKey))).click();
			
		}
		public void type(String objectKey,String data) {
			log("typing into the fils name "+objectKey+ " and data is -"+data);
			driver.findElement(getObject(objectKey)).sendKeys(data);
		}
		
		public void select(String objectKey,String data) {
			driver.findElement(getObject(objectKey)).sendKeys(data);
			
			
		}
		public void clear(String objectKey){
			driver.findElement(getObject(objectKey)).clear();
			
		}
}
