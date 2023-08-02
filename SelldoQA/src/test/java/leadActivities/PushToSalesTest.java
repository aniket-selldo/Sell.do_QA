package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.PushToSalesPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import Enums.AutoForwarding;
import Enums.Strategy;

public class PushToSalesTest extends BaseTest {

	@Test
	public void pushingLeadTest_ForwardingOff() throws Exception {
		AdminDashboardPage ad = new AdminDashboardPage(driver);
		ad.AutoForwading("Aniket Automation", Strategy.Team, AutoForwarding.OFF);

		LoginPage login = new LoginPage(driver);
		deZoom(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		login.login(prop("Sales_email"), prop("Password"));

		salesPresalesDashboard.refreshDashboardStats();

		int leadCount_b = salesPresalesDashboard.getPushToSalesCount();
		System.out.println(leadCount_b);

		//leadProfilePage.backToAdmin();

		logout();
		login.login(prop("PreSales_email"), prop("Password"));

		salesPresalesDashboard.goToAllLeadsList();

		adminDashboardPage.SelectList("Incoming");
		leadProfilePage.clearFilter();
		salesPresalesDashboard.openLeadDetails(0);
		salesPresalesDashboard.changing_BookedToProspect();
		salesPresalesDashboard.addProjectOnLead();
		Assert.assertEquals(getSuccessMSG(), "Lead updated successfully");

		String leadId_b = salesPresalesDashboard.getLeadId();
		System.out.println(leadId_b);

		leadProfilePage.selectPush();

		Thread.sleep(3000);
		PushToSalesPage pushToSalesPage = new PushToSalesPage(driver);

		pushToSalesPage.selectTeam(prop("Sales_team"));

		pushToSalesPage.selectUser(prop("Sales_Name"));

		pushToSalesPage.clickOnPushButton();
		Assert.assertEquals(getSuccessMSG(), "Please wait while we move the lead into sales.");

		//leadProfilePage.backToAdmin();

		logout();
		login.login(prop("Sales_email"), prop("Password"));

		salesPresalesDashboard.goToAllLeadsList();

		adminDashboardPage.SelectList("From Pre Sales");

		salesPresalesDashboard.openLeadDetails(0);

		String leadId_a = salesPresalesDashboard.getLeadId();
		System.out.println("Matching lead id >>> " + leadId_a + " = " + leadId_b);

		Assert.assertEquals(leadId_a, leadId_b, "Leads are not matching");

		salesPresalesDashboard.selectLeadActions(2);

		salesPresalesDashboard.refreshDashboardStats();

		int leadCount_a = salesPresalesDashboard.getPushToSalesCount();
		System.out.println(leadCount_a);

		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before pushing lead");

	}

}
