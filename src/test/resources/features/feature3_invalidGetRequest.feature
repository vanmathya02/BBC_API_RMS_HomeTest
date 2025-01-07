Feature: Verify the invalid endpoint status code and response body

@Scenario7
Scenario Outline: Verify the status code and error object for invalid endpoint
Given User makes a get request to invalid endpoint
When Verify the invalid response status code is '<errorStatusCode>'
Then Verify the error object and its properties
Examples:
|errorStatusCode|
|404            |

