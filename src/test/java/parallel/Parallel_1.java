package parallel;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Parallel_1
{

	
	@Parameters({"deviceName","UDID","platformVersion","port"})
	@Test
	public void testparallel(String deviceName,String UDID,String platformVersion, String port ) throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion );
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, UDID);
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName );
		desiredCapabilities.setCapability("appPackage", "com.androidsample.generalstore");
		desiredCapabilities.setCapability("appActivity", ".SplashActivity");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("autoGrantPermission", false);

		URL url = new URL("http://localhost:"+port+"/wd/hub");

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String msg=driver.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getText();

		System.out.println(msg);
		

	}
	
}
