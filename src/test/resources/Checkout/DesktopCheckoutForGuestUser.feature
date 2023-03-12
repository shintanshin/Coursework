Feature: Desktop Checkout for Guest User
  As a costumer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Proceed to checkout, final review and place order as a guest user
    Given I am an anonymous customer with the clear cookies
    And I open the "Initial home page"
    And I search for "Thinking in Java"
    And I am redirected to a "Search page"
    And Search results contain the following products
      | Thinking in Java       |
      | Thinking Java Part I   |
      | Core Java Professional |
    And I apply the following search filters
      | Price range  | 30 € +         |
      | Availability | In Stock (5)   |
      | Language     | English (17)   |
      | Format       | Paperback (22) |
    And Search results contain only the following products
      | Thinking in Java                                                  |
      | Think Java                                                        |
      | Thinking Recursively - A 20th Anniversary Edition with Java (WSE) |
      | Think Data Structures                                             |
    And I click "Add to basket button for product with name "Thinking in Java"
    And I select 'Basket Checkout in basket pop-up
    And I am redirected to a "Basket page"
    And Basket order summary is as following:
      | Delivery cost | FREE    |
      | Total         | 85,38 € |
    And I click 'Checkout' button on 'Basket' page
    And I checkout as a new customer with email "test@mail.com"
    And Checkout order summary is as following:
      | SubTotal | 85,38 € |
      | Delivery | FREE    |
      | Total    | 85,38 € |
    When I fill delivery address information manually:
      | Full name | Delivery country | Address line 1   | Address line 2   | Town/City | County/State | Postcode |
      | Anna      | Poland           | Random address 1 | Random address 2 | Kyiv      | Random State | 123      |
    And I enter my card details
      | cardNumber  | 4111111111111111 |
      | Expiry Date | 03/2025          |
      | CVV         | 123              |
