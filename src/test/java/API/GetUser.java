package API;

import static io.restassured.RestAssured.given;

import com.selldo.Utility.API_Reusable;

import POJO_Get_Sales_PreSales_PostSales_GET.Root_GetUsersWithType;
import io.restassured.http.ContentType;

public class GetUser extends API_Reusable {

	public Root_GetUsersWithType[] getAll(String user, String flag) {
		if (user.equalsIgnoreCase("sales")) {
			return given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
					.queryParam("conditions%5Bdepartment%5D%5B%24in%5D%5B%5D", "sales")
					.queryParam("conditions%5Bis_active%5D", flag).queryParam("api_key", prop("Clinet_API_Full"))
					.queryParam("client_id", prop("Client_id")).when().get(prop("URL") + "/client/users/data_provider")
					.then().extract().response().as(Root_GetUsersWithType[].class);
		}
		else if (user.equalsIgnoreCase("presales")) {
			return given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
					.queryParam("conditions%5Bdepartment%5D%5B%24in%5D%5B%5D", "pre_sales")
					.queryParam("conditions%5Bis_active%5D", flag).queryParam("api_key", prop("Clinet_API_Full"))
					.queryParam("client_id", prop("Client_id")).when().get(prop("URL") + "/client/users/data_provider")
					.then().extract().response().as(Root_GetUsersWithType[].class);
		}
		else if (user.equalsIgnoreCase("postsales")) {
			return given().urlEncodingEnabled(false).contentType(ContentType.JSON).with()
					.queryParam("conditions%5Bdepartment%5D%5B%24in%5D%5B%5D", "post_sales")
					.queryParam("conditions%5Bis_active%5D", flag).queryParam("api_key", prop("Clinet_API_Full"))
					.queryParam("client_id", prop("Client_id")).when().get(prop("URL") + "/client/users/data_provider")
					.then().extract().response().as(Root_GetUsersWithType[].class);
		} else {
			return null;
		}
	}

//	  {
//	        "id": "642a8145b083453f914ce856",
//	        "text": "AniketUser User (Sales) (Test Master 01)",
//	        "department": "sales",
//	        "allow_to_manage_leads": true,
//	        "email": "aniket.khandizod+uu@sell.do",
//	        "assign_leads": true,
//	        "team_id": "642a815bb083453f914cea46"
//	    },
}
