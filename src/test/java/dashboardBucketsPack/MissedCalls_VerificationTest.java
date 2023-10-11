package dashboardBucketsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MissedCalls_VerificationTest extends BaseTest {

	@Test
	public void missedCalls_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);
		String leadCount_missedCallsBucket = salesPresalesDashboard.getMisscallBucketCount();
		System.out.println(leadCount_missedCallsBucket);

		salesPresalesDashboard.clickOnMissedCallsBucket();

		Thread.sleep(3000);

		String leadCount_MissedCalls=salesPresalesDashboard.getHashStringCount();
		System.out.println(leadCount_MissedCalls);

		// Get count of leads from string
		String count_MissedCalls = leadCount_MissedCalls.replaceAll("\\D+", "");

		System.out.println("Started verification");
		Assert.assertEquals(leadCount_missedCallsBucket, count_MissedCalls, "Counts are different");
		System.out.println("Completed verification");
	}
}
