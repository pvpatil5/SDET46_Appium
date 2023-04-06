package driverUtility;

import java.util.Set;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtil 
{
	AndroidDriver driver;

	public DriverUtil(AndroidDriver driver) {
		this.driver=driver;
	}

	public void getViews() 
	{
		Set<String> contexts=driver.getContextHandles();	
		for(String context:contexts) 
		{
			System.out.println(context);	
		}
	}
	
	public void switchContext(String name) 
	{
	
		driver.context(name);
	}

}
