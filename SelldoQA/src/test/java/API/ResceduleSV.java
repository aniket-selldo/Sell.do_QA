package API;

import java.text.SimpleDateFormat;
import java.util.Date;

import POJO_SiteVisitReschedule_2.Root_ResceduleSV_2;
import POJO_SiteVisitReschedule_2.SiteVisit;
import POJO_SiteVisitReschedule_2_GET.Root_sv_re_2;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ResceduleSV {

	public Root_sv_re_2 reschedule_sitevisit(String FullAccessAPI, String clientID, String leadID, String svid) {

		Root_ResceduleSV_2 root = new Root_ResceduleSV_2();
		SiteVisit svr = new SiteVisit();

		svr.setLead_id(leadID);
		svr.set_id(svid);

		int days = 1;
		svr.setScheduled_on(
				new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date().getTime() + (days * (1000 * 60 * 60 * 24)))
						+ " IST");

		svr.setEnds_on(new SimpleDateFormat("dd-MM-yyyy HH:mm")
				.format(new Date().getTime() + (days * (1000 * 60 * 60 * 24)) + (15 * 60000)) + " IST");
		svr.setType("site_visit");
		root.setSite_visit(svr);
		root.setApi_key(FullAccessAPI);
		root.setClient_id(clientID);

		String url = "https://v2.sell.do/client/leads/" + leadID + "/site_visits/" + svid;
		return RestAssured.given().contentType(ContentType.JSON).body(root).put(url).then().extract().response()
				.as(Root_sv_re_2.class);
	}

	public static void main(String[] args) {
		String apiFull = "c13ad8e13264b1c22bc39bb475889c7e";
		String APIRes = "fa8d6ca0217e676a7b0e06f51c32568c";
		String clientID = "587ddb2b5a9db31da9000002";
		String Userid = "587de77426300a3aca000003";
		String leadID = "64c69f41b08345aad3c0d648";
		String svID = new getAllLeadActivity().get(apiFull, clientID, leadID).getResults().get(0).getSite_visit()
				.get_id();
		System.out.println(svID);

		String a =new ResceduleSV().reschedule_sitevisit(apiFull, clientID, leadID, svID).getSite_visit().get_id();
		System.out.println(a);

	}
}
