package POJO_Constant_GET;

import java.util.ArrayList;

public class SvVerificationConf {
    public SiteVisitVerification site_visit_verification;
    public ArrayList<Object> otp_override_roles;
	public SiteVisitVerification getSite_visit_verification() {
		return site_visit_verification;
	}
	public void setSite_visit_verification(SiteVisitVerification site_visit_verification) {
		this.site_visit_verification = site_visit_verification;
	}
	public ArrayList<Object> getOtp_override_roles() {
		return otp_override_roles;
	}
	public void setOtp_override_roles(ArrayList<Object> otp_override_roles) {
		this.otp_override_roles = otp_override_roles;
	}
}
