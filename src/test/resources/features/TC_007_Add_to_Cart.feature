
Feature: US_006_ Add to Cart
  Scenario: User should be able to choose random products and add to cart
    When Success Login
    Given Click to search box
    And   Search "product_name"
    And   Select a products random
    Then  Click to Add Cart

