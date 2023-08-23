package POJO_Constant_GET;

public class EnableCommunication {
	  public boolean mixpanel;
	    public boolean sms;
	    public boolean email;
	    public boolean pusher;
	    public boolean call;
	    public boolean enable_profiles;
	    public boolean voip_call;
	    public boolean whatsapp;
		public boolean isMixpanel() {
			return mixpanel;
		}
		public void setMixpanel(boolean mixpanel) {
			this.mixpanel = mixpanel;
		}
		public boolean isSms() {
			return sms;
		}
		public void setSms(boolean sms) {
			this.sms = sms;
		}
		public boolean isEmail() {
			return email;
		}
		public void setEmail(boolean email) {
			this.email = email;
		}
		public boolean isPusher() {
			return pusher;
		}
		public void setPusher(boolean pusher) {
			this.pusher = pusher;
		}
		public boolean isCall() {
			return call;
		}
		public void setCall(boolean call) {
			this.call = call;
		}
		public boolean isEnable_profiles() {
			return enable_profiles;
		}
		public void setEnable_profiles(boolean enable_profiles) {
			this.enable_profiles = enable_profiles;
		}
		public boolean isVoip_call() {
			return voip_call;
		}
		public void setVoip_call(boolean voip_call) {
			this.voip_call = voip_call;
		}
		public boolean isWhatsapp() {
			return whatsapp;
		}
		public void setWhatsapp(boolean whatsapp) {
			this.whatsapp = whatsapp;
		}
}
