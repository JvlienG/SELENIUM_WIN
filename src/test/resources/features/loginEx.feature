@LoginEx
Feature: As user I want to log to my account with Excel data

  Scenario Outline: Login with valid credentials
    Given user is on the login page
    When  user is logging-in with the data from Excel
    Then  he should be on the home page with a welcome message