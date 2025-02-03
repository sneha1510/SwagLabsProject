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
import pages.CheckOutStep2Page;
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class CheckOutStep2Page_test extends TestBase
{
	InventoryPage invet;
    LoginPage loginPage;
    CartPage cart;
    CheckOutStep1Page checkoutpage1;
    CheckOutStep2Page checkoutpage2;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		invet=new InventoryPage();
		cart=new CartPage();
		checkoutpage1=new CheckOutStep1Page();
		checkoutpage2=new CheckOutStep2Page();
		
		loginPage.LoginToApplication();
		invet.add3products();
		invet.clickOncartIcon();
		cart.clickOnCheckoutBtn();
		checkoutpage1.inputInfo();
		
		
	}
	
	@Test
	public void verifyPaymentInfotxtTest() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 0);
		String act=checkoutpage2.verifyPaymentInfotxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual payment info text: "+act);
	}
	@Test
	public void verifysasaucecardTxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 1);
		String act=checkoutpage2.verifysasaucecardTxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual sauce card text: "+act);
	}
	@Test
	public void verifyshippinginfoTxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 2);
		String act=checkoutpage2.verifyshippinginfoTxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual shipping info text: "+act);
	}
	@Test
	public void  verifyfreeponyTxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 3);
		String act=checkoutpage2.verifyfreeponyTxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual free pony text: "+act);
	}
	@Test
	public void  verifyitemSubTottxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 4);
		String act=checkoutpage2.verifyitemSubTottxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual item subtot text: "+act);
	}
	@Test
	public void  verifyitemTaxtxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 5);
		String act=checkoutpage2.verifyitemTaxtxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual item tax text: "+act);
	}
	@Test
	public void  verifyitemTottxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(4, 6);
		String act=checkoutpage2.verifyitemTottxt();
		Assert.assertEquals(exp, act);
		Reporter.log("Actual item total tax text: "+act);
	}
	
	@Test
	public void clickfinishbtnTxt() throws EncryptedDocumentException, IOException
	{
		String exp=ReadData.readExcel(5, 0);
		String act=checkoutpage2.clickfinishbtn();
		Assert.assertEquals(exp, act);
		Reporter.log("After click on finish btn move to : "+act);
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
