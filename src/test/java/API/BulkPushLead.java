package API;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BulkPushLead extends AbstractComponent {
	public static void pushLead() throws FileNotFoundException, IOException, InterruptedException {

		String apiKeyWebSite = "fa8d6ca0217e676a7b0e06f51c32568c";
		String apiKeyFullAccess = "c13ad8e13264b1c22bc39bb475889c7e";
		String user = "587f43cb5a9db3fa14000006";
		String clinetID = "587ddb2b5a9db31da9000002";
		ArrayList<String> st = new ArrayList<String>();
		ArrayList<String> ary = GetAllProjectIDAndName.getAllProjectID(apiKeyFullAccess, clinetID);

		for (int i = 0; i < 500; i++) {
			String leadCRMID = CreateLead_POST.createLeadByAPI(apiKeyWebSite, user);
			String LeadID = GetLeadID.getLeadId(apiKeyFullAccess, clinetID, leadCRMID);

			UpdateLead_Project_Stage.updateProjectAndStage(apiKeyFullAccess, clinetID, LeadID, "prospect", ary);
			String a = PushLead.PushToSales(apiKeyFullAccess, clinetID, LeadID, ary.get(0));
			System.out.println((i + 1) + ") " + leadCRMID + " Push to Sales : " + a);
			st.add(a);

		}
		findDuplicateInArrayList(st);

	}

	public static void CreateLeadWithMultipleIPs() throws FileNotFoundException, IOException, InterruptedException {

		String apiKeyWebSite = "3a24cf56e28d5ab1bf0ff6f23e0a0347";
		String apiKeyFullAccess = "c4d649781e5451ce2903b34b02496e2c";
		String user = "64a2bf61b08345763e71634c";
		String clinetID = "64a2be1db0834560eaa19563";
		ArrayList<String> st = new ArrayList<String>();
		ArrayList<String> ary = GetAllProjectIDAndName.getAllProjectID(apiKeyFullAccess, clinetID);

		for (int i = 0; i < 100; i++) {
			// Thread.sleep(1000);
			String leadCRMID = CreateLead_POST.createLeadByAPI(apiKeyWebSite, user);
			String LeadID = GetLeadID.getLeadId(apiKeyFullAccess, clinetID, leadCRMID);

			UpdateLead_Project_Stage.updateProjectAndStage(apiKeyFullAccess, clinetID, LeadID, "prospect", ary);
			System.out.println((i + 1) + ") " + leadCRMID);

		}

	}
	public static void demooo() {
		new APIs().getFullAccessAPI();
	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		demooo() ;
	}
}
