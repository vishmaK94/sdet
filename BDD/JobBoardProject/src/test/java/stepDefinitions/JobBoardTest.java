package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class JobBoardTest {

WebDriver driver;
WebDriverWait wait;    
	String user = "yashpaltest20";
	String email = "yashpalwa20@gmail.com";
	//Goal-1
	@Given("^User Open browser and login to job board site$")
	public void loginjobboard() throws Throwable {
	
	String pass = "pa$$w0rd";
	System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
	driver.findElement(By.id("user_login")).sendKeys("root");
	driver.findElement(By.id("user_pass")).sendKeys(pass);
	driver.findElement(By.id("wp-submit")).click();
	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	@And("^User Locate the left hand menu and click the menu item that says 'Users'$")
	public void clicklefthandmenuuser() throws Throwable{
		
		WebDriverWait wait = new WebDriverWait(driver,20);		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#wp-admin-bar-site-name")));
		driver.findElement(By.cssSelector("#menu-users")).click();
		
	}
	
	@When("^User Locate the 'Add New' button and click it$")
	public void clickaddnewbutton() throws Throwable {
		
		//driver.findElement(By.cssSelector("#wpbody-conten")).click();
		driver.findElement(By.xpath("//*[@id='wpbody-content']/div[4]/a")).click();
       
	}
	
	@Then("^User Fill in the necessary details$")
	public void fillindetails() throws Throwable {		
		driver.findElement(By.id("user_login")).sendKeys(user);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@And("^User Click the 'Add New User' button$")
	public void clickaddnewuserbutton() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.id("createusersub"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(1000);
		Element.click();
		
	}
	
	@And("^User Verify that the user was created$")
	public void verifyusercreated() throws Throwable {
		
		WebElement search = driver.findElement(By.id("user-search-input"));
		search.click();
		search.sendKeys(user);
		driver.findElement(By.id("search-submit")).click();
		String verifyuser = driver.findElement(By.id("the-list")).getText();
		System.out.println(verifyuser);
		Thread.sleep(1000);
		
	}
	
	//Goal-2
	@Then("^User Find the Keywords search input field on jobs page$")
	public void findandsearchinput() throws Throwable{
		
		driver.findElement(By.id("menu-item-24")).click();
		WebDriverWait wait = new WebDriverWait(driver,20);		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("search_keywords")));
		
	}
	
	@And("^User Type in keywords to search for jobs and change the Job type$")
	public void searchjob() throws Throwable {
		
		driver.findElement(By.id("search_keywords")).sendKeys("Developer");
		driver.findElement(By.id("post-7")).click();
	}
	
	@Then("^User Find the filter using XPath and filter job type to show only 'Full Time' jobs$")
	public void filterjobtype() throws Throwable {		
		
		Thread.sleep(1000);
		driver.findElement(By.id("job_type_freelance")).click();
		driver.findElement(By.id("job_type_internship")).click();
		driver.findElement(By.id("job_type_part-time")).click();
		driver.findElement(By.id("job_type_temporary")).click();	
		Thread.sleep(1000);
	}
	
	@And("^User Find a job listing using XPath and it to see job details$")
	public void findjoblisting() throws Throwable {
		
		driver.findElement(By.xpath("//*[@id='post-7']/div/div/ul/li[1]")).click();	
		
	}
	
	@Then("^User Find the title of the job listing using XPath and print it to the console$")
	public void findjobandprint() throws Throwable {
	
		String jobtitle = driver.findElement(By.className("entry-title")).getText();
		System.out.println(jobtitle);
	}
	
	@And("^User Find and Click on the 'Apply for job' button$")
	public void applyjobbuttonclick() throws Throwable {
		
		driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
		Thread.sleep(5000);
		
	}
	
	//Goal-3	
	@Then("^Go to Post a Job page$")
	public void postjobpage() throws Throwable{
		
		driver.findElement(By.cssSelector("#menu-item-26")).click();
		
	}
	
	@And("^Read job information from the Feature file table and fill in the details$")
	public void enterdetails(DataTable testData) throws Throwable {
		
		List<String> details = testData.asList(String.class);
		driver.findElement(By.id("create_account_email")).sendKeys(details.get(0));
		driver.findElement(By.id("job_title")).sendKeys(details.get(1));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.id("job_type"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='job_description_ifr']")).sendKeys(details.get(2));
		driver.findElement(By.id("application")).sendKeys(details.get(3));
		driver.findElement(By.id("company_name")).sendKeys(details.get(4));
		//body[@data-id='job_description']
	}
	
	@Then("^Click submit$")
	public void submitjob() throws Throwable {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//input[@value='Preview']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(1000);
		Element.click();
		driver.findElement(By.id("job_preview_submit_button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='post-5']/div/a")).click();
		
	}
	
	
	@Then("^Confirm job listing is shown on page$")
	public void confirmjoblisting(DataTable table) throws Throwable {
		
		//driver.findElement(By.id("menu-item-24")).click();		
		//String job = driver.findElement(By.xpath("//*[@id='post-7']/div/div/ul/li[1]")).getText();	
		//System.out.println(job);
		try {
			List<String> values = table.asList();
			String jobTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='entry-title']"))).getText().trim();
			String jobType = driver.findElement(By.xpath("//li[text()='Full Time']")).getText().trim();
			String jobLocation = driver.findElement(By.xpath("//a[@class='google_map_link']")).getText().trim();
			String company = driver.findElement(By.xpath("//p[@class='name']/strong")).getText().trim();
			String jobDesc = driver.findElement(By.xpath("//div[@class='job_description']/p")).getText().trim();
			Assert.assertEquals(jobTitle, values.get(0));
			Assert.assertEquals(jobLocation, values.get(1));
			Assert.assertEquals(jobType, values.get(2));
			Assert.assertEquals(jobDesc, values.get(3));
			Assert.assertEquals(company, values.get(4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Goal-4
	@And("^Enter \"(.*)\" and \"(.*)\"$")
	public void enteremailandtitle(String email, String Title) throws Throwable {
		
		driver.findElement(By.id("create_account_email")).sendKeys(email);	
		driver.findElement(By.id("job_title")).sendKeys(Title);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.id("job_type"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		Thread.sleep(1000);
		
	}
	@And("^Enter \"(.*)\" and \"(.*)\" for job$")
	public void descriptionandurl(String Description, String url) throws Throwable {
				
		driver.findElement(By.xpath("//*[@id='job_description_ifr']")).sendKeys(Description);
		driver.findElement(By.id("application")).sendKeys(url);
		
	}
	@And("^Enter \"(.*)\" for job$")
	public void companyname(String Companyname) throws Throwable {
		
		driver.findElement(By.id("company_name")).sendKeys(Companyname);
		
	}	
	
	//Goal-2,3,4
	@Given("^User open browser and navigate to Alchemy Job Site$")
	public void navigatesite() throws Throwable {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\UdayVerma\\Desktop\\Mobile Automation Softwares\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/jobs/");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);	
		
	}
	
	//Goal-1,2,3,4
	@Then("^User Close the browser$")	
    public void closeTheBrowser() throws Throwable {	
        driver.close();
    }
	
}
