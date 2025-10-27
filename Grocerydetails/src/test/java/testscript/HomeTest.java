package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import login.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.Excelutility;

public class HomeTest extends TestNGBase{
	
	HomePage logout;
	
	@Test(description="user is trying to login and logout from page")
	public void validateloginwithvalidcreds() throws IOException
	{
		String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
		String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
	LoginPage loginpage=new LoginPage(driver);
	//HomePage logout=new HomePage(driver);
	loginpage.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue);
	logout=loginpage.login().clickOnAdmin();
	loginpage=logout.clickOnLogout();

	String expected="7rmart supermarket";
	String actual=loginpage.istitledisplayed();
	Assert.assertEquals(actual, expected,Constant.validatelogot);
		
	}

}
