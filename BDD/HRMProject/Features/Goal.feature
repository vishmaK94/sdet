@HRMProject
Feature: Test HRM System

  @tag1
  Scenario: To create a job vacancy for “DevOps Engineer”
    Given User Open OrangeCRMPage and login
    Then Navigate to the 'Recruitment' page
    And Click on the 'Vacancies' menu item to navigate to the vacancies page
    Then Click on the 'Add' button to navigate to the 'Add Job Vacancy' form
    And Fill out the necessary details
    Then Verify that the vacancy was created
    Then User Close the browser

  @tag2
  Scenario: Title of your scenario outline
    Given User Open OrangeCRMPage and login
    Then Navigate to the 'Recruitment' page to add candidate
    And  fill in the details of the candidate
    Then Upload a resume to the form and click save
    And Navigate back to the Recruitments page to confirm candidate entry
    Then User Close the browser