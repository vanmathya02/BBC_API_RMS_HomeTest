package stepDefinitions;

import apiClasses.InvalidGetRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//Step Definitions for Scenario 7
public class InvalidGetRequestStep {
    InvalidGetRequest inValidReq = new InvalidGetRequest();

    @Given("User makes a get request to invalid endpoint")
    public void user_makes_a_get_request_to_invalid_endpoint() {
        inValidReq.userMakesGetRequestToInvalidEndpoint();
    }

    @When("Verify the invalid response status code is {string}")
    public void verify_the_invalid_response_status_code_is(String errorStatusCode) {
      inValidReq.verifyInvalidRequestCode(Integer.parseInt(errorStatusCode));

    }

    @Then("Verify the error object and its properties")
    public void verify_the_error_object_and_its_properties() {
      inValidReq.verifyErrorObjectProperties();
    }

}
