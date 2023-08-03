package POJO_GetAllUser_GET;

import java.util.ArrayList;
import java.util.Date;

public class Result {
	private String _id;
	private boolean accessible_leads;
	private boolean add_to_default_routing_rule;
	private boolean allow_to_approve_reject_negotiations;
	private boolean allow_to_manage_leads;
	private ArrayList<Object> allowed_client_ids;
	private ArrayList<Object> allowed_ip_addresses;
	private boolean assign_leads;
	private Object auth_otp_code;
	private boolean auto_roster_management;
	private boolean billable_user;
	private boolean bypass_ip_restriction;
	private boolean calling_enabled;
	private ArrayList<Object> campaign_ids;
	private String circle;
	private String client_id;
	private Date created_at;
	private boolean daily_reports;
	private Object deactivated_at;
	private Object default_for_client_id;
	private Object default_pre_sales_for_client_id;
	private String department;
	private DeviceIds device_ids;
	private String email;
	private boolean enable_voip;
	private boolean feedback_submitted;
	private String first_name;
	private GoogleCalendarDetails google_calendar_details;
	private GoogleToken google_token;
	private boolean gps_tracking_enabled;
	private boolean is_active;
	private String last_name;
	private Object last_otp_sent_at;
	private LatestGpsLocation latest_gps_location;
	private Object manager_id;
	private Object ms365_calendar_details;
	private Ms365Token ms365_token;
	private ArrayList<Object> oauth_accounts;
	private Object otp_attempt;
	private ArrayList<Object> owner_ids;
	private PasswordUpdatedBy password_updated_by;
	private String phone;
	private PhoneCodes phone_codes;
	private ArrayList<Object> post_sales_project_ids;
	private ArrayList<Object> pre_sales_project_ids;
	private ArrayList<Object> project_ids;
	private boolean push_notification_mobile;
	private Date reactivated_on;
	private ArrayList<Object> relative_team_ids;
	private int resend_otp_counter;
	private String roaster;
	private Object roaster_sub_state;
	private String role;
	private ArrayList<Object> secondary_booking_detail_ids;
	private String secondary_phone;
	private String session_token;
	private ArrayList<Object> target_ids;
	private String team_id;
	private boolean temporary_reassignment;
	private String time_zone;
	private boolean unlimited_calling;
	private Date updated_at;
	private boolean user_in_default_routing;
	private boolean using_mobile_app;
	private VoipCredentials voip_credentials;
	private boolean work_as_manager;
	private ZoomusConfiguration zoomus_configuration;
	private ZoomusToken zoomus_token;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public boolean isAccessible_leads() {
		return accessible_leads;
	}

	public void setAccessible_leads(boolean accessible_leads) {
		this.accessible_leads = accessible_leads;
	}

	public boolean isAdd_to_default_routing_rule() {
		return add_to_default_routing_rule;
	}

	public void setAdd_to_default_routing_rule(boolean add_to_default_routing_rule) {
		this.add_to_default_routing_rule = add_to_default_routing_rule;
	}

	public boolean isAllow_to_approve_reject_negotiations() {
		return allow_to_approve_reject_negotiations;
	}

	public void setAllow_to_approve_reject_negotiations(boolean allow_to_approve_reject_negotiations) {
		this.allow_to_approve_reject_negotiations = allow_to_approve_reject_negotiations;
	}

	public boolean isAllow_to_manage_leads() {
		return allow_to_manage_leads;
	}

	public void setAllow_to_manage_leads(boolean allow_to_manage_leads) {
		this.allow_to_manage_leads = allow_to_manage_leads;
	}

	public ArrayList<Object> getAllowed_client_ids() {
		return allowed_client_ids;
	}

	public void setAllowed_client_ids(ArrayList<Object> allowed_client_ids) {
		this.allowed_client_ids = allowed_client_ids;
	}

	public ArrayList<Object> getAllowed_ip_addresses() {
		return allowed_ip_addresses;
	}

	public void setAllowed_ip_addresses(ArrayList<Object> allowed_ip_addresses) {
		this.allowed_ip_addresses = allowed_ip_addresses;
	}

	public boolean isAssign_leads() {
		return assign_leads;
	}

	public void setAssign_leads(boolean assign_leads) {
		this.assign_leads = assign_leads;
	}

	public Object getAuth_otp_code() {
		return auth_otp_code;
	}

	public void setAuth_otp_code(Object auth_otp_code) {
		this.auth_otp_code = auth_otp_code;
	}

	public boolean isAuto_roster_management() {
		return auto_roster_management;
	}

	public void setAuto_roster_management(boolean auto_roster_management) {
		this.auto_roster_management = auto_roster_management;
	}

