package apiClasses;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import static org.junit.Assert.assertNotNull;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import org.junit.Assert;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static java.io.IO.println;
import static java.util.function.Predicate.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//package apiClasses;
//import io.restassured.response.Response;
//import org.json.JSONArray;
//import org.json.JSONObject;
//import static io.restassured.RestAssured.given;
//import static org.junit.Assert.*;


public class UserGetRequest {


//    private Response response;
//    private Long responseTime;
//
//
//    //Commmon from scenario 1 to scenario 5
//    public void userMakesGetRequestAndGetsResponse() {
//
//        RestAssured.baseURI = "https://testapi.io/api/RMSTest/ibltest";
//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.get(RestAssured.baseURI);
//        System.out.println("Get Request Successful");
//
//        // By using the ResponseBody.asString() method, we can convert the  body
//        // into the string representation.
//        System.out.println("Response Body is: " + response.asString());
//
//    }

    /*
        prop = new Properties();
        try {
            prop.load(UserGetRequest.class.getClassLoader().getResourceAsStream("config.properties"));
            baseURL = prop.getProperty(baseURL);
            System.out.println("BaseURL" + baseURL);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        public void responseAfterGetRequest() {

            response = given().log().all().get(baseURL);
        }
//    */
//    //Scenario 1
//    public void verifyResponseStatusCode(int expectedStatusCode) {
//        this.response = RestAssured.given().when().get("https://testapi.io/api/RMSTest/ibltest");
//
//        int statusCode = this.response.getStatusCode();
//        System.out.println("Response Status Code" + statusCode);
//        //Assert.assertTrue(statusCode==expectedStatusCode);
//        assertEquals(statusCode, expectedStatusCode);
//        System.out.println("Expected status code matches the actual status code");
//
//    }
//
//    //Scenario 1
//    public void verifyResponseTime(int expectedResponseTime) {
//        this.response = RestAssured.given().when().get("https://testapi.io/api/RMSTest/ibltest");
//
//        responseTime = this.response.time();
//        System.out.println("Response Time: " + responseTime + " ms");
//
//        if (responseTime < expectedResponseTime) {
//            System.out.println("Response time is below " + expectedResponseTime + " ms.");
//        } else {
//            System.out.println("Response time is above " + expectedResponseTime + " ms.");
//        }
//    }

    //public void verifyElementIdNotNull()
    //{
    //response = RestAssured.
    //  given().contentType("ContentType.JSON").
    //when().get("https://testapi.io/api/RMSTest/ibltest")
    //       .then().statusCode(200).
    //     header("Content-Type", "application/json")
    //   .body("schedule.elements[0].id",equalTo("p0g9q573"))z




    /*public void verifyEpisodeTypeAlwaysEpisode()
    {

        List<String> episodeTypes = jsonPath.getList("schedule.elements.episode.type");

        // Validate that the "type" is always "episode"
        for (String type : episodeTypes) {
            assertEquals("Episode type should be 'episode'", "episode", type);
    }*/
    // Assert that the response time is below 1000 ms
    //assertThat("Response time is greater than 1000 ms", responseTime, lessThan(1000L));



   /* public void verifyElementIdNotNull() {
        // Send GET request to the API
        Response response1 = given()
                .contentType("application/json")  // Set content type
                .when()
                .get("https://testapi.io/api/RMSTest/ibltest");

        // Assert the status code is 200 and Content-Type is application/json
        response1.then().statusCode(200)
                .header("Content-Type", "application/json");

        // Print out the full response body (to inspect the JSON structure)
        String responseBody = response1.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Parse the entire response JSON object
        JSONObject responseObject = new JSONObject(responseBody);

        // Get the "schedule" object from the response
        JSONObject scheduleObject = responseObject.optJSONObject("schedule");

        // Check if the "schedule" object exists and contains "elements"
        if (scheduleObject != null) {
            // Extract the "elements" array from the schedule
            JSONArray elementsArray = scheduleObject.optJSONArray("elements");

            // Check if "elements" is null or empty
            if (elementsArray == null || elementsArray.length() == 0) {
                System.out.println("No elements found or 'elements' is null.");
            } else {
                // Loop through each element in the "elements" array
                for (int i = 0; i < elementsArray.length(); i++) {
                    JSONObject element = elementsArray.optJSONObject(i);

                    // Check if the element is null
                    if (element == null) {
                        System.out.println("Element " + i + " is null.");
                    } else {
                        // Get the "id" field from the element and check if it's null
                        String elementId = element.optString("id", null);  // Use optString to safely get "id"

                        // Check if the ID is null and print it
                        if (elementId == null) {
                            System.out.println("Element " + i + " ID is null.");
                        } else {
                            System.out.println("Element " + i + " ID: " + elementId);
                        }

                        // Assert the ID is not null
                        assertNotNull("Element ID is null for element " + i, elementId);


                    }
                }
            }
        } else {
            System.out.println("'schedule' object is missing in the response.");
        }
    }*/

