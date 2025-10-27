package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="username") WebElement username;
	@FindBy(name="password") WebElement password;
	@FindBy(xpath="//button[@type='submit']") WebElement login;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newCreate;
	@FindBy(xpath="//textarea[@id='news']") WebElement addText;
	@FindBy(xpath="//button[@type='submit']") WebElement savenews;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement search;
	@FindBy(xpath="//input[@class='form-control']") WebElement searchnews;
@FindBy(xpath="//button[@class='btn btn-danger btn-fix']") WebElement save;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement text;
@FindBy(xpath="//a[@class='page-link']") WebElement one;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and @class='small-box-footer']") WebElement moreinfo;

	public LoginPage enterusernameonusernamedfeild(String usernamevalue) 
	{
		
		username.sendKeys(usernamevalue);
		return new LoginPage(driver);
		
	}
	
	public LoginPage enterpasswordonpasswordfeild(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return new LoginPage(driver);
	}
	
	public HomePage login()
	{
		login.click();
		return new HomePage(driver);
	}
	 
	public ManageNewsPage createnew()
	{
		newCreate.click();
		return this;
		
	}
	
	public ManageNewsPage addText()
	
	{
		addText.sendKeys("Adding news here");
		return this;
		
	}
	public ManageNewsPage moreinfo()
	{
		
		moreinfo.click();
		return this;
	}
	public ManageNewsPage savenews()
	{
		savenews.click();
		return this;
		
	}
	
	public ManageNewsPage search()
	{
		search.click();
		return this;
	}
	
	public ManageNewsPage searchnews()
	{
		searchnews.sendKeys("Adding news here");
		return this;
		
	}
	
	public ManageNewsPage save()
	{
		save.click();
		return this;
	}
	public boolean isalertdisplayed()
	{
		return text.isDisplayed();
	}
	public String isOnedisplayed()
	{
		
		return one.getText();
	}
}
