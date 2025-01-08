Feature: User makes Get Request to URL and checks the element and its properties
@Scenario1
  Scenario Outline:Verify the response status code and response time
    Given User makes a get request "https://testapi.io/api/RMSTest/ibltest"
    When  Verify the response status code is '<expectedStatusCode>'
    Then  Verify the response time is less than '<expectedResponseTime>'
    Examples:
      | expectedStatusCode | expectedResponseTime |
      | 200                | 1000                 |
@Scenario2.1
  Scenario:Verify the Element is never null or empty
      Given Validate the API response from "https://testapi.io/api/RMSTest/ibltest"
      Then Verify element Id is never null or empty
@Scenario2.2
  Scenario:Verify the Episode type is always episode
     Given Validate the API response from "https://testapi.io/api/RMSTest/ibltest"
     Then Verify the episode type is episode
@Scenario3
  Scenario: Verify the Episode title is never null or empty
       Given Validate the API response from "https://testapi.io/api/RMSTest/ibltest"
       Then Verify the episode title is never null or empty
@Scenario4
  Scenario: Verify the Episode live is true for only one
    Given Validate the API response from "https://testapi.io/api/RMSTest/ibltest"
    Then Verify the episode live is true for only one
@Scenario5
  Scenario: Verify the Element Transmission start date is less than end date
    Given Validate the API response from "https://testapi.io/api/RMSTest/ibltest"
    Then Verify the element transmission start date is less than end date




