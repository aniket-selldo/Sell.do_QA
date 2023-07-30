package POJO_SiteVisitReschedule;

import java.util.ArrayList;
import java.util.Date;

public class SiteVisit_Reschedule {
	private String lead_id;
	private String _id;
	private String scheduled_on;
	private String ends_on;
	private String participants;
	private String asset_ids;
	private String sitevisit_type;
	private String agenda;
	private String channel_partner_id;
	private String project_id;
	private boolean confirmed;
	private boolean pickup;
//	private String custom_rating;
//	private String custom_test;
//	private String custom_cgggcgf;
//	private String custom_datefield_data;
	private Object booking_detail_id;
	private CampaignInfo campaign_info;
	private Date created_at;
	private ExternalCalendarReference external_calendar_reference;
	private ArrayList<Object> external_participants;
	private GpsTracking gps_tracking;
	private String initiated_by;
	private Object interested_property_id;
	private int lead_crm_id;
	private Object notes;
	private Object pickup_location;
	private Object pickup_time;
	private String sales_id;
	private String status;
	private Date updated_at;
	private String google_calendar_invite;
	private String ms365_calendar_invite;
	private String zoom_calendar_invite;
	private Object allow_calendar_resync;
	private String type;

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

	public String getScheduled_on() {
		return scheduled_on;
	}

	public void setScheduled_on(String scheduled_on) {
		this.scheduled_on = scheduled_on;
	}

	public String getEnds_on() {
		return ends_on;
	}

	public void setEnds_on(String ends_on) {
		this.ends_on = ends_on;
	}

	public String getParticipants() {
		return participants;
	}

	public void setParticipants(String participants) {
		this.participants = participants;
	}

	public String getAsset_ids() {
		return asset_ids;
	}

	public void setAsset_ids(String asset_ids) {
		this.asset_ids = asset_ids;
	}

	public String getSitevisit_type() {
		return sitevisit_type;
	}

	public void setSitevisit_type(String sitevisit_type) {
		this.sitevisit_type = sitevisit_type;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public String getChannel_partner_id() {
		return channel_partner_id;
	}

	public void setChannel_partner_id(String channel_partner_id) {
		this.channel_partner_id = channel_partner_id;
	}

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
		this.project_id = project_id;
	}

	public boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public boolean isPickup() {
		return pickup;
	}

	public void setPickup(boolean pickup) {
		this.pickup = pickup;
	}

	public Object getBooking_detail_id() {
		return booking_detail_id;
	}

	public void setBooking_detail_id(Object booking_detail_id) {
		this.booking_detail_id = booking_detail_id;
	}

	public CampaignInfo getCampaign_info() {
		return campaign_info;
	}

	public void setCampaign_info(CampaignInfo campaign_info) {
		this.campaign_info = campaign_info;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public ExternalCalendarReference getExternal_calendar_reference() {
		return external_calendar_reference;
	}

	public void setExternal_calendar_reference(ExternalCalendarReference external_calendar_reference) {
		this.external_calendar_reference = external_calendar_reference;
	}

	public ArrayList<Object> getExternal_participants() {
		return external_participants;
	}

	public void setExternal_participants(ArrayList<Object> external_participants) {
		this.external_participants = external_participants;
	}

	public GpsTracking getGps_tracking() {
		return gps_tracking;
	}

	public void setGps_tracking(GpsTracking gps_tracking) {
		this.gps_tracking = gps_tracking;
	}

	public String getInitiated_by() {
		return initiated_by;
	}

	public void setInitiated_by(String initiated_by) {
		this.initiated_by = initiated_by;
	}

	public Object getInterested_property_id() {
		return interested_property_id;
	}

	public void setInterested_property_id(Object interested_property_id) {
		this.interested_property_id = interested_property_id;
	}

	public int getLead_crm_id() {
		return lead_crm_id;
	}

	public void setLead_crm_id(int lead_crm_id) {
		this.lead_crm_id = lead_crm_id;
	}

	public Object getNotes() {
		return notes;
	}

	public void setNotes(Object notes) {
		this.notes = notes;
	}

	public Object getPickup_location() {
		return pickup_location;
	}

	public void setPickup_location(Object pickup_location) {
		this.pickup_location = pickup_location;
	}

	public Object getPickup_time() {
		return pickup_time;
	}

	public void setPickup_time(Object pickup_time) {
		this.pickup_time = pickup_time;
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

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public String getGoogle_calendar_invite() {
		return google_calendar_invite;
	}

	public void setGoogle_calendar_invite(String google_calendar_invite) {
		this.google_calendar_invite = google_calendar_invite;
	}

	public String getMs365_calendar_invite() {
		return ms365_calendar_invite;
	}

	public void setMs365_calendar_invite(String ms365_calendar_invite) {
		this.ms365_calendar_invite = ms365_calendar_invite;
	}

	public String getZoom_calendar_invite() {
		return zoom_calendar_invite;
	}

	public void setZoom_calendar_invite(String zoom_calendar_invite) {
		this.zoom_calendar_invite = zoom_calendar_invite;
	}

	public Object getAllow_calendar_resync() {
		return allow_calendar_resync;
	}

	public void setAllow_calendar_resync(Object allow_calendar_resync) {
		this.allow_calendar_resync = allow_calendar_resync;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
