package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllProjectIDAndName {

	public static ArrayList<String> getAllProjectID(String APIKey, String ClientID)
			throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		String page = null;
		ArrayList<String> ary = new ArrayList<String>();

		RestAssured.baseURI = prop.getProperty("URL");
		RestAssured.basePath = "/client/projects.json";
		int totalProject = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("page", page).queryParam("client_id", ClientID).queryParam("api_key", APIKey).when().get()
				.then().extract().response().jsonPath().getInt("total");
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

}
