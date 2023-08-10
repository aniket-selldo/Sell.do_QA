package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class AddingANoteTest extends BaseTest {

	@Test
	public void addingNoteTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboard.searchLead("#"+new APIs().createLead(prop("Sales_id")).getSell_do_lead_id());
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		System.out.println("Lead Id >>> " + leadProfilePage.getLeadId());
		leadProfilePage.clickOnAddANoteLink();
		String noteText = "Note added Successfully By Automation " + Random("AN", 1500);
		leadProfilePage.enterNote(noteText);
		leadProfilePage.clickOnsaveNoteButton();
		driver.navigate().refresh();
		Assert.assertEquals(leadProfilePage.getNoteText(), noteText, "Text are not matching");
	}

}
