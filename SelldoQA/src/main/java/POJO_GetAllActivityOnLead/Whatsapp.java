package POJO_GetAllActivityOnLead;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Whatsapp {
	private String _id;
	private Object booking_detail_id;
	private Object content;
	private Date created_at;
	private Object from;
	private int lead_crm_id;
	private String lead_id;
	private Object media_url;
	private Object project_id;
	private String sales_id;
	private String status;
	@JsonProperty("to")
	private Object myto;
	private boolean unread;
	private Date updated_at;
	private String vendor;
	private Extras extras;

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

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Object getFrom() {
		return from;
	}

	public void setFrom(Object from) {
		this.from = from;
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

	public Object getMedia_url() {
		return media_url;
	}

	public void setMedia_url(Object media_url) {
		this.media_url = media_url;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getMyto() {
		return myto;
	}

	public void setMyto(Object myto) {
		this.myto = myto;
	}

	public boolean isUnread() {
		return unread;
	}

	public void setUnread(boolean unread) {
		this.unread = unread;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}
}
