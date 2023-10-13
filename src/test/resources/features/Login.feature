@Login
Feature: Login
  As a user i want to login to account

  @positive
  Scenario: Login With Valid Credentials
    Given User already open the website
    When User set input "standard_user" as username
    And User set input "secret_sauce" as password
    And User click login button
    Then User already on homepage

  @negative
  Scenario Outline: Login With Invalid Credentials
    Given User already open the website
    When User set input "<username>" as username
    And User set input "<password>" as password
    And User click login button
    Then User get "<error>" as error message

    Examples: Negative Scenarios Data
      | username       | password     | error                                                                     |
      |                |              | Epic sadface: Username is required                                        |
      | standard_user  |              | Epic sadface: Password is required                                        |
      | standard_user1 |              | Epic sadface: Password is required                                        |
      |                | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user  | secret_sauc  | Epic sadface: Username and password do not match any user in this service |