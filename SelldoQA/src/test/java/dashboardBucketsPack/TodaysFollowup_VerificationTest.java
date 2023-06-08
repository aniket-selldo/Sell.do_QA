package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.FollowupsPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class TodaysFollowup_VerificationTest extends BaseTest {

	@Test

	public void todaysFollowup_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+user033@sell.do", prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7')), "All Leads");

		extentTest.get().log(Status.INFO, "Getting Lead Id on which followup is to be scheduled for today.......");
		String leadId_profileObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText()
				.replaceAll("\\s+", "");
		System.out.println(leadId_profileObj);

		// .............Scehduling Followup for today...................

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Followup link......");
		leadProfilePage.followupLink();
		

		FollowupsPage followupsPage = new FollowupsPage(driver);

		extentTest.get().log(Status.INFO, "Selecting today's Date from calander......");
		followupsPage.selectDate();

		extentTest.get().log(Status.INFO, "Clicking on Schedule Followup Button .......");
		followupsPage.clickOnScheduleFollowupButon();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			try {
				extentTest.get().log(Status.INFO, "Clicking on Ignore and schedule button.......");
				followupsPage.clickOnIgnoreAndSchedule();
			} catch (Exception e) {
			}
		}

		extentTest.get().log(Status.INFO, "Validation for Scheduled followup .......");
		Thread.sleep(5000);

		String expectedText = prop.getProperty("scheduleExpectedText");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) div.card div:nth-child(1) > div.col-lg-11")));
		Assert.assertTrue(driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) div.card div:nth-child(1) > div.col-lg-11"))
				.getText().trim().contains(expectedText), "Followup is not scheduled");

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Going back to dashboard......");
		salesPresalesDashboard.selectLeadActions(2);
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Filter scheduled Followups.......");
		salesPresalesDashboard.applyFollowupFilter();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Getting Lead Id from toadys followup bucket......");
		String leadId_dashboardObj = driver
				.findElement(By.xpath("//a[@class='navigation clearfix todays_stat_show_lead']")).getText()
				.replaceAll("[^0-9]+", "").trim();
		System.out.println("#" + leadId_dashboardObj);

		extentTest.get().log(Status.INFO, "Verifying followup scheduled for today from dashboard......");
		Assert.assertTrue(followupsPage.validateIDInActivity(leadId_dashboardObj), "Leads are not matching");

	}
}
