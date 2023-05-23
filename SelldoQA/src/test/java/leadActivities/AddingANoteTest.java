package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class AddingANoteTest extends BaseTest {

	@Test
	public void addingNoteTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboard.goToAllLeadsList();
		salesPresalesDashboard.openLeadDetails(Integer.parseInt(R('1', '2', '3')));
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		System.out.println("Lead Id >>> "+leadProfilePage.getLeadId());
		leadProfilePage.clickOnAddANoteLink();
		String noteText = "Note added Successfully By Automation "+random("noteText", "AN", 10000);
		leadProfilePage.enterNote(noteText);
		leadProfilePage.clickOnsaveNoteButton();
		Assert.assertEquals(getSuccessMSG(), "Note saved successfully.");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Assert.assertEquals(leadProfilePage.getNoteText(), noteText, "Text are not matching");
	}

}
