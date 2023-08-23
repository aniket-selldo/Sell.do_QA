package POJO_Constant_GET;

import java.util.ArrayList;

public class DefaultSearchCriterion {
	   public String name;
	    public String id;
	    public String type;
	    public ArrayList<String> filter_types;
	    public String date_range;
	    public String date_range_field;
	    public String stage;
	    public String created_at;
	    public ArrayList<String> available_for;
	    public boolean is_default;
	    public Object not_in_stages;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public ArrayList<String> getFilter_types() {
			return filter_types;
		}
		public void setFilter_types(ArrayList<String> filter_types) {
			this.filter_types = filter_types;
		}
		public String getDate_range() {
			return date_range;
		}
		public void setDate_range(String date_range) {
			this.date_range = date_range;
		}
		public String getDate_range_field() {
			return date_range_field;
		}
		public void setDate_range_field(String date_range_field) {
			this.date_range_field = date_range_field;
		}
		public String getStage() {
			return stage;
		}
		public void setStage(String stage) {
			this.stage = stage;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public ArrayList<String> getAvailable_for() {
			return available_for;
		}
		public void setAvailable_for(ArrayList<String> available_for) {
			this.available_for = available_for;
		}
		public boolean isIs_default() {
			return is_default;
		}
		public void setIs_default(boolean is_default) {
			this.is_default = is_default;
		}
		public Object getNot_in_stages() {
			return not_in_stages;
		}
		public void setNot_in_stages(Object not_in_stages) {
			this.not_in_stages = not_in_stages;
		}
}
