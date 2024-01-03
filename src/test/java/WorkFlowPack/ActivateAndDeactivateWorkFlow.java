package WorkFlowPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.AutomationDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import WorkFlow.WorkFlowListPage;

public class ActivateAndDeactivateWorkFlow extends BaseTest {

	@Test
	public void ActivateAndDeactivateWorkFlowTest() throws InterruptedException {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		AutomationDashboardPage automationDashboardPage = new AutomationDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		WorkFlowListPage WorkFlowListPage = new WorkFlowListPage(driver);

		adminDashboardPage.clickOnWandIcon();

		automationDashboardPage.clickOnWorkFlow();
		
		WorkFlowListPage.clearFilter();
		
		String WorkFlowName =WorkFlowListPage.FirstWorkflowNameFromList();

		WorkFlowListPage.SearchWorkFlow(WorkFlowName);

		WorkFlowListPage.Activate_Action_WorkFlow(WorkFlowName);

		WorkFlowListPage.displayAllActiveWF();

		String status1 = WorkFlowListPage.WorkFlowStatus(WorkFlowName);
		Assert.assertEquals(status1, "Active");

		WorkFlowListPage.Deactivate_Action_WorkFlow(WorkFlowName);

		WorkFlowListPage.displayAllInactiveWF();

		String status2 = WorkFlowListPage.WorkFlowStatus(WorkFlowName);
		Assert.assertEquals(status2, "Inactive");
	}

}
