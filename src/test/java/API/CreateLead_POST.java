package API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import com.selldo.Utility.API_Reusable;

import POJO_LeadCreate.AddressesField;
import POJO_LeadCreate.Form;
import POJO_LeadCreate.Lead;
import POJO_LeadCreate.Note;
import POJO_LeadCreate.PrimaryEmail;
import POJO_LeadCreate.PrimaryPhone;
import POJO_LeadCreate.Profile;
import POJO_LeadCreate.ReceivedFrom;
import POJO_LeadCreate.Requirement;
import POJO_LeadCreate.RootLeadCreate;
import POJO_LeadCreate.SellDo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateLead_POST extends API_Reusable {

	public static String createLeadByAPI() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		Note note = new Note();
		note.setContent("Note Rest");

		AddressesField addressesField = new AddressesField();
		PrimaryEmail primaryEmail = new PrimaryEmail();
		PrimaryPhone primaryPhone = new PrimaryPhone();
		Profile profile = new Profile();
		ReceivedFrom receivedFrom = new ReceivedFrom();
		Requirement requirement = new Requirement();

		Lead lead = new Lead();
		lead.setFirst_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setLast_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setEmail(randomEmail2());
		lead.setPhone(randomPhone2());
		lead.setSalutation("mr");
		lead.setTime_zone("Asia/Calcutta");
		lead.setStage("incoming");
		lead.setStatus(null);
		lead.setNri(false);
		lead.setProject_id("");
		lead.setSales("587f196f5a9db39c6e000004");
		

		Form form = new Form();
		form.setNote(note);
		form.setRequirement(requirement);
		form.setLead(lead);
		SellDo selldo = new SellDo();
		selldo.setForm(form);
		RootLeadCreate root = new RootLeadCreate();
		root.setSell_do(selldo);
		root.setApi_key("fa8d6ca0217e676a7b0e06f51c32568c");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root)
				.post(prop.getProperty("URL") + "/api/leads/create");

		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
		System.out.println("Lead id >> " + jsnPath.getString("sell_do_lead_id"));
		return "#" + jsnPath.getString("sell_do_lead_id");

	}

	public static String createLeadByAPI(String APIKey, String User) {

		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Note note = new Note();
		note.setContent("Note By Rest Assured");

		AddressesField addressesField = new AddressesField();
		PrimaryEmail primaryEmail = new PrimaryEmail();
		PrimaryPhone primaryPhone = new PrimaryPhone();
		Profile profile = new Profile();
		ReceivedFrom receivedFrom = new ReceivedFrom();
		Requirement requirement = new Requirement();

		Lead lead = new Lead();
		lead.setFirst_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setLast_name(RandomStringUtils.randomAlphanumeric(7));
		lead.setEmail(randomEmail2());
		lead.setPhone(randomPhone2());
		lead.setSalutation("mr");
		lead.setTime_zone("Asia/Calcutta");
		lead.setStage("incoming");
		lead.setStatus(null);
		lead.setNri(false);
		lead.setProject_id("");
		lead.setSales(User);

		Form form = new Form();
		form.setNote(note);
		form.setRequirement(requirement);
		form.setLead(lead);
		SellDo selldo = new SellDo();
		selldo.setForm(form);
		RootLeadCreate root = new RootLeadCreate();
		root.setSell_do(selldo);
		root.setApi_key(APIKey);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root)
				.post(prop.getProperty("URL") + "/api/leads/create").then().parser("text/html", Parser.JSON).extract().response();

//		int statusCode = response.getStatusCode();
//		System.out.println("Status code: " + statusCode);
//		String responseBody = response.getBody().asString();
//		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
		// System.out.println("Lead id >> " + jsnPath.getString("sell_do_lead_id"));
		return "#" + jsnPath.getString("sell_do_lead_id");

	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String apiKeyWebSite = "3a24cf56e28d5ab1bf0ff6f23e0a0347";
		String apiKeyFullAccess = "c4d649781e5451ce2903b34b02496e2c";
		String user = "";
		CreateLead_POST.createLeadByAPI(apiKeyWebSite, user);
	}

}
