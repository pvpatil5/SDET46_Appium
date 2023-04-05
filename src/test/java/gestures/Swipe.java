package gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Swipe 
{

	@Test
	public void test1() throws MalformedURLException, InterruptedException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("automationName", "appium");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8N91KGFEH");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		//desiredCapabilities.setCapability(MobileCapabilityType.ORIENTATION, "");
//		desiredCapabilities.setCapability("appPackage", "jp.rallwell.siriuth.touchscreentest");
//		desiredCapabilities.setCapability("appActivity", ".TouchScreenTestActivity");
		desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
		desiredCapabilities.setCapability("appActivity", ".ApiDemos");
		
		
		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();
		
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		Thread.sleep(2000);
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 300, 
			    "top", 200, 
			    "width", 700, 
			    "height",200,
			    "direction", "left",
			    "percent", 0.75
			));
		
		
		
		
		// Java
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//		    "left", 250, 
//		    "top", 450, 
//		    "width", 500, 
//		    "height",450,
//		    "direction", "left",
//		    "percent", 0.75
//		));
//		Thread.sleep(2000);
//		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
//			    "left", 500, 
//			    "top", 750, 
//			    "width", 500, 
//			    "height",800,
//			    "direction", "up",
//			    "percent", 0.75
//			));
		

	}
}
