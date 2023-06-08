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
		String count_missedSiteVisitBefore = salesPresalesDashboard. getMissedSiteVisits();
		System.out.println(count_missedSiteVisitBefore);

		extentTest.get().log(Status.INFO, "Clicking on Missed Sitevisit bucket......");
		salesPresalesDashboard.clickOnMissedSitevisitBucket();

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadProfile(2);

		extentTest.get().log(Status.INFO, "Selecting Pending sitevisit from more under activity details.......");
		leadProfilePage.clickSitvisit_d();

		extentTest.get().log(Status.INFO, "Applying pending sitevisit filter.......");
		leadProfilePage.selectPending_Sitevisit();

		extentTest.get().log(Status.INFO, "Selecting Mark As Conducted from Action Bar.......");
		leadProfilePage.selectMarkAsConducted();

		extentTest.get().log(Status.INFO, "Selecting date on which Site visit was conducted.......");
		siteVisitPage.sitevisitConductedOnDate();

		extentTest.get().log(Status.INFO, "Writing some notes for conducted site visit.......");
		siteVisitPage.enterNotesForConductedSiteVisit("Already conducted");

		extentTest.get().log(Status.INFO, "Clicking on Mark as Conducted button.......");
		siteVisitPage.clickOnSaveButton();
		//siteVisitPage.clickOnMarkAsConductedButton();

		extentTest.get().log(Status.INFO, "Going back to dsahboard.......");
		salesPresalesDashboard.selectLeadActions(2);

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();
		salesPresalesDashboard.clickOnOpenTasksLink();

		Thread.sleep(5000);

		String count_missedSiteVisitAfter = salesPresalesDashboard.getMissedSiteVisits();
		System.out.println(count_missedSiteVisitAfter);


		extentTest.get().log(Status.INFO, "Validating count is not same after scheduling site visit.......");
		Assert.assertNotEquals(count_missedSiteVisitAfter, count_missedSiteVisitBefore,
				"Count is same as before scheduling site visit");

	}
}
