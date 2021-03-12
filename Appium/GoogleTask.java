package GoogleTasksandKeep;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class GoogleTask {

	WebDriverWait wait;
	AndroidDriver<MobileElement> driver = null;
	
	@BeforeClass
	public void beforeclass() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "5554");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		
		URL appserver = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(appserver, caps);
		Thread.sleep(2000);
	}
	
	@Test
	public void addtasktestcase() throws InterruptedException {
		
		//To Mark Previous Task Complete and delete them if available.
		try {
			List<MobileElement> elements = (List<MobileElement>) driver.findElementsByXPath("//*[@resource-id='com.google.android.apps.tasks:id/tasks_item_completed_check']");
			
			for(MobileElement element:elements) {
				driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/tasks_item_completed_check']").click();
				
			}
			
			if(driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/completed_count']").isDisplayed()) {
				driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/action_more_options']").click();
				driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/delete_all_completed_tasks_option']").click();
				//wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//*[@text='Delete']")));
				driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
				driver.findElementByXPath("//*[@text='Delete']").click();
			}else {
				System.out.println("Hello! ");
			}
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No Tasks added currently. Adding Tasks Now ");
		}
		
		//Click button to add a new task
		Thread.sleep(5000);
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Create new task']").click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		
		//Add Task 1
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/add_task_title']").sendKeys("Complete Activity with Google Tasks");
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/add_task_done']").click();
		
		//Add Task 2
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/tasks_fab']").click();
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/add_task_title']").sendKeys("Complete Activity with Google Keep");
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/add_task_done']").click();
		
		//Add Task 3
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/tasks_fab']").click();
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/add_task_title']").sendKeys("Complete the second Activity Google Keep");
		driver.findElementByXPath("//*[@resource-id='com.google.android.apps.tasks:id/add_task_done']").click();
		
		String taskdetails1 = driver.findElementByXPath("//*[@text='Complete Activity with Google Tasks']").getText();
		String taskdetails2 = driver.findElementByXPath("//*[@text='Complete Activity with Google Keep']").getText();
		String taskdetails3 = driver.findElementByXPath("//*[@text='Complete the second Activity Google Keep']").getText();
		
		//Assertion to ensure all three tasks have been added to the list.
		Assert.assertEquals(taskdetails1, "Complete Activity with Google Tasks");
		Assert.assertEquals(taskdetails2, "Complete Activity with Google Keep");
		Assert.assertEquals(taskdetails3, "Complete the second Activity Google Keep");
		
		
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
}
