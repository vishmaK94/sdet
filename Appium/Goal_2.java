package GoogleChrome;

import java.net.MalformedURLException;
import java.net.URL;
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

public class Goal_2 {
	
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
	public void correctcredentials() throws InterruptedException {
		
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);		
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Login Form\")"));
		driver.findElementByXPath("//*[@text='Login Form']").click();
	
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		
		MobileElement username = driver.findElementByXPath("//*[@resource-id='username']");
		MobileElement password = driver.findElementByXPath("//*[@resource-id='password']");
		
		username.click();
		username.sendKeys("admin");
		password.click();
		password.sendKeys("password");
		
		driver.findElementByXPath("//*[@text='Log in']").click();
		Thread.sleep(3000);
		String validlogin = driver.findElementByXPath("//*[@text='Welcome Back, admin']").getText();
		Assert.assertEquals(validlogin, "Welcome Back, admin");		
				
		
	}
	
	@Test
	public void incorrectcredentials() throws InterruptedException {
		
		driver.get("https://www.training-support.net/selenium");		
		Thread.sleep(5000);		
		driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"Login Form\")"));
		driver.findElementByXPath("//*[@text='Login Form']").click();
	
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
		

		MobileElement username = driver.findElementByXPath("//*[@resource-id='username']");
		MobileElement password = driver.findElementByXPath("//*[@resource-id='password']");
		
		username.click();
		username.sendKeys("admin");
		password.click();
		password.sendKeys("passwo1");
		
		driver.findElementByXPath("//*[@text='Log in']").click();
		Thread.sleep(3000);
		String validlogin = driver.findElementByXPath("//*[@text='Invalid Credentials']").getText();
		Assert.assertEquals(validlogin, "Invalid Credentials");		
				
		
	}
	
	
	
	@AfterClass
	public void close() {
		driver.quit();
	}

}
