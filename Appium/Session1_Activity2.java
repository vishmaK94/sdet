package Activities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session1_Activity2 {
		
	
	@Test
	    public void calc() throws InterruptedException, IOException {		
	        // Set the Desired Capabilities		
	        DesiredCapabilities caps = new DesiredCapabilities();	
	        caps.setCapability("deviceName", "5554");		
	        caps.setCapability("platformName", "Android");		
	        caps.setCapability("appPackage", "com.android.calculator2");		
	        caps.setCapability("appActivity", "com.android.calculator2.Calculator");	 
		    caps.setCapability("noReset", true);
	        // Instantiate Appium Driver		
	        AppiumDriver<MobileElement> driver = null;	
	        
	        try {		
	            // Initialize driver		
	            driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);		
	            System.out.println("Calculator is open");
	            
	        } catch (MalformedURLException e) {		
	            System.out.println(e.getMessage());
		
	        }
	        
	        driver.findElementByXPath("//*[@resource-id='com.android.calculator2:id/digit_8']").click();
	        driver.findElementByXPath("//*[@resource-id='com.android.calculator2:id/op_mul']").click();
	        driver.findElementByXPath("//*[@resource-id='com.android.calculator2:id/digit_5']").click();
	        MobileElement result = driver.findElementByXPath("//*[@resource-id='com.android.calculator2:id/result']");
	        System.out.println("Result:- " +result.getText());
	    }
		
		 
	}
