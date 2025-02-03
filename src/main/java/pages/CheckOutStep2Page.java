package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOutStep2Page extends TestBase
{
    //obj repo
	@FindBy(xpath="//div[text()=\"Payment Information:\"]") private WebElement paymentinfoTxt;
	@FindBy(xpath="//div[text()=\"SauceCard #31337\"]") private WebElement saucecardTxt;
	@FindBy(xpath="//div[text()=\"Shipping Information:\"]") private WebElement shippinginfoTxt;
	@FindBy(xpath="//div[text()=\"FREE PONY EXPRESS DELIVERY!\"]") private WebElement freeponyTxt;
	@FindBy(xpath="//div[@class=\"summary_subtotal_label\"]") private WebElement itemSubTottxt;
	@FindBy(xpath="//div[@class=\"summary_tax_label\"]") private WebElement itemTaxtxt;
	@FindBy(xpath="//div[@class=\"summary_total_label\"]") private WebElement itemTotTxt;
    @FindBy(xpath="//a[@class=\"btn_action cart_button\"]") private WebElement finishBtn;
	public CheckOutStep2Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String verifyPaymentInfotxt()
	{
		return paymentinfoTxt.getText();
	}
	public String verifysasaucecardTxt()
	{
		return saucecardTxt.getText();
	}
	public String verifyshippinginfoTxt()
	{
		return shippinginfoTxt.getText();
	}
    public String verifyfreeponyTxt()
    {
    	return freeponyTxt.getText();
    }
    public String verifyitemSubTottxt()
    {
    	return itemSubTottxt.getText();
    }
    public String verifyitemTaxtxt()
    {
    	return itemTaxtxt.getText();
    }
    public String verifyitemTottxt() 
    {
    	return itemTotTxt.getText();
    }
    public String clickfinishbtn()
    {
    	finishBtn.click();
    	return driver.getCurrentUrl();
    }
}
