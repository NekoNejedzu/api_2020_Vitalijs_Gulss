Feature: Trello Lists
  This is very explaining description

  @CreatedNewList
  Scenario: This scenario will add new list on existing board
    Given User has Trello board with id "5e3f08c70f889b817d4e260b"
    When Add a new list to board with name "Automation done"
    Then in board can be found newly created list