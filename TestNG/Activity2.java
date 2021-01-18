package testNGTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver = null;

	@BeforeClass
	public void setUp() {
		try {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\VishmaKumar\\Downloads\\vishma\\SM\\Java\\jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");

			driver = new FirefoxDriver();
			driver.get("https://www.training-support.net/selenium/target-practice/");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void getTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("Page title is : "+pageTitle);
		Assert.assertEquals(pageTitle, "Target Practice");
	}
		
	@Test
	public void findBlackBtn() {
		WebElement blackBtn = driver.findElement(By.xpath("//button[@class='ui black button']"));
		WebElement bullsEye = driver.findElement(By.xpath("//div[@class='content']"));
		//Assert.assertEquals(blackBtn, blackBtn);
		Assert.assertEquals(blackBtn, bullsEye);
	}
	
	@Test(enabled = false)
	public void skipMethod1() {
		System.out.println("Skipping this method with enabled = false");
	}
	
	@Test
	public void skipMethod2() {
		throw new SkipException("Skipping this method with SkipException");
	}
	
	@AfterClass
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
