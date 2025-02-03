package testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class VerifyLoginMultiCredentials extends TestBase
{
    LoginPage loginPage;
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
	}
	@DataProvider(name="validation")
	public Object[][] getData()
	{
		return new Object[][] 
		{
			{"standard_user","secret_sauce"},
			{"locked_out_user","secret_sauce"},
			{"problem_user","secret_sauce"},
			{"performance_glitch_user","secret_sauce"},
		};
	};
	
	@Test(dataProvider="validation")

	public void VerifyMultiCredTest(String usernm,String pass)
	{
		SoftAssert s=new SoftAssert();
		String expURL="https://www.saucedemo.com/v1/inventory.html";
		String actURL=loginPage.VerifyMultiCred(usernm, pass);
		s.assertEquals(expURL, actURL);
		s.assertAll();
      
		
		
		
	}
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.getStatus()==it.FAILURE)
		{
			ScreenShot.captureScreenShot(it.getName());
		}
		driver.close();
	}

}
