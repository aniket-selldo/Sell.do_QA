package Enums;

public enum WFEvent {


	Newlead_Created( "Newlead Created",1 ),
	Newcall_Created( "Newcall Created",2 ),
	Incomingcall_Missed( "Incomingcall Missed",3 ),
	Incomingcall_Answered( "Incomingcall Answered",4 ),
	Outgoingcall_Missed( "Outgoingcall Missed",5 ),
	Outgoingcall_Answered( "Outgoingcall Answered",6 ),
	Project_Added( "Project Added",7 ),
	Site_Visit_Scheduled( "Site Visit Scheduled",8 ),
	Site_Visit_Conducted( "Site Visit Conducted",9 ),
	Site_Visit_Missed( "Site Visit Missed",10 ),
	Site_Visit_Pending( "Site Visit Pending",11 ),
	Site_Visit_Dropped( "Site Visit Dropped",12 ),
	Followup_Scheduled( "Followup Scheduled",13 ),
	Followup_Pending( "Followup Pending",14 ),
	Followup_Conducted( "Followup Conducted",15 ),
	Touched_undefined( "Touched undefined",16 ),
	Email_Opened( "Email Opened",17 ),
	Email_Unsubscribed( "Email Unsubscribed",18 ),
	Email_Received( "Email Received",19 ),
	Lead_Validated( "Lead Validated",20 ),
	Pushedto_Sales( "Pushedto Sales",21 ),
	Pulledto_Sales( "Pulledto Sales",22 ),
	Campaignresponse_Received( "Campaignresponse Received",23 ),
	Leadre_engaged_undefined( "Leadre-engaged undefined",24 ),
	Lead_Reassigned( "Lead Reassigned",25 ),
	Leadrequirement_Updated( "Leadrequirement Updated",26 ),
	Leadprofile_Updated( "Leadprofile Updated",27 ),
	Stage_Changed( "Stage Changed",28 ),
	Status_Changed( "Status Changed",29 ),
	Lead_Lost( "Lead Lost",30 ),
	Lead_Unqualified( "Lead Unqualified",31 ),
	Site_Visit_Rescheduled( "Site Visit Rescheduled",32 ),
	Lead_Verified( "Lead Verified",33 ),
	Newenquiry_Received( "Newenquiry Received",34 ),
	Booked_Lead( "Booked Lead",35 ),
	Email_Sent( "Email Sent",36 ),
	Leadhotness_Updated( "Leadhotness Updated",37 ),
	Booking_Created( "Booking Created",38 ),
	Booking_Updated( "Booking Updated",39 ),
	Booking_Receipt_Created( "Booking Receipt created",40 ),
	Booking_Receipt_Updated( "Booking Receipt updated",41 ),
	Sms_Created( "Sms Created",42 ),
	Lead_Updated( "Lead Updated",43 ),
	Call_Feedback( "Call Feedback",44 ),
	Note_added( "Note added",45 ),
	Whatsapp_Sent( "Whatsapp Sent",46 ),
	Whatsapp_Delivered( "Whatsapp Delivered",47 ),
	Whatsapp_Read( "Whatsapp Read",48 ),
	Whatsapp_Received( "Whatsapp Received",49 );
	private String value;
	private int a;
	WFEvent(String value ,int a) {
		this.value = value;
		this.a=a;
	}

	public String toString() {
		return value;
	}
	public int toInt() {
		return a;
	}
}
