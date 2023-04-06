package genralstore.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cart 
{
	AndroidDriver driver;
	public  Cart(AndroidDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);

	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement pagetitle;
	public WebElement getPagetitle() {
		return pagetitle;
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedtowebbtn;
	
	public WebElement getProceedtowebbtn() {
		return proceedtowebbtn;
	}



}
