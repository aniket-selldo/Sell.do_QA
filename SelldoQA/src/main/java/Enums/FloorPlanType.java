package Enums;

public enum FloorPlanType {

	villa("villa"),apartment("apartment"),penthouse("penthouse");

	private String value;
	FloorPlanType(String str){
		this.value=str;
	}
	public String toString() {
		return value;
	}
}
