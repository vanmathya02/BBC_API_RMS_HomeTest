package stepDefinitions;

import apiClasses.ResponseHeader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

//Author: Vanmathy Aravalluvan
//Step Definitions for Scenario 6
public class ResponseHeaderStep {
    ResponseHeader verifyHeaderDate = new ResponseHeader();

    @Given("User makes a get request to url and gets response header")
    public void user_makes_a_get_request_to_url_and_gets_response_header() {
        Response headerResponse = given()
                .contentType("application/json")  // Set content type
                .when()
                .get("https://testapi.io/api/RMSTest/ibltest");
        headerResponse.then().statusCode(200)
                .header("Content-Type", "application/json");
        Headers headers = headerResponse.getHeaders();
        System.out.println("Response Headers:");
        for (Header header : headers) {
            System.out.println(header.getName() + ": " + header.getValue());

        }
    }

        @Then("Verify date value in the response header")
        public void verify_date_value_in_the_response_header() {
        verifyHeaderDate.verifyResponseHeader();

        }
        }

