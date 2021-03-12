package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Alertteststeps {
	Alert alert;
	WebDriver driver;
	
	@Given("^User is on the page$")
	public void homepage() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.training-support.net/selenium/javascript-alerts");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);			
	}
		
	@When("^User clicks the Simple Alert button$")
	public void simplealert() throws Throwable{
		
		driver.findElement(By.cssSelector("#simple")).click();
		
	}
	
	@When("^User clicks the Confirm Alert button$")
	public void confrimalert() throws Throwable{
		
		driver.findElement(By.cssSelector("#confirm")).click();
		
	}
	
	@When("^User clicks the Prompt Alert button$")
	public void promptalert() throws Throwable{
		
		driver.findElement(By.cssSelector("#prompt")).click();
		
	}
	
	@Then("^Alert opens$")
	public void alertoptionswitch() throws Throwable{
		
		alert = driver.switchTo().alert();
		
	}

	@And("^Read the text from it and print it$")
	public void readtext() throws Throwable{
		
		 System.out.println("Alert: " + alert.getText());
		
	}
	
	@And("^Read the result text$")
	public void readresulttext() throws Throwable{
		
		String result = driver.findElement(By.id("simple")).getText();
		System.out.println("Result Text: " + result);
		
	}
	
	@And("^Write a custom message in it$")
	public void customemessagepropmt() throws Throwable{
		
		 alert.sendKeys("Test Message");
		
	}
	
	@And("^Close the alert$")
	public void closealert() throws Throwable{
		
		 alert.accept();
		
	}
	
	@And("^Close the alert with Cancel$")
	public void closealertwithcancel() throws Throwable{
		
		 alert.dismiss();
		
	}
	
    @And("^Close Browser$")	
    public void closeBrowser() {	
        driver.close();	
    }
	
}
