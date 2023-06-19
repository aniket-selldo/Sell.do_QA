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
		
		String leadID = "647f371cb08345ab2f35a36a";
        RestAssured.baseURI = "https://v2.sell.do/client/leads/"+leadID+".json";

		root.setApi_key("99c4b48c7732b5183000999d1200d520");
		root.setClient_id("642a8145b083453f914ce854");
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
		project_ids.add("587dec4626300a3aca00001c");
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
		project_ids.add("587dec4626300a3aca00001c");
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
