package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUserPage {
	public WebDriver driver;
	public AdminUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement login;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newuser;
	@FindBy(xpath="//select[@id='ut']") WebElement usertype;
	@FindBy(xpath="//input[@id='username']") WebElement usernamefield;
	@FindBy(xpath="//input[@id='password']") WebElement passwordfield;
	@FindBy(name="Create") WebElement save;
	@FindBy(xpath="//select[@id='user_type']") WebElement usertypecreate;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement search;
	@FindBy(xpath="//button[@value='sr']") WebElement savesearch;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']") WebElement reset;
	@FindBy(xpath="//input[@type='text']") WebElement entertext;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement text;
	@FindBy(xpath="//a[@class='page-link']") WebElement one;
	@FindBy(xpath="//h4[text()='Admin Users']") WebElement adminusers;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'and @class='small-box-footer']") WebElement moreinfo;
	
	
	
	PageUtility pageutility=new PageUtility();
	
	public void enterusernameonusernamedfeild(String usernamevalue) 
	{
		
		username.sendKeys(usernamevalue);
		
	}
	
	public void enterpasswordonpasswordfeild(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
	}
	public AdminUserPage enternewusernameonusernamedfeild(String usernamefeild) 
	{
		
		username.sendKeys(usernamefeild);
		return this;
	}
	
	public AdminUserPage enternewpasswordonpasswordfeild(String passwordfield)
	{
		password.sendKeys(passwordfield);
		return this;
	}
	public AdminUserPage login()
	{
		login.click();
		return this;
	}
	public AdminUserPage savenewuser() {
		
		save.click();
		return this;
	}
	
	public AdminUserPage newuser()
	{
		newuser.click();
		return this;
		
	}
	
	public AdminUserPage savesearch()
	{
		savesearch.click();
		return this;
	}
	
	public AdminUserPage usertype()
	{
		//pageutility.selectDragDropByVisibleText(usertype, "Staff");
		Select select=new Select(usertype);
		select.selectByVisibleText("Staff");
		return this;
		
	}
	public AdminUserPage usertypecreate()
	{
		Select select=new Select(usertypecreate);
		select.selectByVisibleText("Staff");
		return this;
	}
	
	public AdminUserPage moreinfo()
	{
		
		moreinfo.click();
		return this;
	}
	
	public AdminUserPage search()
	{
		search.click();
		return this;
	}
	
	public AdminUserPage reset()
	{
		reset.click();
		return this;
	}
	
	public void entertext()
	{
		entertext.sendKeys("Yolande");
	}
	public String istitledisplayed()
	{
		
		return text.getText();
	}
	
	public String isOnedisplayed()
	{
		
		return one.getText();
	}
	
	public String adminusers()
	{
		return adminusers.getText();
		
	}
	public boolean isalertdisplayed()
	{
		return text.isDisplayed();
	}



	
	
	
}
