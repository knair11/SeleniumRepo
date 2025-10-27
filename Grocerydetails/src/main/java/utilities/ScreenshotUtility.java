package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility
{
	public void getScreenshot(WebDriver driver,String failedTestCase) 
	{
		TakesScreenshot scrShot=(TakesScreenshot) driver;
		File screenShot=scrShot.getScreenshotAs(OutputType.FILE);
		String timestamp=new SimpleDateFormat("dd_MM_yyy_hh_mm_ss").format(new Date());
		File f1=new File(System.getProperty("user.dir")+"//OutputScreenShot");
		if(!f1.exists())
		{
			f1.mkdirs();
		}
		
	}
}

