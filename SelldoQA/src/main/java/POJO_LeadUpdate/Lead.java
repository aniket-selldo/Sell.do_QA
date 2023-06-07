package POJO_LeadUpdate;

import java.util.ArrayList;

public class Lead {
	private String salutation;
	private String first_name;
	private String last_name;
	private String time_zone;
	private ArrayList<String> user_created_tags;
	private String stage;
	private Object status;
	private boolean nri;
	private ReceivedFrom received_from;
	private PrimaryEmail primary_email;
	private PrimaryPhone primary_phone;
	private ArrayList<Object> secondary_emails;
	private ArrayList<Object> secondary_phones;
	private Requirement requirement;
	private ArrayList<AddressesField> addresses_fields;
	private LeadProfile lead_profile;
	private RemovedIds removed_ids;
	private ArrayList<String> interested_project_ids;
	private String sales_id;
	private String currently_in;
	private boolean push_to_sales;
	private String team_id;
	private String custom_ddf;
	private String custom_call_timing;
	private String custom_location;
	private ArrayList<Object> custom_test_dropdown;
	private String custom_data;
	private Object custom_lead_account_manager_name;
	private String custom_lead_category;
	private String custom_lead_region;
	private Object custom_lead_client_name;
	private Object custom_lead_deparment;
	private Object custom_lead_department;
	private Object custom_reasons_for_purchase;
	private String custom_avcd;
	private String custom_abcd;
	private String custom_dev;
	private String custom_other_remarks;
	private String custom_booked_project;
	private String custom_unit_number;
	private String custom_date_of_booking;
	private String custom_tvs_lead_score;
	private String custom_custom_location;
	private String custom_company;
	private String custom_designation;
	private String custom_probability_of_walkin;
	private String custom_floor_plan_custom_field;
	private ArrayList<Integer> custom_annual_income;

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

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

	public Object getStatus() {
		return status;
	}

	public void setStatus(Object status) {
		this.status = status;
	}

	public boolean isNri() {
		return nri;
	}

	public void setNri(boolean nri) {
		this.nri = nri;
	}

	public ReceivedFrom getReceived_from() {
		return received_from;
	}

