package API;

import static io.restassured.RestAssured.given;

import com.selldo.Utility.API_Reusable;

import POJO_AddDevloper_GET.Root_AddDevloper_GET;
import io.restassured.http.ContentType;

public class AddDevloper extends API_Reusable {
	
	
	public Root_AddDevloper_GET addDevloper() {
	return	given().urlEncodingEnabled(true).contentType(ContentType.URLENC)
		        .formParam("developer[name]", Random("AN",10))
		        .formParam("developer[description]", Random("AN",10))
		        .formParam("developer[contact][phone][ph_number]", randomPhone().trim())
		        .formParam("developer[contact][phone][dial_code]", "91")
		        .formParam("developer[contact][phone][country_code]", "in")
		        .formParam("developer[contact][first_name]", Random("AN",10))
		        .formParam("developer[contact][salutation]", "mr")
		        .formParam("developer[contact][last_name]", Random("AN",10))
		        .formParam("developer[contact][email]", randomEmail())
		        .formParam("quick_add", "developer")
		        .formParam("api_key", prop("Clinet_API_Full"))
		        .formParam("client_id", prop("Client_id"))
		    .when()
		        .post(prop("URL")+"/client/developers.json").then().extract().response().as(Root_AddDevloper_GET.class);
	}

}
