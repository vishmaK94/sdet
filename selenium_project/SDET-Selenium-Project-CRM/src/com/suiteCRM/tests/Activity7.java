package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity7 extends TestUtils{
		
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
	public void readAdditionalInfo() {
		try {
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
			driver.findElement(By.id("moduleTab_9_Leads")).click();
			
			waitForSeconds(5);
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'Leads')]")), 10);
						
			driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")).click();
			
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'CREATE')]")), 10);
			
			String firstName = "Misal";
			String lastName = "Paav";
			//entering details for a new lead
			Select sel = new Select(driver.findElement(By.id("salutation")));
			sel.selectByValue("Mr.");
			WebElement firstNameEl = driver.findElement(By.id("first_name"));
			firstNameEl.clear();
			firstNameEl.sendKeys(firstName);
			WebElement lastNameEl = driver.findElement(By.id("last_name"));
			lastNameEl.clear();
			lastNameEl.sendKeys(lastName);
			driver.findElement(By.id("department")).sendKeys("Accounting");
			driver.findElement(By.id("EditView_account_name")).sendKeys("WestPac");
			driver.findElement(By.id("phone_mobile")).sendKeys("9876543210");
			driver.findElement(By.id("SAVE")).click();
			
			driver.findElement(By.xpath("//div[contains(text(),'View Leads')]")).click();
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'Leads')]")), 10);
			
			//filtering for newly created lead
			driver.findElement(By.xpath("//a[@title='Filter']")).click();
			//WebElement advanceFilterTab = driver.findElement(By.xpath("//a[contains(text(),'Advanced Filter']"));
			//scrollToView(advanceFilterTab);
			//advanceFilterTab.click();
			driver.findElement(By.id("first_name_advanced")).sendKeys(firstName);
			driver.findElement(By.id("last_name_advanced")).sendKeys(lastName);
			WebElement searchBtnAdvanced = driver.findElement(By.id("search_form_submit_advanced")); 
			scrollToView(searchBtnAdvanced);
			searchBtnAdvanced.click();
			
			waitForSeconds(5);
			
			WebElement additionalInfo = driver.findElement(By.xpath("//table[@class='list view table-responsive']/tbody/tr/td[10]"));
			additionalInfo.click();
			String onScreenMobileNo = driver.findElement(By.xpath("//div/span[@class='phone']")).getText().trim();
			System.out.println("The phone number is : "+onScreenMobileNo);
			
			//clearing filter
			driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[5]")).get(0).click();
						
			
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
