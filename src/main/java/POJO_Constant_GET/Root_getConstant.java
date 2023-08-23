package POJO_Constant_GET;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Root_getConstant {
    @JsonProperty("Constants") 
    public Constants constants;

	public Constants getConstants() {
		return constants;
	}

	public void setConstants(Constants constants) {
		this.constants = constants;
	}
}
