package otherLeadActivitiesPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.ReassignLeadPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;
import API.Update_Lead;

public class ReassigningLeadTest extends BaseTest {

	@Test
	public void reassigningLeadTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		String leadID = "#" + new APIs().createLead(prop("PreSales_id")).getSell_do_lead_id();
		new Update_Lead().LeadStageChnage(leadID, "incoming");
		adminDashboardPage.searchLead(leadID);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		String leadId = leadProfilePage.getLeadId();

		leadProfilePage.selectReassign();

		ReassignLeadPage reassignLeadPage = new ReassignLeadPage(driver);

		Thread.sleep(4000);

		reassignLeadPage.selectTeam("Test Master 02");

		reassignLeadPage.selectUser("AniketKhandizod");

		reassignLeadPage.clickOnReassignButton();

		Thread.sleep(3000);
		login.login(prop("PreSales_email_2"), prop("Password"));

		salesPresalesDashboard.goToAllLeadsList();

		adminDashboardPage.SelectList("Reassigned To Me");

		salesPresalesDashboard.openLeadDetails(0);

		String leadId_after = leadProfilePage.getLeadId();

		Assert.assertEquals(leadId, leadId_after, "Leads are not matching");
	}

}
