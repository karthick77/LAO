Feature: Swag Labs Valid Login Drop Down

  @regression @dropdown
  Scenario Outline: Valid Login Drop Down
  Given user is on login page
  When user enters "<username>" and "<password>"
  And user clicks the login button
  Then validate "<title>" label
  And user selects "<howTo>" from the dropdown as "<value>"
  And logout from application successfully
  
  Examples:
  |username     |password    |title   |value|howTo |
  |standard_user|secret_sauce|Products|hilo |value |
  

  
