package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity5 extends TestUtils{
		
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
	public void navigationMenuColor() {
		try {
			String navMenuColor = driver.findElement(By.id("toolbar")).getCssValue("color");
			System.out.println("The navigation menu color is : "+navMenuColor);
			
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
