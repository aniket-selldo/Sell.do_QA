package API;

import java.util.ArrayList;
import java.util.List;

import POJO_LeadUpdate.ActivitiesData;
import POJO_LeadUpdate.AddressesField;
import POJO_LeadUpdate.Lead;
import POJO_LeadUpdate.LeadProfile;
import POJO_LeadUpdate.PrimaryEmail;
import POJO_LeadUpdate.PrimaryPhone;
import POJO_LeadUpdate.ReceivedFrom;
import POJO_LeadUpdate.RemovedIds;
import POJO_LeadUpdate.Requirement;
import POJO_LeadUpdate.Root;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Update_Lead {

	
	
	public static void UpdateLead() {
		ActivitiesData activitiesData = new ActivitiesData();
		AddressesField addressesField = new AddressesField();
		LeadProfile leadProfile = new LeadProfile();
		PrimaryEmail primaryEmail = new PrimaryEmail();
		PrimaryPhone primaryPhone = new PrimaryPhone();
		ReceivedFrom receivedFrom = new ReceivedFrom();
		RemovedIds removedIds = new RemovedIds();
		Requirement requirement = new Requirement();
		Lead Lead = new Lead();
		Root root = new Root();
		String leadID = "64b0d852b08345f63030c525";
        RestAssured.baseURI = "https://v2.sell.do/client/leads/"+leadID+".json";

		root.setApi_key("c4d649781e5451ce2903b34b02496e2c");
		root.setClient_id("64a2be1db0834560eaa19563");
		Lead.setSalutation("mr");
		Lead.setFirst_name("Aniket");
		Lead.setLast_name("LastName");
		Lead.setTime_zone("Asia/Calcutta");
		Lead.setStage("prospect");
		Lead.setStatus(null);
		Lead.setNri(false);
		receivedFrom.setCampaign_id("");
		receivedFrom.setProject_id("");
		receivedFrom.setSource("");
		Lead.setReceived_from(receivedFrom);
		primaryEmail.setEmail("i77wgzksysu@sell.do");
		primaryEmail.setEmail_type("office");
		Lead.setPrimary_email(primaryEmail);
		ArrayList<String> project_ids = new ArrayList<String>();
		project_ids.add("5886efb35a9db35df300000a");
		Lead.setInterested_project_ids(project_ids);
		Lead.setSales_id("587ddb2b5a9db31da9000001");
		root.setLead(Lead);
		
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all()
				.put();

		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
	}
	public static void UpdateLead(String leadID,String URL,String APIKey,String ClientID) {
		ActivitiesData activitiesData = new ActivitiesData();
		AddressesField addressesField = new AddressesField();
		LeadProfile leadProfile = new LeadProfile();
		PrimaryEmail primaryEmail = new PrimaryEmail();
		PrimaryPhone primaryPhone = new PrimaryPhone();
		ReceivedFrom receivedFrom = new ReceivedFrom();
		RemovedIds removedIds = new RemovedIds();
		Requirement requirement = new Requirement();
		Lead Lead = new Lead();
		Root root = new Root();
		
        RestAssured.baseURI = URL+"/client/leads/"+leadID+".json";

		root.setApi_key(APIKey);
		root.setClient_id(ClientID);
		Lead.setSalutation("mr");
		Lead.setFirst_name("Aniket");
		Lead.setLast_name("LastName");
		Lead.setTime_zone("Asia/Calcutta");
		Lead.setStage("incoming");
		Lead.setStatus(null);
		Lead.setNri(false);
		receivedFrom.setCampaign_id("");
		receivedFrom.setProject_id("");
		receivedFrom.setSource("");
		Lead.setReceived_from(receivedFrom);
		primaryEmail.setEmail("i77wgzksysu@sell.do");
		primaryEmail.setEmail_type("office");
		Lead.setPrimary_email(primaryEmail);
		ArrayList<String> project_ids = new ArrayList<String>();
		project_ids.add("64b0dbb8b08345f63030cd4c");
		Lead.setInterested_project_ids(project_ids);
		Lead.setSales_id("587ddb2b5a9db31da9000001");
		root.setLead(Lead);
		
		
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all()
				.put();
		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
	}
	
	public static void main(String[] args) {
		UpdateLead();
	}
}
