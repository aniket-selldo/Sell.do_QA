package API;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PushLead {

	public static String PushToSales(String api_key, String client_id, String leadID,String projectID)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		String onlyProject = "{\n" + "    \"project_id\":\""+projectID+"\"\n" + "}";
		String onlyTeam = "{\n" + "    \"project_id\":\""+projectID+"\"\n" + "}";
		Response response = RestAssured
				.given().contentType(ContentType.JSON).body(onlyProject).post(prop.getProperty("URL") + "/client/leads/"
						+ leadID + "/push_to_sales?api_key=" + api_key + "&client_id=" + client_id + "")
				.then().extract().response();

		return response.jsonPath().getString("assigned_sales_person_name");

	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String apiKeyWebSite = "fa8d6ca0217e676a7b0e06f51c32568c";
		String apiKeyFullAccess = "c13ad8e13264b1c22bc39bb475889c7e";
		String user = "587ddb2b5a9db31da9000001";
		String clinetID = "587ddb2b5a9db31da9000002";
		PushToSales(apiKeyFullAccess,clinetID,"64bf9a33b08345ff2d39edfa","587dec4626300a3aca00001c");
	}
}
