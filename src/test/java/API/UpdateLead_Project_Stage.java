package API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.selldo.Utility.API_Reusable;

import POJO_LeadUpdate_Stage_Project.Lead;
import POJO_LeadUpdate_Stage_Project.Root;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateLead_Project_Stage extends API_Reusable  {
	public static void updateProjectAndStage(String APIKey, String ClientID, String leadID, String leadStage,
			ArrayList<String> str) throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		Lead lead = new Lead();
		lead.setStage(leadStage);
		lead.setInterested_project_ids(str);
		Root root = new Root();
		root.setLead(lead);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).put(prop.getProperty("URL")
				+ "/client/leads/" + leadID + ".json?api_key=" + APIKey + "&client_id=" + ClientID + "");

	}
	public static String CreateUpdateProjectAndStageOfLead(String leadStage,
			int addProjectNumber) throws FileNotFoundException, IOException {
		String leadCRMID= new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
		String leadID =new APIs().getLeadId(leadCRMID);
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		Lead lead = new Lead();
		lead.setStage(leadStage);
		lead.setInterested_project_ids(new GetAllProjectIDAndName().getAllProjectID(addProjectNumber));
		Root root = new Root();
		root.setLead(lead);

		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).put(prop.getProperty("URL")
				+ "/client/leads/" + leadID + ".json?api_key=" + prop("Clinet_API_Full") + "&client_id=" + prop("Client_id") + "");
		return "#"+leadCRMID;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String apiKeyFullAccess = "c4d649781e5451ce2903b34b02496e2c";
		String clinetID = "64a2be1db0834560eaa19563";
		ArrayList<String> ary = new ArrayList<String>();
		ary.add("64b0dbb8b08345f63030cd4c");
		ary.add("64b10c0cb0834554d124d993");
		ary.add("64b10e6cb0834554d124d99a");
		UpdateLead_Project_Stage.updateProjectAndStage(apiKeyFullAccess, clinetID, "64be9ce9b08345274d50f467", "prospect", ary);

	}
}
