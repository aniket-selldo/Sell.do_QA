package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthConfEnable {
	@JsonProperty("sms")
	public boolean getSms() {
		return this.sms;
	}

	public void setSms(boolean sms) {
		this.sms = sms;
	}

	boolean sms;

	@JsonProperty("email")
	public boolean getEmail() {
		return this.email;
	}

	public void setEmail(boolean email) {
		this.email = email;
	}

	boolean email;
}
