package POJO_SiteVisit;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SiteVisit {
	private String project_id;
	private String scheduled_on;
	private String ends_on;
	private String sales_id;
	private String sitevisit_type;
	private String agenda;
	private boolean confirmed;
	private String lead_crm_id;
	@JsonProperty("Rating")
	private String rating;
	@JsonProperty("Test")
	private String test;

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getScheduled_on() {
		return scheduled_on;
	}

	public void setScheduled_on(String scheduled_on) {
		this.scheduled_on = scheduled_on;
	}

	public String getEnds_on() {
		return ends_on;
	}

	public void setEnds_on(String ends_on) {
		this.ends_on = ends_on;
	}

	public String getSales_id() {
		return sales_id;
	}

	public void setSales_id(String sales_id) {
		this.sales_id = sales_id;
	}

	public String getSitevisit_type() {
		return sitevisit_type;
	}

	public void setSitevisit_type(String sitevisit_type) {
		this.sitevisit_type = sitevisit_type;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public String getLead_crm_id() {
		return lead_crm_id;
	}

	public void setLead_crm_id(String lead_crm_id) {
		this.lead_crm_id = lead_crm_id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

}
