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
import pages.InventoryPage;
import pages.LoginPage;
import utility.ReadData;
import utility.ScreenShot;

public class CartPage_test extends TestBase
{
	InventoryPage invet;
    LoginPage loginPage;
    CartPage cart;
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		invet=new InventoryPage();
		cart=new CartPage();
		loginPage.LoginToApplication();
		invet.add3products();
		invet.clickOncartIcon();
	}
	@Test
	public void verifyCartPageURLTest() throws EncryptedDocumentException, IOException
	{
	      String actURL=ReadData.readExcel(1, 0);
	      String expURL=cart.verifyCartPageURL();
	      Assert.assertEquals(actURL, expURL);
	      Reporter.log("actual Cart URL:"+actURL);
	}
	
	@Test
	public void verifyYourCartTitleTest() throws EncryptedDocumentException, IOException
	{
		String actTitle=ReadData.readExcel(1, 1);
		String expTitle=cart.verifyYourCartTitle();
		Assert.assertEquals(actTitle, expTitle);
	      Reporter.log("actual cart title: "+actTitle);

		
	}
	@Test
	public void verifyQuantityTextTest() throws EncryptedDocumentException, IOException
	{
		String actqtyText=ReadData.readExcel(1, 2);
		String expqtyText=cart.verifyQuantityText();
		Assert.assertEquals(actqtyText,expqtyText);
	      Reporter.log("actual quantity text: "+actqtyText);

	}
	@Test
	public void verifyDescriptionTextTest() throws EncryptedDocumentException, IOException
	{
		String actDescriptionText=ReadData.readExcel(1, 3);
		String expDescriptionText=cart.verifyDescriptionText();
		Assert.assertEquals(actDescriptionText, expDescriptionText);
	      Reporter.log("actual description text: "+actDescriptionText);
	      

	}
	@Test
	public void clickOnCheckoutBtnTest() throws EncryptedDocumentException, IOException
	{
		String actURL=ReadData.readExcel(1, 4);
		String expURL=cart.clickOnCheckoutBtn();
		Assert.assertEquals(actURL, expURL);
		Reporter.log("step 1 URL after click on checkOUT button: "+actURL);
		
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
