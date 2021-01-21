package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity3 extends TestUtils{
	
	@BeforeClass(alwaysRun = true)
	@Override
	public void setUp() {
		super.setUp();
	}
	
	@Test(priority = 1)
	public void copyRightText() {
		try {
			String copyRightText1 = driver.findElement(By.id("admin_options")).getText().trim();
			String copyRightText2 = driver.findElement(By.id("powered_by")).getText().trim();
			
			System.out.println("Copyright text 1 : "+copyRightText1);
			System.out.println("Copyright text 2 : "+copyRightText2);
			
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
