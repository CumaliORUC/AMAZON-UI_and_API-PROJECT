@Parallel1
Feature: US_002 Negative Login
  Scenario:TC_003 Negative Login
    Given Go to "testpage_Url"
    Then Click to Sign_in_Icon
    Then Enter a valid_mail address in the mail box
    And Click to Continue
    Then Enter a invalid_ password in the password box
    And Close the page
