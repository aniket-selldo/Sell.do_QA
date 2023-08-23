package POJO_Constant_GET;

public class User {
    public String _id;
    public boolean allow_to_manage_leads;
    public boolean assign_leads;
    public String department;
    public String first_name;
    public boolean is_active;
    public String last_name;
    public Object manager_id;
    public String role;
    public String team_id;
    public String name;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public boolean isAllow_to_manage_leads() {
		return allow_to_manage_leads;
	}
	public void setAllow_to_manage_leads(boolean allow_to_manage_leads) {
		this.allow_to_manage_leads = allow_to_manage_leads;
	}
	public boolean isAssign_leads() {
		return assign_leads;
	}
	public void setAssign_leads(boolean assign_leads) {
		this.assign_leads = assign_leads;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Object getManager_id() {
		return manager_id;
	}
	public void setManager_id(Object manager_id) {
		this.manager_id = manager_id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTeam_id() {
		return team_id;
	}
	public void setTeam_id(String team_id) {
		this.team_id = team_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
