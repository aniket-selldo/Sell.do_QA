package API;

import java.text.SimpleDateFormat;
import java.util.Date;

import POJO_SiteVisitReschedule.CampaignInfo;
import POJO_SiteVisitReschedule.ExternalCalendarReference;
import POJO_SiteVisitReschedule.GpsTracking;
import POJO_SiteVisitReschedule.RootSiteVisitReschedule;
import POJO_SiteVisitReschedule.SiteVisit_Reschedule;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResceduleSV {

	public static void main(String[] args) {
		String apiFull = "c13ad8e13264b1c22bc39bb475889c7e";
		String APIRes = "fa8d6ca0217e676a7b0e06f51c32568c";
		String clientID = "587ddb2b5a9db31da9000002";
		String Userid = "587de77426300a3aca000003";

		SiteVisit_Reschedule svr = new SiteVisit_Reschedule();
		RootSiteVisitReschedule root = new RootSiteVisitReschedule();
		GpsTracking gt = new GpsTracking();
		ExternalCalendarReference exc = new ExternalCalendarReference();
		CampaignInfo ci = new CampaignInfo();

		svr.set_id("64c5648db083455200caa24b");
		svr.setAgenda("Reschedule site visit by Rest Assured");
		svr.set_id("64c25453b08345383aacae3b");
		String CurrentTime=new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (2 * (1000 * 60 * 60 * 24)))+" IST";
		svr.setScheduled_on(CurrentTime);
		
	    CurrentTime=new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (2 * (1000 * 60 * 60 * 24))+(15 * 60000))+" IST";
		svr.setEnds_on(CurrentTime);
		
		svr.setProject_id("587dec4626300a3aca00001c");
		
		svr.setStatus("scheduled");
		
		root.setApi_key(apiFull);
		root.setClient_id(clientID);
		root.setSite_visit(svr);
		String url = "https://v2.sell.do/client/leads/64c25453b08345383aacae3b/site_visits/64c5648db083455200caa24b";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().put(url).then().log().all().extract().response();
	}
	String s[]={"Scheduled on can't be blank",
    "Project can't be blank",
    "Project cannot be empty",
    "Status is not included in the list"};
}
