package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressType {
	@JsonProperty("label")
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	String label;

	@JsonProperty("val")
	public String getVal() {
		return this.val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	String val;
}
