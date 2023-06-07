package POJO_LeadUpdate;

import java.util.ArrayList;

public class LeadProfile {
	private String gender;
	private boolean married;
	private String anniversary;
	private String age;
	private String birthday;
	private String industry;
	private ArrayList<Object> urls;
	private ArrayList<Object> incomes;
	private ArrayList<Object> loan_details;
	private ArrayList<Object> educational_details;
	private ArrayList<Object> professional_details;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public String getAnniversary() {
		return anniversary;
	}

	public void setAnniversary(String anniversary) {
		this.anniversary = anniversary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public ArrayList<Object> getUrls() {
		return urls;
	}

	public void setUrls(ArrayList<Object> urls) {
		this.urls = urls;
	}

	public ArrayList<Object> getIncomes() {
		return incomes;
	}

	public void setIncomes(ArrayList<Object> incomes) {
		this.incomes = incomes;
	}

	public ArrayList<Object> getLoan_details() {
		return loan_details;
	}

	public void setLoan_details(ArrayList<Object> loan_details) {
		this.loan_details = loan_details;
	}

	public ArrayList<Object> getEducational_details() {
		return educational_details;
	}

	public void setEducational_details(ArrayList<Object> educational_details) {
		this.educational_details = educational_details;
	}

	public ArrayList<Object> getProfessional_details() {
		return professional_details;
	}

	public void setProfessional_details(ArrayList<Object> professional_details) {
		this.professional_details = professional_details;
	}
}
