@Login
Feature: As a Zenity collaborator I want to login so that I could access the intranet

  Scenario Outline: Login with valid credentials
    Given user is on the login page
    When  user is logging-in with "<username>" and "<password>"
    Then  he should be on the home page with a welcome message

    Examples:
    | username          | password        |
    | test8@yopmail.com | Cacahuette9102  |