package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session3_Activity1 {
	
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void lanuchdevice() throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appserver,caps);	
        wait = new WebDriverWait(driver, 5);
	}
	
	@Test
	public void startnewmessage() {
		
		driver.findElementById("start_new_conversation_button").click();
		
		//MobileElement enternumber = driver.findElementByXPath("//*[@resource-id='com.google.android.apps.messaging:id/recipient_text_view']");
		//MobileElement enternumber = driver.findElementByXPath("//*[@text='Type a name, phone number, or email']");
		//wait = new WebDriverWait(driver, 5);
		//enternumber.sendKeys("9931299112");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String enternumber = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
		driver.findElement(MobileBy.AndroidUIAutomator(enternumber)).sendKeys("9931299112");		
		
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.messaging:id/contact_picker_create_group']").click();
	    String done = "resourceId(\"com.google.android.apps.messaging:id/action_confirm_participants\")";    	
        driver.findElement(MobileBy.AndroidUIAutomator(done)).click();
        
		String entermessage = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
	    MobileElement compose = driver.findElement(MobileBy.AndroidUIAutomator(entermessage));	    	
	    compose.sendKeys("Hello from Appium");         	
        
	    driver.findElementByXPath("//*[@resource-id='com.google.android.apps.messaging:id/send_message_button_icon']").click();
	    
		String textmessage = driver.findElementByXPath("//*[@resource-id='com.google.android.apps.messaging:id/message_text']").getText();
		System.out.println(textmessage);
		Assert.assertEquals(textmessage, "Hello from Appium");		
	}
	

    @AfterClass	
    public void afterClass() {	
        driver.quit();	
    }
	
}
