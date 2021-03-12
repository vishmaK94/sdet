package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HRMTest {

WebDriver driver;
    
	//Goal-1
	@Given("^User Open OrangeCRMPage and login$")
	public void OrangeCRMPage() throws Throwable {
	
	System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/orangehrm");
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
	driver.findElement(By.id("txtUsername")).sendKeys("orange");
	driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
	driver.findElement(By.id("btnLogin")).click();
	driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}
	
	@Then("^Navigate to the 'Recruitment' page$")
	public void recruitmentpage() throws InterruptedException {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		
		Thread.sleep(2000);
	}
	
	@And("^Click on the 'Vacancies' menu item to navigate to the vacancies page$")
	public void vacanciespage() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver,20);			
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("menu_recruitment_viewJobVacancy")));	
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();	
		
	}
	
	@Then("^Click on the 'Add' button to navigate to the 'Add Job Vacancy' form$")
	public void addjobvacancypage() {
		driver.findElement(By.xpath("//input[@value='Add']")).click();		
	}
	
	@And("^Fill out the necessary details$")
	public void fillnecessarydetails() throws InterruptedException {
		//Select Job Title - Deveops Engineer
		WebElement jobtitle = driver.findElement(By.id("addJobVacancy_jobTitle"));
		jobtitle.click();
		Select drpcompany = new Select(jobtitle);
		drpcompany.selectByIndex(3);
		
		//Add Vacancy 
		driver.findElement(By.id("addJobVacancy_name")).sendKeys("Test HRM21");
		
		//Select Hiring Manager
		String searchUserXpath = "//input[@id='addJobVacancy_hiringManager']";
		String optionXpath = "//html/body/div[4]/ul/li";
		driver.findElement(By.xpath(searchUserXpath )).sendKeys("Dheeraj");
		driver.findElement(By.xpath(optionXpath )).click();
		Thread.sleep(50);		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@value='Save']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
		Thread.sleep(3000);
	}
	
	@Then("^Verify that the vacancy was created$")	
    public void verfiyvacancycreated() throws Throwable {	
		WebElement jobtitle = driver.findElement(By.xpath("//select[@id='addJobVacancy_jobTitle']/option[4]"));
		WebElement jobvacancy = driver.findElement(By.xpath("//label[@id='addJobVacancy_name']"));
		WebElement hiringmngr = driver.findElement(By.id("addJobVacancy_hiringManager"));
		System.out.println("Job Title-" +jobtitle.getText());
		System.out.println("Vacancy Name-"+jobvacancy.getText());
		System.out.println("Hiring Manager- "+hiringmngr.getText());
    }
	
	//Goal -2
	@Then("^Navigate to the 'Recruitment' page to add candidate$")
	public void recruitmentpageaddcandidate() throws InterruptedException {
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
	}
	
	@And("^fill in the details of the candidate$")
	public void filldetailstoaddcandidate() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='Add']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("FirstTestHRM5");
		Thread.sleep(100);
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("LastTestHRM5");
		Thread.sleep(100);
		driver.findElement(By.id("addCandidate_email")).sendKeys("testhrm4@gmail.com");
		Thread.sleep(2000);
		
	}
	
	@Then("^Upload a resume to the form and click save$")
	public void uploadresume() throws InterruptedException {
		WebElement uploadElement = driver.findElement(By.id("addCandidate_resume"));
		uploadElement.sendKeys("C:\\Users\\UdayVerma\\Desktop\\SDET\\IBM_SDET\\HRMProject\\Docs\\Resume.doc");
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@value='Save']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Element.click();
		Thread.sleep(2000);	
	}

	@And("^Navigate back to the Recruitments page to confirm candidate entry$")
	public void navigaterecruitementpage() throws InterruptedException {
		
		driver.findElement(By.id("menu_recruitment_viewCandidates")).click();
		Thread.sleep(2000);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.id("resultTable"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(2000);	    		
		System.out.println(driver.findElement(By.xpath("//table/thead")).getText());	
		System.out.println(driver.findElement(By.xpath("//table/thead/tbody/tr[1]")).getText());	
				
	}
	
	@Then("^User Close the browser$")	
    public void closeTheBrowser() throws Throwable {	
        driver.close();
    }
	
	
	
}
