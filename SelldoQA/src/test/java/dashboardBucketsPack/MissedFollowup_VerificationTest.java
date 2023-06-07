package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.FollowupsPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class MissedFollowup_VerificationTest extends BaseTest {

	@Test()

	public void missedFollowup_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		salesPresalesDashboard.clickOnOpenTasksLink();
		String count_missedFollowupBefore = salesPresalesDashboard.getMissedFollowups();
		System.out.println(count_missedFollowupBefore);

		extentTest.get().log(Status.INFO, "Clicking on Missed Followup bucket......");
		salesPresalesDashboard.clickOnMissedFollowupBucket();

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadProfile(3);

		extentTest.get().log(Status.INFO, "Scheduling Followup.......");
		leadProfilePage.followupLink();

		FollowupsPage followupsPage = new FollowupsPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Date.......");
		followupsPage.selectDate();

		extentTest.get().log(Status.INFO, "Clicking on Schedule Followup Button .......");
		followupsPage.clickOnScheduleFollowupButton();

		Thread.sleep(3000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Clicking on Ignore and schedule button.......");
			followupsPage.clickOnIgnoreAndSchedule();

		}

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Going back to dsahboard.......");
		salesPresalesDashboard.selectLeadActions(2);

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.clickOnOpenTasksLink();
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(5000);
		salesPresalesDashboard.clickOnOpenTasksLink();
		String count_missedFollowupAfter =salesPresalesDashboard.getMissedFollowups();
		System.out.println(count_missedFollowupAfter);

		extentTest.get().log(Status.INFO, "Validating count is not same after scheduling Followup.......");
		Assert.assertNotEquals(count_missedFollowupAfter, count_missedFollowupBefore,
				"Count is same as before scheduling Followup");

	}
}
