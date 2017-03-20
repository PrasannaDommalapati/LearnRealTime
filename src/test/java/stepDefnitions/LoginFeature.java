package stepDefnitions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.prasanna.demo.pageObjects.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class LoginFeature {
	
	public static WebDriver hf;
	@Before
	public static void setUp()
	{
		try {
			System.setProperty("webdriver.gecko.driver","/Users/prasanna/Documents/PrasannaKC/geckodriver");
			hf = new RemoteWebDriver(new URL("http://localhost:4455/wd/hub"), DesiredCapabilities.firefox());
			hf.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			hf.get("https://mail.rediff.com/cgi-bin/login.cgi");
			System.out.println("Before method is up and running");
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
	@Given("^The user is in Gmail page$")
	public void the_user_is_in_Gmail_page() {
		LoginPage loginPage = new LoginPage(hf);
		Assert.assertTrue(loginPage.pageTitle().contains("Rediffmail"));
	}

	@When("^the user enters valid \"(.*?)\" and valid \"(.*?)\" and clicks on logon button$")
	public void the_user_enters_valid_and_valid_and_clicks_on_logon_button(String username, String password) {
		LoginPage loginPage = new LoginPage(hf);
		
		loginPage.fillLoginDetails(username, password);
		loginPage.clickLoginBtn();
	    
	}

	@Then("^Homepage should be displayed$")
	public void homepage_should_be_displayed() {
		LoginPage loginPage = new LoginPage(hf);

		Assert.assertTrue(loginPage.pageTitle().contains("Rediffmail"));
	    
	}

	@When("^the user enters invalid \"(.*?)\" and invalid \"(.*?)\" and clicks on logon button$")
	public void the_user_enters_invalid_and_invalid_and_clicks_on_logon_button(String username, String password) {
		LoginPage loginPage = new LoginPage(hf);
		
		loginPage.fillLoginDetails(username, password);
		loginPage.clickLoginBtn();
	    
	}

	@Then("^Error message should be displayed$")
	public void error_message_should_be_displayed() {
		Assert.assertTrue(hf.getCurrentUrl().equals("https://mail.rediff.com/cgi-bin/login.cgi"));
	}
	@When("^the user enters valid \"([^\"]*)\" and empty \"([^\"]*)\" and clicks on logon button$")
	public void the_user_enters_valid_and_empty_and_clicks_on_logon_button(String username, String password) {
		LoginPage loginPage = new LoginPage(hf);
		
		loginPage.fillLoginDetails(username, password);
		loginPage.clickLoginBtn();
	   
	}

	@When("^the user enters empty \"([^\"]*)\" and empty \"([^\"]*)\" and clicks on logon button$")
	public void the_user_enters_empty_and_empty_and_clicks_on_logon_button(String username, String password) {
	    
	    
	}

	@When("^the user enters empty \"([^\"]*)\" and valid \"([^\"]*)\" and clicks on logon button$")
	public void the_user_enters_empty_and_valid_and_clicks_on_logon_button(String username, String password) {
	    
		LoginPage loginPage = new LoginPage(hf);
		
		loginPage.fillLoginDetails(username, password);
		loginPage.clickLoginBtn();
	}

	@When("^the user enters invalid \"([^\"]*)\" and valid \"([^\"]*)\" and clicks on logon button$")
	public void the_user_enters_invalid_and_valid_and_clicks_on_logon_button(String username, String password) {
	    
		LoginPage loginPage = new LoginPage(hf);
		
		loginPage.fillLoginDetails(username, password);
		loginPage.clickLoginBtn();
	}

	@When("^the user enters valid \"([^\"]*)\" and invalid \"([^\"]*)\" and clicks on logon button$")
	public void the_user_enters_valid_and_invalid_and_clicks_on_logon_button(String username, String password) {
		LoginPage loginPage = new LoginPage(hf);
		
		loginPage.fillLoginDetails(username, password);
		loginPage.clickLoginBtn();
	    
	}
	@After
	public void tearDown() {
	    hf.close();
	}


}
