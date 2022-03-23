package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	WebDriver driver;
	@FindBy(xpath="//*[@id='nextbtn']")
	  WebElement submitButton;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;	
	}
	
	public void websitehomepage() {
		submitButton.click();
		}
         }
