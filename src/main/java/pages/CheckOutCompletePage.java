package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutCompletePage extends TestBase
{
	//obj repo
	@FindBy(xpath="//h2[@class=\"complete-header\"]") private WebElement thankUtxt;
	@FindBy(xpath="//div[@class=\"complete-text\"]") private WebElement ordertxt;
	@FindBy(xpath="//img[@class=\"pony_express\"]") private WebElement img;
	
	public CheckOutCompletePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifythankUtxt()
	{
		return thankUtxt.getText();
	}
	public String verifyOrdertxt() 
	{
		return ordertxt.getText();
	}
	public boolean verifyImg()
	{
		return img.isDisplayed();
	}

}
