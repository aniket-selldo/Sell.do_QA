package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class AddConductedSiteVisitTest extends BaseTest {

	@Test
	public void addConductedSiteVisitTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);
		salesPresalesDashboard.searchLead("#"+new APIs().createLead(prop("Sales_id")).getSell_do_lead_id());
		leadProfilePage.selectConductedSiteVisit();
		siteVisitPage.selectProject();
		String status = siteVisitPage.selectSiteVisitType("Home Visit");
		siteVisitPage.dateSelector(-1);
		siteVisitPage.addNotes("Automation " + Random("AN", 1000));
		siteVisitPage.clickOnAddPreviouslyConductedSvButton();
		Thread.sleep(1000);
		Assert.assertEquals(siteVisitPage.trackActivity(), "Conducted   |   " + status + "",
				"Previously conducted site visit is not added");
	}
}
