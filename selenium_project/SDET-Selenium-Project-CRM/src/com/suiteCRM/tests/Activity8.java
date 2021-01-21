package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity8 extends TestUtils {

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
	public void traversingTables() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
			driver.findElement(By.id("moduleTab_9_Accounts")).click();

			waitForSeconds(5);
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'Accounts')]")), 10);
		
			String accountsTableRowsXpath = "//table[@class='list view table-responsive']/tbody/tr[@class='oddListRowS1'][";
			try {
				for (int i = 1; i <= 5; i++) {
					String nameXpath = accountsTableRowsXpath+i+"]/td[@field='name']/b/a";
					String name = driver.findElement(By.xpath(nameXpath)).getText().trim();
					System.out.println("Name " +i+" : " + name);
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("The table does not have 5 elements");
				e.printStackTrace();
			}
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
