package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class ReschedulingSiteVisitTest extends BaseTest {

	@Test
	public void reschedulingSiteVisitTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.searchLead("#"+new APIs().createLead(prop("Clinet_API_Res"),prop("Sales_id")).getSell_do_lead_id());


		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnMeetingLink();

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		siteVisitPage.selectProject();

		int date = siteVisitPage.sitevisitScheduleDate();

		siteVisitPage.clickOnScheduleSiteVisitButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
				System.out.println("1>>>>" + getSuccessMSG());
			} catch (Exception e) {
			}

		}

		leadProfilePage.selectReschedule();

		String projectName = driver.findElement(
				By.cssSelector("div.select2-container.project_id.form-control.project_select a span:nth-child(1)"))
				.getText();
		System.out.println(projectName);

		siteVisitPage.sitevisitRescheduleDate();

		siteVisitPage.clickOnRescheduleButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
				System.out.println("2>>>>" + getSuccessMSG());

			} catch (Exception e) {
			}

		}
		leadProfilePage.clickFeedTab();

		String text = driver.findElement(By.xpath("//div[@class='title site_visit_date']")).getText().trim();

		System.out.println(">>> " + text);
		Assert.assertEquals(text.split(",")[0],
				"The Site visit is scheduled for " + projectName + " on " + "" + 28 + "/" + DateTime("MM/YYYY"));

	}

}
