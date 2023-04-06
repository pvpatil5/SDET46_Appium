package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.google.common.io.Files;

import genralstore.POM.GenralStore_LandingPage;
import gesturesUtility.Gestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base 
{

	AppiumDriverLocalService server;
	public AndroidDriver driver;
	static AndroidDriver sdriver;
	public Gestures gesture;
	

	public static AppiumDriverLocalService getService() {
		return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
				.usingPort(4723)
				.withLogFile(new File("../SDET46_APPIUM/Logs/ServerLogs.txt"))
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
				);
	}

	@BeforeSuite
	public void startServer() 
	{
		server=getService();
		server.start();
		server.clearOutPutStreams();
	}

	@AfterSuite
	public void stopServer()
	{
		server.stop();
	}


	@BeforeClass
	public void launchApp() throws MalformedURLException 
	{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, "RZ8N91KGFEH");
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
		desiredCapabilities.setCapability("appPackage", "com.androidsample.generalstore");
		desiredCapabilities.setCapability("appActivity", ".SplashActivity");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("autoGrantPermission", false);

		URL url = new URL("http://localhost:4723");

		driver = new AndroidDriver(url, desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		gesture= new Gestures(driver);
		sdriver=driver;
	}
	
	@AfterClass
	public void closeApp() {
		driver.terminateApp("com.androidsample.generalstore");
	}

	@BeforeMethod
	public void logintoApp()
	{
		GenralStore_LandingPage landingPage = new GenralStore_LandingPage(driver);
		landingPage.logintoApp();
		
	}
	
	public static String takescreenshot(String name) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)sdriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String path ="../SDET46_APPIUM/screenshots/"+name+".png";
		File dest = new File(path);
		Files.copy(src, dest);
		return path;
		
	}
	
}
