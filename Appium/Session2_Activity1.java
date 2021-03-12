package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Session2_Activity1 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeTest
	public void desiredcapabilities() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(appserver, caps);
		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void activitytest() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.training-support.net/");
		
		String title = driver.findElementByXPath("//*[@text='Training Support']").getText();
		System.out.println("Title Of Page: " +title);
		
		try {
			MobileElement crossbutton = driver.findElementByXPath("//*[@resource-id='com.android.chrome:id/infobar_close_button']");
			crossbutton.click();
		}
		catch (Exception e) {		
            System.out.println(e);	
        }
        
		
		MobileElement locateus = driver.findElementByXPath("//*[@resource-id='about-link']");
		locateus.click();
		
		try {
			MobileElement crossbutton = driver.findElementByXPath("//*[@resource-id='com.android.chrome:id/infobar_close_button']");
			crossbutton.click();
		}
		catch (Exception e) {		
            System.out.println(e.getMessage());	
        }
		
		String newpagetitle = driver.findElementByXPath("//*[@text='About Us']").getText();
		System.out.println("Title Of Page: " +newpagetitle);
		
        Assert.assertEquals(title, "Training Support");
    	Assert.assertEquals(newpagetitle, "About Us");
				
	}
	
	@AfterTest
	public void close() {		
		driver.quit();
	}
	
}
