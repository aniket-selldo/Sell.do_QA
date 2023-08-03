package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import com.selldo.Utility.API_Reusable;

import POJO_CreateFollowup.Followup;
import POJO_CreateFollowup.RootFolloup;
import POJO_CreateFollowup_GET.Root_followUp_Get;
import POJO_GetAllActivityOnLead.Root_GetAllLeadActivity;
import POJO_GetAllUser_GET_2.Root_GetAllUser_GET_2;
import POJO_LeadCreate.Form;
import POJO_LeadCreate.Lead;
import POJO_LeadCreate.Note;
import POJO_LeadCreate.RootLeadCreate;
import POJO_LeadCreate.SellDo;
import POJO_LeadCreate_GET.Root_CreateLead_GET;
import POJO_SiteVisit.RootCreateSiteVisit;
import POJO_SiteVisit.SiteVisit;
import POJO_SiteVisit_GET.Root_sitevisitSchedule_Get;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class APIs extends API_Reusable {

// ==================================== FollowUp ===========================================================
	public Root_followUp_Get createFollowUp(String API_Key, String ClientID, String leadID) {

		Followup followup = new Followup();
		followup.setFollowup_type("email");
		followup.setLead_id(leadID);
		String futureDate = new SimpleDateFormat("dd-MM-yyyy HH:mm")
				.format(new Date().getTime() + (1 * (1000 * 60 * 60 * 24))) + " IST";
		followup.setScheduled_on(futureDate);
		followup.setStatus("scheduled");
		followup.setSubject("Subject By RestAssured");
		followup.setAgenda("Agenda By RestAssured");
		followup.setType("followup");
		RootFolloup root = new RootFolloup();
		root.setApi_key(API_Key);
		root.setClient_id(ClientID);
		root.setFollowup(followup);

		Response response = RestAssured.given().relaxedHTTPSValidation().urlEncodingEnabled(true)
				.contentType(ContentType.JSON).body(root)
				.post(prop("URL") + "/client/leads/" + leadID + "/followups.json");
		return response.as(Root_followUp_Get.class);
	}

	// ============================ Site Visit =========================

	public Root_sitevisitSchedule_Get createSiteVisit(String APIKey, String CliendID, String USerID, String leadCRMID) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now) + ":59 IST";
		System.out.println("Date >> " + date);

		RootCreateSiteVisit root = new RootCreateSiteVisit();
		SiteVisit siteVisit = new SiteVisit();

		siteVisit.setProject_id(getAllProjectID().get(0));
		String CurrentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (10 * 60000))
				+ " IST";
		siteVisit.setScheduled_on(CurrentTime);
		String NextTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (25 * 60000)) + " IST";
		siteVisit.setEnds_on(NextTime);
		siteVisit.setSales_id(USerID);
		siteVisit.setSitevisit_type("visit");// visit | home_visit | online_walkthrough
		siteVisit.setAgenda("Agenda By Rest Assured");
		siteVisit.setConfirmed(false);
		siteVisit.setLead_crm_id(leadCRMID);
		siteVisit.setRating("4");
		siteVisit.setTest("test");

		root.setApi_key(APIKey);
		root.setClient_id(CliendID);
		root.setSite_visit(siteVisit);

		String leadID = getLeadId(leadCRMID);
		String url = prop("URL") + "/client/leads/" + leadID + "/site_visits.json";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).post(url);
		return response.as(Root_sitevisitSchedule_Get.class);

	}

	// ============================ Lead Related =========================

	public String getLeadId(String leadCRMID) {

		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("search", "#" + leadCRMID).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(prop("URL") + "/client/get_db_id").then()
				.extract().response();
		String leadCRMid = response.jsonPath().getString("id[0]").trim();
		return leadCRMid;
	}

	public Root_GetAllLeadActivity getAllLeadActivity( String leadCRMID) {
		String URL = prop("URL") + "/client/leads/" + getLeadId(leadCRMID) + "/activities?api_key=" + prop("Clinet_API_Full") + "&client_id="
				+ prop("Client_id");
		return RestAssured.given().contentType(ContentType.JSON).when().get(URL).then().extract().response()
				.as(Root_GetAllLeadActivity.class);
	}

	public Root_CreateLead_GET createLead(String User) {

		Note note = new Note();
		note.setContent("Note By Rest Assured");

		Lead lead = new Lead();
		lead.setFirst_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setLast_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setEmail(RandomStringUtils.randomAlphanumeric(10) + "@sell.do");
		lead.setPhone("7" + RandomStringUtils.randomNumeric(9));
		lead.setSalutation("mr");
		lead.setTime_zone("Asia/Calcutta");
		lead.setStage("incoming");
		lead.setStatus(null);
		lead.setNri(false);
		lead.setProject_id("");
		lead.setSales(User);
		Form form = new Form();
		form.setNote(note);
		form.setLead(lead);
		SellDo selldo = new SellDo();
		selldo.setForm(form);
		RootLeadCreate root = new RootLeadCreate();
		root.setSell_do(selldo);
		root.setApi_key(prop("Clinet_API_Res"));

		return RestAssured.given().urlEncodingEnabled(true).contentType(ContentType.JSON).body(root).when()
				.post(prop("URL") + "/api/leads/create").then().parser("text/html", Parser.JSON).extract().response()
				.as(Root_CreateLead_GET.class);
	}
	// ============================ Other =========================

	public ArrayList<String> getAllProjectID() {

		String page = null;
		ArrayList<String> ary = new ArrayList<String>();

		String URL = prop("URL") + "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response().jsonPath()
				.getInt("total");
		System.out.println("Total Project On this client is " + totalProject);
		int totalPage = (totalProject / 15);

		for (int i = 1; i <= totalPage; i++) {
			Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
					.queryParam("page", i).queryParam("client_id", prop("Client_id"))
					.queryParam("api_key", prop("Clinet_API_Full")).when().get().then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "]._id"));
			}
		}
		return ary;
	}

	public String getProjectID(String nameOfProject) {

		String page = null;
		ArrayList<String> ary = new ArrayList<String>();

		String URL = prop("URL") + "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response().jsonPath()
				.getInt("total");
		System.out.println("Total Project On this client is " + totalProject);
		int totalPage = (totalProject / 15);

		for (int i = 1; i <= totalPage; i++) {
			Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
					.queryParam("page", i).queryParam("client_id", prop("Client_id"))
					.queryParam("api_key", prop("Clinet_API_Full")).when().get().then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "].name"));
			}
		}
		return ary.stream().filter(S -> S.equalsIgnoreCase(nameOfProject)).findFirst().get();
	}

	public String getProjectName(String nameOfProject) {

		String page = null;
		ArrayList<String> ary = new ArrayList<String>();

		String URL = prop("URL") + "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response().jsonPath()
				.getInt("total");
		System.out.println("Total Project On this client is " + totalProject);
		int totalPage = (totalProject / 15);

		for (int i = 1; i <= totalPage; i++) {
			Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
					.queryParam("page", i).queryParam("client_id", prop("Client_id"))
					.queryParam("api_key", prop("Clinet_API_Full")).when().get().then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "]._id"));
			}
		}
		return ary.stream().filter(S -> S.equalsIgnoreCase(nameOfProject)).findFirst().get();
	}
	// ============================ User related =========================

	public Root_GetAllUser_GET_2 getUserList() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		String full = prop.getProperty("URL") + "/client/users.json?api_key=" + prop("Clinet_API_Full") + "&client_id="
				+ prop("Client_id");
		return RestAssured.given().when().get(full).then().extract().response().as(Root_GetAllUser_GET_2.class);
	}

	public String GetUserNameByID(String id) {
		try {
			return getUserList().getAll_users().stream().filter(S -> S.getId().equalsIgnoreCase(id))
					.map(S -> S.getText()).findFirst().get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String GetUserIDByName(String name) {
		try {
			return getUserList().getAll_users().stream().filter(S -> S.getText().trim().equalsIgnoreCase(name))
					.map(S -> S.getId()).findFirst().get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void Tests() throws FileNotFoundException, IOException {

		String apiFull = "d2d386fbcc9805220d76fa9137519e78";
		String APIRes = "fa8d6ca0217e676a7b0e06f51c32568c";
		String clientID = "587ddb2b5a9db31da9000002";
		String Userid = "587ddb2b5a9db31da9000001";
		getAllLeadActivity("10380").getResults().stream().forEach(S->System.out.println(S.getNote().getContent()));
	}

}
