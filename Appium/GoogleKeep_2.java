package GoogleTasksandKeep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class GoogleKeep_2 {
	
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
		
		//Adding new Note
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='New text note']").click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/edit_note_text']").sendKeys("Goal: Use the Google Keep app to add a note with a reminder");
		driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/editable_title']").sendKeys("Task2");
		
		//Setting Reminder
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Reminder']").click();
		//When the script runs in morning
		MobileElement reminder = driver.findElementByXPath("//android.widget.TextView[@text='Later today']");
		if(reminder.isDisplayed()) {
			reminder.click();
		}
		//When the script runs in Evening 
		else {		
		driver.findElementByXPath("//*[@text='Pick a date & time']").click();	
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.Spinner[1]").click();
		driver.findElementByXPath("//*[@text='Today']").click();
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.Spinner/android.widget.TextView").click();
		driver.findElementByXPath("//*[@text='Afternoon']").click();
		driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/save']").click();
		}
		
		//Adding Assertions
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		String title = driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/index_note_title']").getText();
		String note = driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/index_note_text_description']").getText();
		String reminders = driver.findElementByXPath("//*[@resource-id='com.google.android.keep:id/reminder_chip_text']").getText();
		
		Assert.assertEquals(title, "Task2");
		Assert.assertEquals(note, "Goal: Use the Google Keep app to add a note with a reminder");
		Assert.assertEquals(reminders, "Today, 6:00 PM");
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	
}
