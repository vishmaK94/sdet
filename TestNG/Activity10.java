package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity10 {

	WebDriver driver = null;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		try {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\VishmaKumar\\Downloads\\vishma\\SM\\Java\\jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();
			driver.get("https://www.training-support.net/selenium/sliders");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	public void middleValue() {
		try {
			driver.findElement(By.id("slider")).sendKeys("admin");
			driver.findElement(By.id("password")).sendKeys("password");
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			
			String expectedMessage = "Welcome Back, admin";
			String actualMessage = driver.findElement(By.id("action-confirmation")).getText().trim();
			Assert.assertEquals(actualMessage, expectedMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		try {
			if (driver != null) {
				driver.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
