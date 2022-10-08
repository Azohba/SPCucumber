Feature: Client Delay features

  Background:
    Given go to homepage

    Scenario:Check Chrome Cpu load
    When click dynamictable href link
     Then get Chrome Cpu value
