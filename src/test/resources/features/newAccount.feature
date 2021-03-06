Feature: As frequent user I want to create an account

    @Create
    Scenario Outline:
      Given user is on the login page
      When user fill is email by "<email>"
      And validate email
      And fill password by "<password>"
      And fill nickname by "<nickname>"
      And choose gender as "<gender>"
      And fill name by "<name>"
      And fill firstname by "<firstname>"
      And fill cellphone by "<cellphone>"
      And fill birthdate by "<birth>"
      And fill adress by "<adress>"
      And fill zipCode by "<zipcode>"
      And fill city by "<city>"
      And validate inscription
      Then he should be on page for account activation

      Examples:
        | email                 | password        | nickname  | gender  | name  | firstname | cellphone   | birth       | adress                | zipcode | city               |
        | test20@yopmail.com  | zertyuiop       | Ax12357 | Male    |GUIRAL | Julien    | 0699492619  | 09/09/1998  |4 avenue Laurent Cely  | 92600   | Asnieres sur Seine |


    @Multiple
    Scenario Outline: I want to create <number> account
      Given user is on the login page
      When user create all accounts
      Then he should be on page for account activation

      Examples:
        |number |
        |2      |