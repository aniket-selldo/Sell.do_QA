package POJO_GetAllActivityOnLead;

import java.util.Date;

public class Followup {
	private String _id;
	private Object acted_on;
	private String agenda;
	private Object booking_detail_id;
	private Object cancellation_note;
	private Object cancellation_reason;
	private Date created_at;
	private String followup_type;
	private String initiated_by;
	private int lead_crm_id;
	private String lead_id;
	private Object project_id;
	private String sales_id;
	private Date scheduled_on;
	private String status;
	private String subject;
	private Date updated_at;
	private Extras extras;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Object getActed_on() {
		return acted_on;
	}

	public void setActed_on(Object acted_on) {
		this.acted_on = acted_on;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public Object getBooking_detail_id() {
		return booking_detail_id;
	}

	public void setBooking_detail_id(Object booking_detail_id) {
		this.booking_detail_id = booking_detail_id;
	}

	public Object getCancellation_note() {
		return cancellation_note;
	}

	public void setCancellation_note(Object cancellation_note) {
		this.cancellation_note = cancellation_note;
	}

	public Object getCancellation_reason() {
		return cancellation_reason;
	}

	public void setCancellation_reason(Object cancellation_reason) {
		this.cancellation_reason = cancellation_reason;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getFollowup_type() {
		return followup_type;
	}

	public void setFollowup_type(String followup_type) {
		this.followup_type = followup_type;
	}

	public String getInitiated_by() {
		return initiated_by;
	}

	public void setInitiated_by(String initiated_by) {
		this.initiated_by = initiated_by;
	}

	public int getLead_crm_id() {
		return lead_crm_id;
	}

	public void setLead_crm_id(int lead_crm_id) {
		this.lead_crm_id = lead_crm_id;
	}

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	public Object getProject_id() {
		return project_id;
	}

	public void setProject_id(Object project_id) {
		this.project_id = project_id;
	}

	public String getSales_id() {
		return sales_id;
	}

	public void setSales_id(String sales_id) {
		this.sales_id = sales_id;
	}

	public Date getScheduled_on() {
		return scheduled_on;
	}

	public void setScheduled_on(Date scheduled_on) {
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

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}
}
