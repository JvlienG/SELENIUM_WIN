
Feature: As user I want to log to my account

  @Login
  Scenario Outline: Login with valid credentials
    Given user is on the login page
    When  user is logging-in with "<username>" and "<password>"
    Then  he should be on the home page with a welcome message

    Examples:
    | username          | password        |
    | test8@yopmail.com | Cacahuette9102  |

  @LoginEx
  Scenario: Login with valid credentials
    Given user is on the login page
    When  user is logging-in with the data from Excel
    Then  he should be on the home page with a welcome message