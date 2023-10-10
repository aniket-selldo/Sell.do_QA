package API;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class BulkPushLead extends AbstractComponent {

	
	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		String apiKeyWebSite = "0f78d52f936023a9f66df801c2a311b5";
		String apiKeyFullAccess = "0316ee486ac1fd68d313b6d6bb1c209a";
		String user = "63315d92b083454f56ba4af8";
		String clinetID = "598480165a9db32837000042";
		ArrayList<String> st = new ArrayList<String>();
		ArrayList<String> ary = GetAllProjectIDAndName.getAllProjectID(apiKeyFullAccess, clinetID,1);
		
		for (int i = 0; i < 5; i++) {
			String leadCRMID = CreateLead_POST.createLeadByAPI(apiKeyWebSite, user);
			String LeadID = GetLeadID.getLeadId(apiKeyFullAccess, clinetID, leadCRMID);
			
			UpdateLead_Project_Stage.updateProjectAndStage(apiKeyFullAccess, clinetID, LeadID, "prospect", ary);
			String a = PushLead.PushToSales(apiKeyFullAccess, clinetID, LeadID,ary.get(0));
			System.out.println((i + 1) + ") "+leadCRMID+" Push to Sales : " + a);
			st.add(a);

		}
		findDuplicateInArrayList(st);

	}
}
