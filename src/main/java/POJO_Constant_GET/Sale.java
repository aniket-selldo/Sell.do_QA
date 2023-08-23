package POJO_Constant_GET;

import java.util.ArrayList;

public class Sale {
	 public String label;
	    public String value;
	    public ArrayList<String> allowed;
	    public String status;
	    public String stage_type;
	    public boolean enabled;
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public ArrayList<String> getAllowed() {
			return allowed;
		}
		public void setAllowed(ArrayList<String> allowed) {
			this.allowed = allowed;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getStage_type() {
			return stage_type;
		}
		public void setStage_type(String stage_type) {
			this.stage_type = stage_type;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
}
