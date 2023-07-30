package POJO_LeadCreate_GET;

import java.util.Date;

public class SelldoLeadDetails {
	private boolean lead_already_exists;
	private Date lead_created_at;
	private String exists_by;
	private String stage;
	private String stage_changed_on;
	private Object last_sv_conducted_on;
	private String last_campaign_created_at;
	private StageData stage_data;

	public boolean isLead_already_exists() {
		return lead_already_exists;
	}

	public void setLead_already_exists(boolean lead_already_exists) {
		this.lead_already_exists = lead_already_exists;
	}

	public Date getLead_created_at() {
		return lead_created_at;
	}

	public void setLead_created_at(Date lead_created_at) {
		this.lead_created_at = lead_created_at;
	}

	public String getExists_by() {
		return exists_by;
	}

	public void setExists_by(String exists_by) {
		this.exists_by = exists_by;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStage_changed_on() {
		return stage_changed_on;
	}

	public void setStage_changed_on(String stage_changed_on) {
		this.stage_changed_on = stage_changed_on;
	}

	public Object getLast_sv_conducted_on() {
		return last_sv_conducted_on;
	}

	public void setLast_sv_conducted_on(Object last_sv_conducted_on) {
		this.last_sv_conducted_on = last_sv_conducted_on;
	}

	public String getLast_campaign_created_at() {
		return last_campaign_created_at;
	}

	public void setLast_campaign_created_at(String last_campaign_created_at) {
		this.last_campaign_created_at = last_campaign_created_at;
	}

	public StageData getStage_data() {
		return stage_data;
	}

	public void setStage_data(StageData stage_data) {
		this.stage_data = stage_data;
	}
}
