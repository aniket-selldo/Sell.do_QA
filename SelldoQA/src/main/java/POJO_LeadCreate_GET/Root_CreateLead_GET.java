package POJO_LeadCreate_GET;

import java.util.ArrayList;

public class Root_CreateLead_GET {
	private String sell_do_lead_id;
	private String sell_do_lead_verified;
	private ArrayList<Object> error;
	private SelldoLeadDetails selldo_lead_details;

	public String getSell_do_lead_id() {
		return sell_do_lead_id;
	}

	public void setSell_do_lead_id(String sell_do_lead_id) {
		this.sell_do_lead_id = sell_do_lead_id;
	}

	public String getSell_do_lead_verified() {
		return sell_do_lead_verified;
	}

	public void setSell_do_lead_verified(String sell_do_lead_verified) {
		this.sell_do_lead_verified = sell_do_lead_verified;
	}

	public ArrayList<Object> getError() {
		return error;
	}

	public void setError(ArrayList<Object> error) {
		this.error = error;
	}

	public SelldoLeadDetails getSelldo_lead_details() {
		return selldo_lead_details;
	}

	public void setSelldo_lead_details(SelldoLeadDetails selldo_lead_details) {
		this.selldo_lead_details = selldo_lead_details;
	}
}
