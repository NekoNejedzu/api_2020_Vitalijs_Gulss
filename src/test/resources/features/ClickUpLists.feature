Feature: Trello Lists
  This is very explaining description

  @CreatedNewList
  Scenario: This scenario will fetch folder and return ID and NAME
    Given User has Trello board with id "15131858"
    When I verify ID and name
    Then Delete created folder