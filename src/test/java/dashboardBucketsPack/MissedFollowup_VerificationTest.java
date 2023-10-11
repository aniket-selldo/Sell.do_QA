package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.FollowupsPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class MissedFollowup_VerificationTest extends BaseTest {

	@Test
	public void missedFollowup_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		salesPresalesDashboard.clickOnOpenTasksLink();
		String count_missedFollowupBefore = salesPresalesDashboard.getMissedFollowups();
		System.out.println(count_missedFollowupBefore);

		salesPresalesDashboard.clickOnMissedFollowupBucket();

		Thread.sleep(5000);
		salesPresalesDashboard.openLeadProfile(0);

		leadProfilePage.followupLink();

		FollowupsPage followupsPage = new FollowupsPage(driver);

		followupsPage.selectDate();

		followupsPage.clickOnScheduleFollowupButton2();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			siteVisitPage.clickOnIgnoreAndSchedule();

		}

		Thread.sleep(1000);

		salesPresalesDashboard.selectLeadActions(2);

		Thread.sleep(1000);

		salesPresalesDashboard.clickOnOpenTasksLink();
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(5000);
		salesPresalesDashboard.clickOnOpenTasksLink();
		String count_missedFollowupAfter = salesPresalesDashboard.getMissedFollowups();
		System.out.println(count_missedFollowupAfter);

		Assert.assertNotEquals(count_missedFollowupAfter, count_missedFollowupBefore,
				"Count is same as before scheduling Followup");

	}
}
