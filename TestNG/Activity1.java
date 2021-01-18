package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VishmaKumar\\Downloads\\vishma\\SM\\Java\\jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.get("https://www.training-support.net/");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void activity1Test() {
		try {
			String pageTitle = driver.getTitle();
			System.out.println("Page title is : "+pageTitle);
			Assert.assertEquals(pageTitle, "Training Support");
			
			driver.findElement(By.id("about-link")).click();
			
			String newPageTitle = driver.getTitle();
			System.out.println("New page title : "+newPageTitle);
			Assert.assertEquals(newPageTitle, "About Training Support");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown() {
		try {
			if(driver!=null) {
				driver.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
