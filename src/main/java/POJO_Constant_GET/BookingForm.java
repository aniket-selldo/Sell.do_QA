package POJO_Constant_GET;

public class BookingForm {
	public String _id;
	public AgreementRequiredFields agreement_required_fields;
	public ApplicantRequiredFields applicant_required_fields;
	public String cost_details;
	public LoanRequiredFields loan_required_fields;
	public PossessionRequiredFields possession_required_fields;
	public RequiredFields required_fields;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public AgreementRequiredFields getAgreement_required_fields() {
		return agreement_required_fields;
	}

	public void setAgreement_required_fields(AgreementRequiredFields agreement_required_fields) {
		this.agreement_required_fields = agreement_required_fields;
	}

	public ApplicantRequiredFields getApplicant_required_fields() {
		return applicant_required_fields;
	}

	public void setApplicant_required_fields(ApplicantRequiredFields applicant_required_fields) {
		this.applicant_required_fields = applicant_required_fields;
	}

	public String getCost_details() {
		return cost_details;
	}

	public void setCost_details(String cost_details) {
		this.cost_details = cost_details;
	}

	public LoanRequiredFields getLoan_required_fields() {
		return loan_required_fields;
	}

	public void setLoan_required_fields(LoanRequiredFields loan_required_fields) {
		this.loan_required_fields = loan_required_fields;
	}

	public PossessionRequiredFields getPossession_required_fields() {
		return possession_required_fields;
	}

	public void setPossession_required_fields(PossessionRequiredFields possession_required_fields) {
		this.possession_required_fields = possession_required_fields;
	}

	public RequiredFields getRequired_fields() {
		return required_fields;
	}

	public void setRequired_fields(RequiredFields required_fields) {
		this.required_fields = required_fields;
	}
}
