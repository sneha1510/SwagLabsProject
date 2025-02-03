package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	//obj repo
	@FindBy(xpath="//div[@class=\"subheader\"]") private WebElement YourCartText;
	@FindBy(xpath="//div[@class=\"cart_quantity_label\"]") private WebElement quantityText;
	@FindBy(xpath="//div[@class=\"cart_desc_label\"]") private WebElement descriptionText;
	
	@FindBy(xpath="//a[@class=\"btn_action checkout_button\"]") private WebElement checkOutBtn;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageURL()
	{
		return driver.getCurrentUrl();
	}
	public String verifyYourCartTitle()
	{
	    return YourCartText.getText();	
	}
	public String verifyQuantityText()
	{
		return quantityText.getText();
	}
	public String verifyDescriptionText()
	{
		return descriptionText.getText();
	}
	public String clickOnCheckoutBtn()
	{
		checkOutBtn.click();
		return driver.getCurrentUrl();
	}
	

}
