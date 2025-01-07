Feature: Verify the response header

  @Scenario6
  Scenario: Verify the data value in response header
    Given User makes a get request to url and gets response header
    Then Verify date value in the response header
