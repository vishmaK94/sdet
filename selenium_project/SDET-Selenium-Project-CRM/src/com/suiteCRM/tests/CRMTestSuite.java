package com.suiteCRM.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRMTestSuite {
	
	WebDriver driver = null;
	WebDriverWait wait = null;	
	
	boolean isElementClickable(WebElement element) {
		try {
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	void waitForElementVisibility(WebElement element, int seconds) {
		try {
			wait = new WebDriverWait(driver, seconds);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	void waitForSeconds(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Exception in waiting for seconds");
			e.printStackTrace();
		}
	}
	
	void scrollToView(WebElement element) {
		try {
			JavascriptExecutor jsEx = (JavascriptExecutor) driver;
			jsEx.executeScript("arguments[0].scrollIntoView(true);", element);
		} catch (Exception e) {
			System.out.println("Unable to scroll to element");
			e.printStackTrace();
		}
	}
	
	@BeforeClass(alwaysRun = true)
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
	/*
	@Test(priority = 1)
	public void verifyTitle() {
		try {
			String pageTitleActual = driver.getTitle();
			String pageTitleExpected = "SuiteCRM";
			
			Assert.assertEquals(pageTitleActual, pageTitleExpected);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 2)
	public void headerImageURL() {
		try {
			String headerImageUrl = driver.findElement(By.xpath("//a[@title='SuiteCRM']")).getAttribute("href");
			System.out.println("Header image URL : "+headerImageUrl);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 3)
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
	*/
	@Test(priority = 4, enabled = false)
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
	/*
	@Test(priority = 5)
	public void navigationMenuColor() {
		try {
			login();

			String navMenuColor = driver.findElement(By.id("toolbar")).getCssValue("color");
			System.out.println("The navigation menu color is : "+navMenuColor);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6)
	public void activitiesMenu() {
		try {
			login();
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
	
	@Test(priority = 7)
	public void readAdditionalInfo() {
		try {
			login();
			
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
			driver.findElement(By.id("moduleTab_9_Leads")).click();
			
			waitForSeconds(5);
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'Leads')]")), 10);
						
			driver.findElement(By.xpath("//div[@class='actionmenulink' and text()='Create Lead']")).click();
			
			waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'CREATE')]")), 10);
			
			String firstName = "Azhar";
			String lastName = "Mohd";
			//entering details for a new lead
			Select sel = new Select(driver.findElement(By.id("salutation")));
			sel.selectByValue("Mr.");
			driver.findElement(By.id("first_name")).sendKeys(firstName);
			driver.findElement(By.id("last_name")).sendKeys(lastName);
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
	
	@Test(priority = 8)
	public void traversingTables() {
		
		login();
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
		driver.findElement(By.id("moduleTab_9_Accounts")).click();
		
		waitForSeconds(5);
		waitForElementVisibility(driver.findElement(By.xpath("//h2[contains(text(),'Accounts')]")), 10);
	
		List<WebElement> accountsTableOddListRows = driver.findElements(By.xpath("//table[@class='list view table-responsive']/tbody/tr[@class='oddListRowS1']"));
		try {
			for(int i=0; i<5; i++) {
				String name = accountsTableOddListRows.get(i).findElement(By.xpath("//td[@field='name']/b/a")).getText().trim();
				System.out.println("Name "+(i+1)+": "+name);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The table does not have 5 elements");
			e.printStackTrace();
		}		
		
	}*/
	
	@Test(priority = 9)
	public void traversingTables2() {
		try {
			login();
			
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
					System.out.println("Name "+(i+1)+": "+name+" | User : "+user);				
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
