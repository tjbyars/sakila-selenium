Feature: Film creation
  Background:
    Given the driver is "chrome"
    And the page "/create/film" is loaded

  Scenario: The user submits some text
    When the user selects the "title" input
    And types "Hello, World!"
    And submits the form
    Then the URL should be "/films/{id}"
    And the film details should be displayed

  Scenario: The user submits from a dropdown
    When the user selects an option from the dropdown list
    And submits the form
    Then the URL should be "/films/{id}"
    And the film details should be displayed