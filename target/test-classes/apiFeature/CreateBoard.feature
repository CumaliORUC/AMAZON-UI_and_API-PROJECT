
Feature: Trello_testi
@amazon1
  Scenario: Create_board
    When POST request for create board
    Then  Assert status code 200
    And Assert board name