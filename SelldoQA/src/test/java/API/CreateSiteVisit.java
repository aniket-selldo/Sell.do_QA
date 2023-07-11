package API;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import Enums.APIKeys;
import Enums.Project;
import POJO_SiteVisit.Root;
import POJO_SiteVisit.SiteVisit;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateSiteVisit {
public static void createSiteVisit(String leadId,String leadID,APIKeys API_Key,APIKeys ClientID,APIKeys SalesID,Project ProjectID,String URL) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now) + ":59 IST";
		System.out.println("Date >> " + date);
		
		
		Root root = new Root();
		SiteVisit siteVisit =new SiteVisit();
		
		siteVisit.setProject_id(ProjectID.toString());
		siteVisit.setScheduled_on(date);
		siteVisit.setEnds_on(dtf.format(now)+" 23:59");
		siteVisit.setSales_id(SalesID.toString());
		siteVisit.setSitevisit_type("visit");// visit | home_visit | online_walkthrough
		siteVisit.setAgenda("Agenda By Rest Assured");
		siteVisit.setConfirmed(true);
		siteVisit.setLead_crm_id(leadId);
		siteVisit.setRating("4");
		siteVisit.setTest("test");
		
		root.setApi_key(API_Key.toString());
		root.setClient_id(ClientID.toString());
		root.setSite_visit(siteVisit);
		
		RestAssured.baseURI = URL+"/client/leads/" + leadID + "/site_visits.json";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post();
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		
	}

	public static void createSiteVisit() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH");// yyyy/MM/dd
		LocalDateTime now = LocalDateTime.now();
		String date = dtf.format(now) + ":59 IST";
		System.out.println("Date >> " + date);
		
		
		Root root = new Root();
		SiteVisit siteVisit =new SiteVisit();
		
		siteVisit.setProject_id("642bc873b08345a7f044e100");
		siteVisit.setScheduled_on(date);
		siteVisit.setEnds_on(dtf.format(now)+" 23:59");
		siteVisit.setSales_id("642a9b11b083454f959c1b14");
		siteVisit.setSitevisit_type("visit");// visit | home_visit | online_walkthrough
		siteVisit.setAgenda("Agenda By Rest Assured");
		siteVisit.setConfirmed(true);
		siteVisit.setLead_crm_id("10219");
		siteVisit.setRating("4");
		siteVisit.setTest("test");
		
		root.setApi_key("99c4b48c7732b5183000999d1200d520");
		root.setClient_id("642a8145b083453f914ce854");
		root.setSite_visit(siteVisit);
		
		String leadID ="647f3522b08345ab2f35a33e";
		RestAssured.baseURI = "https://v2.sell.do/client/leads/" + leadID + "/site_visits.json";
		Response response = RestAssured.given().contentType(ContentType.JSON).body(root).log().all().post();
		String responseBody = response.getBody().asString();
		System.out.println("Response body: " + responseBody);
		
	}
	
	public static void main(String[] args) {
		createSiteVisit();
	}
}
