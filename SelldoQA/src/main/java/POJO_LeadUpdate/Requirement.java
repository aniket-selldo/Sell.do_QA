package POJO_LeadUpdate;

import java.util.ArrayList;

public class Requirement {
	private String min_budget;
	private String max_budget;
	private String min_possession;
	private String max_possession;
	private ArrayList<Object> property_types;
	private ArrayList<Object> facing;
	private ArrayList<Object> furnishing;
	private ArrayList<Object> bathrooms;
	private ArrayList<Object> property_purpose;
	private ArrayList<Object> bhk;
	private ArrayList<Object> locations;
	private String funding_source;
	private String transaction_type;
	private String area;

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

	public ArrayList<Object> getProperty_types() {
		return property_types;
	}

	public void setProperty_types(ArrayList<Object> property_types) {
		this.property_types = property_types;
	}

	public ArrayList<Object> getFacing() {
		return facing;
	}

	public void setFacing(ArrayList<Object> facing) {
		this.facing = facing;
	}

	public ArrayList<Object> getFurnishing() {
		return furnishing;
	}

	public void setFurnishing(ArrayList<Object> furnishing) {
		this.furnishing = furnishing;
	}

	public ArrayList<Object> getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(ArrayList<Object> bathrooms) {
		this.bathrooms = bathrooms;
	}

	public ArrayList<Object> getProperty_purpose() {
		return property_purpose;
	}

	public void setProperty_purpose(ArrayList<Object> property_purpose) {
		this.property_purpose = property_purpose;
	}

	public ArrayList<Object> getBhk() {
		return bhk;
	}

	public void setBhk(ArrayList<Object> bhk) {
		this.bhk = bhk;
	}

	public ArrayList<Object> getLocations() {
		return locations;
	}

	public void setLocations(ArrayList<Object> locations) {
		this.locations = locations;
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
}
