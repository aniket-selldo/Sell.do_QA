package dashboardBucketsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class UnreadEmail_VerificationTest extends BaseTest {

	@Test
	public void unreadEmail_VerificationTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email_amura"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		String leadCount_unreadEmailBucket = salesPresalesDashboard.getUnreadEmailCount();
		System.out.println(leadCount_unreadEmailBucket);

		salesPresalesDashboard.goToAllLeadsList();

		adminDashboardPage.SelectListBySelectClass("Pending Emails");
		
		salesPresalesDashboard.clearAllFilter();

		Thread.sleep(3000);

		String leadCount_pendingEmail = salesPresalesDashboard.getLeadHash();
		Assert.assertEquals(leadCount_unreadEmailBucket, leadCount_pendingEmail, "Counts are different");
		System.out.println("Completed verification");
	}

}
