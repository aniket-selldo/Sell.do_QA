package POJO_Constant_GET;

public class Project {
	 public String _id;
	    public String developer_id;
	    public String developer_name;
	    public boolean inventory_enabled;
	    public boolean is_active;
	    public String name;
		public String get_id() {
			return _id;
		}
		public void set_id(String _id) {
			this._id = _id;
		}
		public String getDeveloper_id() {
			return developer_id;
		}
		public void setDeveloper_id(String developer_id) {
			this.developer_id = developer_id;
		}
		public String getDeveloper_name() {
			return developer_name;
		}
		public void setDeveloper_name(String developer_name) {
			this.developer_name = developer_name;
		}
		public boolean isInventory_enabled() {
			return inventory_enabled;
		}
		public void setInventory_enabled(boolean inventory_enabled) {
			this.inventory_enabled = inventory_enabled;
		}
		public boolean isIs_active() {
			return is_active;
		}
		public void setIs_active(boolean is_active) {
			this.is_active = is_active;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
}
