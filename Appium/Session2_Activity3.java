package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session2_Activity3 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
	public void devicecapability() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.contacts");
		caps.setCapability("appActivity", ".activities.PeopleActivity");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appserver,caps);		
	}
	
	@Test
	public void addtocontact() {
		
		driver.findElementByXPath("//*[@text='Contacts']").click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.findElementByXPath("//*[@text='ADD ACCOUNT']").click();
		driver.findElementById("floating_action_button").click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement firstname = driver.findElementByXPath("//*[@text='First name']");
		firstname.click();
		firstname.sendKeys("Aaditya");
		MobileElement lastname = driver.findElementByXPath("//*[@text='Last name']");
		lastname.click();
		lastname.sendKeys("Varma");
		MobileElement phonenumber = driver.findElementByXPath("//*[@text='Phone']");
		phonenumber.click();
		phonenumber.sendKeys("999148292");
		driver.findElementByXPath("//*[@text='SAVE']").click();		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				
        String contactName = driver.findElementById("large_title").getText();    	
        Assert.assertEquals(contactName, "Aaditya Varma");
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	

}
