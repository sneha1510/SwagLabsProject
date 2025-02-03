package testcases;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

//test cases
public class LoginPage_test extends TestBase
{
	LoginPage loginPage;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
	}
	@Test(invocationCount = 1)
	public void LoginToApplicationTest() throws IOException
	{
		//take this expected data from excel (0,0)
		//String expURL="https://www.saucedemo.com/v1/inventory.html";
		String expURL=ReadData.readExcel(0, 0);
		
		String actURL=loginPage.LoginToApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Login Successful: "+actURL);
	}
	@Test
	public void verifyURLofApplicationTest() throws EncryptedDocumentException, IOException
	{
		//String expectedURL="https://www.saucedemo.com/v1/";
		String expectedURL=ReadData.readExcel(0, 1);
		String actualURL=loginPage.verifyURLofApplication();
		Assert.assertEquals(expectedURL,actualURL);
		Reporter.log("URL of application: "+actualURL);
	}
	@Test
	public void verifyTitleofApplicationTest() throws EncryptedDocumentException, IOException
	{
		//String expectedTitle="Swag Labs";
		String expectedTitle=ReadData.readExcel(0, 2); //correct
		//String expectedTitle=ReadData.readExcel(0, 1); //wrong

		String actualTitle=loginPage.verifyTitleofApplication();
		Assert.assertEquals(expectedTitle, actualTitle);
		Reporter.log("Title of application: "+actualTitle);
	}
	
	@AfterMethod
	/*public void closeBrowser()
	{
		driver.close();
	}*/
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.getStatus()==it.FAILURE)
		{
			ScreenShot.captureScreenShot(it.getName());
		}
		driver.close();
	}

}
