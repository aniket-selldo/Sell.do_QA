package API;

import org.apache.commons.lang3.RandomStringUtils;

import POJO_LeadCreate.AddressesField;
import POJO_LeadCreate.Form;
import POJO_LeadCreate.Lead;
import POJO_LeadCreate.Note;
import POJO_LeadCreate.PrimaryEmail;
import POJO_LeadCreate.PrimaryPhone;
import POJO_LeadCreate.Profile;
import POJO_LeadCreate.ReceivedFrom;
import POJO_LeadCreate.Requirement;
import POJO_LeadCreate.Root;
import POJO_LeadCreate.SellDo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateLead_POST {
	public static String createLeadByAPI() {

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
		lead.setEmail(RandomStringUtils.randomAlphanumeric(10)+"@sell.do");
		lead.setPhone("123"+RandomStringUtils.randomNumeric(7));
		lead.setSalutation("mr");
		lead.setTime_zone("Asia/Calcutta");
		lead.setStage("incoming");
		lead.setStatus(null);
		lead.setNri(false);
		lead.setProject_id("");
		lead.setSales("642a9b11b083454f959c1b14");

		Form form = new Form();
		form.setNote(note);
		form.setRequirement(requirement);
		form.setLead(lead);
		SellDo selldo = new SellDo();
		selldo.setForm(form);
		Root root = new Root();
		root.setSell_do(selldo);
		root.setApi_key("05982fc554c597db3bd1db3a4e6fb9b9");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all()
				.post("https://v2.sell.do/api/leads/create");

		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
		System.out.println("Lead id >> " + jsnPath.getString("sell_do_lead_id"));
		return "#"+jsnPath.getString("sell_do_lead_id");

	}
	public static String createLeadByAPI(String APIKey,String User) {

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
		lead.setEmail(RandomStringUtils.randomAlphanumeric(10)+"@sell.do");
		lead.setPhone("123"+RandomStringUtils.randomNumeric(7));
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
		Root root = new Root();
		root.setSell_do(selldo);
		root.setApi_key(APIKey);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all()
				.post("https://v2.sell.do/api/leads/create");

		int statusCode = response.getStatusCode();
		System.out.println("Status code: " + statusCode);
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		JsonPath jsnPath = response.jsonPath();
		System.out.println("Lead id >> " + jsnPath.getString("sell_do_lead_id"));
		return "#"+jsnPath.getString("sell_do_lead_id");

	}

}
