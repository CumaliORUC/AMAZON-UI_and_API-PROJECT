Feature: US_004_Searching Product

  Scenario: US_004_When the user searches for a product, all listed products must contain the searched word
    When Success Login
    Given Click to search box
    And   Search "product_name"
    Then  Test all listed products must contain "product_name"
    And Close the page
