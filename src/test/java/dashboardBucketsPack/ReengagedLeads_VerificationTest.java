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

		salesPresalesDashboard.refreshDashboardStats();

		String leadCount_ReengagedLeadsBucket = salesPresalesDashboard.getReenggagedLeadCount();
		salesPresalesDashboard.clickOnReenggegeBucket();
		String leadCount_ReengagedLeadsList = salesPresalesDashboard.getLeadHash();

		Integer value = Integer.parseInt(leadCount_ReengagedLeadsList);
		leadCount_ReengagedLeadsList = String.valueOf(value);

		Assert.assertEquals(leadCount_ReengagedLeadsList, leadCount_ReengagedLeadsBucket, "Counts are different");
	}
}
