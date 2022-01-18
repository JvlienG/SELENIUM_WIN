@Multiple
  Feature: As bot I want to create multiple account

    Scenario Outline: I want to create <number>
      Given user is on the login page
      When user create all accounts
      Then he should be on page for account activation

      Examples:
      |number |
      |2      |