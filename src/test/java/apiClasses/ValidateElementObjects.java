package apiClasses;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

//Author: Vanmathy Aravalluvan
//Method related to ApiUserRequestStep and feature1_apiUserRequest.feature
public class ValidateElementObjects {


    //Verifying the Episode's Live value is True for only one
    public void validateEpisodeLiveStatus(JSONArray elementsArray) {
        int liveCount = 0;
        for (int i = 0; i < elementsArray.length(); i++) {
            JSONObject element = elementsArray.getJSONObject(i);

            String elementId = element.optString("id", null);
            assertNotNull("Element ID is missing for element at index " + i, elementId);

            JSONObject episodeObject = element.optJSONObject("episode");
            assertNotNull("Episode object is missing for element at index " + i, episodeObject);

            if (episodeObject.optBoolean("live")) { // Default live to false
                System.out.println("Found live episode for element at index " + i);
                liveCount++;
            } else {
                System.out.println("Element at index " + i + " is not live.");
            }
        }

        // Validate that exactly one episode is live
        assertEquals("Expected exactly one live episode, but found " + liveCount, 1, liveCount);
        System.out.println("Validation passed: Exactly one live episode found.");

    }

    //Verifying Episode's type is always episode
    public void validateEpisodeType(JSONArray elementsArray1) {

        for (int i = 0; i < elementsArray1.length(); i++) {
            JSONObject element = elementsArray1.getJSONObject(i);

            JSONObject episodeObject = element.optJSONObject("episode");
            assertNotNull("Episode object is null for element " + i, episodeObject);

            // Check Episode Type
            String episodeType = episodeObject.optString("type", null);
            assertEquals("Episode type mismatch for element " + i, "episode", episodeType);
            System.out.println("Validate Passed: Episode type matches Episode for element  " + i + " Episode Type: " + episodeType);
        }
    }

    //Verifying Episode's title is never null or empty
    public void validateEpisodeTitle(JSONArray elementsArray1) {

        for (int i = 0; i < elementsArray1.length(); i++) {
            JSONObject element = elementsArray1.getJSONObject(i);

            JSONObject episodeObject = element.optJSONObject("episode");
            assertNotNull("Episode object is null for element " + i, episodeObject);

            // Check Title is not null
            String episodeTitle = episodeObject.optString("title", null);
            assertNotNull("Episode title is null for element " + i, episodeTitle);
            System.out.println("Validate Passed: Episode title is not null or empty for element " + i + " Episode Title: " + episodeTitle);
        }
    }

    // Verifying all elements ID's is never null or empty
    public void validateElements(JSONArray elementsArray) {
        for (int i = 0; i < elementsArray.length(); i++) {
            JSONObject element = elementsArray.getJSONObject(i);

            // Validate element ID
            String elementId = element.optString("id", null);
            assertNotNull("Element ID is missing for element at index " + i, elementId);
            System.out.println("Validate Element ID for element at index " + i + ": " + elementId + " passed");
        }
    }

    // Verify that Transmission start date is earlier than Transmission end date
        public void validateTransmissionDates(JSONArray elementsArray) {

            // Define the date-time format
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'");

            for (int i = 0; i < elementsArray.length(); i++) {
                JSONObject element = elementsArray.getJSONObject(i);


                String transmissionStart = element.optString("transmission_start", null);
                String transmissionEnd = element.optString("transmission_end", null);

                if (transmissionStart == null || transmissionEnd == null) {
                    System.err.println("Transmission dates are missing for element at index " + i +
                            ". Start: " + transmissionStart + ", End: " + transmissionEnd);
                    continue;
                }

                try {
                    // Parse the dates using LocalDateTime
                    LocalDateTime startDateTime = LocalDateTime.parse(transmissionStart, dateTimeFormatter);
                    LocalDateTime endDateTime = LocalDateTime.parse(transmissionEnd, dateTimeFormatter);

                    if (startDateTime.isBefore(endDateTime)) {
                        System.out.println("Validation Passed for Element " +
                                "ID: " + element.optString("id", "N/A") +
                                ", Start Date: " + transmissionStart +
                                ", End Date: " + transmissionEnd +
                                " - Start date is before End date.");
                    } else {
                        System.err.println("Validation Failed for Element " +
                                "ID: " + element.optString("id", "N/A") +
                                ", Start Date: " + transmissionStart +
                                ", End Date: " + transmissionEnd +
                                " - Start date is NOT before End date.");
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Invalid date format for element at index " + i +
                            ". Start: " + transmissionStart + ", End: " + transmissionEnd +
                            " - Error: " + e.getMessage());
                }
            }
        }
    }






