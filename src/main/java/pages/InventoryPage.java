package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropDownList;

public class InventoryPage extends TestBase 
{
	//obj repo
	@FindBy(xpath="(//button[@class=\"btn_primary btn_inventory\"])[1]") private WebElement prodBackbackaddtocart;
    @FindBy(xpath="(//button[@class=\"btn_primary btn_inventory\"])[2]") private WebElement prodBikelightaddtocart;
    @FindBy(xpath="//div[@class=\"product_label\"]") private WebElement productTitle;
    @FindBy(xpath="(//button[@class=\"btn_primary btn_inventory\"])[3]") private WebElement prodBoltTshirt;
    @FindBy(xpath="//button[@class=\"btn_secondary btn_inventory\"]") private WebElement removeprodBoltTshirt;
    //@FindBy(xpath="(//button[@class=\"btn_primary btn_inventory\"])[4]") private WebElement prodjacket;
    //@FindBy(xpath="(//button[@class=\"btn_secondary btn_inventory\"])[2]") private WebElement removeprodjacket;

    
    @FindBy(xpath="//select[@class=\"product_sort_container\"]") private WebElement sortDropDwn;
    @FindBy(xpath="//span[@class=\"fa-layers-counter shopping_cart_badge\"]") private WebElement cartCount;
    @FindBy(xpath="//a[@class=\"shopping_cart_link fa-layers fa-fw\"]") private WebElement cartIcon;
    
    @FindBy(xpath="//li[@class=\"social_twitter\"]") private WebElement footerTwitter;
    @FindBy(xpath="//li[@class=\"social_facebook\"]") private WebElement footerFB;
    @FindBy(xpath="//li[@class=\"social_linkedin\"]") private WebElement footerLinkedin;
    @FindBy(xpath="//div[text()=\"© 2020 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy\"]") private WebElement footerText;

   //class calling
    public InventoryPage()
    {
        PageFactory.initElements(driver, this);
    }
    
    
   //methods
   public String verifyFootertext()
   {
	   return footerText.getText();
   }
   public String verifyTitle()
   {	  
	return productTitle.getText();   
   }
   public boolean verifyTwitterLogo()
   {
	   return footerTwitter.isDisplayed();   
   }
   public boolean verifyFBlogo()
   {
	   return footerFB.isDisplayed();
   }
   public boolean verifyLinkedinlogo()
   {
	   return footerLinkedin.isDisplayed();
   }
   /*public String add6products()
   {
	   Select s=new Select(sortDropDwn);
	   s.selectByVisibleText("Name (A to Z)");
	   prodBackbackaddtocart.click();
	   prodBikelightaddtocart.click();
	  return cartCount.getText();
	   
   }*/
   public String add3products()
   {
	    HandleDropDownList.handleSelect(sortDropDwn,"Name (A to Z)");
	    prodBackbackaddtocart.click();
	    prodBikelightaddtocart.click();
	    prodBoltTshirt.click();
	    //prodjacket.click();
	    return cartCount.getText();
   }
   //now remove 1 product from cart
   public String remove1products()
   {
	   add3products();
	   removeprodBoltTshirt.click();
	   return cartCount.getText();
	   
   }
   //click on cart icon to move to cart.html page
   public void clickOncartIcon()
   {
	   cartIcon.click();
   }
   
}