    // Ensure this import is present
    //Scenario 2
    /***public void verifyElementIdNotNull() {
        // Send GET request to the API
        Response response1 = given()
                .contentType("application/json")  // Set content type
                .when()
                .get("https://testapi.io/api/RMSTest/ibltest");

        // Assert the status code is 200 and Content-Type is application/json
        response1.then().statusCode(200)
                .header("Content-Type", "application/json");

        // Print out the full response body (to inspect the JSON structure)
        String responseBody = response1.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Parse the entire response JSON object
        JSONObject responseObject = new JSONObject(responseBody);

        // Get the "schedule" object from the response
        JSONObject scheduleObject = responseObject.optJSONObject("schedule");

        // Check if the "schedule" object exists and contains "elements"
        if (scheduleObject != null) {
            // Extract the "elements" array from the schedule
            JSONArray elementsArray = scheduleObject.optJSONArray("elements");

            // Check if "elements" is null or empty
            assertNotNull("The 'elements' array is null.", elementsArray);
            if (elementsArray.isEmpty()) {
                throw new AssertionError("The 'elements' array is empty.");
            }

            // Loop through each element in the "elements" array
            for (int i = 0; i < elementsArray.length(); i++) {
                JSONObject element = elementsArray.optJSONObject(i);
                // Assert the element is not null
                assertNotNull("Element " + i + " is null.", element);

                // Get the "id" field from the element and check if it's null
                String elementId = element.optString("id", null);  // Use optString to safely get "id"
                assertNotNull("Element ID is null for element " + i, elementId);


               /* // Scenario 5 - Retrieve the "transmission_start" and "transmission_end" fields
                String transmissionStart = element.optString("transmission_start", null);
                String transmissionEnd = element.optString("transmission_end", null);
                assertNotNull("Transmission start date is null for element at index " + i, transmissionStart);
                assertNotNull("Transmission end date is null for element at index " + i, transmissionEnd);

                try {
                    // Parse the dates
                    Date startDate = dateFormat.parse(transmissionStart);
                    Date endDate = dateFormat.parse(transmissionEnd);

                    // Verify that transmission_start is before transmission_end
                    assertTrue("Transmission start date is not before end date for element at index " + i,
                            startDate.before(endDate));

                    // Log the dates
                    System.out.println("Element ID: " + element.optString("id", "N/A") +
                            ", Start: " + transmissionStart +
                            ", End: " + transmissionEnd);

                } catch (ParseException e) {
                    throw new AssertionError("Invalid date format for element at index " + i + ": " + e.getMessage());
                }*/


              /***  // Scenario 2 - Check Episode Type is Episode

                JSONObject episodeObject = element.optJSONObject("episode");
                // Retrieve the "type" field
                String episodeType = episodeObject.optString("type", null);
                assertEquals("episode", episodeType);
                // Log Episode Type
                System.out.println("Episode " + i + " Type " + episodeType);

                // Scenario 3 - Check Title is not NULL
                String episodeTitle = episodeObject.optString("title", null);
                assertNotNull("Episode Title is Null", episodeTitle);
                // Log Episode Title
                System.out.println("Episode Title " + i + episodeTitle);

                // Scenario 4 - Check Episode Live
                boolean episodeLive = episodeObject.optBoolean("live", false);
                // Log Episode Live
                System.out.println("Element " + i + " Episode Live: " + episodeLive);


            }
        } else {
            throw new AssertionError("'schedule' object is missing in the response.");
        }
    }


//
//    public void verifyElementTypesAndDates() {
//        // Send GET request to the API
//        Response response = given()
//                .contentType("application/json")  // Set content type
//                .when()
//                .get("https://testapi.io/api/RMSTest/ibltest");
//
//        // Assert the status code is 200 and Content-Type is application/json
//        response.then().statusCode(200)
//                .header("Content-Type", "application/json");
//
//        // Parse the response body into a JSON object
//        String responseBody = response.getBody().asString();
//        JSONObject responseObject = new JSONObject(responseBody);
//
//        // Navigate to the "schedule" object
//        JSONObject scheduleObject = responseObject.optJSONObject("schedule");
//        assertNotNull("'schedule' object is missing in the response.", scheduleObject);
//
//        // Navigate to the "elements" array
//        JSONArray elementsArray = scheduleObject.optJSONArray("elements");
//        assertNotNull("'elements' array is missing in the 'schedule' object.", elementsArray);
//
//        // Date format used in the API
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//
//        // Iterate through each element in the "elements" array
//        for (int i = 0; i < elementsArray.length(); i++) {
//            JSONObject element = elementsArray.optJSONObject(i);
//            assertNotNull("Element at index " + i + " is null.", element);
//
//            // Retrieve and verify the "type" field
//            String type = element.optString("type", null);
//            assertNotNull("Type is null for element at index " + i, type);
//            assertEquals("Element at index " + i + " does not have type 'episode'.", "episode", type);
//
Retrieve the "transmission_start" and "transmission_end" fields
//            String transmissionStart = element.optString("transmission_start", null);
//            String transmissionEnd = element.optString("transmission_end", null);
//            assertNotNull("Transmission start date is null for element at index " + i, transmissionStart);
//            assertNotNull("Transmission end date is null for element at index " + i, transmissionEnd);

           /* try {
                // Parse the dates
                Date startDate = dateFormat.parse(transmissionStart);
                Date endDate = dateFormat.parse(transmissionEnd);

                // Verify that transmission_start is before transmission_end
                assertTrue("Transmission start date is not before end date for element at index " + i,
                        startDate.before(endDate));

                // Log the dates
                System.out.println("Element ID: " + element.optString("id", "N/A") +
                        ", Start: " + transmissionStart +
                        ", End: " + transmissionEnd);

            } catch (ParseException e) {
                throw new AssertionError("Invalid date format for element at index " + i + ": " + e.getMessage());
            }
        }*/
//}


