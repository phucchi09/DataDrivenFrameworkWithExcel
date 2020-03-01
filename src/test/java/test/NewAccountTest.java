package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import page.NewAccountPage;
import page.SideNavigation;
import util.BrowserFactory;
import util.ExcelReader;

public class NewAccountTest 
{
	ExcelReader reader = new ExcelReader("./data/data.xlsx");  // getCellDAta mehtod lai call gar6   (ExcelReader class line no : 38)
//  String username = reader.getCellData(sheetName, colName, rowNum);
	String username = reader.getCellData("Sheet1", "UserName", 2);
	String password = reader.getCellData("Sheet1", "Password", 2);
	String accountTitle = reader.getCellData("Sheet1", "AccountTitle", 2);
	String balance =  reader.getCellData("Sheet1", "InitialBalance", 2);
	
	
	// Test Case : Open a New Account 
	@Test
	public void OpenANewAccount() throws InterruptedException
	{
		WebDriver driver = BrowserFactory.startBrowser();
		LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		loginPage.login(username, password);
		
		SideNavigation sidenav = PageFactory.initElements(driver, SideNavigation.class);
		sidenav.goToNewAccountPage();
		
		
		Random rnd = new Random();
		String expectedTitle = accountTitle + rnd.nextInt(999);
		System.out.println("Just checking this is newly created Account:   " + expectedTitle);
		
		
		// NewAccountPage ma kaam garne
		NewAccountPage newAccountPage = PageFactory.initElements(driver, NewAccountPage.class);
		//reader.getCellData(  garena vane mistake hun6 
		// excel bata data linalai we must do   "reader.getCellData(sheetName, colName, rowNum);
		   newAccountPage.fillInTheNewAccountForm(expectedTitle, 
				   reader.getCellData("Sheet1", "Description", 2),
				   balance);
				  
		
	}

}
