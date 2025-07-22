Feature: Window Switching

  Scenario: User can switch between browser windows
    Given I am on the W3Schools window switching page
    When I open a new window and switch to it
    Then I can verify the titles of both windows

