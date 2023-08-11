package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.selldo.Utility.API_Reusable;

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
import POJO_MarkLeadLost.CancelActivities;
import POJO_MarkLeadLost.Root_MarkLeadLost;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Update_Lead extends API_Reusable {

	public static void UpdateLead() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

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
		RestAssured.baseURI = prop.getProperty("URL") + "/client/leads/" + leadID + ".json";

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

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().put();

		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
	}

	public static void UpdateLead(String APIKey, String ClientID, String leadID)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
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

		root.setApi_key(APIKey);
		root.setClient_id(ClientID);
		Lead.setSalutation("mr");
		Lead.setFirst_name("Aniket");
		Lead.setLast_name("LastName");
		Lead.setTime_zone("Asia/Calcutta");
		Lead.setStage("Prospect");
		Lead.setStatus(null);
		Lead.setNri(false);
		receivedFrom.setCampaign_id("");
		receivedFrom.setProject_id("");
		receivedFrom.setSource("");
		Lead.setReceived_from(receivedFrom);
		primaryEmail.setEmail("i77wgzksysu@sell.do");
		primaryEmail.setEmail_type("office");
		Lead.setPrimary_email(primaryEmail);
//		ArrayList<String> project_ids = new ArrayList<String>();
//		project_ids.add("64b0dbb8b08345f63030cd4c");
//		Lead.setInterested_project_ids(project_ids);
		// Lead.setSales_id("587ddb2b5a9db31da9000001");
		root.setLead(Lead);
		String URL = prop.getProperty("URL") + "/client/leads/" + leadID + ".json";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().put(URL);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
	}

	public void UpdateLead_stage(String leadID, String stage) throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
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

		root.setApi_key(prop("Clinet_API_Full"));
		root.setClient_id(prop("Client_id"));
		Lead.setSalutation("mr");
		Lead.setFirst_name("Aniket");
		Lead.setLast_name("LastName");
		Lead.setTime_zone("Asia/Calcutta");
		Lead.setStage(stage);
		Lead.setStatus(null);
		Lead.setNri(false);
		receivedFrom.setCampaign_id("");
		receivedFrom.setProject_id("");
		receivedFrom.setSource("");
		Lead.setReceived_from(receivedFrom);
		primaryEmail.setEmail("i77wgzksysu@sell.do");
		primaryEmail.setEmail_type("office");
		Lead.setPrimary_email(primaryEmail);
		ArrayList<String> project_ids = new APIs().getAllProjectID();
		Lead.setInterested_project_ids(project_ids);
		Lead.setSales_id(prop("Sales_id"));
		root.setLead(Lead);
		String URL = prop.getProperty("URL") + "/client/leads/" + getLeadId(leadID) + ".json";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().put(URL);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
	}

	public void LeadStageChnage(String leadCRMid,String stage) {
		CancelActivities CancelActivities = new CancelActivities();
		CancelActivities.setFollowups(false);
		CancelActivities.setSite_visits(false);
		Root_MarkLeadLost Root_MarkLeadLost = new Root_MarkLeadLost();
		Root_MarkLeadLost.setCancel_activities(CancelActivities);
		Root_MarkLeadLost.setStage(stage);
		Root_MarkLeadLost.setStage_change_reason("no_followup");
		String url = prop("URL")+"/client/leads/"+getLeadId(leadCRMid);
		given().urlEncodingEnabled(true).contentType(ContentType.JSON).body(Root_MarkLeadLost).with()
				.queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().put(url);
	}
	public String getLeadId(String leadCRMID) {

		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("search", "#" + leadCRMID).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(prop("URL") + "/client/get_db_id").then()
				.extract().response();
		String leadCRMid = response.jsonPath().getString("id[0]").trim();
		return leadCRMid;
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException {

	}
}