	public void setReceived_from(ReceivedFrom received_from) {
		this.received_from = received_from;
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

	public ArrayList<Object> getSecondary_emails() {
		return secondary_emails;
	}

	public void setSecondary_emails(ArrayList<Object> secondary_emails) {
		this.secondary_emails = secondary_emails;
	}

	public ArrayList<Object> getSecondary_phones() {
		return secondary_phones;
	}

	public void setSecondary_phones(ArrayList<Object> secondary_phones) {
		this.secondary_phones = secondary_phones;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public ArrayList<AddressesField> getAddresses_fields() {
		return addresses_fields;
	}

	public void setAddresses_fields(ArrayList<AddressesField> addresses_fields) {
		this.addresses_fields = addresses_fields;
	}

	public LeadProfile getLead_profile() {
		return lead_profile;
	}

	public void setLead_profile(LeadProfile lead_profile) {
		this.lead_profile = lead_profile;
	}

	public RemovedIds getRemoved_ids() {
		return removed_ids;
	}

	public void setRemoved_ids(RemovedIds removed_ids) {
		this.removed_ids = removed_ids;
	}

	public ArrayList<String> getInterested_project_ids() {
		return interested_project_ids;
	}

	public void setInterested_project_ids(ArrayList<String> interested_project_ids) {
		this.interested_project_ids = interested_project_ids;
	}

	public String getSales_id() {
		return sales_id;
	}

	public void setSales_id(String sales_id) {
		this.sales_id = sales_id;
	}

	public String getCurrently_in() {
		return currently_in;
	}

	public void setCurrently_in(String currently_in) {
		this.currently_in = currently_in;
	}

	public boolean isPush_to_sales() {
		return push_to_sales;
	}

	public void setPush_to_sales(boolean push_to_sales) {
		this.push_to_sales = push_to_sales;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public String getCustom_ddf() {
		return custom_ddf;
	}

	public void setCustom_ddf(String custom_ddf) {
		this.custom_ddf = custom_ddf;
	}

	public String getCustom_call_timing() {
		return custom_call_timing;
	}

	public void setCustom_call_timing(String custom_call_timing) {
		this.custom_call_timing = custom_call_timing;
	}

	public String getCustom_location() {
		return custom_location;
	}

	public void setCustom_location(String custom_location) {
		this.custom_location = custom_location;
	}

	public ArrayList<Object> getCustom_test_dropdown() {
		return custom_test_dropdown;
	}

	public void setCustom_test_dropdown(ArrayList<Object> custom_test_dropdown) {
		this.custom_test_dropdown = custom_test_dropdown;
	}

	public String getCustom_data() {
		return custom_data;
	}

	public void setCustom_data(String custom_data) {
		this.custom_data = custom_data;
	}

	public Object getCustom_lead_account_manager_name() {
		return custom_lead_account_manager_name;
	}

	public void setCustom_lead_account_manager_name(Object custom_lead_account_manager_name) {
		this.custom_lead_account_manager_name = custom_lead_account_manager_name;
	}

	public String getCustom_lead_category() {
		return custom_lead_category;
	}

	public void setCustom_lead_category(String custom_lead_category) {
		this.custom_lead_category = custom_lead_category;
	}

	public String getCustom_lead_region() {
		return custom_lead_region;
	}

	public void setCustom_lead_region(String custom_lead_region) {
		this.custom_lead_region = custom_lead_region;
	}

	public Object getCustom_lead_client_name() {
		return custom_lead_client_name;
	}

	public void setCustom_lead_client_name(Object custom_lead_client_name) {
		this.custom_lead_client_name = custom_lead_client_name;
	}

	public Object getCustom_lead_deparment() {
		return custom_lead_deparment;
	}

	public void setCustom_lead_deparment(Object custom_lead_deparment) {
		this.custom_lead_deparment = custom_lead_deparment;
	}

	public Object getCustom_lead_department() {
		return custom_lead_department;
	}

	public void setCustom_lead_department(Object custom_lead_department) {
		this.custom_lead_department = custom_lead_department;
	}

	public Object getCustom_reasons_for_purchase() {
		return custom_reasons_for_purchase;
	}

	public void setCustom_reasons_for_purchase(Object custom_reasons_for_purchase) {
		this.custom_reasons_for_purchase = custom_reasons_for_purchase;
	}

	public String getCustom_avcd() {
		return custom_avcd;
	}

	public void setCustom_avcd(String custom_avcd) {
		this.custom_avcd = custom_avcd;
	}

	public String getCustom_abcd() {
		return custom_abcd;
	}

	public void setCustom_abcd(String custom_abcd) {
		this.custom_abcd = custom_abcd;
	}

	public String getCustom_dev() {
		return custom_dev;
	}

	public void setCustom_dev(String custom_dev) {
		this.custom_dev = custom_dev;
	}

	public String getCustom_other_remarks() {
		return custom_other_remarks;
	}

	public void setCustom_other_remarks(String custom_other_remarks) {
		this.custom_other_remarks = custom_other_remarks;
	}

	public String getCustom_booked_project() {
		return custom_booked_project;
	}

	public void setCustom_booked_project(String custom_booked_project) {
		this.custom_booked_project = custom_booked_project;
	}

	public String getCustom_unit_number() {
		return custom_unit_number;
	}

	public void setCustom_unit_number(String custom_unit_number) {
		this.custom_unit_number = custom_unit_number;
	}

	public String getCustom_date_of_booking() {
		return custom_date_of_booking;
	}

	public void setCustom_date_of_booking(String custom_date_of_booking) {
		this.custom_date_of_booking = custom_date_of_booking;
	}

	public String getCustom_tvs_lead_score() {
		return custom_tvs_lead_score;
	}

	public void setCustom_tvs_lead_score(String custom_tvs_lead_score) {
		this.custom_tvs_lead_score = custom_tvs_lead_score;
	}

	public String getCustom_custom_location() {
		return custom_custom_location;
	}

	public void setCustom_custom_location(String custom_custom_location) {
		this.custom_custom_location = custom_custom_location;
	}

	public String getCustom_company() {
		return custom_company;
	}

	public void setCustom_company(String custom_company) {
		this.custom_company = custom_company;
	}

	public String getCustom_designation() {
		return custom_designation;
	}

	public void setCustom_designation(String custom_designation) {
		this.custom_designation = custom_designation;
	}

	public String getCustom_probability_of_walkin() {
		return custom_probability_of_walkin;
	}

	public void setCustom_probability_of_walkin(String custom_probability_of_walkin) {
		this.custom_probability_of_walkin = custom_probability_of_walkin;
	}

	public String getCustom_floor_plan_custom_field() {
		return custom_floor_plan_custom_field;
	}

	public void setCustom_floor_plan_custom_field(String custom_floor_plan_custom_field) {
		this.custom_floor_plan_custom_field = custom_floor_plan_custom_field;
	}

	public ArrayList<Integer> getCustom_annual_income() {
		return custom_annual_income;
	}

	public void setCustom_annual_income(ArrayList<Integer> custom_annual_income) {
		this.custom_annual_income = custom_annual_income;
	}
}
