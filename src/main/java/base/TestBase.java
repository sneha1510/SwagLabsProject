package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;


public class TestBase 
{
   public static WebDriver driver;
   public void initialization() throws IOException
   {
	   String browser=ReadData.readPropertyFile("Browser");
	   if(browser.equals("chrome"))
	   {
		   WebDriverManager.chromedriver().setup();
		   driver=new ChromeDriver();   
	   }
	   else if(browser.equals("edge"))
	   {
		   WebDriverManager.edgedriver().setup();
		   driver =new EdgeDriver();
	   }
	   else if(browser.equals("firefox"))
	   {
		   WebDriverManager.firefoxdriver().setup();
		   driver=new FirefoxDriver();
	   }
	   
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.get(ReadData.readPropertyFile("Url"));
	   
	   
	   /*WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.manage().window().maximize();
	   driver.get("https://www.saucedemo.com/v1");*/
	   
	   
	   
   }
}
