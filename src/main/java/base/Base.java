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
import org.testng.annotations.Parameters;

import com.google.common.io.Files;

import genralstore.POM.GenralStore_LandingPage;
import gesturesUtility.Gestures;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {

	AppiumDriverLocalService server;
	public AndroidDriver driver;
	static AndroidDriver sdriver;
	public Gestures gesture;

	public static AppiumDriverLocalService getService(String port) 
	{
		
		return AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingPort(Integer.parseInt(port)).withLogFile(new File("../SDET46_APPIUM/Logs/ServerLogs.txt"))
						.withArgument(GeneralServerFlag.SESSION_OVERRIDE));
	}

	@Parameters("port")
	@BeforeSuite
	public void startServer(String port) {
		server = getService(port);
		server.start();
		server.clearOutPutStreams();
	}

	@AfterSuite
	public void stopServer() {
		server.stop();
	}

	@Parameters({ "deviceName", "UDID", "platformVersion", "port" })
	@BeforeClass
	public void launchApp(String deviceName, String UDID, String platformVersion, String port)
			throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
		desiredCapabilities.setCapability(MobileCapabilityType.UDID, UDID);
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		desiredCapabilities.setCapability("appPackage", "com.androidsample.generalstore");
		desiredCapabilities.setCapability("appActivity", ".SplashActivity");
		desiredCapabilities.setCapability("noReset", true);
		desiredCapabilities.setCapability("autoGrantPermission", false);

		URL url = new URL("http://localhost:"+port+"");

		driver = new AndroidDriver(url, desiredCapabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		gesture = new Gestures(driver);
		sdriver = driver;
	}

	@AfterClass
	public void closeApp() {
		driver.terminateApp("com.androidsample.generalstore");
	}

	@BeforeMethod
	public void logintoApp() {
		GenralStore_LandingPage landingPage = new GenralStore_LandingPage(driver);
		landingPage.logintoApp();

	}

	public static String takescreenshot(String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "../SDET46_APPIUM/screenshots/" + name + ".png";
		File dest = new File(path);
		Files.copy(src, dest);
		return path;

	}

}
