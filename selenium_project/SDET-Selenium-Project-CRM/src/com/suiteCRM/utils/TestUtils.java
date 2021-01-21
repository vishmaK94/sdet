package com.suiteCRM.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TestUtils {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public boolean isElementClickable(WebElement element) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void waitForElementVisibility(WebElement element, int seconds) {
		try {
			wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForSeconds(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Exception in waiting for seconds");
			e.printStackTrace();
		}
	}
	
	public void scrollToView(WebElement element) {
		try {
			JavascriptExecutor jsEx = (JavascriptExecutor) driver;
			jsEx.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Unable to scroll to element");
			e.printStackTrace();
		}
	}
	
	public void setUp() {
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\VishmaKumar\\Downloads\\vishma\\SM\\Java\\jars\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.get("https://alchemy.hguy.co/crm/");
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void login() {
		try {
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
			
			driver.findElement(By.id("bigbutton")).click();
			
			wait = new WebDriverWait(driver, 20);
			WebElement homePageEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bootstrap-container")));
			
			Assert.assertEquals(homePageEl.isDisplayed(), true);
			System.out.println("Homepage is displayed!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
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
