package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.API_Reusable;

import POJO_CreateFollowup.Followup;
import POJO_CreateFollowup.RootFolloup;
import POJO_CreateFollowup_GET.Root_followUp_Get;
import POJO_GetAllActivityOnLead.Root_GetAllLeadActivity;
import POJO_GetAllDevloperID.Root_GetAllDevID;
import POJO_GetAllUser_GET_2.Root_GetAllUser_GET_2;
import POJO_GetUnitConfiguration.Root_GetAllUnitConfigurationID;
import POJO_Get_Sales_PreSales_PostSales_GET.Root_GetUsersWithType;
import POJO_LeadCreate.Form;
import POJO_LeadCreate.Lead;
import POJO_LeadCreate.Note;
import POJO_LeadCreate.RootLeadCreate;
import POJO_LeadCreate.SellDo;
import POJO_LeadCreate_GET.Root_CreateLead_GET;
import POJO_SiteVisit.RootCreateSiteVisit;
import POJO_SiteVisit.SiteVisit;
import POJO_SiteVisit_GET.Root_sitevisitSchedule_Get;
import POJO_getAllProjectTowerID.Root_GetAllTowerID;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
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

	public ArrayList<String> getAllFollowupCancelationResons() {
		String URL = prop("URL") + "/client/configuration/followup_cancellation_reasons";
		Response res = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("client_id", prop("Client_id")).queryParam("api_key", prop("Clinet_API_Full")).when()
				.get(URL).then().extract().response();

		ArrayList<String> ary = new ArrayList<String>();
		System.out.println();
		for (int i = 0; i < 6; i++) {
			ary.add(res.jsonPath().getString("[" + i + "].text"));
			System.out.println(res.jsonPath().getString("[" + i + "].text"));
		}
		return ary;

	}

	// ============================ Site Visit =========================

	public Root_sitevisitSchedule_Get createSiteVisit(String leadCRMID, int min_ahead) {

		RootCreateSiteVisit root = new RootCreateSiteVisit();
		SiteVisit siteVisit = new SiteVisit();

		siteVisit.setProject_id(getAllProjectID().get(0));
		// int min_ahead = 20;
		String CurrentTime = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (min_ahead * 60000))
				+ " IST";
		siteVisit.setScheduled_on(CurrentTime);
		String NextTime = new SimpleDateFormat("dd-MM-yyyy HH:mm")
				.format(new Date().getTime() + ((15 + min_ahead) * 60000)) + " IST";
		siteVisit.setEnds_on(NextTime);
		siteVisit.setSales_id(prop("Sales_id"));
		siteVisit.setSitevisit_type("visit");// visit | home_visit | online_walkthrough
		siteVisit.setAgenda("Agenda By Rest Assured");
		siteVisit.setConfirmed(true);
		siteVisit.setLead_crm_id(leadCRMID);
		siteVisit.setRating("4");
		siteVisit.setTest("test");

		root.setApi_key(prop("Clinet_API_Full"));
		root.setClient_id(prop("Client_id"));
		root.setSite_visit(siteVisit);

		String url = prop("URL") + "/client/leads/" + getLeadId(leadCRMID) + "/site_visits.json";
		return RestAssured.given().contentType(ContentType.JSON).body(root).post(url).then().extract().response()
				.as(Root_sitevisitSchedule_Get.class);

	}

	public void markAllSiteVisitConductedOnLead(String leadID) {

		getAllLeadActivity(leadID).getResults().stream()
				.filter(S -> S.getSite_visit() != null && S.getSite_visit().getStatus().equalsIgnoreCase("scheduled"))
				.forEach(S -> new MarkSiteVisitConducted().markSVSconducted(leadID, S.getSite_visit().get_id()));
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

	public Root_GetAllLeadActivity getAllLeadActivity(String leadCRMID) {
		String URL = prop("URL") + "/client/leads/" + getLeadId(leadCRMID) + "/activities?api_key="
				+ prop("Clinet_API_Full") + "&client_id=" + prop("Client_id");
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
	// Used in FU import
	public Root_CreateLead_GET createLead(String API ,String User,String email ,String phone) {

		Note note = new Note();
		note.setContent("Note By Rest Assured");

		Lead lead = new Lead();
		lead.setFirst_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setLast_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setEmail(email);
		lead.setPhone(phone);
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
		root.setApi_key(API);

		return RestAssured.given().urlEncodingEnabled(true).contentType(ContentType.JSON).body(root).when()
				.post(prop("URL") + "/api/leads/create").then().parser("text/html", Parser.JSON).extract().response()
				.as(Root_CreateLead_GET.class);
	}
	public Root_CreateLead_GET createLead(String api, String User) {

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
		root.setApi_key(api);

		return RestAssured.given().urlEncodingEnabled(true).contentType(ContentType.JSON).body(root).when()
				.post(prop("URL") + "/api/leads/create").then().parser("text/html", Parser.JSON).extract().response()
				.as(Root_CreateLead_GET.class);
	}

	// ============================ Inventry =========================

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
					.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "]._id"));
			}
		}
		return ary;
	}

	public String getRandomProjectID() {

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
					.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "]._id"));
			}
		}
		int index = (int) (Math.random() * ary.size());
		return ary.get(index);
	}

	public String getdisableEnventryName() {

		String page = null;
		ArrayList<String> flag = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();

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
					.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response();

			for (int j = 0; j < 15; j++) {
				flag.add(response.jsonPath().getString("results[" + j + "].inventory_enabled"));
				Name.add(response.jsonPath().getString("results[" + j + "].name"));
				if (response.jsonPath().getString("results[" + j + "].inventory_enabled").equalsIgnoreCase("false")) {
					return response.jsonPath().getString("results[" + j + "].name");
				}
			}
		}
		return null;
	}

	public String getEnableEnventryName() {

		String page = null;
		ArrayList<String> flag = new ArrayList<String>();
		ArrayList<String> Name = new ArrayList<String>();

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
					.queryParam("api_key", prop("Clinet_API_Full")).when().get(URL).then().extract().response();

			for (int j = 0; j < 15; j++) {
				flag.add(response.jsonPath().getString("results[" + j + "].inventory_enabled"));
				Name.add(response.jsonPath().getString("results[" + j + "].name"));
				if (response.jsonPath().getString("results[" + j + "].inventory_enabled").equalsIgnoreCase("true")) {
					return response.jsonPath().getString("results[" + j + "].name");
				}
			}
		}
		return null;
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

	public void AddDevloperInClient() {
		AddDevloper AddDevloper = new AddDevloper();
		System.out.println(AddDevloper.addDevloper().get_id());
	}

	public void AddProjectTower() {
		AddProjectTower AddProjectTower = new AddProjectTower();
		System.out.println(AddProjectTower.addProjectTower(getRandomProjectID()).get_id());
	}

	public Root_GetAllDevID[] GetAllDevloperID() {
		String URL = prop("URL") + "/client/developers.json";
		return given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
				.queryParam("client_id", prop("Client_id")).queryParam("api_key", prop("Clinet_API_Full")).when()
				.get(URL).then().extract().response().as(Root_GetAllDevID[].class);

	}

	public Root_GetAllTowerID[] getAllProjectTowerID() {
		String URL = prop("URL") + "/client/project_towers.json";
		return given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
				.queryParam("client_id", prop("Client_id")).queryParam("api_key", prop("Clinet_API_Full")).when()
				.get(URL).then().extract().response().as(Root_GetAllTowerID[].class);
	}

	public Root_GetAllUnitConfigurationID[] GetAllUnitConfigurationID() {
		String URL = prop("URL") + "/client/unit_configurations.json";
		return given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
				.queryParam("client_id", prop("Client_id")).queryParam("api_key", prop("Clinet_API_Full")).when()
				.get(URL).then().extract().response().as(Root_GetAllUnitConfigurationID[].class);
	}

	public String addUnit() {
		String str = null;
		given().urlEncodingEnabled(true).contentType(ContentType.URLENC)
				.formParam("project_unit[developer_id]", GetAllDevloperID()[0].get_id())
				.formParam("project_unit[project_id]", new GetAllProjectIDAndName().getAllProjectID(1).get(0))
				.formParam("project_unit[project_tower_id]", getAllProjectTowerID()[0].get_id())
				.formParam("project_unit[unit_configuration_id]", GetAllUnitConfigurationID()[0].get_id())
				.formParam("project_unit[name]", str = Random("AN", 10)).formParam("project_unit[floor]", "2")
				.formParam("project_unit[unit_index]", "2").formParam("project_unit[base_rate]", "2580")
				.formParam("project_unit[base_price]", "1754400")
				.formParam("project_unit[calculated_agreement_value]", "")
				.formParam("project_unit[calculated_total_price]", "0.0").formParam("project_unit[security_amount]", "")
				.formParam("project_unit[maintenance_amount]", "").formParam("project_unit[property_purpose]", "sale")
				.formParam("project_unit[type]", "apartment").formParam("project_unit[category]", "premium")
				.formParam("project_unit[bedrooms]", "0").formParam("project_unit[bathrooms]", "0")
				.formParam("project_unit[measure]", "sq_ft").formParam("project_unit[carpet]", "680")
				.formParam("project_unit[saleable]", "680").formParam("project_unit[loading]", "11.7647")
				.formParam("commit", "Save").formParam("api_key", prop("Clinet_API_Full"))
				.formParam("client_id", prop("Client_id")).when().post(prop("URL") + "/client/project_units.json")
				.then().extract().response();
		return str;
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

	public void getUserData(String userRole, String flag) {
		GetUser GetUser = new GetUser();
		Root_GetUsersWithType[] ary = GetUser.getAll("presales", flag);
	}
	// ============================ Other =========================

	public JsonPath getConstant(String id, String password) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get(prop("URL"));
		new LoginPage(driver).login(id, password);

		Cookie CRM_session = driver.manage().getCookieNamed("_crm_session");
		Cookie sesion_id = driver.manage().getCookieNamed("_session_id");

		String url = prop("URL") + "/client/constants";
		JsonPath js = RestAssured.given().with()
				.header("Cookie", "_crm_session=" + CRM_session.getValue() + ";_session_id=" + sesion_id.getValue())
				// .header("Cookie", ck)
				.header("Host", prop("URL").split("//")[1]).header("Accept", "*/*").when().get(url).then().log().all()
				.extract().response().jsonPath();
		System.out.println("Constant API working Fine");
		return js;

	}

	public String[] getFullAccessAPI(String id, String password) {
		JsonPath js = getConstant(id, password);
		int numberOfAPIs = js.getInt("Constants.api_clients.size()");
		String Full = null;
		String Res = null;
		for (int i = 0; i < numberOfAPIs - 1; i++) {
			String APIType = js.getString("Constants.api_clients["+i+"].name").trim();
			String APICategory = js.getString("Constants.api_clients[" + i + "].category").trim();
			if (APIType.equalsIgnoreCase("selldo access") && APICategory.equalsIgnoreCase("full_access")) {
				Full = js.getString("Constants.api_clients[" + i + "]._id");
			} else if (APIType.equalsIgnoreCase("website") && APICategory.equalsIgnoreCase("restricted")) {
				Res = js.getString("Constants.api_clients[" + i + "]._id");
			}
		}
		String out[] = { Full, Res };
		return out;
	}

	public static void main(String[] args) {
		APIs api = new APIs();
		String []apiss=api.getFullAccessAPI(prop("Sales_email"), prop("Password"));
		System.out.println(apiss[0]);
		System.out.println(apiss[1]);
		
		
	}

}
