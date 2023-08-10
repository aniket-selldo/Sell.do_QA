package POJO_GetAllActivityOnLead;

import java.util.ArrayList;
import java.util.Date;

public class Email {
	 private String _id;
	  private Object booking_detail_id;
	  private Date created_at;
	  private String direction;
	  private String email_template_id;
	  private String email_template_type;
	  private Object fromname;
	  private int lead_crm_id;
	  private String lead_id;
	  private Object project_id;
	  private String sales_id;
	  private String status;
	  private String subject;
	  private Object toCC;
	  private ArrayList<String> toaddr;
	  private boolean unread;
	  private Date updated_at;
	  private ArrayList<Object> email_attachments;
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
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getEmail_template_id() {
		return email_template_id;
	}
	public void setEmail_template_id(String email_template_id) {
		this.email_template_id = email_template_id;
	}
	public String getEmail_template_type() {
		return email_template_type;
	}
	public void setEmail_template_type(String email_template_type) {
		this.email_template_type = email_template_type;
	}
	public Object getFromname() {
		return fromname;
	}
	public void setFromname(Object fromname) {
		this.fromname = fromname;
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
	public Object getToCC() {
		return toCC;
	}
	public void setToCC(Object toCC) {
		this.toCC = toCC;
	}
	public ArrayList<String> getToaddr() {
		return toaddr;
	}
	public void setToaddr(ArrayList<String> toaddr) {
		this.toaddr = toaddr;
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
	public ArrayList<Object> getEmail_attachments() {
		return email_attachments;
	}
	public void setEmail_attachments(ArrayList<Object> email_attachments) {
		this.email_attachments = email_attachments;
	}
	public Extras getExtras() {
		return extras;
	}
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
}
