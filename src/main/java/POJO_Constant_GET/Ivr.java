package POJO_Constant_GET;

import java.util.ArrayList;

public class Ivr {
	 public String _id;
	    public boolean is_active;
	    public String name;
	    public ArrayList<String> sales_ids;
		public String get_id() {
			return _id;
		}
		public void set_id(String _id) {
			this._id = _id;
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
		public ArrayList<String> getSales_ids() {
			return sales_ids;
		}
		public void setSales_ids(ArrayList<String> sales_ids) {
			this.sales_ids = sales_ids;
		}
}
