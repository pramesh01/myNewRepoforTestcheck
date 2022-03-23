package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;

public class LoginTest {
	
	WebDriver driver;
	
	/*@Test
	  public void login() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		HomePage hp=new HomePage(driver);
		LoginPage lp=hp.gotoLoginPage(driver);
		LandingPage landpage=lp.doLogin("bloggerdelhi123@gmail.com","Ishu@284128");
		landpage.websitehomepage();
	}  */
	
	@Test
	public void login() {
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		LoginPage lp=hp.gotoLoginPage();
		LandingPage lanpg=lp.doLogin("bloggerdelhi123@gmail.com", "Ishu@284128");
		lanpg.websitehomepage();
		
		
	}

}
