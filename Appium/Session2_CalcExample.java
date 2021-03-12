package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Session2_CalcExample {

	AppiumDriver<MobileElement> driver = null;
	
		@BeforeClass
		public void beforeclass() throws MalformedURLException {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("deviceName", "5554");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.android.calculator2");
			caps.setCapability("appActivity", "com.android.calculator2.Calculator");
			caps.setCapability("noReset", true);
			
			URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
			driver = new AndroidDriver<MobileElement>(appserver, caps);
			
		}
		
		@Test
		public void multiplication() {
			driver.findElementById("digit_8").click();
			driver.findElementById("op_mul").click();
			driver.findElementById("op_mul").click();
			driver.findElementById("digit_2").click();
			
			String result = driver.findElementById("result").getText();
			System.out.println(result);
			Assert.assertEquals(result, "16");
		}
		
		@AfterClass
		public void afterclass() {			
			driver.quit();
		}
	}

