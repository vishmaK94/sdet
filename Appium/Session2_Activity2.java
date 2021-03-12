package Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Session2_Activity2 {

	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;
	
	@BeforeTest	
	public void desiredcapabilities() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", "com.android.calculator2.Calculator");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(appserver, caps);
		wait = new WebDriverWait(driver, 10);
	}
	
	//This should work  "//*[@text='First name']"
	
	@Test(priority=1)
	public void add() {
		
		driver.findElementById("digit_5").click();	
		driver.findElementById("op_add").click();	
		driver.findElementById("digit_9").click();		
        driver.findElementById("eq").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Sum:- " +result);
		Assert.assertEquals(result, "14");
		
	}
	
	@Test(priority=2)
	public void minus() {
		
		driver.findElementById("digit_1").click();	
		driver.findElementById("digit_0").click();
		driver.findElementById("op_sub").click();	
		driver.findElementById("digit_5").click();		
        driver.findElementById("eq").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Minus:- "+result);
		Assert.assertEquals(result, "5");
		driver.findElementById("result").clear();
	}
	
	@Test(priority=3)
	public void multiply() {
		
		driver.findElementById("digit_5").click();	
		driver.findElementById("op_mul").click();	
		driver.findElementById("digit_1").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("digit_0").click();
		driver.findElementById("eq").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Multiply:- " +result);
		Assert.assertEquals(result, "500");
		driver.findElementById("result").clear();
	}
	
	@Test(priority=4)
	public void divide() {
		
		driver.findElementById("digit_5").click();	
		driver.findElementById("digit_0").click();
		driver.findElementById("op_div").click();	
		driver.findElementById("digit_2").click();
		driver.findElementById("eq").click();
		String result = driver.findElementById("result").getText();
		System.out.println("Divide:- "+result);
		Assert.assertEquals(result, "25");
		driver.findElementById("result").clear();
	}
	
    @AfterClass
	public void afterClass() {	
        driver.quit();
	
    }
	
}
