package Enums;

public enum Strategy {

	Team("Team"), Project("Project");

	private String value;

	Strategy(String value) {
		this.value = value;
	}

	public String toString() {
		return value;
	}
}
