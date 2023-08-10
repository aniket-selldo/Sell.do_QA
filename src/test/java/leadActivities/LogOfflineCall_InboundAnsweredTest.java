package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LogOfflineCallPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class LogOfflineCall_InboundAnsweredTest extends BaseTest {

	@Test
	public void logOfflineCall_InboundAnsweredTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		LogOfflineCallPage logOfflineCallPage = new LogOfflineCallPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();

		adminDashboardPage.searchLead(leadID);

		leadProfilePage.selectLogOfflineCalls();

		logOfflineCallPage.selectDirection_Inbound();

		logOfflineCallPage.selectStatus_Answered();

		logOfflineCallPage.dateSelector(-2);

		logOfflineCallPage.selectTime();

		Thread.sleep(2000);

		logOfflineCallPage.enterDuration("2");
		logOfflineCallPage.selectDurationUnit_Minutes();

		String noteText = "This was an Inbound answered call";

		logOfflineCallPage.enterNotes(noteText);

		logOfflineCallPage.clickOnSaveButton();

		Thread.sleep(2000);

		leadProfilePage.clickOnCall_d();

		Thread.sleep(2000);

		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText();

		Assert.assertTrue(text.contains("You answered the Lead's call"));

		String directionText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div:nth-child(2) > span"))
				.getText();
		System.out.println(directionText);
		System.out.println("Length Of leadId -> " + directionText.length());
		String croppedDirectionText = directionText.substring(0, +directionText.length() - 5);
		System.out.println(croppedDirectionText);
		Assert.assertEquals(directionText.trim(), "Incoming  |  Offline  |  Answered", "text not matching");// [Incoming
																											// | Offline
																											// | Ans]
		String recordingText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > div:nth-child(2) > span"))
				.getText();
		System.out.println(recordingText);

		Assert.assertEquals(recordingText, "No recording available", "text not matching");

		logOfflineCallPage.clickOnViewNotesLink();

		Thread.sleep(500);
		String textUnderViewNotes = driver.findElement(By.xpath("(//div[contains(@class,'collapse show')])[3]"))
				.getText().trim();
		Assert.assertEquals(textUnderViewNotes, noteText, "text not matching");

	}
}
