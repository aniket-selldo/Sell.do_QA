package API;

import java.io.FileInputStream;
import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import com.selldo.Utility.API_Reusable;

import Enums.APIKeys;
import POJO_CreateFollowup.Followup;
import POJO_CreateFollowup.RootFolloup;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateFollowUp extends API_Reusable {

	public static void createFollowUp(APIKeys API_Key, APIKeys ClientID, String leadID)
			throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now) + ":59 IST";
		System.out.println("Date >> " + date);

		RestAssured.baseURI = prop.getProperty("URL") + "/client/leads/" + leadID + "/followups.json";

		Followup followup = new Followup();
		followup.setFollowup_type("email");
		followup.setLead_id(leadID);
		followup.setScheduled_on(date);
		followup.setStatus("scheduled");
		followup.setSubject("Update");
		followup.setAgenda("agenda");
		followup.setType("followup");

		RootFolloup root = new RootFolloup();
		root.setApi_key(API_Key.toString());
		root.setClient_id(ClientID.toString());
		root.setFollowup(followup);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post();
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
	}

	public void createFollowUp(String leadID)  {
//		Properties prop = new Properties();
//		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
//		LocalDateTime now = LocalDateTime.now();
//		String date = dtf.format(now) + ":59 IST";
//		System.out.println("Date >> " + date);

		String URL= prop("URL") + "/client/leads/" + getLeadId(leadID) + "/followups.json";

		Followup followup = new Followup();
		followup.setFollowup_type("email");
		followup.setLead_id(getLeadId(leadID));
		String CurrentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (10 * 60000))
				+ " IST";
		followup.setScheduled_on(CurrentTime);
		followup.setStatus("scheduled");
		followup.setSubject("Update");
		followup.setAgenda("agenda");
		followup.setType("followup");

		RootFolloup root = new RootFolloup();
		root.setApi_key(prop("Clinet_API_Full"));
		root.setClient_id(prop("Client_id"));
		root.setFollowup(followup);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post(URL);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
	}
	public String getLeadId(String leadCRMID) {

		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("search", "#" + leadCRMID).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(prop("URL") + "/client/get_db_id").then()
				.extract().response();
		String leadCRMid = response.jsonPath().getString("id[0]").trim();
		return leadCRMid;
	}

	public static void main(String[] args) {

//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
//		LocalDateTime now = LocalDateTime.now();
//		String date = dtf.format(now) + ":59 IST";
//		System.out.println("Date >> " + date);
//
//		String leadID = "647f332cb08345ab2f35a314";
//		RestAssured.baseURI = "https://v2.sell.do/client/leads/" + leadID + "/followups.json";
//
//		Followup followup = new Followup();
//		followup.setFollowup_type("email");
//		followup.setLead_id(leadID);
//		followup.setScheduled_on(date);
//		followup.setStatus("scheduled");
//		followup.setSubject("Update");
//		followup.setAgenda("agenda");
//		followup.setType("followup");
//
//		RootFolloup root = new RootFolloup();
//		root.setApi_key("99c4b48c7732b5183000999d1200d520");
//		root.setClient_id("642a8145b083453f914ce854");
//		root.setFollowup(followup);
//
//		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post();
//
//		int statusCode = response.getStatusCode();
//		System.out.println("Status code: " + statusCode);
//		String responseBody = response.getBody().asString();
//		System.out.println("Response body: " + responseBody);
//		JsonPath jsnPath = response.jsonPath();
//		System.out.println("Lead id >> " + jsnPath.getString("sell_do_lead_id"));

		new CreateFollowUp().createFollowUp("10267");
	}
}
