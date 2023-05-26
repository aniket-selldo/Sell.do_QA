package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class ChangingSiteVisitStatusTest extends BaseTest {

	@Test
	public void changingSiteVisitStatusTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6', '7', '8', '9')), "All Leads");

		String leadId = driver.findElement(By.xpath("//span[@name='lead_id']")).getAttribute("innerHTML");
		System.out.println(leadId);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnMeetingLink();

		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);
		siteVisitPage.selectProject();

		siteVisitPage.selectTentative();

		siteVisitPage.clickOnScheduleSiteVisitButton();
		//Thread.sleep(5000);

		if (!driver.findElements(By.xpath("//button[text()=' Ignore & Schedule ']")).isEmpty()) {
			
			siteVisitPage.clickOnIgnoreAndSchedule();
		}
		String a = "Site visit for Visit scheduled successfully.";
		Assert.assertEquals(a, getSuccessMSG());
		leadProfilePage.selectConfirm();
		siteVisitPage.clickOnConfirmButton();

		
	}

}
