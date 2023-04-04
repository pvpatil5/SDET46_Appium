package server;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class StartSever_custom 
{

	AppiumDriverLocalService server;

	public static  AppiumDriverLocalService getAppiumServer(int port) 
	{
		return	AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingPort(port)
				.withLogFile(new File("../SDET46_APPIUM/ServerLogs.txt"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				);
	}

	@BeforeMethod
	public void startServerPr() {
		server=getAppiumServer(4723);
		server.start();
		server.clearOutPutStreams();
	}

	@AfterMethod
	public void stopserver() {
		server.stop();
	}

	@Test
	public void launchapp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8N91KGFEH");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		desiredCapabilities.setCapability("appPackage", "io.appium.android.apis");
		desiredCapabilities.setCapability("appActivity", ".ApiDemos");
		//desiredCapabilities.setCapability(MobileCapabilityType.APP, "D:\\APPIUM_Stuff\\Appium_Docs\\ApiDemos-debug.apk");

		URL url = new URL("http://localhost:4723");

		AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);

	}

}
