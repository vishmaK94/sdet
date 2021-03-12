package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	
    WebDriver driver;
    
	
	@Given("^User is on Google Home Page$")
	public void userisongooglehomepage() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);			
	}
	
	@When("^User types in Cheese and hits ENTER$")
	public void usertypescheeseandhitenter() throws Throwable{
		
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
		
	}
	
	@Then("^Show how many search results were shown$")
	public void searchresult() throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver,20);		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();    	
        System.out.println("Number of results found: " + resultStats);
	}
	
    @And("^Close the browser$")	
    public void closeTheBrowser() throws Throwable {	
        driver.close();
    }
	
}
