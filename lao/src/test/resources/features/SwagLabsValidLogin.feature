Feature: Swag Labs Valid Login

  @regression @sanity
  Scenario Outline: Valid Login
  Given user is on login page
  When user enters "<username>" and "<password>"
  And user clicks the login button
  Then validate "<title>" label
  And logout from application successfully
  
  Examples:
  |username     |password    |title|
  |standard_user|secret_sauce|Products|
  

  
