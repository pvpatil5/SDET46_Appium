package practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class pac
{

	@Test
	public void test1() {
		Assert.assertEquals(false, true);
	}
	@BeforeMethod
	public void bm() {
		System.out.println("bm executed");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("am executed");
	}
	
	@BeforeClass
	public void bc() {
		System.out.println("bc execute");
	}
	
	@AfterClass
	public void ac() {
		System.out.println("ac executed");
	}
	
	@BeforeSuite
	public void bs() {
		System.out.println("bs executed");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("as executed");
	}
	
}
