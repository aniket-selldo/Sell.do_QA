package workingTestscripts;

import org.openqa.selenium.By;
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

		leadProfilePage.clickOnAddANoteLink();

		String noteText = "Note added Successfully "+Random("AN",1000);
		
		leadProfilePage.enterNote(noteText);

		leadProfilePage.clickOnsaveNoteButton();
		
		Thread.sleep(2000);
		
		String noteText_AfterAddition = driver.findElement(By.cssSelector("#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div > div > span:nth-child(1)")).getText();

		Assert.assertEquals(noteText_AfterAddition, noteText, "Text are not matching");

	}

}
