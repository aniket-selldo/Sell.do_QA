package POJO_SiteVisitReschedule;

public class RootSiteVisitReschedule {
	private SiteVisit_Reschedule site_visit;
	private String api_key;
	private String client_id;

	public SiteVisit_Reschedule getSite_visit() {
		return site_visit;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public void setSite_visit(SiteVisit_Reschedule site_visit) {
		this.site_visit = site_visit;
	}

}
