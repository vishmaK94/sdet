#Sample Feature Definition Template
@activity1_1
Feature: First Test
  
  @Test1
  Scenario: Opening a webpage using Selenium
    Given User is on Google Home Page
    When User types in Cheese and hits ENTER
    Then Show how many search results were shown
    And Close the browser