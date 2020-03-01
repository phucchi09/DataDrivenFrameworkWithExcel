package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory
{
	// global, so all methods can use
	static WebDriver driver;

	public static WebDriver startBrowser() 
	{
	// Set Chrome Driver Properties
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	// Create ChromeDriver object and launch chrome browser
	WebDriver driver = new ChromeDriver();
	
	driver.get("http://techfios.com/test/billing/?ng=admin/");

	// return the driver to the test class    
     return driver;    // returning driver to another class ---> here LoginTest.java 
	    
	}
	
}
