package otherLeadActivitiesPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.ReassignLeadPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class ReassigningLeadTest extends BaseTest {


	@Test
	public void reassigningLeadTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("divya+superadmin@amuratech.com", "amura@123");
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin("Aniket Automation");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Signing in as a Presales user.......");
		adminDashboardPage.loginAsUser("AniketPreSale00");

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadProfile(0);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Getting Lead Id before assigning.......");
		String leadId = leadProfilePage.getLeadId();

		extentTest.get().log(Status.INFO, "Selecting Reassign from more.......");
		leadProfilePage.selectReassign();

		ReassignLeadPage reassignLeadPage = new ReassignLeadPage(driver);

		Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Selecting Team.......");
		reassignLeadPage.selectTeam("Test Master 02");

		extentTest.get().log(Status.INFO, "Selecting User.......");
		reassignLeadPage.selectUser("AniketpreSales01");

		extentTest.get().log(Status.INFO, "Clicking on Reassign button.......");
		reassignLeadPage.clickOnReassignButton();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Signing in as a Presales User.......");
		adminDashboardPage.loginAsUser("AniketpreSales01");

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Going to All leads list.......");
		salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Selecting Reassigned to me list.......");

		adminDashboardPage.SelectList("Reassigned To Me");

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(0);

		extentTest.get().log(Status.INFO, "Getting Lead Id after reassigning.......");
		String leadId_after = leadProfilePage.getLeadId();

		extentTest.get().log(Status.INFO, "Validating lead is reassigned.......");
		Assert.assertEquals(leadId, leadId_after, "Leads are not matching");
	}

}
