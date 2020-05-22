Feature: Order
  Scenario: Go to tiki page and order a item then go to cart check correct order
    Given Tiki homepage showing home page
    When User click on product image
    And User click to buy a item
    And User go to cart
    Then Item added is displayed on cart
