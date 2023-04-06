package gestures;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Scroll_Gesture
{

	@Test
	public void scrol() throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability("automationName", "appium");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8N91KGFEH");
		desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
		desiredCapabilities.setCapability("appActivity", ".ApiDemos");


		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement views = driver.findElement(AppiumBy.accessibilityId("Views"));
		views.click();

		WebElement element=driver.findElement(AppiumBy.accessibilityId("Hover Events"));
		
		boolean flag =true;
		while(flag)
		{
			flag=(Boolean)	((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					//"elementId", ((RemoteWebElement) element).getId(),
					"left", 500, "top", 600, "width", 500, "height", 1000,
					"direction", "down",
					"percent", 1.0
					));
			System.out.println(flag);
		}
	}


}
