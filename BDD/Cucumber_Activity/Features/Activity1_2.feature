#Sample Feature Definition Template
@activity1_2
Feature: Login Test

  @tag1
  Scenario: Testing Login
    Given User is on Login page
    When User enters username and password
    Then Read the page title and confirmation message
    And Close the Browser