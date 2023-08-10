package API;

import static io.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.selldo.Utility.API_Reusable;

import POJO_siteVisit_markConducted.Root_MarkConducted_SV;
import POJO_siteVisit_markConducted.SiteVisit;
import POJO_siteVisit_markConducted_GET.Root_conductedSV_GET;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class MarkSiteVisitConducted extends API_Reusable {

	public Root_conductedSV_GET markSVSconducted(String leadid, String svcID) {

		SiteVisit svc = new SiteVisit();
		svc.set_id(svcID);
		String date = new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime()) + " IST";
		svc.setConducted_on(date);
		svc.setLead_crm_id(Integer.parseInt(leadid));
		svc.setLead_id(getLeadId(leadid));
		svc.setStatus("conducted");
		Root_MarkConducted_SV sv = new Root_MarkConducted_SV();
		sv.setSite_visit(svc);

		String APIKeys = prop("Clinet_API_Full");
		String ClientID = prop("Client_id");

		String url = prop("URL") + "/client/leads/" + getLeadId(leadid) + "/site_visits/" + svcID + "?api_key="
				+ APIKeys + "&client_id=" + ClientID;
		return RestAssured.given().contentType(ContentType.JSON).body(sv).when().put(url).then().extract().response().as(Root_conductedSV_GET.class);
	}

	public String getLeadId(String leadCRMID) {

		Response response = given().urlEncodingEnabled(true).contentType(ContentType.JSON).with()
				.queryParam("search", "#" + leadCRMID).queryParam("client_id", prop("Client_id"))
				.queryParam("api_key", prop("Clinet_API_Full")).when().get(prop("URL") + "/client/get_db_id").then()
				.extract().response();
		String leadCRMid = response.jsonPath().getString("id[0]").trim();
		return leadCRMid;
	}
}
