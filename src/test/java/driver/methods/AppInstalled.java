package driver.methods;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.netty.handler.codec.socksx.v4.DefaultSocks4CommandRequest;

public class AppInstalled 
{


	@Test
	public void unlock() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8N91KGFEH");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		desiredCapabilities.setCapability("appPackage", "com.androidsample.generalstore");
		desiredCapabilities.setCapability("appActivity", ".SplashActivity");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("autoGrantPermission", false);

		URL url = new URL("http://localhost:4723/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

		System.out.println(driver.isAppInstalled("com.androidsample.generalstore"));
		Thread.sleep(2000);
		//			
		driver.activateApp("io.appium.android.apis");
		
		
		//		
		//		driver.installApp(null);
		Thread.sleep(2000);
		driver.runAppInBackground(Duration.ofSeconds(15));

		System.out.println(driver.queryAppState("com.androidsample.generalstore"));
		
		System.out.println(driver.queryAppState("io.appium.android.apis"));
		
		


		driver.terminateApp("");



	}
}