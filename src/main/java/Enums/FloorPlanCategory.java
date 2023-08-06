package Enums;

public enum FloorPlanCategory {
	premium("premium"),facing("facing"),corner("corner"),front("front");

	private String value;
	FloorPlanCategory(String str){
		this.value=str;
	}
	public String toString() {
		return value;
	}
}
