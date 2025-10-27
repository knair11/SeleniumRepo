package testscript;

import org.testng.annotations.Test;

import constants.Constant;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import login.TestNGBase;
import pages.AdminUserPage;
import pages.HomePage;
import utilities.Excelutility;
import utilities.RandomDataUtility;

public class AdminUserTest extends TestNGBase{
	HomePage home;
	AdminUserPage adminpages;
	@Test(description="user is trying to add new user")
	public void resgisterNewUSer() throws IOException
	{
		
		String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
		String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
		
	AdminUserPage adminpage=new AdminUserPage(driver);
	adminpage.enterusernameonusernamedfeild(usernamevalue);
	adminpage.enterpasswordonpasswordfeild(passwordvalue);
	adminpage.login();
	adminpages=adminpage.moreinfo();
	adminpage.newuser();
	RandomDataUtility data = new RandomDataUtility();
	String newusernname=data.randomusername();
	String newuserpassword=data.randompassword();
	adminpage.enternewusernameonusernamedfeild(newusernname).enternewpasswordonpasswordfeild(newuserpassword);
	
	adminpage.usertypecreate().savenewuser();
	
   boolean alert=adminpage.isalertdisplayed();
   Assert.assertTrue(alert,Constant.valisatenewuser);
	
	}
	
	@Test(description="user is trying to search the user")
	public void searchUserCreatedOrNot() throws IOException 
	{
		String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
		String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
		
	AdminUserPage adminpage=new AdminUserPage(driver);
	adminpage.enterusernameonusernamedfeild(usernamevalue);
	adminpage.enterpasswordonpasswordfeild(passwordvalue);
	adminpage.login();
	adminpage.moreinfo().search().entertext();
	adminpage.usertype().savesearch();
	
	String expected="1";
	String actual=adminpage.isOnedisplayed();
	Assert.assertEquals(actual, expected,Constant.validatesearchuser);
	
	}
	
	@Test(description="user is trying to reset")
	public void resetuser() throws IOException
	{
		String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
		String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
		
	AdminUserPage adminpage=new AdminUserPage(driver);
	adminpage.enterusernameonusernamedfeild(usernamevalue);
	adminpage.enterpasswordonpasswordfeild(passwordvalue);
	adminpage.login();
	adminpage.moreinfo().reset();
	
	String expected="Admin Users";
	String actual=adminpage.adminusers();
	Assert.assertEquals(actual, expected,Constant.validatereset);
		
	}
	


}
