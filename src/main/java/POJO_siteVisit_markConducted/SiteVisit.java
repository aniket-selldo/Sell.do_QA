package POJO_siteVisit_markConducted;

public class SiteVisit {
	private String lead_id;
	private String _id;
	private String conducted_on;
	private int lead_crm_id;
	private String status;

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getConducted_on() {
		return conducted_on;
	}

	public void setConducted_on(String conducted_on) {
		this.conducted_on = conducted_on;
	}

	public int getLead_crm_id() {
		return lead_crm_id;
	}

	public void setLead_crm_id(int lead_crm_id) {
		this.lead_crm_id = lead_crm_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
