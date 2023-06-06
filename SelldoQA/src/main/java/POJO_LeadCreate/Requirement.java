package POJO_LeadCreate;

import java.util.ArrayList;

public class Requirement {
	private ArrayList<Integer> bhk;
	private String property_type;
	private String purpose;
	private String locations;
	private String min_budget;
	private String max_budget;
	private String min_possession;
	private String max_possession;
	private ArrayList<String> facing;
	private ArrayList<String> furnishing;
	private ArrayList<String> bathrooms;
	private String funding_source;
	private String transaction_type;
	private String area;
	private ArrayList<AddressesField> addresses_fields;

	public ArrayList<Integer> getBhk() {
		return bhk;
	}

	public void setBhk(ArrayList<Integer> bhk) {
		this.bhk = bhk;
	}

	public String getProperty_type() {
		return property_type;
	}

	public void setProperty_type(String property_type) {
		this.property_type = property_type;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public String getMin_budget() {
		return min_budget;
	}

	public void setMin_budget(String min_budget) {
		this.min_budget = min_budget;
	}

	public String getMax_budget() {
		return max_budget;
	}

	public void setMax_budget(String max_budget) {
		this.max_budget = max_budget;
	}

	public String getMin_possession() {
		return min_possession;
	}

	public void setMin_possession(String min_possession) {
		this.min_possession = min_possession;
	}

	public String getMax_possession() {
		return max_possession;
	}

	public void setMax_possession(String max_possession) {
		this.max_possession = max_possession;
	}

	public ArrayList<String> getFacing() {
		return facing;
	}

	public void setFacing(ArrayList<String> facing) {
		this.facing = facing;
	}

	public ArrayList<String> getFurnishing() {
		return furnishing;
	}

	public void setFurnishing(ArrayList<String> furnishing) {
		this.furnishing = furnishing;
	}

	public ArrayList<String> getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(ArrayList<String> bathrooms) {
		this.bathrooms = bathrooms;
	}

	public String getFunding_source() {
		return funding_source;
	}

	public void setFunding_source(String funding_source) {
		this.funding_source = funding_source;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public ArrayList<AddressesField> getAddresses_fields() {
		return addresses_fields;
	}

	public void setAddresses_fields(ArrayList<AddressesField> addresses_fields) {
		this.addresses_fields = addresses_fields;
	}
}
