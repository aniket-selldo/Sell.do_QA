package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetLeadID {

	public static String getLeadId(String APIKey, String ClientID, String leadID) {
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

		RestAssured.baseURI = prop.getProperty("URL");
		RestAssured.basePath = "/client/get_db_id";
		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("search", "#" + leadID).queryParam("client_id", ClientID).queryParam("api_key", APIKey)
				.when().get().then().extract().response();
		String TotalLeadCount = response.jsonPath().getString("id[0]");
		return TotalLeadCount;
	}

}
