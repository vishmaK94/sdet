package testNGTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity9 {

	WebDriver driver = null;

	@BeforeTest(alwaysRun = true)
	public void setUp() {
		try {
			Reporter.log("Setting up the driver");
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\VishmaKumar\\Downloads\\vishma\\SM\\Java\\jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.get("https://www.training-support.net/selenium/javascript-alerts");
			driver.manage().window().maximize();			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@BeforeMethod
	public void focusOnPage() {
		try {
			Reporter.log("Focusing back to default screen");
			driver.switchTo().defaultContent();			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void simpleAlertTestCase() {
		try {
			Reporter.log("Testing the Simple Alert button");
			driver.findElement(By.id("simple")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Simple Alert says : "+alert.getText());
			Assert.assertEquals(alert.getText(), "This is a JavaScript Alert!");
			alert.accept();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void confirmAlertTestCase() {
		try {
			Reporter.log("Testing the Confirm Alert button");
			driver.findElement(By.id("confirm")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Comfirm Alert says : "+alert.getText());
			Assert.assertEquals(alert.getText(), "This is a JavaScript Confirmation!");
			alert.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void promptAlertTestCase() {
		try {
			Reporter.log("Testing the Prompt Alert button");
			driver.findElement(By.id("prompt")).click();
			Alert alert = driver.switchTo().alert();
			System.out.println("Prompt Alert says : "+alert.getText());
			Assert.assertEquals(alert.getText(), "This is a JavaScript Prompt!");
			alert.sendKeys("Sample text for Prompt Alert");
			alert.dismiss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	@AfterTest(alwaysRun = true)
	public void tearDown() {
		try {
			Reporter.log("Closing the driver");
			if(driver!=null) {
				driver.close();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
