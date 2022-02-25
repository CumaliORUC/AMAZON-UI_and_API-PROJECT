
Feature: US_007_ Footer Links
  Scenario: User must make sure that footer links at the bottom of the home page lead to the correct page
    Given Success Login
    And   Go to bottom of page
    Then  Click the footer row no "row_no" and data no "data_no"
    #satır ve sutun nolarını ConfigReaderdan girerek çağırıyoruz.
    And Close the page
