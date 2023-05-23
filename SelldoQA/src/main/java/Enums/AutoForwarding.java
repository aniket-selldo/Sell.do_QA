package Enums;

public enum AutoForwarding {

	ON("Yes"), OFF("No");

	private String value;

	AutoForwarding(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
