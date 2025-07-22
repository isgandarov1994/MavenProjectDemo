Feature: Dynamic Captcha Handling

  Scenario: User can solve the math captcha
    Given I am on the captcha page
    When I solve the math problem
    Then the form should be enabled for submission

