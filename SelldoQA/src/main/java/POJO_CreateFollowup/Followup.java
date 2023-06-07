package POJO_CreateFollowup;

public class Followup {
	private String followup_type;
	private String lead_id;
	private String scheduled_on;
	private String status;
	private String subject;
	private String agenda;
	private String type;

	public String getFollowup_type() {
		return followup_type;
	}

	public void setFollowup_type(String followup_type) {
		this.followup_type = followup_type;
	}

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	public String getScheduled_on() {
		return scheduled_on;
	}

	public void setScheduled_on(String scheduled_on) {
		this.scheduled_on = scheduled_on;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
