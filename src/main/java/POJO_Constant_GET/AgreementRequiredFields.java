package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AgreementRequiredFields {
	@JsonProperty("agreement_date")
	public boolean getAgreement_date() {
		return this.agreement_date;
	}

	public void setAgreement_date(boolean agreement_date) {
		this.agreement_date = agreement_date;
	}

	boolean agreement_date;

	@JsonProperty("signing_date")
	public boolean getSigning_date() {
		return this.signing_date;
	}

	public void setSigning_date(boolean signing_date) {
		this.signing_date = signing_date;
	}

	boolean signing_date;

	@JsonProperty("registration_number")
	public boolean getRegistration_number() {
		return this.registration_number;
	}

	public void setRegistration_number(boolean registration_number) {
		this.registration_number = registration_number;
	}

	boolean registration_number;

	@JsonProperty("registration_date")
	public boolean getRegistration_date() {
		return this.registration_date;
	}

	public void setRegistration_date(boolean registration_date) {
		this.registration_date = registration_date;
	}

	boolean registration_date;

	@JsonProperty("stamp_duty_date")
	public boolean getStamp_duty_date() {
		return this.stamp_duty_date;
	}

	public void setStamp_duty_date(boolean stamp_duty_date) {
		this.stamp_duty_date = stamp_duty_date;
	}

	boolean stamp_duty_date;
}
