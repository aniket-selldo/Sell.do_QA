package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class TodaysSitevisit_VerificationTest extends BaseTest {

	@Test
	public void todaysSitevisit_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+user033@sell.do", prop.getProperty("password"));

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7')), "All Leads");

		extentTest.get().log(Status.INFO, "Getting Lead Id on which Sitevisit is to be scheduled for today.......");
		String leadId_profileObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText()
				.replaceAll("\\s+", "");
		System.out.println(leadId_profileObj);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Meeting Link.......");
		leadProfilePage.clickOnMeetingLink();

		Thread.sleep(3000);

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Project from dropdown.........");
		siteVisitPage.selectProject();

		extentTest.get().log(Status.INFO, "Selecting today's date from Calender.........");
		siteVisitPage.selectDate();

		extentTest.get().log(Status.INFO, "Clicking on Site visit button.........");
		siteVisitPage.clickOnScheduleSiteVisitButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Clicking on Ignore and schedule button.......");
			siteVisitPage.clickOnIgnoreAndSchedule();

		}

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Going back to dashboard......");
		salesPresalesDashboard.selectLeadActions(2);
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Filter scheduled Sitevisits.......");
		salesPresalesDashboard.applySitevisitFilter();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Getting Lead Id from toadys sitevisit bucket......");
		String leadId_dashboardObj = driver.findElements(By.cssSelector(".navigation.clearfix.todays_stat_show_lead"))
				.get(1).getText().replaceAll("[^0-9]+", "").trim();
		System.out.println("#" + leadId_dashboardObj);

		extentTest.get().log(Status.INFO, "Verifying Sitevisit scheduled for today from dashboard......");
		Assert.assertEquals("#" + leadId_dashboardObj, leadId_profileObj, "Leads are not matching");

	}

}
