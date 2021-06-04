Feature: Home page feature

  Background:
    Given user is on the home page
    And user navigates to the For Drivers page

  Scenario: For Drivers page title validation
    When user gets the title of the For Drivers page
    Then the For Drivers page title should be "For Drivers - Drivewyze"

  Scenario: verify video play function
    When user clicks on the play button on the video
    Then user clicks on the stop button