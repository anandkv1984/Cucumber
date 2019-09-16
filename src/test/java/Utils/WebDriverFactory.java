package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	public WebDriver driver=null;
	
	public String url ;
	public String browserName ;
	
	public WebDriver getDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\automation_practice\\Workspace\\CucumberProject\\src\\test\\java\\resources\\config.properties");
		prop.load(fis);
		url=prop.getProperty("url");
		browserName=prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\java_practice\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\java_practice\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}else {
			System.out.println("***** Invalid browser ******");
		}
		
		return driver;
		
	}

}
