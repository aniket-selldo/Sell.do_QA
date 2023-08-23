package POJO_Constant_GET;

public class RoutingConfiguration {
	   public String _id;
	    public boolean advanced_logging;
	    public boolean enabled;
		public String get_id() {
			return _id;
		}
		public void set_id(String _id) {
			this._id = _id;
		}
		public boolean isAdvanced_logging() {
			return advanced_logging;
		}
		public void setAdvanced_logging(boolean advanced_logging) {
			this.advanced_logging = advanced_logging;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
}
