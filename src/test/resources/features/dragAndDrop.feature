Feature: Drag and Drop Functionality

  Scenario: User can drag an element to a target
    Given I am on the droppable page
    When I perform the drag and drop action
    Then the element should be dropped successfully

