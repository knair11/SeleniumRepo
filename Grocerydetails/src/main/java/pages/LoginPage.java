package pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Excelutility;
import utilities.WaitUtility;

public class LoginPage {
	
	
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement login;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminblock;
	@FindBy(xpath="//b[text()='7rmart supermarket']") WebElement text;
	
	public LoginPage enterusernameonusernamedfeild(String usernamevalue) 
	{
		
		username.sendKeys(usernamevalue);
		return this;
	}
	
	public LoginPage enterpasswordonpasswordfeild(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}
	
	public HomePage login()
	{
		wait.waitUntilElementToBeClickable(driver, login);
		login.click();
		return new HomePage(driver);
	}
	
	public boolean validatelogin()
	{
		
		return adminblock.isDisplayed();
		
	}
	public String istitledisplayed()
	{
		
		return text.getText();
	}
	

}
