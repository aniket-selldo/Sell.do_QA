package API;

public class POJOLead {

	String ID;
	String FName;
	String LName;
	String CRMID;
	String SalesName;
	String SalesID;
	String LeadStage;
	String name;
	String email;
	String emailType;
	String LeadDepartment;

	public POJOLead(String iD, String fName, String lName, String cRMID, String salesName, String salesID,
			String leadStage, String name, String email, String emailType, String leadDepartment) {
		super();
		ID = iD;
		FName = fName;
		LName = lName;
		CRMID = cRMID;
		SalesName = salesName;
		SalesID = salesID;
		LeadStage = leadStage;
		this.name = name;
		this.email = email;
		this.emailType = emailType;
		LeadDepartment = leadDepartment;
	}

	@Override
	public String toString() {
		return "POJOLead [ID=" + ID + ", FName=" + FName + ", LName=" + LName + ", CRMID=" + CRMID + ", SalesName="
				+ SalesName + ", SalesID=" + SalesID + ", LeadStage=" + LeadStage + ", name=" + name + ", email="
				+ email + ", emailType=" + emailType + ", LeadDepartment=" + LeadDepartment + "]";
	}
}
