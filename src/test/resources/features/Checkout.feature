@Checkout
Feature: Checkout
  User checkout cart items

  @positive
  Scenario: Checkout cart item With Valid Credentials
    Given User already open the website
    When User set input "standard_user" as username
    And User set input "secret_sauce" as password
    And User click login button
    Then User verify page title "Products"
    When User add item: "<product name>" into a cart
    And User click on cart icon
    Then User verify page title "Your Cart"
    And User verify product name "<product name>"
    When User click checkout button
    Then User verify page title "Checkout: Your Information"
    When User set input "<first name>" as firstName
    And User set input "<last name>" as lastName
    And User set input "<postal code>" as Postal Code
    And User click continue button
    Then User verify page title "Checkout: Overview"
    When User click Finish button
    Then User verify page title "Checkout: Complete!"
    When User click Back To Products button
    Then User verify page title "Products"

    Examples: Negative Scenarios Data
      | first name         | last name              | postal code | product name             |
      | standard_usEr      | seEret_s!@#$##%%%!auce | 12399       | Sauce Labs Backpack      |
      | standaD@d_user     | secret_sa09021uce      | 45999       | Sauce Labs Bike Light    |
      | standar*$&d_user1  | secret_sau^&*ce        | 99599       | Sauce Labs Bolt T-Shirt  |
      | standard_uf*$#@ser | secret_sauce           | 02999       | Sauce Labs Fleece Jacket |


  @negative
  Scenario Outline:  Checkout cart item With Invalid Credentials
    Given User already open the website
    When User set input "standard_user" as username
    And User set input "secret_sauce" as password
    And User click login button
    Then User verify page title "Products"
    When User add item: "Sauce Labs Backpack" into a cart
    And User click on cart icon
    Then User verify page title "Your Cart"
    When User click checkout button
    Then User verify page title "Checkout: Your Information"
    When User set input "<first name>" as firstName
    And User set input "<last name>" as lastName
    And User set input "<postal code>" as Postal Code
    When User click continue button
    Then User get "<error>" as error message


    Examples: Negative Scenarios Data
      | first name     | last name    | postal code | error                          |
      |                |              |             | Error: First Name is required  |
      | standard_user  |              |             | Error: Last Name is required   |
      | standard_user1 | secret_sauce |             | Error: Postal Code is required |
      |                | secret_sauce | 99999       | Error: First Name is required  |







    