package POJO_Constant_GET;

public class PostSalesConfiguration {
	  public boolean allow_dated_stages;
	    public boolean allow_edit_cost_sheet;
	    public boolean enabled;
	    public String payment_types;
	    public String routing_based_on;
		public boolean isAllow_dated_stages() {
			return allow_dated_stages;
		}
		public void setAllow_dated_stages(boolean allow_dated_stages) {
			this.allow_dated_stages = allow_dated_stages;
		}
		public boolean isAllow_edit_cost_sheet() {
			return allow_edit_cost_sheet;
		}
		public void setAllow_edit_cost_sheet(boolean allow_edit_cost_sheet) {
			this.allow_edit_cost_sheet = allow_edit_cost_sheet;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public String getPayment_types() {
			return payment_types;
		}
		public void setPayment_types(String payment_types) {
			this.payment_types = payment_types;
		}
		public String getRouting_based_on() {
			return routing_based_on;
		}
		public void setRouting_based_on(String routing_based_on) {
			this.routing_based_on = routing_based_on;
		}
}
