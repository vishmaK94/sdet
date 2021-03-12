@SuiteCRM
Feature: Suite CRM Activities

  @tag1
  Scenario: Open the homepage and count the number of the dashlets on the page.
    Given User Open browser to the alchemy CRM to login
    And Count the number of Dashlets on the homepage
    Then Print the number and title of each Dashlet into the console
    Then Close the browser
    
  @tag2
  Scenario: Open the Leads page and add multiple lead accounts using values passed fromFeature file
    Given User Open browser to the alchemy CRM to login
    Then Navigate to Create Lead from Sales
    And Fill in the necessary details to create lead accounts and save
    Then Navigate to the View Leads page to see results
    Then Close the browser

   
