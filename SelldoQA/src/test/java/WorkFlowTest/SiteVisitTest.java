package WorkFlowTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import API.CreateSiteVisit;
import Enums.APIKeys;
import Enums.Project;
import Enums.WFEvent;
import WorkFlow.WorkFlowListPage;
import WorkFlow.WorkFlowPage;

public class SiteVisitTest extends BaseTest {

	@Test
	public void siteVisitTest() throws NumberFormatException, InterruptedException {
		LoginPage login = new LoginPage(driver);

		ClientLoginPage clientLogin = new ClientLoginPage(driver);
		login.login(prop.getProperty("Aniket_SM"), prop.getProperty("Aniket_SM_PSWD"));
		try {
			clientLogin.logout();
			login.login(prop.getProperty("Aniket_SM"), prop.getProperty("Aniket_SM_PSWD"));
		} catch (Exception e) {
		}

		clientLogin.clientLogin("Aniket Automation");
		
		WorkFlowPage wfp = new WorkFlowPage(driver);
		wfp.goToWF();
		wfp.clickOnNewWF();
		String WFName = Random(10).toUpperCase();
		String NoteText = Random(100).toUpperCase();
		wfp.fillWFForm(WFName, Random(100));
		wfp.clickOnGetStart();
		wfp.selectTamplete(WFEvent.Site_Visit_Scheduled);
		wfp.clickOnAddAction();
		wfp.clickOnAddActionButton();
		wfp.enterAction("Add Note");
		wfp.enterValue(NoteText);
		wfp.clickOnSaveAllButton();
		wfp.goToWF();
		
		WorkFlowListPage WorkFlowList = new WorkFlowListPage(driver);
		WorkFlowList.clearFilter();
		WorkFlowList.Activate_OR_Deactivate_WorkFlow(WFName);
		clientLogin.logout();

		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadId = adminDashboardPage
				.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')), "Unscheduled Leads");

		String leadID = adminDashboardPage.getLeadURL_ID(leadId);
		CreateSiteVisit.createSiteVisit(leadId, leadID,APIKeys.APIKeyFullAccess,APIKeys. ClientID,APIKeys.PreSalesUserID,Project.Aniket_Project_02, prop.getProperty("URL"));

		LeadProfilePage lpp = new LeadProfilePage(driver);
		lpp.clickFeedTabNote();

		String actualComment = lpp.getFirstNoteText();
		
		clientLogin.logout();
		login.login(prop.getProperty("Aniket_SM"), prop.getProperty("Aniket_SM_PSWD"));
		clientLogin.clientLogin("Aniket Automation");
		wfp.goToWF();
		WorkFlowList.Activate_OR_Deactivate_WorkFlow(WFName);
		
		Assert.assertEquals(actualComment, NoteText);
		
	}
}
