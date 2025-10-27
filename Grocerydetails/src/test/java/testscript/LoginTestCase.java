package testscript;

	import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;

import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import org.testng.annotations.Test;
import org.testng.AssertJUnit;
	import java.io.IOException;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import login.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
	import utilities.Excelutility;

	public class LoginTestCase extends TestNGBase{
		
		HomePage home;
		
		@Test(priority=1,description="user is trying to login with valid creds",groups= {"smoke"})
		public void validateUserloginWithValidCredentials() throws IOException
		{
			
			String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
			String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue);
		home=loginpage.login();
	
		boolean validate=loginpage.validatelogin();
		Assert.assertTrue(validate,Constant.validateCredntialerror);
		
		}
		
		
		@Test(priority=2,description="USer is trying to login with valid username and invalid password")//,retryAnalyzer=retry.Retry.class)
		public void validateLoginwithUsernameInvalidPassword() throws IOException
		{
			
			String usernamevalue=Excelutility.getStringData(1, 0, "Grocerydetails");
			String passwordvalue=Excelutility.getStringData(1, 1, "Grocerydetails");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue).login();
		String expected="7rmart supermarket";
		String actual=loginpage.istitledisplayed();
		Assert.assertEquals(actual, expected,Constant.validateCredsinvalidpassword);
		
				
		}
		
		
		@Test(description="user is trying to login with invalid username and valid password")
		public void validateLoginwithUsernameValidPassword() throws IOException
		{
			
			String usernamevalue=Excelutility.getStringData(2, 0, "Grocerydetails");
			String passwordvalue=Excelutility.getStringData(2, 1, "Grocerydetails");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue).login();
		String expected="7rmart supermarket";
		String actual=loginpage.istitledisplayed();
		Assert.assertEquals(actual, expected,Constant.validateCredswithinvalidusername);
		}
		 
		@Test(description="user is logining with invalid username and invalid password",groups= {"smoke"},dataProvider="loginProvider")
		public void validateUserloginwithInvalidusernameinvalidpassword(String usernamevalue,String passwordvalue) throws IOException
		{
			//String usernamevalue=Excelutility.getStringData(3, 0, "Grocerydetails");
			//String passwordvalue=Excelutility.getStringData(3, 1, "Grocerydetails");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue);
		home=loginpage.login();
		String expected="7rmart supermarket";
		String actual=loginpage.istitledisplayed();
		Assert.assertEquals(actual, expected,Constant.validateCredswithInvalidUSernameandinvalidpassword);
		}
		
		
		@DataProvider(name = "loginProvider")
		public Object[][] getDataFromDataProvider() throws IOException {

		return new Object[][] { new Object[] { "admin", "admin22"  },
		// new Object[] {ExcelUtility.getStringData(3,
		// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
		};
		}

	}



