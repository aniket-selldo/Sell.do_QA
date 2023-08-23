package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiClient {
	@JsonProperty("_id")
	public String get_id() {
		return this._id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	String _id;

	@JsonProperty("api_client_type")
	public String getApi_client_type() {
		return this.api_client_type;
	}

	public void setApi_client_type(String api_client_type) {
		this.api_client_type = api_client_type;
	}

	String api_client_type;

	@JsonProperty("category")
	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	String category;

	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;
}
