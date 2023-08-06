package dashboardBucketsPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class MissedSitevisit_VerificationTest extends BaseTest {

	@Test
	public void missedSitevisit_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		salesPresalesDashboard.clickOnOpenTasksLink();
		String count_missedSiteVisitBefore = salesPresalesDashboard.getMissedSiteVisits();
		System.out.println(count_missedSiteVisitBefore);

		salesPresalesDashboard.clickOnMissedSitevisitBucket();

		salesPresalesDashboard.openLeadProfile(2);

		leadProfilePage.clickSitvisit_d();

		leadProfilePage.selectPending_Sitevisit();

		leadProfilePage.selectMarkAsConducted();

		siteVisitPage.sitevisitConductedOnDate();

		siteVisitPage.enterNotesForConductedSiteVisit("Already conducted");

		siteVisitPage.clickOnSaveButton();
		// siteVisitPage.clickOnMarkAsConductedButton();

		salesPresalesDashboard.selectLeadActions(2);

		Thread.sleep(3000);

		salesPresalesDashboard.refreshDashboardStats();
		salesPresalesDashboard.clickOnOpenTasksLink();

		Thread.sleep(5000);

		String count_missedSiteVisitAfter = salesPresalesDashboard.getMissedSiteVisits();
		System.out.println(count_missedSiteVisitAfter);

		Assert.assertNotEquals(count_missedSiteVisitAfter, count_missedSiteVisitBefore,
				"Count is same as before scheduling site visit");

	}
}
