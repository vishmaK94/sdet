package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session3_Activity2 {
	
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	
	@BeforeClass
	public void openingdevice() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appserver,caps);
		
		driver.get("https://www.training-support.net/selenium/lazy-loading");	
		Thread.sleep(5000);
	}
	
	@Test
	public void testcase() throws InterruptedException {
				
        MobileElement pageTitle = driver.findElementByXPath("//*[@text='Lazy Loading']");  
        Thread.sleep(1000);
        System.out.println(pageTitle.getText());        
        
        List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");    	
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        Assert.assertEquals(numberOfImages.size(), 2);
        
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"helen\").instance(0))"));		
        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.view.View/android.widget.Image");   
        System.out.println("Number of image shown currently: " + numberOfImages.size());
        Assert.assertEquals(numberOfImages.size(), 3);
	}
	
    @AfterClass	
    public void afterClass() {	
        driver.quit();	
    }

}
