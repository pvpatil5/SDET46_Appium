package genralstore.POM;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import gesturesUtility.Gestures;

public class GenralStore_LandingPage 
{


	AndroidDriver driver;

	public GenralStore_LandingPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement selectCountry;

	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nametxtfld;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleradiobtn;

	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleradiobtn;

	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsshopbtn;

	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	private WebElement toastmsg;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='India']")
	private WebElement indiacountry;




	public WebElement getIndiacountry() {
		return indiacountry;
	}

	public WebElement getSelectCountry() {
		return selectCountry;
	}

	public WebElement getNametxtfld() {
		return nametxtfld;
	}

	public WebElement getMaleradiobtn() {
		return maleradiobtn;
	}

	public WebElement getFemaleradiobtn() {
		return femaleradiobtn;
	}

	public WebElement getLetsshopbtn() {
		return letsshopbtn;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}


	public void logintoApp() 
	{
		selectCountry.click();	
		Gestures gestures= new Gestures(driver);
		gestures.scrollIntoView("text", "India");
		indiacountry.click();
		nametxtfld.sendKeys("pavan");
		letsshopbtn.click();
	}






}
