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
import pages.HomePage;
import pages.ManageNewsPage;
import utilities.Excelutility;

public class ManageNewsTest extends TestNGBase{
	
	HomePage home;
	ManageNewsPage managenews;
	
	@Test(priority=1,description="user is trying to add news")
	public void createnews() throws IOException
	{
		
		String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
		String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
		
	ManageNewsPage news=new ManageNewsPage(driver);
	news.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue);
	home=news.login();
	news.moreinfo().createnew();
	news.addText().savenews();
	
	//String expected="News Created Successfully";
	
	
	boolean validate=news.isalertdisplayed();
	Assert.assertTrue(validate,Constant.validatenewscreated);
	}
	
	
	@Test(priority=2,description="user is trying to search the added news")
	public void Search() throws IOException
	{
		
		String usernamevalue=Excelutility.getStringData(0, 0, "Grocerydetails");
		String passwordvalue=Excelutility.getStringData(0, 1, "Grocerydetails");
		
	ManageNewsPage news=new ManageNewsPage(driver);
	news.enterusernameonusernamedfeild(usernamevalue).enterpasswordonpasswordfeild(passwordvalue);
	home=news.login();
	news.moreinfo().search();
	news.searchnews().save();
	
	String expected="1";
	String actual=news.isOnedisplayed();
	Assert.assertEquals(actual, expected,Constant.validatecreatednewspresent);
	
	
	}
	

}
