package leadActivities;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class MarkingSiteVisitDidNotVisitTest extends BaseTest {

	@Test
	public void markingSiteVisitDidNotVisitTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();

		adminDashboardPage.searchLead(leadID);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnMeetingLink();

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		siteVisitPage.selectProject();

		siteVisitPage.sitevisitScheduleDate();

		siteVisitPage.clickOnScheduleSiteVisitButton();

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {
			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
			} catch (Exception e) {
			}

		}

		leadProfilePage.selectMarkDidNotVisit();

		String exp = "Note Generated By Automation " + RandomStringUtils.randomAlphabetic(1000);
		siteVisitPage.enterNotesForDidNotVisit(exp);

		siteVisitPage.clickOnDidNotVisitButton();
		String text = leadProfilePage.clickOnFollowupNote();
		Assert.assertEquals(text, exp);
	}

}
