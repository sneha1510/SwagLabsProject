package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

//actual logic
public class LoginPage extends TestBase
{
	//object repo: here webelements are stored
	@FindBy(xpath="//input[@id=\"user-name\"]") private WebElement userTextbox;
	@FindBy(xpath="//input[@id=\"password\"]") private WebElement passwordTextbox;
	@FindBy(xpath="//input[@id=\"login-button\"]") private WebElement loginBtn;
	public LoginPage()
	{
		PageFactory.initElements(driver,this);//this refer to current obj 
	}
	public String LoginToApplication() throws IOException
	{
		/*userTextbox.sendKeys("standard_user");
		passwordTextbox.sendKeys("secret_sauce");*/
		userTextbox.sendKeys(ReadData.readPropertyFile("Username"));
		passwordTextbox.sendKeys(ReadData.readPropertyFile("Password"));
		loginBtn.click();
		return driver.getCurrentUrl();//https://www.saucedemo.com/v1/inventory.html
	}
	
	public String VerifyMultiCred(String usernm,String pass)
	{
		userTextbox.sendKeys(usernm);
		passwordTextbox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	
	
	public String verifyURLofApplication()
	{
		return driver.getCurrentUrl();
		
	}
	public String verifyTitleofApplication()
	{
		return driver.getTitle();
	}

}
