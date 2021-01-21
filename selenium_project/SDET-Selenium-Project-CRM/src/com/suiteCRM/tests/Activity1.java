package com.suiteCRM.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity1 extends TestUtils{
		
	@BeforeClass(alwaysRun = true)
	@Override
	public void setUp() {
		super.setUp();
	}

	@Test(priority = 1)
	public void verifyTitle() {
		try {
			String pageTitleActual = driver.getTitle();
			String pageTitleExpected = "SuiteCRM";
			
			Assert.assertEquals(pageTitleActual, pageTitleExpected);			
			System.out.println("Page title : "+pageTitleActual);
			
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
