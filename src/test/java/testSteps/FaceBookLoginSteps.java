package testSteps;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Utils.WebDriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import cuke.project.pages.FacebookLoginPage;

@RunWith(Cucumber.class)
public class FaceBookLoginSteps extends WebDriverFactory {
	FacebookLoginPage fb;
	
	@Before(order=1)
	public void set_the_stage() throws IOException {
		driver=getDriver();
	}
	
	@Given("^I navigate to \"([^\"]*)\" login page$")
	public void i_navigate_to_something_login_page(String strArg1) throws IOException{
		//driver=getDriver();
		driver.get(strArg1);
		System.out.println("Navigated to Facebook login page");
	}

	@When("^I enter valid username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_valid_username_something_and_password_something(String strArg1, String strArg2){
		fb = new FacebookLoginPage(driver);
		fb.facebookLogin(strArg1, strArg2);
		System.out.println("Entered login username & password");
	}

	@Then("^I see facebook home page$")
	public void i_see_facebook_home_page() {
		System.out.println("Home page is displayed");
	}
	
	@After
	public void tidyUp() {
	    driver.quit();
	}
}
