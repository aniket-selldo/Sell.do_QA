package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import com.selldo.Utility.API_Reusable;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProjectIDAndName extends API_Reusable {

	public static ArrayList<String> getAllProjectID(String APIKey, String ClientID)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		String page = null;
		ArrayList<String> ary = new ArrayList<String>();

		String url = prop.getProperty("URL") + "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id", ClientID).queryParam("api_key", APIKey).when()
				.get(url).then().extract().response().jsonPath().getInt("total");
		System.out.println("Total Project On this client is " + totalProject);

		int totalPage = totalProject;
		if (totalProject > 15) {
			totalPage = (totalProject / 15);
		}

		for (int i = 1; i <= totalPage; i++) {
			Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
					.queryParam("page", i).queryParam("client_id", ClientID).queryParam("api_key", APIKey).when()
					.get(url).then().extract().response();
			for (int j = 0; j < 15; j++) {
				ary.add(response.jsonPath().getString("results[" + j + "]._id"));
				// System.out.println(response.jsonPath().getString("results[" + j + "]._id"));
			}
		}
		return ary;
	}

	public static ArrayList<String> getAllProjectID(int numberOfProject)
			 {


		String page = null;
		ArrayList<String> ary = new ArrayList<String>();

		String url = prop("URL") + "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id",  prop("Client_id")).queryParam("api_key", prop("Clinet_API_Full")).when()
				.get(url).then().extract().response().jsonPath().getInt("total");
		System.out.println("Total Project On this client is " + totalProject + " But Add on Lead " + numberOfProject);

		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with().queryParam("page", 1)
				.queryParam("client_id", prop("Client_id")).queryParam("api_key", prop("Clinet_API_Full")).when().get(url).then().extract()
				.response();
		for (int j = 0; j < numberOfProject; j++) {
			ary.add(response.jsonPath().getString("results[" + j + "]._id"));
			// System.out.println(response.jsonPath().getString("results[" + j + "]._id"));
		}
		return ary;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		String apiKeyFullAccess = "c4d649781e5451ce2903b34b02496e2c";
		String clinetID = "64a2be1db0834560eaa19563";
		getAllProjectID(apiKeyFullAccess, clinetID);
	}

}
