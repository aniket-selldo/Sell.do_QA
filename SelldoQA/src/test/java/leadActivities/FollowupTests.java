package leadActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.FollowupsPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class FollowupTests extends BaseTest {
	@Test
	public void scheduleFollowup() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6', '7', '8', '9')), "All Leads");

		WebElement Lead1 = driver.findElement(By.cssSelector("span[name='lead_id']"));
		String leadtext1 = Lead1.getText().replaceAll("\\s+", "");
		System.out.println(leadtext1);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		leadProfilePage.followupLink();
		leadProfilePage.ifFollowupShedule();
		FollowupsPage followupsPage = new FollowupsPage(driver);

		followupsPage.selectDate();

		followupsPage.selectDate();

		String followupBy =followupsPage.clickOnScheduleFollowupButton();

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {
			try {
				new SiteVisitPage(driver).clickOnIgnoreAndSchedule();} catch (Exception e) {}}
		
		//Assert.assertEquals(getSuccessMSG(), "Followup call scheduled successfully");

		String expec = ("A followup call is scheduled by " + leadProfilePage.getUserName() + " on "
				+ DateTime("dd/MM/yyyy"));
		System.out.println(">>>>"+followupsPage.getFeedText());

		Assert.assertEquals(expec, followupsPage.getFeedText(),"Followup is not scheduled");
		System.out.println(followupsPage.getFeedText());
		// cancel followup
		salesPresalesDashboard.searchLead(leadtext1);
		
		leadProfilePage.followupLink();
		String msg=leadProfilePage. cancleFollowup();// Followup call scheduled successfully
		Assert.assertEquals(msg, "Followup call cancelled successfully");

	    expec = ("A followup "+followupBy+" was cancelled which was scheduled on "+ DateTime("dd/MM/yyyy"));
		Assert.assertEquals(expec, followupsPage.getFeedText(),"Followup is not cancelled");


	}

}
