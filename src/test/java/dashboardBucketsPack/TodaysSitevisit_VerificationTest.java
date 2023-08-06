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

		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7')), "incoming");

		String leadId_profileObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText()
				.replaceAll("\\s+", "");
		System.out.println(leadId_profileObj);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnMeetingLink();

		Thread.sleep(3000);

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		siteVisitPage.selectProject();

		siteVisitPage.selectDate();

		siteVisitPage.clickOnScheduleSiteVisitButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			siteVisitPage.clickOnIgnoreAndSchedule();

		}

		Thread.sleep(3000);

		salesPresalesDashboard.selectLeadActions(2);
		Thread.sleep(2000);

		salesPresalesDashboard.refreshDashboardStats();
		Thread.sleep(2000);

		salesPresalesDashboard.applySitevisitFilter();

		Thread.sleep(2000);

		int leadId_dashboardObj_Size = driver.findElements(By.cssSelector(".navigation.clearfix.todays_stat_show_lead"))
				.size();
		String leadId_dashboardObj = driver.findElements(By.cssSelector(".navigation.clearfix.todays_stat_show_lead"))
				.get(leadId_dashboardObj_Size - 1).getText().split(" ")[0].replaceAll("[^0-9]+", "").trim();
		System.out.println("#" + leadId_dashboardObj);

		Assert.assertEquals("#" + leadId_dashboardObj, leadId_profileObj, "Leads are not matching");

	}

}
