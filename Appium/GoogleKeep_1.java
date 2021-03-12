package GoogleTasksandKeep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class GoogleKeep_1 {
	
	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void beforeclass() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appserver, caps);
		Thread.sleep(2000);
	}
	
	@Test
	public void addtasktestcase() {
		
		//Click the Create New Note button to add a new Note.
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='New text note']").click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//Add a title for the note and add a small description.
		driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/edit_note_text']").sendKeys("Goal: Use the Google Keep app to add a note.");
		driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/editable_title']").sendKeys("Task1");
	
		//Press the back button
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		
		//Assertion to ensure that the note was added.
		String note1 = driver.findElementByXPath("//android.widget.TextView[@text='Task1']").getText();
		String note2 = driver.findElementByXPath("//android.widget.TextView[@text='Goal: Use the Google Keep app to add a note.']").getText();
		
		Assert.assertEquals(note1, "Task1");
		Assert.assertEquals(note2, "Goal: Use the Google Keep app to add a note.");
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	

}
