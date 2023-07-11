package API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Enums.APIKeys;
import POJO_CreateFollowup.Followup;
import POJO_CreateFollowup.Root;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateFollowUp {

	public static void createFollowUp(String leadID,APIKeys API_Key,APIKeys ClientID,String URL) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now) + ":59 IST";
		System.out.println("Date >> " + date);

		RestAssured.baseURI = URL+"/client/leads/" + leadID + "/followups.json";

		Followup followup = new Followup();
		followup.setFollowup_type("email");
		followup.setLead_id(leadID);
		followup.setScheduled_on(date);
		followup.setStatus("scheduled");
		followup.setSubject("Update");
		followup.setAgenda("agenda");
		followup.setType("followup");

		Root root = new Root();
		root.setApi_key(API_Key.toString());
		root.setClient_id(ClientID.toString());
		root.setFollowup(followup);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post();
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
	}
	
	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now) + ":59 IST";
		System.out.println("Date >> " + date);

		String leadID = "647f332cb08345ab2f35a314";
		RestAssured.baseURI = "https://v2.sell.do/client/leads/" + leadID + "/followups.json";

		Followup followup = new Followup();
		followup.setFollowup_type("email");
		followup.setLead_id(leadID);
		followup.setScheduled_on(date);
		followup.setStatus("scheduled");
		followup.setSubject("Update");
		followup.setAgenda("agenda");
		followup.setType("followup");

		Root root = new Root();
		root.setApi_key("99c4b48c7732b5183000999d1200d520");
		root.setClient_id("642a8145b083453f914ce854");
		root.setFollowup(followup);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post();

		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
		System.out.println("Lead id >> " + jsnPath.getString("sell_do_lead_id"));

	}
}
