
Feature: As user I want to search an article
  @Search
  Scenario Outline: Search an article on the site
    Given user is on home page
    When user do a research for "<article>"
    Then he should be on the result page matching with "<article>"

    Examples:
    | article |
    | ps5     |

  @SearchEx
  Scenario: Search an article on the site
    Given user is on home page
    When user do a research for article from Excel data
    Then he should be on the result page matching with research