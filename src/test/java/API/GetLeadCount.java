package API;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetLeadCount {
	static String ClientID ="64a2be1db0834560eaa19563";
	static String APIKey ="c4d649781e5451ce2903b34b02496e2c";
	static String search_criterium ="64a2be1db0834560eaa1956c";

	public static void getleadData() throws FileNotFoundException, IOException {
		List<POJOLead> LMI = new ArrayList<POJOLead>();
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		int count = leadCount();
		int devide = count / 25;
		for (int j = 1; j <= 10; j++) {

			RestAssured.baseURI = prop.getProperty("URL");
			RestAssured.basePath = "/client/leads.json";
			Response response = given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
					.queryParam("search_criterium%5Bid%5D", search_criterium)
					.queryParam("search_criterium%5Bname%5D", "all_leads").queryParam("page", j)
					.queryParam("per_page", "25")
					.queryParam("client_id", ClientID)
					.queryParam("api_key", APIKey).when().get().then()
					.extract().response();
			int TotalLeadCount = response.jsonPath().getInt("results.size()");
			// System.out.println("Size -> " + TotalLeadCount);

			for (int i = 0; i < TotalLeadCount; i++) {
				String ID = response.jsonPath().getString("results[" + i + "]._id");
				String FName = response.jsonPath().getString("results[" + i + "].first_name");
				String LName = response.jsonPath().getString("results[" + i + "].last_name");
				String CRMID = response.jsonPath().getString("results[" + i + "].lead_id");
				String SalesName = response.jsonPath().getString("results[" + i + "].sales_name");
				String SalesID = response.jsonPath().getString("results[" + i + "].sales_id");
				String LeadStage = response.jsonPath().getString("results[" + i + "].stage");
				String name = response.jsonPath().getString("results[" + i + "].name");
				String email = response.jsonPath().getString("results[" + i + "].ui_primary_email.email");
				String emailType = response.jsonPath().getString("results[" + i + "].ui_primary_email.email_type");
				String LeadDepartment = response.jsonPath().getString("results[" + i + "].department");

				LMI.add(new POJOLead(ID, FName, LName, CRMID, SalesName, SalesID, LeadStage, name, email, emailType,
						LeadDepartment));
			}
		}
		
		for (POJOLead pojoLead : LMI) {
			System.out.println(pojoLead.toString());
		}
	}

	public static int leadCount() throws FileNotFoundException, IOException {
		Properties prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));

		RestAssured.baseURI = prop.getProperty("URL");
		RestAssured.basePath = "/client/leads.json";
		Response response = given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
				.queryParam("called_from", "get_leads_count")
				.queryParam("search_criterium%5Bid%5D", search_criterium)
				// .queryParam("search_criterium%5Bsearch%5D", "")
				.queryParam("search_criterium%5Bsearch_attributes%5D%5Blisted_by%5D", "buyers")
				// .queryParam("search_criterium%5Bsearch_attributes%5D%5Bdate_range%5D",
				// "actual%3D12-04-2023to12-07-2023")
				.queryParam("client_id", ClientID)
				.queryParam("api_key", APIKey).when().get().then().statusCode(200).extract()
				.response();
		int TotalLeadCount = response.jsonPath().getInt("total");
		System.out.println("Total lead count in Client -> " + TotalLeadCount);
		return TotalLeadCount;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		getleadData();
		//leadCount();
	}
}
