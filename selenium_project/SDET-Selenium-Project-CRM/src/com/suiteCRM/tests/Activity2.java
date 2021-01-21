package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity2 extends TestUtils{

	
	@BeforeClass(alwaysRun = true)
	@Override
	public void setUp() {
		super.setUp();
	}
	
	@Test(priority = 1)
	public void headerImageURL() {
		try {
			String headerImageUrl = driver.findElement(By.xpath("//a[@title='SuiteCRM']")).getAttribute("href");
			System.out.println("Header image URL : "+headerImageUrl);			
			
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
