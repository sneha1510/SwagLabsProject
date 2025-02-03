package testcases;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import base.TestBase;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class InventoryPage_test extends TestBase
{
	InventoryPage invet;
    LoginPage loginPage;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		invet=new InventoryPage();
		loginPage.LoginToApplication();
	}
	@Test(priority = 1,enabled=true)
	public void verifyTitleTest() throws EncryptedDocumentException, IOException
	{
		//String Actual_inventoryPageTitle="Products";
		
		/*String Actual_inventoryPageTitle=ReadData.readExcel(0, 3);
		 fail it purposely to see dependsOnMethods keyword*/
		String Actual_inventoryPageTitle=ReadData.readExcel(0, 3);
		String Exp_inventoryPageTitle=invet.verifyTitle();
		Assert.assertEquals(Actual_inventoryPageTitle, Exp_inventoryPageTitle);
		Reporter.log("Actual Title of inventory page "+Actual_inventoryPageTitle);
	}
	@Test(priority = 2,  enabled = false    ,dependsOnMethods = "verifyTitleTest")
	public void verifyTwitterLogoTest()
	{
		boolean result=invet.verifyTwitterLogo();
		Assert.assertEquals(result, true);
		Reporter.log("Twitter logo :"+result);
	}
	@Test(priority = 3,    dependsOnMethods = "verifyTitleTest")
	public void verifyFBlogoTest()
	{
		boolean result=invet.verifyFBlogo();
		Assert.assertEquals(result, true);
		Reporter.log("FB logo :"+result);

	}
	@Test(priority=4,dependsOnMethods = "verifyTitleTest")
	public void verifyLinkedinlogoTest()
	{
		boolean result=invet.verifyLinkedinlogo();
		Assert.assertEquals(result, true);
		Reporter.log("LinkedIn logo :"+result);
	}
	@Test(priority = 5)
	public void add3productsTest() throws EncryptedDocumentException, IOException
	{
		//String expCount="3";
		String expCount=ReadData.readExcel(0, 4);
		String actCount=invet.add3products();
		Assert.assertEquals(expCount,actCount);
		Reporter.log("Total products added to cart: "+actCount);
		
	}
	@Test(priority = 6)
	public void remove2productsTest() throws EncryptedDocumentException, IOException
	{
		//after adding 3 and removing 1..expected count should be 2 products in cart
		//String expCount="2";
		String expCount=ReadData.readExcel(0, 5);
		String actCount=invet.remove1products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total products available in cart after removal from cart: "+actCount);
	}
	@Test(priority = 7)
	public void verifyFootertext() throws EncryptedDocumentException, IOException
	{
		//String expText="© 2020 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy";
		String expText=ReadData.readExcel(0, 6);
		String actText=invet.verifyFootertext();
		Assert.assertEquals(expText, actText);
		Reporter.log("Actual footer text: "+actText);
		
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
