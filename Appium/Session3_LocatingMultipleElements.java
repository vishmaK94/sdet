package Activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Session3_LocatingMultipleElements {
	
    WebDriverWait wait;	
    AppiumDriver<MobileElement> driver = null;
	
    @BeforeClass	
    public void beforeClass() throws MalformedURLException {	
        // Set the Desired Capabilities	
        DesiredCapabilities caps = new DesiredCapabilities();	
        caps.setCapability("deviceName", "5554");	
        caps.setCapability("platformName", "Android");	
        caps.setCapability("appPackage", "com.android.chrome");	
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");	
        caps.setCapability("noReset", true);
		
        // Instantiate Appium Driver	
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");	
        driver = new AndroidDriver<MobileElement>(appServer, caps);	
        wait = new WebDriverWait(driver, 10);	
    }
    
    @Test	
    public void listElements() {   
	
        driver.get("https://www.training-support.net/selenium/lists");	
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.xpath("//android.widget.ListView"))); 
	
        // Find all text elements on the page	
        List<MobileElement> textItems = driver.findElementsByClassName("android.view.View");	
        for(MobileElement textItem : textItems) {	
            System.out.println(textItem.getText());		
        }
		
        // Find the inner list items of unordered list	
        List<MobileElement> uListItems = driver.findElementsByXPath("//android.widget.ListView//android.widget.ListView//android.view.View/android.widget.TextView");
        for(MobileElement uListItem : uListItems) {	
            System.out.println(uListItem.getText());	
        }	
    }    
	
    @AfterClass	
    public void afterClass() {	
        driver.quit();	
    }
	

}
