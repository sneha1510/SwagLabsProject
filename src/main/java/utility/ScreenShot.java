package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class ScreenShot extends TestBase
{
	//date 
	public static String getDate() {
		return new SimpleDateFormat("dd-MM-YYYY ss-mm-HH").format(new Date());
	}
	//ss capture
	public static void captureScreenShot(String nameOfmethod) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File destination= new File("C:\\Selenium_Framework\\1_SeleniumFramework\\ScreenShot\\"+nameOfmethod+"--"+getDate()+".jpeg");
	    FileHandler.copy(source, destination);
	}
  
}
