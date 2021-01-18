package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
	
	WebDriver driver = null;
	
	@BeforeClass(alwaysRun = true)
	public void setUp() {
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VishmaKumar\\Downloads\\vishma\\SM\\Java\\jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.get("https://www.training-support.net/selenium/target-practice");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(groups = {"HeaderTests", "ButtonTests"})
	public void getTitle() {
		try {
			String pageTitle = driver.getTitle();
			System.out.println("Page title is : "+pageTitle);
			Assert.assertEquals(pageTitle, "Target Practice");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups = {"HeaderTests"})
	public void headerTest1() {
		try {
			String thirdHeader = driver.findElement(By.id("third-header")).getText().trim();
			Assert.assertEquals(thirdHeader, "Third header");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(groups = {"HeaderTests"})
	public void headerTest2() {
		try {
			String fifthHeaderColor = driver.findElement(By.tagName("h5")).getCssValue("color");
			//System.out.println(fifthHeaderColor);
			String fifthHeaderExpColor = "rgb(33, 186, 69)";
			Assert.assertEquals(fifthHeaderColor, fifthHeaderExpColor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(groups = {"ButtonTests"})
	public void buttonTest1() {
		try {
			String oliveText = driver.findElement(By.className("olive")).getText().trim();
			Assert.assertEquals(oliveText, "Olive");				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(groups = {"ButtonTests"})
	public void buttonTest2() {
		try {
			String tealColorActual = driver.findElement(By.className("teal")).getCssValue("color");
			String tealColorExp = "rgb(0,128,128)";
			Assert.assertEquals(tealColorActual, tealColorExp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(alwaysRun = true)
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
