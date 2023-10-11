package workingTestscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

		Thread.sleep(2000);

		siteVisitPage.selectProject();

		siteVisitPage.dateSelector(-1);

		siteVisitPage.addNotes("Site visit was conducted previously");

		siteVisitPage.clickOnAddPreviouslyConductedSvButton();

		Thread.sleep(3000);

		WebElement text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div > div.row > div:nth-child(2) > span"));
		String text_conducted = text.getText();

		Assert.assertEquals(text_conducted, "Conducted   |   Visit",
				"Previously conducted site visit is not added");

	}
}
