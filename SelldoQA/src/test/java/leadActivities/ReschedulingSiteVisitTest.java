package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class ReschedulingSiteVisitTest extends BaseTest {

	@Test
	public void reschedulingSiteVisitTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+sae02@sell.do","amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		// Thread.sleep(1000);
		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
				"All Leads");// prop.getProperty("Rescheduling_SiteVisit_lead_id")

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Meeting Link.......");
		leadProfilePage.clickOnMeetingLink();

		// Thread.sleep(3000);

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Project from dropdown.........");
		siteVisitPage.selectProject();

		extentTest.get().log(Status.INFO, "Selecting date from Calender.........");
		int date =siteVisitPage.sitevisitScheduleDate();

		extentTest.get().log(Status.INFO, "Clicking on Site visit button.........");
		siteVisitPage.clickOnScheduleSiteVisitButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Clicking on Ignore and schedule button.......");
			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
				System.out.println("1>>>>"+getSuccessMSG());
			} catch (Exception e) {
			}
			

		}

		// Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Selecting Reschedule from Action bar.........");
		leadProfilePage.selectReschedule();

		String projectName = driver.findElement(
				By.cssSelector("div.select2-container.project_id.form-control.project_select a span:nth-child(1)"))
				.getText();
		System.out.println(projectName);

		extentTest.get().log(Status.INFO, "Changing date to reschedule site visit.........");
		siteVisitPage.sitevisitRescheduleDate();

		extentTest.get().log(Status.INFO, "Clicking on Reschedule button.......");
		// Thread.sleep(4000);
		siteVisitPage.clickOnRescheduleButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Clicking on Ignore and schedule button.......");
			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
				System.out.println("2>>>>"+getSuccessMSG());

			} catch (Exception e) {
			}
			
		}
		// Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Clicking on Feed tab.......");
		leadProfilePage.clickFeedTab();

		extentTest.get().log(Status.INFO, "Fetching the text appeared under Feed after scheduling site visit....");
		String text = driver.findElement(By.xpath(
				"//div[@class='title site_visit_date']"))
				.getText().trim();

		extentTest.get().log(Status.INFO, "Verifying that Interested property Feed is generated successfully....");
		System.out.println(">>> "+text);
		Assert.assertEquals(text.split(",")[0], "The Site visit is scheduled for " + projectName + " on "+""+28+"/"+DateTime("MM/YYYY"));

	}

}
