@Login
Feature: As a Zenity collaborator I want to login so that I could access the intranet

  Scenario: Login with valid credentials
    Given user is on the login page
    When  user is logging-in with test8@yopmail.com and Cacahuette9102
    Then  he should be on the home page with a welcome message