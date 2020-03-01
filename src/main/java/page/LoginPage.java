package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage 
{
	WebDriver driver;
	
	
	public LoginPage(WebDriver driver) // Every Page must have a constructor to invite the driver
	{
		this.driver = driver;
	}
	
	/* Element Library ===>   2 ways to store WebElements 
	
		 1.   By userName = By.id("username");
		 2.   WebElement username = driver.findElement (By.findelement(By.id)"username"));   --> this does not work for thsi framework PAGE object MODEL
	*/	 
		 // Storing WebElements 
	  @FindBy(how = How.ID, using="username")   // ===>  DOM ma id = "username"
	  WebElement UserName;   // UserName ==> maile deko name 
	  
	  @FindBy(how = How.ID, using="password")   
	  WebElement Password; 
	  
	  @FindBy(how = How.NAME, using="login")   
	  WebElement SignInButton; 
	  
	// Methods to interact with Elements 
	 // Mehtod No 1: login
	      public void login(String userName, String password) 
	      {
		    UserName.sendKeys(userName);
		    Password.sendKeys(password);
		    SignInButton.click();
		  }

	      // Method NO 2: getPageTitle
		  public String getPageTitle() 
		  {
		    return driver.getTitle();
		  }
	  


}
