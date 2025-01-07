package utilities;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;


public class BaseApiUtils {
    private static Response lastResponse;

    // Sends a GET request and validates response
    public Response sendGetRequestAndValidate(String url) {
        Response response = given()
                .contentType("application/json")
                .when()
                .get(url);


        response.then().statusCode(200)
                .header("Content-Type", "application/json");
        return response;
    }

    // Parses response to JSON object
    public JSONObject parseResponseToJson(Response response) {
        String responseBody = response.getBody().asString();
        return new JSONObject(responseBody);
    }

    // Validates the presence of a schedule and extracts elements
    public JSONArray extractAndValidateElements(JSONObject jsonObject) {
        JSONObject scheduleObject = jsonObject.optJSONObject("schedule");
        assertNotNull("'schedule' object is missing!", scheduleObject);


        JSONArray elementsArray = scheduleObject.optJSONArray("elements");
        assertNotNull("'elements' array is missing!", elementsArray);
        assertFalse("'elements' array is empty!", elementsArray.isEmpty());

        return elementsArray;
    }

}

