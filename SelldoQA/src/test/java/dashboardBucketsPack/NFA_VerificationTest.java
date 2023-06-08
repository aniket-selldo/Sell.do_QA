package dashboardBucketsPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class NFA_VerificationTest extends BaseTest {

	@Test

	public void nFA_VerificationTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of No Future Activity bucket......");
		WebElement count_b = driver.findElement(By.cssSelector("div[id='nfa-leads'] span[class='title-item-body-count']"));
		String leadCount_b = count_b.getText();
		System.out.println(leadCount_b);

		extentTest.get().log(Status.INFO, "Clicking on NFA bucket.......");
		salesPresalesDashboard.clickOnNFAbucket();

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboard.openLeadProfile(1);

		// ................Scheduling site visit on a lead under NFA
		// list...................

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Clicking on site visit Link.......");
		leadProfilePage.selectSiteVisit();

		Thread.sleep(3000);

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Project from dropdown.........");
		siteVisitPage.selectProject();

		extentTest.get().log(Status.INFO, "Selecting date from Calender.........");
		siteVisitPage.sitevisitScheduleDate();
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Clicking on Site visit button.........");
		siteVisitPage.clickOnScheduleSiteVisitButton();
		
		Thread.sleep(2000);
		
		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Clicking on Ignore and schedule button.......");
			try {
				siteVisitPage.clickOnIgnoreAndSchedule();
			} catch (Exception e) {
			}
			

		}
		
		Thread.sleep(2000);

		// ..........Going back to dashboard after scheduling site
		// visit.......................

		extentTest.get().log(Status.INFO, "Going back to dashboard......");
		salesPresalesDashboard.selectLeadActions(2);

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Refreshing the User Dashboard.......");
		salesPresalesDashboard.refreshDashboardStats();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Getting count of No Future Activity bucket......");
		WebElement count_a = driver.findElement(By.cssSelector("div[id='nfa-leads'] span[class='title-item-body-count']"));
		String leadCount_a = count_a.getText();
		System.out.println(leadCount_a);


		extentTest.get().log(Status.INFO, "Validating count is not same after scheduling site visit.......");
		Assert.assertNotEquals(leadCount_b, leadCount_a, "Count is same as before scheduling site visit");


	}
}
