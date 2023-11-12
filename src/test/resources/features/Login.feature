@Login
Feature: Login
  As a user i want to login to account

  @positive
  Scenario Outline: Login With Valid Credentials
    Given User click on sign in button
    And User wait 5 sec
    And User already open the website
    And User wait 5 sec
    When User set input "<username>" as username
    And User wait 5 sec
    And User set input "<password>" as password
    And User wait 5 sec
    And User click login button
    And User wait 31 sec
    And User click login button
    And User wait 5 sec
    Then User already on account page
    Examples:
      | username   | password             |
      | 1972644973 | fuqVy0-qopdom-pujvof |

  @negative
  Scenario Outline: Login With Invalid Credentials
    Given User click on sign in button
    And User wait 5 sec
    And User already open the website
    And User wait 5 sec
    When User set input "<username>" as username
    And User wait 5 sec
    And User set input "<password>" as password
    And User wait 5 sec
    And User click login button
    And User wait 5 sec
    Then User observe error message
    Examples:
      | username   | password             |
      | 1972633190 | tyvnef-Xocwej-9ziscy |



