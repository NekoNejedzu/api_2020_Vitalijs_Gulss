Feature: Trello Task Management
  Automates Trello task management flows

#  Scenario: Dummy scenario
#    Given Some dummy step

#    pievienot jaunu scenāriju lai pārsaukta board vārdu

  @ChangedBoardName @jfjf @papildusInfoDevelopier
  Scenario: Update Board name
    Given User has Trello board with id "5e3f08c70f889b817d4e260b"
    When user changes Trello board name to "The new name"
    Then Trello board name has been changed to "The new name"