package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity6 extends TestUtils{
		
	@BeforeClass(alwaysRun = true)
	@Override
	public void setUp() {
		super.setUp();
	}
	
	@Test(priority = 1)
	@Override
	public void login() {
		super.login();
	}
	
	@Test(priority = 2)
	public void activitiesMenu() {
		try {
			WebElement activityMenu = driver.findElement(By.id("grouptab_3"));
			String activityText = activityMenu.getText();
			System.out.println(activityText);
			
			boolean isActivityMenuDisplayed = activityMenu.isDisplayed();
			boolean isActivityMenuClickable = isElementClickable(activityMenu);
			
			Assert.assertEquals(isActivityMenuDisplayed, true);
			Assert.assertEquals(isActivityMenuClickable, true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterClass(alwaysRun = true)
	@Override
	public void tearDown() {
		super.tearDown();
	}
}
