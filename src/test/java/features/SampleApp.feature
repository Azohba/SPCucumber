Feature: SampleApp features

  Background:
    Given go to homepage


  Scenario:  Sample App - Success login
  -------------------------------
    When click sampleapp href link
    And  enter Onur  and pws
    And click Log In button
    Then check successLogin login status


  Scenario Outline:  Sample App : Success login
  -------------------------------
    When click sampleapp href link
    And  enter '<name>'  and '<pass>'
    And click Log In button
    Then check <status> login status

    Examples:
      | name | pass | status      |
      |      |      | successLogin |
      | asdd |      | failedLogin |
      |      | pwd  | failedLogin |




