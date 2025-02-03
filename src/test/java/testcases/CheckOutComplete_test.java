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
import pages.CheckOutCompletePage;
import pages.CheckOutStep1Page;
import pages.CheckOutStep2Page;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class CheckOutComplete_test extends TestBase
{
	InventoryPage invet;
    LoginPage loginPage;
    CartPage cart;
    CheckOutStep1Page checkoutpage1;
    CheckOutStep2Page checkoutpage2;
    CheckOutCompletePage checkoutcompletepage;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		invet=new InventoryPage();
		cart=new CartPage();
		checkoutpage1=new CheckOutStep1Page();
		checkoutpage2=new CheckOutStep2Page();
		checkoutcompletepage=new CheckOutCompletePage();
		loginPage.LoginToApplication();
		invet.add3products();
		invet.clickOncartIcon();
		cart.clickOnCheckoutBtn();
		checkoutpage1.inputInfo();
		checkoutpage2.clickfinishbtn();	
	}
	
	@Test(groups="sanity")
	public void verifythankUtxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(6, 0);
		String act=checkoutcompletepage.verifythankUtxt();
		Assert.assertEquals(exp,act);
		Reporter.log("actual thank u text: "+act);
	}
	@Test(groups="retest")
	public void verifyordertxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(6, 2);
		String act=checkoutcompletepage.verifyOrdertxt();
		Assert.assertEquals(exp,act);
		Reporter.log("actual order text: "+act);
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
