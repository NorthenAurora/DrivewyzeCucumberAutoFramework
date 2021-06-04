Feature: Home page feature

  Scenario: home page title validation
    Given user is on the home page
    When user gets the title of the page
    Then page title should be "Drivewyze - North America's Largest Weigh Station Bypass Service"

  Scenario: home page logo validation
    Given user is on the home page
    Then logo should present on the page

  Scenario: verify For Drivers link
    Given  user is on the home page
    Then For Drivers link should be displayed




