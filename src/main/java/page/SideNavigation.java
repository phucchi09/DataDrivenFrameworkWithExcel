package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

// monitors or operate Side Navigation bar only 
public class SideNavigation 
{
   WebDriver driver;
	
	
	public SideNavigation(WebDriver driver) // Every Page must have a constructor to invite the driver
	  {
		this.driver = driver;
	  }
		
		 //  Element Library    Storing WebElements  
	  @FindBy(how = How.XPATH, using= "//span[text()='Bank & Cash']")   
	  WebElement BankCashModule;   
	  
	  @FindBy(how = How.LINK_TEXT, using="New Account")   
	  WebElement NewAccountPage;     // we need to put Explicit wait becasuse  "Bank and Cash khulepachi ekchin lag6 Yo tab ma click garna
	  
	  @FindBy(how = How.LINK_TEXT, using="List Accounts")   
	  WebElement ListAccountPage;   
	  
	  public void goToNewAccountPage() throws InterruptedException
	  {
		  BankCashModule.click();
		  Thread.sleep(2000);
		  NewAccountPage.click();		  
	  }
	  
	  public void goToListAccountPage() throws InterruptedException
	  {
		  ListAccountPage.click();		    // we don't need to click   "BankCashModule " because it remains open 
	  }
	

}
