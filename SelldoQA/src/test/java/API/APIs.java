package API;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Test;

import com.selldo.Utility.API_Reusable;

import POJO_CreateFollowup.Followup;
import POJO_CreateFollowup.RootFolloup;
import POJO_CreateFollowup_GET.Root_followUp_Get;
import POJO_GetAllActivityOnLead.Root_GetAllLeadActivity;
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

		siteVisit.setProject_id(getAllProjectID(APIKey, CliendID).get(0));
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

		String leadID = getLeadId(APIKey, CliendID, leadCRMID);
		String url = prop("URL") + "/client/leads/" + leadID + "/site_visits.json";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).post(url);
		return response.as(Root_sitevisitSchedule_Get.class);

	}

	// ============================ Lead Related  =========================

	public String getLeadId(String APIKey, String ClientID, String leadCRMID) {

		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("search", "#" + leadCRMID).queryParam("client_id", ClientID).queryParam("api_key", APIKey)
				.when().get(prop("URL") + "/client/get_db_id").then().log().all().extract().response();
		String leadCRMid = response.jsonPath().getString("id[0]").trim();
		return leadCRMid;
	}
	public Root_GetAllLeadActivity get(String fullAPI,String ClientID,String leadID) {
		String URL = prop("URL")+"/client/leads/"+leadID+"/activities?api_key="+fullAPI+"&client_id="+ClientID;
		return RestAssured.given().contentType(ContentType.JSON).when().get(URL).then().extract().response()
				.as(Root_GetAllLeadActivity.class);
	}

	public Root_CreateLead_GET createLead(String APIKey, String User) {

		Note note = new Note();
		note.setContent("Note By Rest Assured");

		Lead lead = new Lead();
		lead.setFirst_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setLast_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setEmail(RandomStringUtils.randomAlphanumeric(10) + "@sell.do");
		lead.setPhone("123" + RandomStringUtils.randomNumeric(7));
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
		root.setApi_key(APIKey);

		return RestAssured.given().urlEncodingEnabled(true).contentType(ContentType.JSON).body(root).when().post(prop("URL") + "/api/leads/create").then().parser("text/html", Parser.JSON).extract().response().as(Root_CreateLead_GET.class);
	}
	// ============================ Other  =========================

	public ArrayList<String> getAllProjectID(String APIKey, String ClientID) {
		
		String page = null;
		ArrayList<String> ary = new ArrayList<String>();
		
		String URL = prop("URL") + "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id", ClientID).queryParam("api_key", APIKey).when()
				.get(URL).then().extract().response().jsonPath().getInt("total");
		System.out.println("Total Project On this client is " + totalProject);
		int totalPage = (totalProject / 15);
		
		for (int i = 1; i <= totalPage; i++) {
			Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
					.queryParam("page", i).queryParam("client_id", ClientID).queryParam("api_key", APIKey).when().get()
					.then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "]._id"));
				// System.out.println(response.jsonPath().getString("results[" + j + "]._id"));
			}
		}
		return ary;
	}
	
	@Test
	public void Tests() throws FileNotFoundException, IOException {

		String apiFull = "c13ad8e13264b1c22bc39bb475889c7e";
		String APIRes = "fa8d6ca0217e676a7b0e06f51c32568c";
		String clientID = "587ddb2b5a9db31da9000002";
		String Userid = "587ddb2b5a9db31da9000001";
		String LEADCRMID =createLead(APIRes, Userid).getSell_do_lead_id();
		System.out.println(">>>>>>>"+LEADCRMID);
		String leadID=getLeadId(apiFull,clientID,LEADCRMID);
		
		Update_Lead.UpdateLead(apiFull, clientID, leadID);
	}

}
