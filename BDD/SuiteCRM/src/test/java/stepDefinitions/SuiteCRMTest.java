package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class SuiteCRMTest {

	
WebDriver driver;
    
	//Goal-1
	@Given("^User Open browser to the alchemy CRM to login$")
	public void loginalchemyCRM() throws Throwable {
	
		System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://alchemy.hguy.co/crm");
		WebElement user = driver.findElement(By.id("user_name"));	  
		WebElement pass = driver.findElement(By.id("username_password"));
		user.sendKeys("admin");
		pass.sendKeys("pa$$w0rd");
		driver.findElement(By.id("bigbutton")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
		
	}
	
	@And("^Count the number of Dashlets on the homepage$")
	public void numberofdashlets() throws Throwable{
		
		List<WebElement> dashlets = driver.findElements(By.className("dashlet-title"));
		System.out.println("No. of Dashlets on Homepage -" + dashlets.size());
		
	}
		
	@Then("^Print the number and title of each Dashlet into the console$")
	public void printeachdashlets() throws Throwable {		
		
		List<WebElement> dashlets = driver.findElements(By.className("dashlet-title"));
		dashlets.size();
		for(WebElement dashlet:dashlets) {
			
			System.out.println(dashlet.getText());
			
		}
		
	}
	
	//Goal-2
	@Then("^Navigate to Create Lead from Sales$")
	public void navigatecreatelead() throws Throwable{
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("grouptab_0"))).perform();
		driver.findElement(By.id("moduleTab_9_Leads")).click();	
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='actionMenuSidebar']/ul/li[1]")).click();		
	}
		
	@And("^Fill in the necessary details to create lead accounts and save$")
	public void createleadsandsave() throws Throwable {	
		
		WebElement element = driver.findElement(By.id("first_name"));
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.visibilityOf(element)); 
		element.sendKeys("FCucumberTest1");
		driver.findElement(By.id("last_name")).sendKeys("LCucumberTest1");
		driver.findElement(By.xpath("//*[@id='SAVE']")).click();
		Thread.sleep(2000);
		
	}
	
	@Then("^Navigate to the View Leads page to see results$")
	public void viewleads() throws Throwable{
		
		driver.findElement(By.xpath("//*[@id='actionMenuSidebar']/ul/li[3]")).click();	
		WebElement element = driver.findElement(By.xpath("//*[@title='Filter']"));
		WebDriverWait wait = new WebDriverWait(driver, 30); 
		wait.until(ExpectedConditions.visibilityOf(element)); 
		element.click();
		WebElement name = driver.findElement(By.xpath("//*[@id='first_name_advanced']"));
		Thread.sleep(1000);	
		name.clear();
		name.sendKeys("FCucumberTest1");
		
	}
	

	@Then("^Close the browser$")	
    public void closeTheBrowser() throws Throwable {	
        driver.close();
    }
	
}
