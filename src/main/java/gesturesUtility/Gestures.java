package gesturesUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Gestures 
{
	AndroidDriver driver;


	public Gestures(AndroidDriver driver) 
	{
		this.driver=driver;
	}

	/**
	 * This Method Performs click action on given element
	 * @param WebElement
	 */
	public void clickonElement(WebElement element) 
	{

		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId()
				));

	}
	/**
	 * This Method Performs click action on given co-ordinates
	 * @param x
	 * @param y
	 */
	public void click_w_r_t_coordinates(int x,int y) 
	{

		driver.executeScript("mobile: clickGesture", ImmutableMap.of(
				"x",x,
				"y",y

				));

	}

	public void dragandDrop(WebElement element,int endx,int endy) 
	{
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) element).getId(),
				"endX", endx,
				"endY", endy
				));
	}
	
	public void scrollIntoView(String an,String av) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))"));
	}

}
