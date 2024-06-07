Feature: Swag Labs not Valid Login

  @regression @smoke
  Scenario Outline: Not Valid Login
  Given user is on login page
  When user enters "<username>" and "<password>"
  And user clicks the login button
  Then validate "<error>" message
  
  Examples:
  |username       |password    |error                               |
  |locked_out_user|secret_sauce|Sorry, this user has been locked out|