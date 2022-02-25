
Feature: US_009_DeleteProductShoopingList
  Scenario: User should be able delete products in shoppingList
    Given Success Login
    Then  Hold on the Sign in box
    And   Go to your shoopping list
    #Onceden sepette 2 veya daha fazla ürün olmalıdır.
    #Sepette 2 ve daha fazla ürün var ise yukarıdan aşağıya sıra numarası ile delete edilebilir.
    Then  Delete "productNumber" product
