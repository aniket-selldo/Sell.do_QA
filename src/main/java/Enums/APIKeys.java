package Enums;

public enum APIKeys {

	APIKey("05982fc554c597db3bd1db3a4e6fb9b9"), APIKeyFullAccess("99c4b48c7732b5183000999d1200d520"),
	ClientID("642a8145b083453f914ce854"), PreSalesUserID("642a9b11b083454f959c1b14"),
	SalesUserID("64522253b0834520de89a2d1");

	private String value;

	APIKeys(String str) {
		this.value = str;
	}

	public String toString() {
		return value;
	}
}
