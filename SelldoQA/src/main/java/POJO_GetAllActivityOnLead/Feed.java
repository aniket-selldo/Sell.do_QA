package POJO_GetAllActivityOnLead;

import java.util.Date;

public class Feed {
	private String _id;
	private Object booking_detail_id;
	private Date created_at;
	private String feed_type;
	private int lead_crm_id;
	private String lead_id;
	private Object project_id;
	private String sales_id;
	private Date updated_at;
	private Extras extras;
	private String content;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public Object getBooking_detail_id() {
		return booking_detail_id;
	}

	public void setBooking_detail_id(Object booking_detail_id) {
		this.booking_detail_id = booking_detail_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getFeed_type() {
		return feed_type;
	}

	public void setFeed_type(String feed_type) {
		this.feed_type = feed_type;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
