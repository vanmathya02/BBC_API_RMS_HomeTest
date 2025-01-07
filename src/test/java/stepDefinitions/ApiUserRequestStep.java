package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utilities.BaseApiUtils;
import apiClasses.ValidateElementObjects;

import static org.junit.Assert.assertEquals;

//Step Definitions for Scenario 1 till Scenario 5
public class ApiUserRequestStep {

    private final BaseApiUtils baseApiUtils = new BaseApiUtils();
    private JSONArray elementsArray;
    private final ValidateElementObjects validateObject = new ValidateElementObjects();
    private Response response;
    private Long responseTime;

   //Scenario 1
    @Given("User makes a get request {string}")
    public void user_makes_a_get_request(String url) {
       Response response = baseApiUtils.sendGetRequestAndValidate(url);

        // Log the response status for debugging
        System.out.println("GET request sent to: " + url);
        System.out.println("Response received: " + response.getBody().asString());

    }

    //Scenario 1
   @When("Verify the response status code is {string}")
   public void verifyTheResponseStatusCodeIs(String expectedStatusCode) {
       response = RestAssured.given().when().get("https://testapi.io/api/RMSTest/ibltest");
        int statusCode = response.getStatusCode();

        System.out.println("Response Status Code" + statusCode);
        //Assert.assertTrue(statusCode==expectedStatusCode);
        assertEquals(statusCode, Integer.parseInt(expectedStatusCode));
        System.out.println("Expected status code matches the actual status code");

    }
    //Scenario 1
    @Then("Verify the response time is less than {string}")
    public void verifyTheResponseTimeIsLessThan(String expectedResponseTime)
    {
        response = RestAssured.given().when().get("https://testapi.io/api/RMSTest/ibltest");

        responseTime = response.time();
        System.out.println("Response Time: " + responseTime + " ms");

        if (responseTime < Integer.parseInt(expectedResponseTime)) {
            System.out.println("Response time is below " + expectedResponseTime + " ms.");
        } else {
            System.out.println("Response time is above " + expectedResponseTime + " ms.");
        }
    }


    //Scenario 2 till Scenario 5
        @Given("Validate the API response from {string}")
    public void step_ValidateTheApiResponseFrom(String url) {
        // Step 1: Send GET request and validate the response
        Response response = baseApiUtils.sendGetRequestAndValidate(url);

        // Step 2: Parse the response to JSON and extract elements
        JSONObject jsonObject = baseApiUtils.parseResponseToJson(response);
        elementsArray = baseApiUtils.extractAndValidateElements(jsonObject);
    }
    //Scenario 2.1
    @Then("Verify element Id is never null or empty")
    public void verify_element_id_is_never_null_or_empty() {
        validateObject.validateElements(elementsArray);
        }
    //Scenario 2.2
    @Then("Verify the episode type is episode")
    public void verify_the_episode_type_is_episode() {
        validateObject.validateEpisodeType(elementsArray);
    }
    //Scenario 3
    @Then("Verify the episode title is never null or empty")
    public void verify_the_episode_title_is_never_null_or_empty() {
        validateObject.validateEpisodeTitle(elementsArray);

    }
    //Scenario 4
    @Then("Verify the episode live is true for only one")
    public void verify_the_episode_live_is_true_for_only_one() {
        validateObject.validateEpisodeLiveStatus(elementsArray);

    }
    //Scenario 5
    @Then("Verify the element transmission start date is less than end date")
   public void verify_the_element_transmission_start_date_is_less_than_end_date() {
        validateObject.validateTransmissionDates(elementsArray);

        }

}

