Feature: US_002
  Scenario:TC_0002 Success Login
    Given Go to "testpage_Url"
    Then Click to Sign_in_Icon
    Then Enter a valid_mail address in the mail box
    And Click to Continue
    Then Enter a valid_ password in the password box
    When Click to Sign_in
    And Close the page
