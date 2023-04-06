package genralstore.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products 
{
	AndroidDriver driver;
	public  Products(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement pagetitle;

	@AndroidFindBy(id="//android.widget.TextView[@text='Air Jordan 4 Retro']/parent::android.widget.LinearLayout//android.widget.TextView[@text='ADD TO CART']")
	private WebElement addtocart;

	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartbtn;
	
	
	
	
	public AndroidDriver getDriver() {
		return driver;
	}




	public WebElement getPagetitle() {
		return pagetitle;
	}




	public WebElement getAddtocart() {
		return addtocart;
	}




	public WebElement getCartbtn() {
		return cartbtn;
	}


	public String getTextTitle ()
	{
		return pagetitle.getText();
	}


}
