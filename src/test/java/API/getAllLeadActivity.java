package API;

import POJO_GetAllActivityOnLead.Root_GetAllLeadActivity;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class getAllLeadActivity {
	
	public Root_GetAllLeadActivity get(String fullAPI,String ClientID,String leadID) {
		String URL = "https://v2.sell.do/client/leads/"+leadID+"/activities?api_key="+fullAPI+"&client_id="+ClientID;
		return RestAssured.given().contentType(ContentType.JSON).when().get(URL).then().extract().response()
				.as(Root_GetAllLeadActivity.class);
	}
	

	public static void main(String[] args) {
		
		String apiFull = "c13ad8e13264b1c22bc39bb475889c7e";
		String APIRes = "fa8d6ca0217e676a7b0e06f51c32568c";
		String clientID = "587ddb2b5a9db31da9000002";
		String Userid = "587ddb2b5a9db31da9000001";
		String leadID ="64c69f41b08345aad3c0d648";
		
		String a = new getAllLeadActivity().get(apiFull, clientID, leadID).getResults().get(0).getSite_visit().get_id();
		System.out.println(a);
	}
}
