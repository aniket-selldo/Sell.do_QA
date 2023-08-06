package POJO_LeadUpdate_Stage_Project;

import java.util.ArrayList;

public class Lead {
	private String stage;
	private ArrayList<String> interested_project_ids;

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public ArrayList<String> getInterested_project_ids() {
		return interested_project_ids;
	}

	public void setInterested_project_ids(ArrayList<String> interested_project_ids) {
		this.interested_project_ids = interested_project_ids;
	}
}
