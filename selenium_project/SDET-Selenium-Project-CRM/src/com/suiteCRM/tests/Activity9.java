package com.suiteCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.suiteCRM.utils.TestUtils;

public class Activity9 extends TestUtils{
		
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
	public void traversingTables2() {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
			driver.findElement(By.id("moduleTab_9_Leads")).click();
			
			waitForSeconds(30);
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'Leads')]")), 20);
			
			waitForSeconds(20);
			try {
				//clearing filter
				WebElement clearFilterBtn = driver.findElements(By.xpath("//table[@class='paginationTable']/tbody/tr/td/ul[5]")).get(0);
				clearFilterBtn.click();
			} catch (ElementNotInteractableException e) {
				System.out.println("The table is not filtered");
			} catch(IndexOutOfBoundsException e) {
				try {
					System.out.println("No results found page. Wrong search data was entered");
					WebElement clearFilterBtn = driver.findElements(By.xpath("//li[@class='sugar_action_button desktopOnly']")).get(0);
					clearFilterBtn.click();
				} catch (Exception e2) {
					e2.printStackTrace();
				}				
			}
						
			//List<WebElement> leadsTableRows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr"));
			String leadTableXpath = "//table[@class='list view table-responsive']/tbody/tr[";
			try {
				for(int i=1; i<=10; i++) {
					
					/*String name = leadsTableRows.get(i).findElement(By.xpath("//td[@field='name']/b/a")).getText().trim();
					String user = leadsTableRows.get(i).findElement(By.xpath("//td[@field='assigned_user_name']/a")).getText().trim();*/
					
					String nameXpath = leadTableXpath+i+"]/td[@field='name']/b/a";
					String userXpath = leadTableXpath+i+"]/td[@field='assigned_user_name']/a";
					String name = driver.findElement(By.xpath(nameXpath)).getText().trim();
					String user = driver.findElement(By.xpath(userXpath)).getText().trim();
					System.out.println("Name "+i+": "+name+" | User : "+user);				
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("The table does not have 10 elements");
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
