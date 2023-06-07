package POJO_LeadUpdate;

import java.util.ArrayList;

public class Root {
	private String api_key;
	private String client_id;
	private Lead lead;
	private ArrayList<String> project_for_sv;
	private String conducted_on_for_sv;
	private ActivitiesData activities_data;

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

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public ArrayList<String> getProject_for_sv() {
		return project_for_sv;
	}

	public void setProject_for_sv(ArrayList<String> project_for_sv) {
		this.project_for_sv = project_for_sv;
	}

	public String getConducted_on_for_sv() {
		return conducted_on_for_sv;
	}

	public void setConducted_on_for_sv(String conducted_on_for_sv) {
		this.conducted_on_for_sv = conducted_on_for_sv;
	}

	public ActivitiesData getActivities_data() {
		return activities_data;
	}

	public void setActivities_data(ActivitiesData activities_data) {
		this.activities_data = activities_data;
	}

}
