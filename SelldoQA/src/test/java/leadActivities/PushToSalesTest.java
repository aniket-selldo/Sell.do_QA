package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.PushToSalesPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import Enums.AutoForwarding;
import Enums.Strategy;

public class PushToSalesTest extends BaseTest {
	private String SalesUser = "AniketSales00";
	private String PreSalesUser = "AniketPreSale00";

	@Test
	public void pushingLeadTest_ForwardingOff() throws Exception {
		AdminDashboardPage ad = new AdminDashboardPage(driver);
		ad.AutoForwading("Aniket Automation", Strategy.Team, AutoForwarding.OFF);

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
				prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);
		clientLogin.clientLogin("Aniket Automation");

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO,"Signing in as a sales user to which lead is to be pushed.......");
		adminDashboardPage.loginAsUser(SalesUser); //

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		extentTest.get().log(Status.INFO,"Getting count of Lead from Presales bucket......");
		int leadCount_b = salesPresalesDashboard.getPushToSalesCount();
		System.out.println(leadCount_b);

		extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();

		extentTest.get().log(Status.INFO, "Signing in as a Presales user from which lead is to be pushed......");
		adminDashboardPage.loginAsUser(PreSalesUser);

		extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		// Thread.sleep(2000);
		
		extentTest.get().log(Status.INFO, "Selecting Prospect list......");
		adminDashboardPage.SelectList("Incoming");
		leadProfilePage.clearFilter();
		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(0);
		salesPresalesDashboard.changing_BookedToProspect();
		salesPresalesDashboard.addProjectOnLead();
		Assert.assertEquals(getSuccessMSG(), "Lead updated successfully");
		 
		extentTest.get().log(Status.INFO, "Getting Lead Id before Pushing.......");
		String leadId_b = salesPresalesDashboard.getLeadId();
		System.out.println(leadId_b);

		extentTest.get().log(Status.INFO, "Selecting push from more dropdown......");
		leadProfilePage.selectPush();
		
		Thread.sleep(3000);
		PushToSalesPage pushToSalesPage = new PushToSalesPage(driver);

		// Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Selecting Team of user to which lead is to be pushed......");
		pushToSalesPage.selectTeam("Test Master 01");

		// Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Selecting User to which lead is to be pushed......");
		pushToSalesPage.selectUser(SalesUser);

		extentTest.get().log(Status.INFO, "Clicking on Push Button.......");
		pushToSalesPage.clickOnPushButton();
		Assert.assertEquals(getSuccessMSG(), "Please wait while we move the lead into sales.");
		// Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();

		extentTest.get().log(Status.INFO, "Signing in as a Presales user.......");
		adminDashboardPage.loginAsUser(SalesUser);

		extentTest.get().log(Status.INFO, "Going to All Lead List.......");
		salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Selecting From Presales list.......");
		adminDashboardPage.SelectList("From Pre Sales");

		// Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadDetails(0);

		extentTest.get().log(Status.INFO, "Getting Lead Id after pushing.......");
		String leadId_a = salesPresalesDashboard.getLeadId();
		System.out.println("Matching lead id >>> " + leadId_a + " = " + leadId_b);

		extentTest.get().log(Status.INFO, "Validating lead is pushed.......");

		Assert.assertEquals(leadId_a, leadId_b, "Leads are not matching");

		extentTest.get().log(Status.INFO, "Going to Users Dashboard.......");
		salesPresalesDashboard.selectLeadActions(2);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		// Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of Lead from Presales......");
		int leadCount_a = salesPresalesDashboard.getPushToSalesCount();
		System.out.println(leadCount_a);

		extentTest.get().log(Status.INFO, "Validating that count is not same after lead push.......");
		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before pushing lead");

	}

}
