@Select
Feature: As user I want to select an article after research

  Scenario Outline: Select the first article on the research page

    Given user is on result page for "<article>"
    When user select the first article on the page
    Then he should be on the article page

    Examples:
    | article |
    | ps5     |