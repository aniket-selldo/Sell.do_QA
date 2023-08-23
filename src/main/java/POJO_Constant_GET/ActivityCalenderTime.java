package POJO_Constant_GET;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityCalenderTime {
	@JsonProperty("_id")
	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	String _id;

	@JsonProperty("active")
	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	boolean active;

	@JsonProperty("client_configuration_id")
	public String getClient_configuration_id() {
		return this.client_configuration_id;
	}

	public void setClient_configuration_id(String client_configuration_id) {
		this.client_configuration_id = client_configuration_id;
	}

	String client_configuration_id;

	@JsonProperty("created_at")
	public Date getCreated_at() {
		return this.created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	Date created_at;

	@JsonProperty("followup_hours")
	public int getFollowup_hours() {
		return this.followup_hours;
	}

	public void setFollowup_hours(int followup_hours) {
		this.followup_hours = followup_hours;
	}

	int followup_hours;

	@JsonProperty("followup_minutes")
	public int getFollowup_minutes() {
		return this.followup_minutes;
	}

	public void setFollowup_minutes(int followup_minutes) {
		this.followup_minutes = followup_minutes;
	}

	int followup_minutes;

	@JsonProperty("site_visit_hours")
	public int getSite_visit_hours() {
		return this.site_visit_hours;
	}

	public void setSite_visit_hours(int site_visit_hours) {
		this.site_visit_hours = site_visit_hours;
	}

	int site_visit_hours;

	@JsonProperty("site_visit_minutes")
	public int getSite_visit_minutes() {
		return this.site_visit_minutes;
	}

	public void setSite_visit_minutes(int site_visit_minutes) {
		this.site_visit_minutes = site_visit_minutes;
	}

	int site_visit_minutes;

	@JsonProperty("updated_at")
	public Date getUpdated_at() {
		return this.updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	Date updated_at;
}
