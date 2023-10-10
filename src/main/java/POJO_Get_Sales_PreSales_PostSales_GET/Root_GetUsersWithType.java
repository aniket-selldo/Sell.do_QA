package POJO_Get_Sales_PreSales_PostSales_GET;

public class Root_GetUsersWithType {
	private String id;
	private String text;
	private String department;
	private boolean allow_to_manage_leads;
	private String email;
	private boolean assign_leads;
	private String team_id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public boolean isAllow_to_manage_leads() {
		return allow_to_manage_leads;
	}

	public void setAllow_to_manage_leads(boolean allow_to_manage_leads) {
		this.allow_to_manage_leads = allow_to_manage_leads;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAssign_leads() {
		return assign_leads;
	}

	public void setAssign_leads(boolean assign_leads) {
		this.assign_leads = assign_leads;
	}

	public String getTeam_id() {
		return team_id;
	}

	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
}
