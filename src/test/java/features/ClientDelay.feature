Feature: Client Delay features

  Background:
    Given go to homepage

  Scenario: Client Delay - 1 Click test
    When click clientdelay href link
    And  click "1" times to Client Side button
    Then  check success messages


  Scenario: Client Delay - 2 Click test
    When  click clientdelay href link
    And  click "2" times to Client Side button
    Then  check success messages