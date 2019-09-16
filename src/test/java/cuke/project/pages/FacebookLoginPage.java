package cuke.project.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Unit test for simple App.
 */
public class FacebookLoginPage extends LoadableComponent<FacebookLoginPage>{
	
	private WebDriver driver = null;
	private boolean isPageLoaded;
	
	// Page objects
	@FindBy(css="#email")
	private WebElement txbUsername;
	
	@FindBy(css="#pass")
	private WebElement txbPassword;
	
	@FindBy(css="input[type='submit']")
	private WebElement btnLogin;

	public FacebookLoginPage(WebDriver driver) {
		this.driver = driver;

		// This call sets the WebElement fields.
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		isPageLoaded = true;
	}

	@Override
	protected void isLoaded() throws Error {
        if (!isPageLoaded) {
            Assert.assertFalse(true);
        }
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("facebook"));
	}
	
	public void facebookLogin(String username, String password) {
		txbUsername.sendKeys(username);
		txbPassword.sendKeys(password);
		btnLogin.click();
	}
}
