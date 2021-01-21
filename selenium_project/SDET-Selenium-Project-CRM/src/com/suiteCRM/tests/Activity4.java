package com.suiteCRM.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity4 extends TestUtils{
		
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
	
	@AfterClass(alwaysRun = true)
	@Override
	public void tearDown() {
		super.tearDown();
	}
}
