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
import pages.CartPage;
import pages.CheckOutStep1Page;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class CheckOutStep1Page_test extends TestBase
{
	InventoryPage invet;
    LoginPage loginPage;
    CartPage cart;
    CheckOutStep1Page checkoutpage;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		invet=new InventoryPage();
		cart=new CartPage();
		checkoutpage=new CheckOutStep1Page();
		
		loginPage.LoginToApplication();
		invet.add3products();
		invet.clickOncartIcon();
		cart.clickOnCheckoutBtn();
		
	}
	
	@Test(groups = "sanity")
	public void verifyCheckInfoTextTest() throws EncryptedDocumentException, IOException
	{
	   String actText=ReadData.readExcel(2, 3);
	   String expText=checkoutpage.verifyCheckInfoText();
	   Assert.assertEquals(actText, expText);
	   Reporter.log("Check out step 1 page title: "+actText);
	}
	@Test(groups = "retest")
	public void inputInfoTest() throws EncryptedDocumentException, IOException
	{
		String actURL=ReadData.readExcel(2, 4);
		String expURL=checkoutpage.inputInfo();
		Assert.assertEquals(actURL,expURL);
		Reporter.log("After check out step 1 next URL is: "+actURL);
	}
	@Test(groups="sanity")
	public void clickCancelBtnTest() throws EncryptedDocumentException, IOException
	{
		String actURL=ReadData.readExcel(3, 0);
		String expURL=checkoutpage.clickCancelBtn();
		Assert.assertEquals(actURL, expURL);
		Reporter.log("After click on cancel btn URL is: "+actURL);
		
	}
	
	
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if(it.getStatus()==it.FAILURE)
		{
			ScreenShot.captureScreenShot(it.getName());
		}
		driver.close();
	}

}
