package genral.store.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import genralstore.POM.Cart;
import genralstore.POM.Products;

public class TC02_AddProductToCart  extends Base
{
	@Test
	public void addproduct() throws InterruptedException 
	{
		Products products= new Products(driver);	
		String titleofproduct=products.getTextTitle();
		Assert.assertEquals(titleofproduct, "Products");
		//products.getAddtocart().click();
		Thread.sleep(2000);
		gesture.clickonElement(products.getAddtocart());
		products.getCartbtn().click();
		Cart cart = new Cart(driver);
		String titleofcart=cart.getPagetitle().getText();
		Assert.assertEquals(titleofcart, "Cart");
		
		
	}
}
