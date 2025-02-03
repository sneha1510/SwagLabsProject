package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CheckOutStep1Page extends TestBase
{
	//obj repo
	@FindBy(xpath="//div[text()=\"Checkout: Your Information\"]") private WebElement CheckInfoText;
	@FindBy(xpath="//input[@id=\"first-name\"]") private WebElement firstNametxtbox;
	@FindBy(xpath="//input[@id=\"last-name\"]")private WebElement lastNametxtbox;
	@FindBy(xpath="//input[@id=\"postal-code\"]")private WebElement postalCodetxtbox;
	@FindBy(xpath="//input[@class=\"btn_primary cart_button\"]") private WebElement continueBtn;
	
	//cancelbtn
	@FindBy(xpath="//a[@class=\"cart_cancel_link btn_secondary\"]") private WebElement cancelBtn;
	
	public CheckOutStep1Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyCheckInfoText()
	{
		return CheckInfoText.getText();
	}
	public String clickCancelBtn()
	{
		cancelBtn.click();
		return driver.getCurrentUrl();
	}
	public String inputInfo() throws EncryptedDocumentException, IOException
	{
		firstNametxtbox.sendKeys(ReadData.readExcel(2, 0));
		lastNametxtbox.sendKeys(ReadData.readExcel(2, 1));
		postalCodetxtbox.sendKeys(ReadData.readExcel(2, 2));
		continueBtn.click();
		return driver.getCurrentUrl();
	}
	

}
