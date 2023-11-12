@Join
Feature: Join
  As a user i want to join to hilton account

  @positive
  Scenario: Join With Valid Credentials
    Given User already open the join website
    And User wait 2 sec
    When User set valid data in input fields
    And User wait 2 sec
    And User click Join For Free Button
    Then User already on confirmation page
    And User saves login