package API;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulkPushLead extends AbstractComponent {

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
		String apiKeyWebSite = "0f78d52f936023a9f66df801c2a311b5";
		String apiKeyFullAccess = "a842744c2067dc03e306f99ff8696cbb";
		String user = "5e1c3d3a0c7392055d349fe0";
		String clinetID = "598480165a9db32837000042";
		ArrayList<String> st = new ArrayList<String>();
		ArrayList<String> ary = GetAllProjectIDAndName.getAllProjectID(apiKeyFullAccess, clinetID);
		
		for (int i = 0; i < 50; i++) {
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
