Feature: As user logged, I want to log out
  @Logout
  Scenario: user log out
    Given user is on account page
    When user click on "log out"
    Then he should be disconnect