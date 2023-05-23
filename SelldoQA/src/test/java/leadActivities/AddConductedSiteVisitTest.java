package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.crm.SiteVisitPage;
import com.selldo.Utility.BaseTest;

public class AddConductedSiteVisitTest extends BaseTest {

	@Test
	public void addConductedSiteVisitTest() throws Exception {
		
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		SiteVisitPage siteVisitPage = new SiteVisitPage(driver);
		salesPresalesDashboard.goToAllLeadsList();
		salesPresalesDashboard.openLeadDetails(4);
		leadProfilePage.selectConductedSiteVisit();
		siteVisitPage.selectProject();
		String status = siteVisitPage.selectSiteVisitType("Home Visit");
		siteVisitPage.sitevisitConductedDate(23);
		siteVisitPage.addNotes("Automation " + random("addNotes", "AN", 1000));
		siteVisitPage.clickOnAddPreviouslyConductedSvButton();
		Thread.sleep(1000);
		Assert.assertEquals(getSuccessMSG(),"Previously conducted Site visitfor Home Visitadded successfully.");
		Assert.assertEquals(siteVisitPage.trackActivity(), "Conducted   |   " + status + "",
				"Previously conducted site visit is not added");
	}
}
