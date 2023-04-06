package genral.store.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.Base;
import genralstore.POM.Products;

@Listeners(base.ListnersImp.class)
public class TC_01_LoginSuccess extends Base {

	@Test
	public void ckecklogin() 
	{
		Products products= new Products(driver);	
		String title=products.getTextTitle();
		Assert.assertEquals(title, "Product");
	}

}
