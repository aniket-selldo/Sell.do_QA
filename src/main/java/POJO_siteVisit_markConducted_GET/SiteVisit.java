package POJO_siteVisit_markConducted_GET;

import java.util.ArrayList;
import java.util.Date;

public class SiteVisit {
	private String _id;
	private String agenda;
	private Object booking_detail_id;
	private CampaignInfo campaign_info;
	private Date conducted_on;
	private boolean confirmed;
	private Date created_at;
	private Date ends_on;
	private ExternalCalendarReference external_calendar_reference;
	private ArrayList<Object> external_participants;
	private GpsTracking gps_tracking;
	private String initiated_by;
	private Object interested_property_id;
	private int lead_crm_id;
	private String lead_id;
	private Object notes;
	private ArrayList<Object> participants;
	private boolean pickup;
	private Object pickup_location;
	private Object pickup_time;
	private String project_id;
	private String sales_id;
	private Date scheduled_on;
	private String sitevisit_type;
	private String status;
	private String team_id;
	private Date updated_at;
	private String google_calendar_invite;
	private String ms365_calendar_invite;
	private String zoom_calendar_invite;
	private Extras extras;
	private Object allow_calendar_resync;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public CampaignInfo getCampaign_info() {
		return campaign_info;
	}

	public void setCampaign_info(CampaignInfo campaign_info) {
		this.campaign_info = campaign_info;
	}

	public Date getConducted_on() {
		return conducted_on;
	}

	public void setConducted_on(Date conducted_on) {
		this.conducted_on = conducted_on;
	}

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getEnds_on() {
		return ends_on;
	}

	public void setEnds_on(Date ends_on) {
		this.ends_on = ends_on;
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

	public String getLead_id() {
		return lead_id;
	}

	public void setLead_id(String lead_id) {
		this.lead_id = lead_id;
	}

	public Object getNotes() {
		return notes;
	}

	public void setNotes(Object notes) {
		this.notes = notes;
	}

	public ArrayList<Object> getParticipants() {
		return participants;
	}

	public void setParticipants(ArrayList<Object> participants) {
		this.participants = participants;
	}

	public boolean isPickup() {
		return pickup;
	}

	public void setPickup(boolean pickup) {
		this.pickup = pickup;
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

	public String getProject_id() {
		return project_id;
	}

	public void setProject_id(String project_id) {
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

	public String getSitevisit_type() {
		return sitevisit_type;
	}

	public void setSitevisit_type(String sitevisit_type) {
		this.sitevisit_type = sitevisit_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
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

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}

	public Object getAllow_calendar_resync() {
		return allow_calendar_resync;
	}

	public void setAllow_calendar_resync(Object allow_calendar_resync) {
		this.allow_calendar_resync = allow_calendar_resync;
	}
}
