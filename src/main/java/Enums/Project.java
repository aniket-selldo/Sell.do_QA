package Enums;

public enum Project {

	Aniket_Project_02("642a9700b083454f959c1a6d", "Aniket_Project_02"),
	Mamta_Building("642bc873b08345a7f044e100", "Mamta_Building"),
	Aniket_Project_03("6467a403b08345596afcc615", "Aniket_Project_03"),
	Aniket_Project_04("6467a45fb08345596afcc61c", "Aniket_Project_04"),
	Aniket_Project_05("6467a504b08345596afcc623", "Aniket_Project_05"),
	Aniket_Project_06("6467a5c3b08345596afcc62a", "Aniket_Project_06"),
	Aniket_Project_07("6467a779b08345596afcc631", "Aniket_Project_07");

	private String value;
	private String projectName;

	Project(String value, String projectName) {
		this.value = value;
		this.projectName = projectName;
	}

	public String toString() {
		return value;
	}

	public String getName() {
		return projectName;
	}
}
