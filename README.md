# RMS API Automation Framework 

This project demonstrates API testing for the endpoint https://testapi.io/api/RMSTest/ibltest using Rest Assured, Cucumber, and JUnit.

## Description
The project has been developed to Validate HTTP status codes, response times, and error handling.
Ensure data integrity, field consistency, and proper validation of key fields like id, type, title, and live.
Verify date logic between transmission_start and transmission_end.

Handle invalid requests and confirm error responses meet expectations.

**Framework Structure:**

Feature Files: Located at src/test/resources/features.

Step Definitions: Implemented in src/test/java/stepDefinitions.

Test Runner: src/test/java/cucumberRunner/TestRunner.java.

**Reporting:**

Test execution results are presented as graphical HTML reports using Extent Reports, offering detailed insights and analysis.

This framework is modular, easy to extend, and suitable for comprehensive API validation.



## Testing Detailed Flow Diagram

![BBC_RMS_Testing_Framework](https://github.com/user-attachments/assets/8a4ff53a-e94f-4622-88ee-656e9a7a0fcc)


### Dependencies & IDE

* Add all dependencies to **pom.xml**
* ex. Rest Assured,Cucumber,Junit,JSON,Extent Reports,etc
* Whole project is developed in Intellij https://www.jetbrains.com/idea/


### Scenarios Covered :

**Scenario 1:**
1. Make a GET request to https://testapi.io/api/RMSTest/ibltest
2. Verify that the HTTP status code of the response is 200
3. Verify that the response time of the request is below 1000 milliseconds
   
**Scenario 2:**
1. Make a GET request to https://testapi.io/api/RMSTest/ibltest
2. Verify if the “id” field is never null or empty(“”) for all 5 items present in the
Element data array
3. Verify that the “type” in “episode” for every item is always “episode”

**Scenario 3:**
1. Make a GET request to https://testapi.io/api/RMSTest/ibltest
2. Verify that the “title” field in “episode”, is never null or empty(“”) for any
schedule item

**Scenario 4:
1. Make a GET request to https://testapi.io/api/RMSTest/ibltest
2. Verify that only one episode in the list has “live” field in “episode” as true

**Scenario 5:**
1. Make a GET request to https://testapi.io/api/RMSTest/ibltest
2. Verify that the “transmission_start” date value is before the
“transmission_end” date


#### Feature file Path for above scenarios :
```
src/test/resources/features/feature1_apiUserRequest.feature
```
#### StepDefinition Path for above scenarios:
```
src/test/java/stepDefinitions/ApiUserRequestStep.java
```

**Scenario 6:**
1. Make a GET request to https://testapi.io/api/RMSTest/ibltest
2. In the response headers, verify the “Date” value


#### Feature file Path:

```
src/test/resources/features/feature2_responseHeader.feature
```

#### StepDefinition Path:
```
src/test/java/stepDefinitions/ResponseHeaderStep.java
```

**Scenario 7:**

1. Make a GET request to https://testapi.io/api/RMSTest/ibltest/2023-09-11
2. Verify that the HTTP status code of the response is 404
3. Verify the error object had the properties ‘details’ and ‘http_response_code’

#### Feature file Path:
```
src/test/resources/features/feature3_invalidGetRequest.feature
```

#### StepDefinition Path:
```
src/test/java/stepDefinitions/InvalidGetRequestStep.java
```

### Test Runner:

```
src/test/java/cucumberRunner/TestRunner.java
```

### Extent-Report:

Generates HTML Report on the above execution more graphically for detailed analysis

```
test-output/SparkReport/SparkReport.html(Should be launched in Browser)
```

<img width="1404" alt="Extent" src="https://github.com/user-attachments/assets/00192928-f895-4a28-a799-019df23b1a68" />


## Authors

Contributors names and contact info

* Vanmathy Aravalluvan
* vanarvme@gmail.com

## Version History

* V1-Initial Release

