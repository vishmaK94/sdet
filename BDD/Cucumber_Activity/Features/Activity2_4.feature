#Sample Feature Definition Template
@activity2_4
Feature: Login Test

  @LoginTest
  Scenario: Testing Login without Examples
    Given User is on Login page
    When User enters "admin" and "password"
    Then Read the page title and confirmation message
    And Close the Browser