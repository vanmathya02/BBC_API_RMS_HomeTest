package apiClasses;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//Methods related to InvalidGetRequestStep and feature3_invalidGetRequest.feature
public class InvalidGetRequest {


    //Get Request to Invalid Endpoint
    public void userMakesGetRequestToInvalidEndpoint() {

        Response response = given()
                .contentType("application/json")
                .when()
                .get("https://testapi.io/api/RMSTest/ibltest/2023-09-11");

        System.out.println("Get Request Successful");

        //Response as String
        System.out.println("Response Body is: " + response.asString());

    }

    //Invalid Request - Gets response status code
    public void verifyInvalidRequestCode(int errorStatusCode) {

        Response response = given()
                .contentType("application/json")
                .when()
                .get("https://testapi.io/api/RMSTest/ibltest/2023-09-11");
        //Get Error Status code
        int statusCode = response.getStatusCode();
        System.out.println("Error Status Code: " + statusCode);

        assertEquals(statusCode, errorStatusCode);
        System.out.println("Expected error status code matches the actual error status code");

    }

    //Invalid Request - Checking error and its properties in the response
    public void verifyErrorObjectProperties() {
      Response response = given()
             .contentType("application/json")
                .when()
                .get("https://testapi.io/api/RMSTest/ibltest/2023-09-11");

      String responseBody = response.getBody().asString();

        JSONObject responseObject = new JSONObject(responseBody);

        JSONObject errorObject = responseObject.optJSONObject("error");

        assertTrue("Error object is missing 'details' property", errorObject.has("details"));
        assertTrue("Error object is missing 'http_response_code' property", errorObject.has("http_response_code"));

        String details = errorObject.getString("details");
        int httpResponseCode = errorObject.getInt("http_response_code");

        System.out.println("Error Details: " + details);
        System.out.println("HTTP Response Code in Error: " + httpResponseCode);

    }

}

