package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AllowedPropertyPurpose {
	@JsonProperty("id")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	String id;

	@JsonProperty("text")
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	String text;
}
