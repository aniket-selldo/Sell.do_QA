package dashboardBucketsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class ReengagedLeads_VerificationTest extends BaseTest {

	@Test
	public void reengagedLeads_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		extentTest.get().log(Status.INFO, "Getting count of Reengaged Leads bucket......");
		String leadCount_ReengagedLeadsBucket = salesPresalesDashboard.getReenggagedLeadCount();
		salesPresalesDashboard.clickOnReenggegeBucket();
		extentTest.get().log(Status.INFO, "Clicking on Reengaged Leads bucket......");
		String leadCount_ReengagedLeadsList = salesPresalesDashboard.getLeadHash();

		extentTest.get().log(Status.INFO, "Getting count of leads under Reengaged Leads list......");
		Integer value = Integer.parseInt(leadCount_ReengagedLeadsList);
		leadCount_ReengagedLeadsList = String.valueOf(value);

		extentTest.get().log(Status.INFO,
				"Validating that the count of Reengaged bucket is same as that of the count of leads under Reengaged Leads list......");
		Assert.assertEquals(leadCount_ReengagedLeadsList, leadCount_ReengagedLeadsBucket, "Counts are different");
	}
}
