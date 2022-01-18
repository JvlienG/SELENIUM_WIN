@SearchEx
Feature: As user I want to search an article from Excel

  Scenario: Search an article on the site
    Given user is on home page
    When user do a research for article from Excel data
    Then he should be on the result page matching with research