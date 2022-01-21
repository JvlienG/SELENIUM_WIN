Feature:

  @LoginSearchSelectLogout
  Scenario: User login, search an article, select the first article and logout
    Given user is on the login page
    When user login with Excel data
    And user search an article with Excel data
    And user select the first article
    And user logout
    Then he should be disconnect