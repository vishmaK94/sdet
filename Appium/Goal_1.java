package GoogleChrome;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;

import junit.framework.Assert;

public class Goal_1 {
	
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void beforeclass() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appserver, caps);
		//driver.get("https://www.training-support.net/selenium");			
		//Thread.sleep(2000);
	}
	
	@Test
	public void todolisttestcase() throws InterruptedException {
		
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);		
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"To-Do List\")"));
		driver.findElementByXPath("//android.view.View[@content-desc='To-Do List Elements get added at run time']").click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
		MobileElement entertask = driver.findElementByXPath("//*[@resource-id='taskInput']");		
		MobileElement addtask= driver.findElementByXPath("//*[@text='Add Task']");
		
		ArrayList<String> tasklist = new ArrayList<String>();
		tasklist.add("Add tasks to list");
		tasklist.add("Get number of tasks");
		tasklist.add("Clear the list");
		
		for(int i=0;i<tasklist.size();i++) {
			entertask.sendKeys(tasklist.get(i));
			addtask.isDisplayed();
			addtask.click();
			Thread.sleep(2000);
			
		}
		
		for(int i=0;i<tasklist.size();i++) {
			
			String temp = "//*[@text='"+tasklist.get(i)+"']";
			driver.findElementByXPath(temp).click();
			
		}
		
		driver.findElementByXPath("//android.view.View/android.view.View[3]/android.view.View[3]/android.widget.TextView").click();				
	
		boolean taskdisplayed = true;
		
		try {			
			driver.findElementByXPath("//*[@text='Add tasks to list']");			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			taskdisplayed = false;			
		}
		Assert.assertEquals(false, taskdisplayed);
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
