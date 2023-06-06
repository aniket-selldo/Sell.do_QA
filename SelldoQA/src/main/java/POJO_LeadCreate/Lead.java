package POJO_LeadCreate;

import java.util.ArrayList;

public class Lead {
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String salutation;
	private String time_zone;
	private ArrayList<String> user_created_tags;
	private String stage;
	private String status;
	private boolean nri;
	private String project_id;
	private String campaign_id;
	private String sales;
	private Profile profile;
	private ReceivedFrom received_from;
	private String channel_partner_id;
	private PrimaryEmail primary_email;
	private PrimaryPhone primary_phone;
	private Object secondary_emails;
	private Object secondary_phones;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public ArrayList<String> getUser_created_tags() {
		return user_created_tags;
	}

	public void setUser_created_tags(ArrayList<String> user_created_tags) {
		this.user_created_tags = user_created_tags;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isNri() {
		return nri;
	}

	public void setNri(boolean nri) {
		this.nri = nri;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public String getCampaign_id() {
		return campaign_id;
	}

	public void setCampaign_id(String campaign_id) {
		this.campaign_id = campaign_id;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public ReceivedFrom getReceived_from() {
		return received_from;
	}

	public void setReceived_from(ReceivedFrom received_from) {
		this.received_from = received_from;
	}

	public String getChannel_partner_id() {
		return channel_partner_id;
	}

	public void setChannel_partner_id(String channel_partner_id) {
		this.channel_partner_id = channel_partner_id;
	}

	public PrimaryEmail getPrimary_email() {
		return primary_email;
	}

	public void setPrimary_email(PrimaryEmail primary_email) {
		this.primary_email = primary_email;
	}

	public PrimaryPhone getPrimary_phone() {
		return primary_phone;
	}

	public void setPrimary_phone(PrimaryPhone primary_phone) {
		this.primary_phone = primary_phone;
	}

	public Object getSecondary_emails() {
		return secondary_emails;
	}

	public void setSecondary_emails(Object secondary_emails) {
		this.secondary_emails = secondary_emails;
	}

	public Object getSecondary_phones() {
		return secondary_phones;
	}

	public void setSecondary_phones(Object secondary_phones) {
		this.secondary_phones = secondary_phones;
	}

}
