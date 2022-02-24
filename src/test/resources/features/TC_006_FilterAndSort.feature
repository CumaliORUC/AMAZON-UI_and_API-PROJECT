Feature: US_005_ Filter and Sort

  Scenario: User should be able to use filters and sorting in product listing process
    Given Success Login
    When  Click to search box
    And   Search "product_name"
    Then  Click to filter and sort box
    And   Select any filter
    Then  Close the page

