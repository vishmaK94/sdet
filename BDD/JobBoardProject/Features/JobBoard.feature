#Sample Feature Definition Template
@JobBoardProject
Feature: Posting a job using parameterization

  @tag1
  Scenario: Visit the site’s backend and create a new user
    Given User Open browser and login to job board site
    And User Locate the left hand menu and click the menu item that says 'Users'
    When User Locate the 'Add New' button and click it
    Then User Fill in the necessary details
    And User Click the 'Add New User' button
    And User Verify that the user was created
    Then User Close the browser
    
	@tag2
  Scenario: Searching for jobs and applying to them using XPath
    Given User open browser and navigate to Alchemy Job Site
    Then User Find the Keywords search input field on jobs page
    And User Type in keywords to search for jobs and change the Job type
    Then User Find the filter using XPath and filter job type to show only 'Full Time' jobs
    And User Find a job listing using XPath and it to see job details
    Then User Find the title of the job listing using XPath and print it to the console
    And User Find and Click on the 'Apply for job' button
		Then User Close the browser
		
  @tag3
  Scenario Outline: Post a job using details passed from the Feature file
    Given User open browser and navigate to Alchemy Job Site
    Then Go to Post a Job page
    And Read job information from the Feature file table and fill in the details
    
      | hitman338@ml.com  											|
      | Test Job8																|  	  
      |	C#,Pearl  															|
			|	https://alchemy.hguy.co/jobs/post-a-job/|
			|	TestSDET8																|
			
    Then Click submit
    And User Find the Keywords search input field on jobs page
    Then Confirm job listing is shown on page
    
    @tag4
  	Scenario Outline: Rewrite activity 3 using a Scenario Outline and Examples table to post a job
    Given User open browser and navigate to Alchemy Job Site
    Then Go to Post a Job page
    And Enter "<email>" and "<Title>"
    And Enter "<Description>" and "<url>" for job
    And Enter "<Companyname>" for job
    Then Click submit
    And User Find the Keywords search input field on jobs page
    Then Confirm job listing is shown on page

    Examples: 
      | email  					| Title 							   | Description   | url  					    | Companyname  |
      | uverma101@ml.com | Application Developer | Pearl,Python  |cmod12@alchmey.com  | Alchemy      |
     

    