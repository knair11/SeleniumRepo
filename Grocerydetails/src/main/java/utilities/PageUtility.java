package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectDragDropWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDragDropByVisibleText(WebElement element, String text) {
		Select object=new Select(element);
		object.selectByVisibleText(text);
	}
	
	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	
	public void selectByIndex(WebElement element, int value) {
		Select object=new Select(element);
		object.selectByIndex(value);
	}
	public void selectByContainsVisibleText(WebElement element,String Text)
	{
		Select object=new Select(element);
		object.selectByContainsVisibleText(Text);;
	}
	
	public void clickByRadiobutton(WebElement element)
	{
		element.click();
	}
	
	public void ClickByCheckbox(WebElement element)
	{
		element.click();
	}

}
