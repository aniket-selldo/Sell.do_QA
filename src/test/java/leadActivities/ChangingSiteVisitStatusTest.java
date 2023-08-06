package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class ChangingSiteVisitStatusTest extends BaseTest {

	@Test
	public void changingSiteVisitStatusTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage
				.searchLead("#" + new APIs().createLead(prop("Clinet_API_Res"), prop("Sales_id")).getSell_do_lead_id());

		String leadId = driver.findElement(By.xpath("//span[@name='lead_id']")).getAttribute("innerHTML");
		System.out.println(leadId);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnMeetingLink();

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);
		siteVisitPage.selectProject();

		siteVisitPage.selectTentative();

		siteVisitPage.clickOnScheduleSiteVisitButton();
		try {
			driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty();
			siteVisitPage.clickOnIgnoreAndSchedule();
		} catch (Exception e) {
		}

		String a = "Site visit for Visit scheduled successfully.";
		siteVisitPage.clickOnConfirmButton();
		driver.findElement(By.xpath("//button[text()='close']")).click();
		Thread.sleep(2000);
		String b = "Site visit for Visit confirmed successfully.";
		Assert.assertTrue(getSuccessMSG().startsWith("Site visit for Visit"));
	}

}
