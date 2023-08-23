package POJO_Constant_GET;

import java.util.ArrayList;

public class CurrentUser {
	 public String authentication_token;
	    public String sales_id;
	    public String role;
	    public String department;
	    public String industry;
	    public boolean merge_leads;
	    public String id;
	    public String name;
	    public String first_name;
	    public String last_name;
	    public String time_zone;
	    public boolean gps_tracking_enabled;
	    public CallAvailabilities call_availabilities;
	    public ArrayList<Object> staff_ids;
	    public String team_id;
	    public boolean work_as_manager;
	    public String roaster;
	    public boolean allow_creating_leads;
	    public boolean allow_to_manage_leads;
	    public boolean assign_leads;
	    public Object roaster_sub_state;
	    public boolean custom_role_can_manage_tasks;
	    public boolean custom_role_can_bulk_reassign_lead;
	    public boolean custom_role_can_bulk_stage_change_lead;
	    public boolean custom_role_can_access_call_recording;
	    public boolean is_custom_role;
	    public boolean enable_voip;
	    public String email;
	    public String phone;
	    public String secondary_phone;
	    public PhoneCodes phone_codes;
	    public VoipCredentials voip_credentials;
	    public boolean is_post_sales_manager;
	    public boolean accessible_leads;
	    public boolean show_accessible_leads_option;
	    public Object custom_generic_user;
		public String getAuthentication_token() {
			return authentication_token;
		}
		public void setAuthentication_token(String authentication_token) {
			this.authentication_token = authentication_token;
		}
		public String getSales_id() {
			return sales_id;
		}
		public void setSales_id(String sales_id) {
			this.sales_id = sales_id;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getIndustry() {
			return industry;
		}
		public void setIndustry(String industry) {
			this.industry = industry;
		}
		public boolean isMerge_leads() {
			return merge_leads;
		}
		public void setMerge_leads(boolean merge_leads) {
			this.merge_leads = merge_leads;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
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
		public boolean isGps_tracking_enabled() {
			return gps_tracking_enabled;
		}
		public void setGps_tracking_enabled(boolean gps_tracking_enabled) {
			this.gps_tracking_enabled = gps_tracking_enabled;
		}
		public CallAvailabilities getCall_availabilities() {
			return call_availabilities;
		}
		public void setCall_availabilities(CallAvailabilities call_availabilities) {
			this.call_availabilities = call_availabilities;
		}
		public ArrayList<Object> getStaff_ids() {
			return staff_ids;
		}
		public void setStaff_ids(ArrayList<Object> staff_ids) {
			this.staff_ids = staff_ids;
		}
		public String getTeam_id() {
			return team_id;
		}
		public void setTeam_id(String team_id) {
			this.team_id = team_id;
		}
		public boolean isWork_as_manager() {
			return work_as_manager;
		}
		public void setWork_as_manager(boolean work_as_manager) {
			this.work_as_manager = work_as_manager;
		}
		public String getRoaster() {
			return roaster;
		}
		public void setRoaster(String roaster) {
			this.roaster = roaster;
		}
		public boolean isAllow_creating_leads() {
			return allow_creating_leads;
		}
		public void setAllow_creating_leads(boolean allow_creating_leads) {
			this.allow_creating_leads = allow_creating_leads;
		}
		public boolean isAllow_to_manage_leads() {
			return allow_to_manage_leads;
		}
		public void setAllow_to_manage_leads(boolean allow_to_manage_leads) {
			this.allow_to_manage_leads = allow_to_manage_leads;
		}
		public boolean isAssign_leads() {
			return assign_leads;
		}
		public void setAssign_leads(boolean assign_leads) {
			this.assign_leads = assign_leads;
		}
		public Object getRoaster_sub_state() {
			return roaster_sub_state;
		}
		public void setRoaster_sub_state(Object roaster_sub_state) {
			this.roaster_sub_state = roaster_sub_state;
		}
		public boolean isCustom_role_can_manage_tasks() {
			return custom_role_can_manage_tasks;
		}
		public void setCustom_role_can_manage_tasks(boolean custom_role_can_manage_tasks) {
			this.custom_role_can_manage_tasks = custom_role_can_manage_tasks;
		}
		public boolean isCustom_role_can_bulk_reassign_lead() {
			return custom_role_can_bulk_reassign_lead;
		}
		public void setCustom_role_can_bulk_reassign_lead(boolean custom_role_can_bulk_reassign_lead) {
			this.custom_role_can_bulk_reassign_lead = custom_role_can_bulk_reassign_lead;
		}
		public boolean isCustom_role_can_bulk_stage_change_lead() {
			return custom_role_can_bulk_stage_change_lead;
		}
		public void setCustom_role_can_bulk_stage_change_lead(boolean custom_role_can_bulk_stage_change_lead) {
			this.custom_role_can_bulk_stage_change_lead = custom_role_can_bulk_stage_change_lead;
		}
		public boolean isCustom_role_can_access_call_recording() {
			return custom_role_can_access_call_recording;
		}
		public void setCustom_role_can_access_call_recording(boolean custom_role_can_access_call_recording) {
			this.custom_role_can_access_call_recording = custom_role_can_access_call_recording;
		}
		public boolean isIs_custom_role() {
			return is_custom_role;
		}
		public void setIs_custom_role(boolean is_custom_role) {
			this.is_custom_role = is_custom_role;
		}
		public boolean isEnable_voip() {
			return enable_voip;
		}
		public void setEnable_voip(boolean enable_voip) {
			this.enable_voip = enable_voip;
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
		public String getSecondary_phone() {
			return secondary_phone;
		}
		public void setSecondary_phone(String secondary_phone) {
			this.secondary_phone = secondary_phone;
		}
		public PhoneCodes getPhone_codes() {
			return phone_codes;
		}
		public void setPhone_codes(PhoneCodes phone_codes) {
			this.phone_codes = phone_codes;
		}
		public VoipCredentials getVoip_credentials() {
			return voip_credentials;
		}
		public void setVoip_credentials(VoipCredentials voip_credentials) {
			this.voip_credentials = voip_credentials;
		}
		public boolean isIs_post_sales_manager() {
			return is_post_sales_manager;
		}
		public void setIs_post_sales_manager(boolean is_post_sales_manager) {
			this.is_post_sales_manager = is_post_sales_manager;
		}
		public boolean isAccessible_leads() {
			return accessible_leads;
		}
		public void setAccessible_leads(boolean accessible_leads) {
			this.accessible_leads = accessible_leads;
		}
		public boolean isShow_accessible_leads_option() {
			return show_accessible_leads_option;
		}
		public void setShow_accessible_leads_option(boolean show_accessible_leads_option) {
			this.show_accessible_leads_option = show_accessible_leads_option;
		}
		public Object getCustom_generic_user() {
			return custom_generic_user;
		}
		public void setCustom_generic_user(Object custom_generic_user) {
			this.custom_generic_user = custom_generic_user;
		}
}
