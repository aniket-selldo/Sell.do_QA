package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class NFA_VerificationTest extends BaseTest {

	@Test

	public void nFA_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email_amura"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		String leadCount_b = salesPresalesDashboard.getNFABucketCount();
		System.out.println(leadCount_b);

		salesPresalesDashboard.clickOnNFAbucket();

		salesPresalesDashboard.openLeadProfile(1);

		// ................Scheduling site visit on a lead under NFA
		// list...................

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.selectSiteVisit();

		Thread.sleep(3000);

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		siteVisitPage.selectProject();

		siteVisitPage.sitevisitScheduleDate();
		Thread.sleep(2000);

		siteVisitPage.clickOnScheduleSiteVisitButton();

		Thread.sleep(2000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
			} catch (Exception e) {
			}

		}

		Thread.sleep(2000);

		// ..........Going back to dashboard after scheduling site
		// visit.......................

		salesPresalesDashboard.selectLeadActions(2);

		Thread.sleep(3000);

		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

//		WebElement count_a = driver
//				.findElement(By.cssSelector("div[id='nfa-leads'] span[class='title-item-body-count']"));
		String leadCount_a =  salesPresalesDashboard.getNFABucketCount();
		System.out.println(leadCount_a);

		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before scheduling site visit");

	}
}
