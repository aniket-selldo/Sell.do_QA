package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApplicantRequiredFields {
	@JsonProperty("first_name")
	public boolean getFirst_name() {
		return this.first_name;
	}

	public void setFirst_name(boolean first_name) {
		this.first_name = first_name;
	}

	boolean first_name;

	@JsonProperty("last_name")
	public boolean getLast_name() {
		return this.last_name;
	}

	public void setLast_name(boolean last_name) {
		this.last_name = last_name;
	}

	boolean last_name;

	@JsonProperty("phone")
	public boolean getPhone() {
		return this.phone;
	}

	public void setPhone(boolean phone) {
		this.phone = phone;
	}

	boolean phone;

	@JsonProperty("pan_number")
	public boolean getPan_number() {
		return this.pan_number;
	}

	public void setPan_number(boolean pan_number) {
		this.pan_number = pan_number;
	}

	boolean pan_number;

	@JsonProperty("age")
	public boolean getAge() {
		return this.age;
	}

	public void setAge(boolean age) {
		this.age = age;
	}

	boolean age;

	@JsonProperty("son_daughter_wife_of")
	public boolean getSon_daughter_wife_of() {
		return this.son_daughter_wife_of;
	}

	public void setSon_daughter_wife_of(boolean son_daughter_wife_of) {
		this.son_daughter_wife_of = son_daughter_wife_of;
	}

	boolean son_daughter_wife_of;

	@JsonProperty("occupation")
	public boolean getOccupation() {
		return this.occupation;
	}

	public void setOccupation(boolean occupation) {
		this.occupation = occupation;
	}

	boolean occupation;

	@JsonProperty("aadhar_no")
	public boolean getAadhar_no() {
		return this.aadhar_no;
	}

	public void setAadhar_no(boolean aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	boolean aadhar_no;

	@JsonProperty("address1")
	public boolean getAddress1() {
		return this.address1;
	}

	public void setAddress1(boolean address1) {
		this.address1 = address1;
	}

	boolean address1;

	@JsonProperty("address2")
	public boolean getAddress2() {
		return this.address2;
	}

	public void setAddress2(boolean address2) {
		this.address2 = address2;
	}

	boolean address2;

	@JsonProperty("city")
	public boolean getCity() {
		return this.city;
	}

	public void setCity(boolean city) {
		this.city = city;
	}

	boolean city;

	@JsonProperty("country")
	public boolean getCountry() {
		return this.country;
	}

	public void setCountry(boolean country) {
		this.country = country;
	}

	boolean country;

	@JsonProperty("zip")
	public boolean getZip() {
		return this.zip;
	}

	public void setZip(boolean zip) {
		this.zip = zip;
	}

	boolean zip;

	@JsonProperty("birthday")
	public boolean getBirthday() {
		return this.birthday;
	}

	public void setBirthday(boolean birthday) {
		this.birthday = birthday;
	}

	boolean birthday;
}
