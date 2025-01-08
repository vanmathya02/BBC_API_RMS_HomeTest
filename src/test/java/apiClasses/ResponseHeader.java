package apiClasses;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
//Author: Vanmathy Aravalluvan
//Method related to ResponseHeaderStep and feature2_responseHeader.feature
    public class ResponseHeader {


        //Verifying the date value in response header
        public void verifyResponseHeader() {

            Response headerResponse = given()
                    .contentType("application/json")  // Set content type
                    .when()
                        .get("https://testapi.io/api/RMSTest/ibltest");
                    headerResponse.then().statusCode(200)
                    .header("Content-Type", "application/json");

            String responseHeader = headerResponse.getHeader("Date");
            System.out.println("Response Header: " + responseHeader);

            assertNotNull("The 'Date' header is missing!", responseHeader);

            // Validate the date format
            try {

                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
                Date parsedDate = dateFormat.parse(responseHeader);

                System.out.println("Parsed Date: " + parsedDate);

                String formattedDate = dateFormat.format(parsedDate);
                System.out.println("Validation Passed: Formatted Date : " + formattedDate);


            } catch (ParseException e) {
                fail("The Date in the header is not in a valid format: " + e.getMessage());
            }
        }
    }