	public boolean isBillable_user() {
		return billable_user;
	}

	public void setBillable_user(boolean billable_user) {
		this.billable_user = billable_user;
	}

	public boolean isBypass_ip_restriction() {
		return bypass_ip_restriction;
	}

	public void setBypass_ip_restriction(boolean bypass_ip_restriction) {
		this.bypass_ip_restriction = bypass_ip_restriction;
	}

	public boolean isCalling_enabled() {
		return calling_enabled;
	}

	public void setCalling_enabled(boolean calling_enabled) {
		this.calling_enabled = calling_enabled;
	}

	public ArrayList<Object> getCampaign_ids() {
		return campaign_ids;
	}

	public void setCampaign_ids(ArrayList<Object> campaign_ids) {
		this.campaign_ids = campaign_ids;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public String getClient_id() {
		return client_id;
	}

	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public boolean isDaily_reports() {
		return daily_reports;
	}

	public void setDaily_reports(boolean daily_reports) {
		this.daily_reports = daily_reports;
	}

	public Object getDeactivated_at() {
		return deactivated_at;
	}

	public void setDeactivated_at(Object deactivated_at) {
		this.deactivated_at = deactivated_at;
	}

	public Object getDefault_for_client_id() {
		return default_for_client_id;
	}

	public void setDefault_for_client_id(Object default_for_client_id) {
		this.default_for_client_id = default_for_client_id;
	}

	public Object getDefault_pre_sales_for_client_id() {
		return default_pre_sales_for_client_id;
	}

	public void setDefault_pre_sales_for_client_id(Object default_pre_sales_for_client_id) {
		this.default_pre_sales_for_client_id = default_pre_sales_for_client_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public DeviceIds getDevice_ids() {
		return device_ids;
	}

	public void setDevice_ids(DeviceIds device_ids) {
		this.device_ids = device_ids;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnable_voip() {
		return enable_voip;
	}

	public void setEnable_voip(boolean enable_voip) {
		this.enable_voip = enable_voip;
	}

	public boolean isFeedback_submitted() {
		return feedback_submitted;
	}

	public void setFeedback_submitted(boolean feedback_submitted) {
		this.feedback_submitted = feedback_submitted;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public GoogleCalendarDetails getGoogle_calendar_details() {
		return google_calendar_details;
	}

	public void setGoogle_calendar_details(GoogleCalendarDetails google_calendar_details) {
		this.google_calendar_details = google_calendar_details;
	}

	public GoogleToken getGoogle_token() {
		return google_token;
	}

	public void setGoogle_token(GoogleToken google_token) {
		this.google_token = google_token;
	}

	public boolean isGps_tracking_enabled() {
		return gps_tracking_enabled;
	}

	public void setGps_tracking_enabled(boolean gps_tracking_enabled) {
		this.gps_tracking_enabled = gps_tracking_enabled;
	}

	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Object getLast_otp_sent_at() {
		return last_otp_sent_at;
	}

	public void setLast_otp_sent_at(Object last_otp_sent_at) {
		this.last_otp_sent_at = last_otp_sent_at;
	}

	public LatestGpsLocation getLatest_gps_location() {
		return latest_gps_location;
	}

	public void setLatest_gps_location(LatestGpsLocation latest_gps_location) {
		this.latest_gps_location = latest_gps_location;
	}

	public Object getManager_id() {
		return manager_id;
	}

	public void setManager_id(Object manager_id) {
		this.manager_id = manager_id;
	}

	public Object getMs365_calendar_details() {
		return ms365_calendar_details;
	}

	public void setMs365_calendar_details(Object ms365_calendar_details) {
		this.ms365_calendar_details = ms365_calendar_details;
	}

	public Ms365Token getMs365_token() {
		return ms365_token;
	}

	public void setMs365_token(Ms365Token ms365_token) {
		this.ms365_token = ms365_token;
	}

	public ArrayList<Object> getOauth_accounts() {
		return oauth_accounts;
	}

	public void setOauth_accounts(ArrayList<Object> oauth_accounts) {
		this.oauth_accounts = oauth_accounts;
	}

	public Object getOtp_attempt() {
		return otp_attempt;
	}

	public void setOtp_attempt(Object otp_attempt) {
		this.otp_attempt = otp_attempt;
	}

	public ArrayList<Object> getOwner_ids() {
		return owner_ids;
	}

	public void setOwner_ids(ArrayList<Object> owner_ids) {
		this.owner_ids = owner_ids;
	}

	public PasswordUpdatedBy getPassword_updated_by() {
		return password_updated_by;
	}

	public void setPassword_updated_by(PasswordUpdatedBy password_updated_by) {
		this.password_updated_by = password_updated_by;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public PhoneCodes getPhone_codes() {
		return phone_codes;
	}

	public void setPhone_codes(PhoneCodes phone_codes) {
		this.phone_codes = phone_codes;
	}

	public ArrayList<Object> getPost_sales_project_ids() {
		return post_sales_project_ids;
	}

	public void setPost_sales_project_ids(ArrayList<Object> post_sales_project_ids) {
		this.post_sales_project_ids = post_sales_project_ids;
	}

	public ArrayList<Object> getPre_sales_project_ids() {
		return pre_sales_project_ids;
	}

	public void setPre_sales_project_ids(ArrayList<Object> pre_sales_project_ids) {
		this.pre_sales_project_ids = pre_sales_project_ids;
	}

	public ArrayList<Object> getProject_ids() {
		return project_ids;
	}

	public void setProject_ids(ArrayList<Object> project_ids) {
		this.project_ids = project_ids;
	}

	public boolean isPush_notification_mobile() {
		return push_notification_mobile;
	}

	public void setPush_notification_mobile(boolean push_notification_mobile) {
		this.push_notification_mobile = push_notification_mobile;
	}

	public Date getReactivated_on() {
		return reactivated_on;
	}

	public void setReactivated_on(Date reactivated_on) {
		this.reactivated_on = reactivated_on;
	}

	public ArrayList<Object> getRelative_team_ids() {
		return relative_team_ids;
	}

	public void setRelative_team_ids(ArrayList<Object> relative_team_ids) {
		this.relative_team_ids = relative_team_ids;
	}

	public int getResend_otp_counter() {
		return resend_otp_counter;
	}

	public void setResend_otp_counter(int resend_otp_counter) {
		this.resend_otp_counter = resend_otp_counter;
	}

	public String getRoaster() {
		return roaster;
	}

	public void setRoaster(String roaster) {
		this.roaster = roaster;
	}

	public Object getRoaster_sub_state() {
		return roaster_sub_state;
	}

	public void setRoaster_sub_state(Object roaster_sub_state) {
		this.roaster_sub_state = roaster_sub_state;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<Object> getSecondary_booking_detail_ids() {
		return secondary_booking_detail_ids;
	}

	public void setSecondary_booking_detail_ids(ArrayList<Object> secondary_booking_detail_ids) {
		this.secondary_booking_detail_ids = secondary_booking_detail_ids;
	}

	public String getSecondary_phone() {
		return secondary_phone;
	}

	public void setSecondary_phone(String secondary_phone) {
		this.secondary_phone = secondary_phone;
	}

	public String getSession_token() {
		return session_token;
	}

	public void setSession_token(String session_token) {
		this.session_token = session_token;
	}

	public ArrayList<Object> getTarget_ids() {
		return target_ids;
	}

	public void setTarget_ids(ArrayList<Object> target_ids) {
		this.target_ids = target_ids;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}

	public boolean isTemporary_reassignment() {
		return temporary_reassignment;
	}

	public void setTemporary_reassignment(boolean temporary_reassignment) {
		this.temporary_reassignment = temporary_reassignment;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public boolean isUnlimited_calling() {
		return unlimited_calling;
	}

	public void setUnlimited_calling(boolean unlimited_calling) {
		this.unlimited_calling = unlimited_calling;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public boolean isUser_in_default_routing() {
		return user_in_default_routing;
	}

	public void setUser_in_default_routing(boolean user_in_default_routing) {
		this.user_in_default_routing = user_in_default_routing;
	}

	public boolean isUsing_mobile_app() {
		return using_mobile_app;
	}

	public void setUsing_mobile_app(boolean using_mobile_app) {
		this.using_mobile_app = using_mobile_app;
	}

	public VoipCredentials getVoip_credentials() {
		return voip_credentials;
	}

	public void setVoip_credentials(VoipCredentials voip_credentials) {
		this.voip_credentials = voip_credentials;
	}

	public boolean isWork_as_manager() {
		return work_as_manager;
	}

	public void setWork_as_manager(boolean work_as_manager) {
		this.work_as_manager = work_as_manager;
	}

	public ZoomusConfiguration getZoomus_configuration() {
		return zoomus_configuration;
	}

	public void setZoomus_configuration(ZoomusConfiguration zoomus_configuration) {
		this.zoomus_configuration = zoomus_configuration;
	}

	public ZoomusToken getZoomus_token() {
		return zoomus_token;
	}

	public void setZoomus_token(ZoomusToken zoomus_token) {
		this.zoomus_token = zoomus_token;
	}
}
