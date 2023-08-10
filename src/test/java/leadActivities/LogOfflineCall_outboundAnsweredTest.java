package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LogOfflineCallPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class LogOfflineCall_outboundAnsweredTest extends BaseTest {

	@Test
	public void logOfflineCall_outboundAnsweredTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		LogOfflineCallPage logOfflineCallPage = new LogOfflineCallPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();

		adminDashboardPage.searchLead(leadID);

		leadProfilePage.selectLogOfflineCalls();

		logOfflineCallPage.selectDirection_Outbound();

		logOfflineCallPage.selectStatus_Answered();

		logOfflineCallPage.selectDate();

		logOfflineCallPage.selectTime();

		logOfflineCallPage.enterDuration("6");

		logOfflineCallPage.selectDurationUnit_Minutes();

		String noteText = "This was an Outbound answered call";

		logOfflineCallPage.enterNotes(noteText);

		logOfflineCallPage.clickOnSaveButton();

		leadProfilePage.clickOnCall_d();

		String text = leadProfilePage.callText();
		
		Assert.assertEquals(leadProfilePage.getFeedTextCall(), "Outgoing  |  Offline  |  Answered",
				"text not matching");

		String recordingText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > div:nth-child(2) > span"))
				.getText();
		System.out.println(recordingText);

		Assert.assertEquals(recordingText, "No recording available", "text not matching");

		logOfflineCallPage.clickOnViewNotesLink();

		String textUnderViewNotes = driver.findElement(By.xpath("(//div[contains(@class,'collapse show')])[3]"))
				.getText().trim();
		System.out.println(textUnderViewNotes);

		Assert.assertEquals(textUnderViewNotes, noteText, "text not matching");

	}

}
