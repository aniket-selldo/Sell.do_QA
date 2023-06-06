package API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang.RandomStringUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostReq {

		
		public static String CreateLead() {
	        // Base URL of the API
	        RestAssured.baseURI = "https://v2.sell.do/api";
	        String random = RandomStringUtils.randomAlphanumeric(10);
	        String Phone = "1234"+RandomStringUtils.randomNumeric(6);
	        String APIKey ="fa8d6ca0217e676a7b0e06f51c32568c";

	    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");// yyyy/MM/dd
			LocalDateTime now = LocalDateTime.now();
			String date= dtf.format(now);
	        // Request payload
	        String requestBody = "{\n" +
	                "    \"sell_do\": {\n" +
	                "        \"form\": {\n" +
	                "            \"lead\": {\n" +
	                "                \"first_name\": \"Automation"+date+"\",\n" +
	                "                \"last_name\": \"LastName\",\n" +
	                "                \"email\": \"aniket.khdizro"+random+"d@sell.do\",\n" +
	                "                \"phone\": \"\",\n" +
	                "                \"salutation\": \"mr\",\n" +
	                "                \"time_zone\": \"Asia/Calcutta\",\n" +
	                "                \"user_created_tags\": [\n" +
	                "                    \"wreer\"\n" +
	                "                ],\n" +
	                "                \"stage\": \"incoming\",\n" +
	                "                \"status\": \"\",\n" +
	                "                \"nri\": true,\n" +
	                "                \"project_id\": \"\",\n" +
	                "                \"campaign_id\": \"5909b4005a9db3129a00003a\",\n" +
	                "                \"sales\": \"642d4058b083457249fe77b5\",\n" +
	                "                \"profile\": {\n" +
	                "                    \"company\": \"selldo\"\n" +
	                "                },\n" +
	                "                \"received_from\": {\n" +
	                "                    \"campaign_id\": null,\n" +
	                "                    \"source\": null,\n" +
	                "                    \"sub_source\": null,\n" +
	                "                    \"project_id\": null\n" +
	                "                },\n" +
	                "                \"channel_partner_id\": \"\",\n" +
	                "                \"primary_email\": {\n" +
	                "                    \"email\": \"\",\n" +
	                "                    \"email_type\": \"office\"\n" +
	                "                },\n" +
	                "                \"primary_phone\": {\n" +
	                "                    \"country_code\": \"in\",\n" +
	                "                    \"dial_code\": \"91\",\n" +
	                "                    \"phone_type\": \"work\",\n" +
	                "                    \"ph_number\": \"\"\n" +
	                "                },\n" +
	                "                \"secondary_emails\": null,\n" +
	                "                \"secondary_phones\": null\n" +
	                "            },\n" +
	                "            \"note\": {\n" +
	                "                \"content\": \"Hello World\"\n" +
	                "            },\n" +
	                "            \"requirement\": {\n" +
	                "                \"bhk\": [\n" +
	                "                    2,\n" +
	                "                    3\n" +
	                "                ],\n" +
	                "                \"property_type\": \"flat\",\n" +
	                "                \"purpose\": \"end_use\",\n" +
	                "                \"locations\": \"pune\",\n" +
	                "                \"min_budget\": \"600000\",\n" +
	                "                \"max_budget\": \"700000\",\n" +
	                "                \"min_possession\": \"12\",\n" +
	                "                \"max_possession\": \"24\",\n" +
	                "                \"facing\": [\n" +
	                "                    \"South\"\n" +
	                "                ],\n" +
	                "                \"furnishing\": [\n" +
	                "                    \"Semi-Furnished\"\n" +
	                "                ],\n" +
	                "                \"bathrooms\": [\n" +
	                "                    \"2\"\n" +
	                "                ],\n" +
	                "                \"funding_source\": \"self\",\n" +
	                "                \"transaction_type\": \"lease\",\n" +
	                "                \"area\": \"112\",\n" +
	                "                \"addresses_fields\": [\n" +
	                "                    {\n" +
	                "                        \"address1\": \"wefwe\",\n" +
	                "                        \"address2\": \"as\",\n" +
	                "                        \"country\": \"India\",\n" +
	                "                        \"state\": \"Lakshadweep\",\n" +
	                "                        \"city\": \"Pune\",\n" +
	                "                        \"address_type\": \"home-address\",\n" +
	                "                        \"zip\": \"848204\",\n" +
	                "                        \"primary\": true\n" +
	                "                    }\n" +
	                "                ],\n" +
	                "                \"personal_details\": {\n" +
	                "                    \"gender\": \"male\",\n" +
	                "                    \"married\": true,\n" +
	                "                    \"anniversary\": \"06/06/2022\",\n" +
	                "                    \"age\": \"\",\n" +
	                "                    \"birthday\": \"07/06/2022\",\n" +
	                "                    \"industry\": \"sefs\",\n" +
	                "                    \"urls\": null,\n" +
	                "                    \"incomes\": null,\n" +
	                "                    \"loan_details\": null,\n" +
	                "                    \"educational_details\": null,\n" +
	                "                    \"professional_details\": null\n" +
	                "                }\n" +
	                "            }\n" +
	                "        }\n" +
	                "    },\n" +
	                "    \"api_key\": \""+APIKey+"\"\n" +
	                "}";
	        
	        // Send POST request
	        Response response = RestAssured.given()
	                .contentType(ContentType.JSON)
	                .body(requestBody)
	                .when()
	                .post("/leads/create");

	        // Extract sell_do_lead_id from the response body
	        String sellDoLeadId = response.jsonPath().getString("sell_do_lead_id");

	        // Print sell_do_lead_id
	        System.out.println("sell_do_lead_id: " + sellDoLeadId);
	        return "#"+sellDoLeadId;
	    }
		
}
