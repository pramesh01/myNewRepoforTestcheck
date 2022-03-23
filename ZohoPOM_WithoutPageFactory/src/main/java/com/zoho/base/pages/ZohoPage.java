package com.zoho.base.pages;

import com.zoho.session.ZohoTestSession;
import com.zoho.web.WebConnector;

public interface ZohoPage extends ZohoNormalPage,ZohoSessionPage {
	
ZohoPage openBrowser(String browser);
ZohoPage gotoHomePage();
void gotoRegisterPage();
ZohoPage submitUsername(String userID);


//Normal
WebConnector validator(boolean flagAssertionType);
WebConnector validator();
WebConnector quit();
void getTotalwindows();

ZohoPage gotoEnterUsernamepage();

//session based
void createDeal();
void Logout();
void log(String message);
ZohoTestSession getSession();
ZohoPage submitPassword(String password);


}
