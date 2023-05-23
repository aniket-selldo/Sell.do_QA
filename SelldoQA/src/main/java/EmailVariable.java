
public class EmailVariable {
	static int val = 1;

	public static void email(String s) {
		String arr1[] = s.split(",");
		for (String string : arr1) {
			System.out.print((val++)+") "+string.split(":")[0].trim() + " = ");
			System.out.println("{{"+string.split(":")[1].replace("$", "").trim()+"}}");

		}
	}
	public static void email2(String s) {
		String arr1[] = s.split("\n");
		for (String string : arr1) {
			if (string.length()>2) {
				System.out.println((val++)+") "+string+" = "+"{{"+string.trim()+"}}");
			}
		}
	}
	public static void main(String[] args) {

		email("project_name: $project_name, rera_id: $rera_id, project_address: $project_address, last_lead_project_name: $last_lead_project_name, first_lead_project_name: $first_lead_project_name, name: $lead_name, lead_first_name: $lead_first_name, lead_last_name: $lead_last_name, lead_id: $lead_id, leadid: $leadid, lead_email: $lead_email, lead_phone_number: $lead_phone_number, sales_email: $sales_email, lead_created_at_date_only: $lead_created_at_date_only, latest_campaign: $latest_campaign, latest_source: $latest_source, latest_sub_source: $latest_sub_source, lead_phone_dialcode: $lead_phone_dialcode, created_at: $created_at, client_short_name: $client_short_name, client_name: $client_name, last_note: $last_note, sales_name: $sales_name, team_name: $team_name, otp_code: $otp_code,current_time: $current_time, lead_created_at: $lead_created_at, lead_address: $lead_address, activity_owner: $activity_owner, agenda: $agenda, date: $date, time: $time, sitevisit_type: $sitevisit_type, conducted_on: $conducted_on, acted_on: $acted_on, lead_otp: $lead_otp, sales_otp: $sales_otp, sitevisit_google_calendar_invite: $sitevisit_google_calendar_invite, sitevisit_ms365_calendar_invite: $sitevisit_ms365_calendar_invite, sitevisit_zoom_calendar_invite: $sitevisit_zoom_calendar_invite, sitevisit_google_calendar_url: $sitevisit_google_calendar_url, sitevisit_ms365_calendar_url: $sitevisit_ms365_calendar_url, sitevisit_zoom_calendar_url: $sitevisit_zoom_calendar_url, sitevisit_google_calendar_sms_invite: $sitevisit_google_calendar_sms_invite, sitevisit_ms365_calendar_sms_invite: $sitevisit_ms365_calendar_sms_invite, sitevisit_zoom_calendar_sms_invite: sitevisit_zoom_calendar_sms_invite, task_due_on: $task_due_on, task_priority: $task_priority, task_status: $task_status, task_assignee: $task_assignee, task_creator: $task_creator, taskable_type: $taskable_type, taskable_name: $taskable_name, lat: $lat, lng: $lng, followup_type: $followup_type, subject: $subject, vr_link: $vr_link, task_title: $task_title, ivr_number: $ivr_number, sales_manager_name: $sales_manager_name, by_creator_name: $by_creator_name, call_time: $call_time, record_url: $record_url, lead_profile_url: $lead_profile_url, call_feedback_url: $call_feedback_url, call_url: $call_url, email_url: $email_url, c_note: $c_note, booking_detail_id: $booking_detail_id, booking_amount: $booking_amount, project_tower_name: $project_tower_name, project_unit_name: $project_unit_name, applicant_name: $applicant_name, ledger_html: $ledger_html, sales_phone: $sales_phone, booking_id: $booking_id, booking_date: $booking_date, floor_number: $floor_number, unit_type: $unit_type, balance: $balance, plan_short_url: $plan_short_url, verification_code: $verification_code, qr_image: $qr_image, qr_image_sms: $qr_image_sms, pick_up_location_time: $pick_up_location_time, sales_pickup_info: $sales_pickup_info, lead_pickup_info: $lead_pickup_info, other_invities: $other_invities, pick_up_location: $pick_up_location, pick_up_time: $pick_up_time, requirement: $requirement, s_note: $s_note, requirement_min_possession: $requirement_min_possession, requirement_max_possession: $requirement_max_possession, confirmation_url: $confirmation_url, lead_source: $lead_source, lead_campaign: $lead_campaign, lead_last_source: $lead_last_source, lead_last_campaign: $lead_last_campaign, masked_lead_primary_email: $masked_lead_primary_email, lead_primary_email: $lead_primary_email, masked_lead_primary_phone: $masked_lead_primary_phone, lead_primary_phone: $lead_primary_phone, phone_number: $phone_number, post_sales_name: $post_sales_name, post_sales_email: $post_sales_email, post_sales_phone: $post_sales_phone, url_shortener_link: $url_shortener_link, lead_otp_text: $lead_otp_text, sales_otp_text: $sales_otp_text, admin_name: $admin_name, client_billing_url: $client_billing_url, support_url: $support_url, support_phone_number: $support_phone_number, activity_created_at: $activity_created_at, work_completed: $work_completed, total_amount_demanded: $total_amount_demanded, due_date: $due_date, current_stage: $current_stage, receipt_amount: $receipt_amount, receipt_status: $receipt_status, receipt_payment_mode: $receipt_payment_mode, receipt_issuing_bank: $receipt_issuing_bank, receipt_issuing_bank_branch: $receipt_issuing_bank_branch, receipt_cheque_no: $receipt_cheque_no, receipt_accounting_date: $receipt_accounting_date, receipt_issued_date: $receipt_issued_date, google_now_tag: $google_now_tag, task_reminder_subject: $task_reminder_subject, task_assigned_subject: $task_assigned_subject, task_completed_subject: $task_completed_subject,  property_types: $property_types, reassigned_by: $reassigned_by");		
	System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		email2("lead_primary_phone\n"
			+ "\n"
			+ "lead_phone_number\n"
			+ "\n"
			+ "lead_phone_dialcode\n"
			+ "\n"
			+ "lead_email\n"
			+ "\n"
			+ "current_time\n"
			+ "\n"
			+ "lead_created_at\n"
			+ "\n"
			+ "lead_created_at_date_only\n"
			+ "\n"
			+ "footer\n"
			+ "\n"
			+ "project_name\n"
			+ "\n"
			+ "last_lead_project_name\n"
			+ "\n"
			+ "first_lead_project_name\n"
			+ "\n"
			+ "name\n"
			+ "\n"
			+ "lead_first_name\n"
			+ "\n"
			+ "lead_last_name\n"
			+ "\n"
			+ "lead_id\n"
			+ "\n"
			+ "lead_stage\n"
			+ "\n"
			+ "lead_status\n"
			+ "\n"
			+ "stage_change_reason\n"
			+ "\n"
			+ "leadid\n"
			+ "\n"
			+ "lead_email\n"
			+ "\n"
			+ "lead_phone_number\n"
			+ "\n"
			+ "sales_email\n"
			+ "\n"
			+ "lead_created_at_date_only\n"
			+ "\n"
			+ "latest_campaign\n"
			+ "\n"
			+ "latest_source\n"
			+ "\n"
			+ "latest_sub_source\n"
			+ "\n"
			+ "lead_phone_dialcode\n"
			+ "\n"
			+ "created_at\n"
			+ "\n"
			+ "client_short_name\n"
			+ "\n"
			+ "client_name\n"
			+ "\n"
			+ "last_note\n"
			+ "\n"
			+ "sales_name\n"
			+ "\n"
			+ "team_name\n"
			+ "\n"
			+ "otp_code\n"
			+ "\n"
			+ "current_time\n"
			+ "\n"
			+ "lead_created_at\n"
			+ "\n"
			+ "lead_address\n"
			+ "\n"
			+ "activity_owner\n"
			+ "\n"
			+ "agenda\n"
			+ "\n"
			+ "date\n"
			+ "\n"
			+ "sitevisit_type\n"
			+ "\n"
			+ "conducted_on\n"
			+ "\n"
			+ "acted_on\n"
			+ "\n"
			+ "lead_otp\n"
			+ "\n"
			+ "sitevisit_google_calendar_invite\n"
			+ "\n"
			+ "sitevisit_ms365_calendar_invite\n"
			+ "\n"
			+ "sitevisit_zoom_calendar_invite\n"
			+ "\n"
			+ "sitevisit_google_calendar_url\n"
			+ "\n"
			+ "sitevisit_ms365_calendar_url\n"
			+ "\n"
			+ "sitevisit_zoom_calendar_url\n"
			+ "\n"
			+ "sitevisit_google_calendar_sms_invite\n"
			+ "\n"
			+ "sitevisit_ms365_calendar_sms_invite\n"
			+ "\n"
			+ "sitevisit_zoom_calendar_sms_invite\n"
			+ "\n"
			+ "task_due_on\n"
			+ "\n"
			+ "task_priority\n"
			+ "\n"
			+ "task_status\n"
			+ "\n"
			+ "task_assignee\n"
			+ "\n"
			+ "task_creator\n"
			+ "\n"
			+ "taskable_type\n"
			+ "\n"
			+ "task_reminder_subject\n"
			+ "\n"
			+ "lat\n"
			+ "\n"
			+ "followup_type\n"
			+ "\n"
			+ "subject\n"
			+ "\n"
			+ "vr_link\n"
			+ "\n"
			+ "task_title\n"
			+ "\n"
			+ "ivr_number\n"
			+ "\n"
			+ "sales_manager_name\n"
			+ "\n"
			+ "by_creator_name\n"
			+ "\n"
			+ "call_time\n"
			+ "\n"
			+ "record_url\n"
			+ "\n"
			+ "lead_profile_url\n"
			+ "\n"
			+ "c_note\n"
			+ "\n"
			+ "booking_amount\n"
			+ "\n"
			+ "booking_detail_id\n"
			+ "\n"
			+ "applicant_email\n"
			+ "\n"
			+ "applicant_phone\n"
			+ "\n"
			+ "parking_number\n"
			+ "\n"
			+ "project_tower_name\n"
			+ "\n"
			+ "carpet_area\n"
			+ "\n"
			+ "total_price\n"
			+ "\n"
			+ "applicant_name\n"
			+ "\n"
			+ "sales_phone\n"
			+ "\n"
			+ "booking_id\n"
			+ "\n"
			+ "booking_date\n"
			+ "\n"
			+ "floor_number\n"
			+ "\n"
			+ "unit_type\n"
			+ "\n"
			+ "balance\n"
			+ "\n"
			+ "plan_short_url\n"
			+ "\n"
			+ "verification_code\n"
			+ "\n"
			+ "qr_image\n"
			+ "\n"
			+ "qr_image_sms\n"
			+ "\n"
			+ "pick_up_location_time\n"
			+ "\n"
			+ "sales_pickup_info\n"
			+ "\n"
			+ "other_invities\n"
			+ "\n"
			+ "pick_up_location\n"
			+ "\n"
			+ "pick_up_time\n"
			+ "\n"
			+ "requirement\n"
			+ "\n"
			+ "requirement_min_possession\n"
			+ "\n"
			+ "requirement_max_possession\n"
			+ "\n"
			+ "confirmation_url\n"
			+ "\n"
			+ "lead_source\n"
			+ "\n"
			+ "lead_campaign\n"
			+ "\n"
			+ "lead_last_campaign\n"
			+ "\n"
			+ "lead_last_source\n"
			+ "\n"
			+ "masked_lead_primary_email\n"
			+ "\n"
			+ "lead_primary_email\n"
			+ "\n"
			+ "masked_lead_primary_phone\n"
			+ "\n"
			+ "lead_primary_phone\n"
			+ "\n"
			+ "phone_number\n"
			+ "\n"
			+ "post_sales_name\n"
			+ "\n"
			+ "url_shortener_link\n"
			+ "\n"
			+ "lead_otp_text\n"
			+ "\n"
			+ "sales_otp_text\n"
			+ "\n"
			+ "admin_name\n"
			+ "\n"
			+ "client_billing_url\n"
			+ "\n"
			+ "support_url\n"
			+ "\n"
			+ "support_phone_number\n"
			+ "\n"
			+ "activity_created_at\n"
			+ "\n"
			+ "work_completed\n"
			+ "\n"
			+ "receipt_amount\n"
			+ "\n"
			+ "receipt_status\n"
			+ "\n"
			+ "receipt_payment_mode\n"
			+ "\n"
			+ "receipt_issuing_bank\n"
			+ "\n"
			+ "receipt_issuing_bank_branch\n"
			+ "\n"
			+ "receipt_cheque_no\n"
			+ "\n"
			+ "receipt_accounting_date\n"
			+ "\n"
			+ "google_now_tag\n"
			+ "\n"
			+ "property_types\n"
			+ "\n"
			+ "reassigned_by\n"
			+ "\n"
			+ "total_amount_demanded\n"
			+ "\n"
			+ "due_date\n"
			+ "\n"
			+ "current_stage\n"
			+ "\n"
			+ "share_payment_link\n"
			+ "\n"
			+ "'call_feedback_url', 'call_url', 'email_url'\n"
			+ "\n"
			+ "taskable_name");
	}

}
