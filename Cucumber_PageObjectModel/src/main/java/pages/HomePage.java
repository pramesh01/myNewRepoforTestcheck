package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		System.out.println("************Homepage Constructor**********");
	    this.driver=driver;
	   }
	
	public LoginPage gotoLoginPage() {
		driver.get("https://zoho.com");
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		//return new LoginPage(driver);
		return lp;
	   }
}
