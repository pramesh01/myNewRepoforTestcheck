package com.zoho.base.pages;

import com.zoho.web.WebConnector;

public interface ZohoNormalPage {

	WebConnector validator();
	WebConnector quit();
	void getTotalwindows();
	ZohoPage gotoHomePage();
	ZohoPage gotoEnterUsernamepage();
	ZohoPage submitPassword(String password);
}
