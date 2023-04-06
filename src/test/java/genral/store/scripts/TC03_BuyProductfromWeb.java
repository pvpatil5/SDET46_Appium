package genral.store.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import driverUtility.DriverUtil;
import genralstore.POM.Cart;
import genralstore.POM.Products;

public class TC03_BuyProductfromWeb extends Base 
{
	@Test
	public void buyproductfrom_web() throws InterruptedException 
	{
		
		Products products= new Products(driver);	
		String titleofproduct=products.getTextTitle();
		Assert.assertEquals(titleofproduct, "Products");
		products.getAddtocart().click();
		products.getCartbtn().click();
		Cart cart = new Cart(driver);
		String titleofcart=cart.getPagetitle().getText();
		Assert.assertEquals(titleofcart, "Cart");
		cart.getProceedtowebbtn().click();
		Thread.sleep(5000);
		DriverUtil driverutil = new DriverUtil(driver);
		driverutil.getViews();
		driverutil.switchContext("WEBVIEW_com.androidsample.generalstore");
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, title);
		
	}
}