    // Method to send a GET request and validate the response status and content type
    public Response sendGetRequest(String url) {
        Response response = given()
                .contentType("application/json") // Set content type
                .when()
                .get(url);

        // Assert status code and content type
        response.then().statusCode(200)
                .header("Content-Type", "application/json");

        return response;
    }

    // Method to parse and return the schedule object
    public JSONObject getScheduleObject(Response response) {
        String responseBody = response.getBody().asString();
        JSONObject responseObject = new JSONObject(responseBody);
        JSONObject scheduleObject = responseObject.optJSONObject("schedule");

        assertNotNull("'schedule' object is missing in the response.", scheduleObject);
        return scheduleObject;
    }

    // Method to validate the elements array
    public JSONArray getElementsArray(JSONObject scheduleObject) {
        JSONArray elementsArray = scheduleObject.optJSONArray("elements");
        assertNotNull("The 'elements' array is null.", elementsArray);
        assertFalse("The 'elements' array is empty.", elementsArray.isEmpty());
        return elementsArray;
    }

    // Method to validate individual element's ID
    public void validateElementId(JSONObject element, int index) {
        String elementId = element.optString("id", null);
        assertNotNull("Element ID is null for element " + index, elementId);
        System.out.println("Element " + index + " ID: " + elementId);
    }

    // Method to validate episode details and count live episodes
    public boolean isEpisodeLive(JSONObject element, int index) {
        JSONObject episodeObject = element.optJSONObject("episode");
        assertNotNull("Episode object is null for element " + index, episodeObject);

        // Check Episode Type
        String episodeType = episodeObject.optString("type", null);
        assertEquals("Episode type mismatch for element " + index, "episode", episodeType);
        System.out.println("Element " + index + " Episode Type: " + episodeType);

        // Check Title is not null
        String episodeTitle = episodeObject.optString("title", null);
        assertNotNull("Episode title is null for element " + index, episodeTitle);
        System.out.println("Element " + index + " Episode Title: " + episodeTitle);

        // Check if Episode is Live
        boolean episodeLive = episodeObject.optBoolean("live", false);
        System.out.println("Element " + index + " Episode Live: " + episodeLive);

        return episodeLive;
    }

    // Combined method to run all validations
    public void verifyResponse(String url) {
        // Step 1: Send GET request
        Response response = sendGetRequest(url);

        // Step 2: Extract schedule and elements
        JSONObject scheduleObject = getScheduleObject(response);
        JSONArray elementsArray = getElementsArray(scheduleObject);

        // Step 3: Counter for live episodes
        int liveCount = 0;

        // Step 4: Loop through elements and validate
        for (int i = 0; i < elementsArray.length(); i++) {
            JSONObject element = elementsArray.optJSONObject(i);
            assertNotNull("Element " + i + " is null.", element);

            // Validate individual scenarios
            validateElementId(element, i);
            if (isEpisodeLive(element, i)) {
                liveCount++;
            }
        }

        // Step 5: Assert only one live episode
        assertEquals("Expected exactly one live episode, but found: " + liveCount, 1, liveCount);
        System.out.println("Validation successful: Exactly one live episode found.");
    }
}
