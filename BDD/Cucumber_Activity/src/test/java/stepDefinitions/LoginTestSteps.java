package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {

	WebDriver driver;
	@Given("^User is on Login page$")
	public void userisonloginpage() throws Throwable{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/login-form");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	@When("^User enters username and password$")
	public void userlogin() throws Throwable{
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void activyt4and5steps(String username, String password) throws Throwable{
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	@Then("^Read the page title and confirmation message$")
	public void readpagetitle() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver,20);		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        String pageTitle = driver.getTitle();    	
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();        
	
        //Print the page title and heading	
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);
	}   
	
    @And("^Close the Browser$")	
    public void closeBrowser() {	
        driver.close();
	
    }
	
}
