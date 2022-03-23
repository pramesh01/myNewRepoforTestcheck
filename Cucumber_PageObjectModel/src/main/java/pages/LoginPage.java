package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div/a[4]")
	WebElement signLink;
	@FindBy(xpath="//*[@id='login_id']")
	WebElement usernameTextField;
	@FindBy(xpath="//*[@id='nextbtn']")
	WebElement nextbutton;
	@FindBy(xpath="//*[@id='password']")
	WebElement passwordTextField;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage doLogin(String username,String password) {
		
		signLink.click();
	    usernameTextField.sendKeys(username);
		nextbutton.click();
		passwordTextField.sendKeys("Ishu@284128");
		LandingPage landpage=PageFactory.initElements(driver,LandingPage.class);
		return landpage ;	
	     }
          }