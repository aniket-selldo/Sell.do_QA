package leadActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.FollowupsPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class FollowupTests extends BaseTest {
	@Test
	public void scheduleFollowup() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage
				.searchLead("#" + new APIs().createLead(prop("Clinet_API_Res"), prop("Sales_id")).getSell_do_lead_id());

		WebElement Lead1 = driver.findElement(By.cssSelector("span[name='lead_id']"));
		String leadtext1 = Lead1.getText().replaceAll("\\s+", "");
		System.out.println(leadtext1);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		leadProfilePage.followupLink_2();
		FollowupsPage followupsPage = new FollowupsPage(driver);

		String date = followupsPage.dateSelector(7);

		String followupBy = followupsPage.clickOnScheduleFollowupButton();

		try {
			new SiteVisitPage(driver).clickOnIgnoreAndSchedule();
		} catch (Exception e) {
		}

		// Assert.assertEquals(getSuccessMSG(), "Followup call scheduled successfully");

		String expec = ("A followup call is scheduled by " + leadProfilePage.getUserName() + " on " + date);
		String feedTest = followupsPage.getFeedText();

		Assert.assertEquals(expec, feedTest, "Followup is not scheduled");
		System.out.println(followupsPage.getFeedText());
		// cancel followup
		salesPresalesDashboard.searchLead(leadtext1);

		leadProfilePage.followupLink();
		leadProfilePage.cancleFollowup();// Followup call scheduled successfully

		expec = ("A followup " + followupBy + " was cancelled which was scheduled on " + date);
		Assert.assertEquals(expec, followupsPage.getFeedText(), "Followup is not cancelled");

	}

}
