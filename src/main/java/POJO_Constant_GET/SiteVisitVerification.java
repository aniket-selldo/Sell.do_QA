package POJO_Constant_GET;

public class SiteVisitVerification {
	 public boolean enabled;
	    public boolean gps;
	    public int otp;
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public boolean isGps() {
			return gps;
		}
		public void setGps(boolean gps) {
			this.gps = gps;
		}
		public int getOtp() {
			return otp;
		}
		public void setOtp(int otp) {
			this.otp = otp;
		}
}
