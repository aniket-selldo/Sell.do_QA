package POJO_Constant_GET;

public class InventoryConf {
	   public boolean enabled;
	    public boolean enabled_negotiation_confirmation;
	    public boolean manage_project_units;
	    public boolean negotiation_and_approval;
	    public boolean price_quotes;
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public boolean isEnabled_negotiation_confirmation() {
			return enabled_negotiation_confirmation;
		}
		public void setEnabled_negotiation_confirmation(boolean enabled_negotiation_confirmation) {
			this.enabled_negotiation_confirmation = enabled_negotiation_confirmation;
		}
		public boolean isManage_project_units() {
			return manage_project_units;
		}
		public void setManage_project_units(boolean manage_project_units) {
			this.manage_project_units = manage_project_units;
		}
		public boolean isNegotiation_and_approval() {
			return negotiation_and_approval;
		}
		public void setNegotiation_and_approval(boolean negotiation_and_approval) {
			this.negotiation_and_approval = negotiation_and_approval;
		}
		public boolean isPrice_quotes() {
			return price_quotes;
		}
		public void setPrice_quotes(boolean price_quotes) {
			this.price_quotes = price_quotes;
		}
}
