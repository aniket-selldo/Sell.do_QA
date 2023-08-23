package API;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BulkPushLead extends AbstractComponent {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		String apiKeyWebSite = "3a24cf56e28d5ab1bf0ff6f23e0a0347";
		String apiKeyFullAccess = "c4d649781e5451ce2903b34b02496e2c";
		String user = "64a2bf61b08345763e71634c";
		String clinetID = "64a2be1db0834560eaa19563";
		ArrayList<String> st = new ArrayList<String>();
		ArrayList<String> ary = GetAllProjectIDAndName.getAllProjectID(apiKeyFullAccess, clinetID);
		
		for (int i = 0; i < 50; i++) {
			String leadCRMID = CreateLead_POST.createLeadByAPI(apiKeyWebSite, user);
			String LeadID = GetLeadID.getLeadId(apiKeyFullAccess, clinetID, leadCRMID);
			
			UpdateLead_Project_Stage.updateProjectAndStage(apiKeyFullAccess, clinetID, LeadID, "prospect", ary);
//			String a = PushLead.PushToSales(apiKeyFullAccess, clinetID, LeadID,ary.get(0));
//			System.out.println((i + 1) + ") "+leadCRMID+" Push to Sales : " + a);
//
//			st.add(a);

		}
	//	findDuplicateInArrayList(st);

	}
}
