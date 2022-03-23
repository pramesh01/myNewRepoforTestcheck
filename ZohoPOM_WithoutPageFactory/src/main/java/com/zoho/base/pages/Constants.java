package com.zoho.base.pages;

import org.openqa.selenium.By;

public class Constants {
	
	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";
	
	public static final String signin_xpath="//*[@class='signupcontainer']/a[1]";
	public static final By signin_link_locator=By.xpath(signin_xpath);
	public static final String signin_xpath_key="signin_xpath";
	
	public static final String username_xpath="//*[@id='login_id']";
	public static final By username_link_locator=By.xpath(username_xpath);
	
	public static final String nextbutton_xpath="//*[@id='login']/button";
	public static final By nextButton_link_locator=By.xpath(nextbutton_xpath);
	
	public static final String password_xpath="//input[@id='password']";
	public static final By password_link_locator=By.xpath(password_xpath);
	
	public static final String signinButton_xpath="//*[@id='login']/button/span";
	public static final By signinButton_link_locator=By.xpath(signinButton_xpath);
	
	
	public static final String HomePage_Title="Pramesh";
	
	//Reports Path
	public static final String Reports_Path=System.getProperty("user.dir")+"//reports//";

}
