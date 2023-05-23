package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LogOfflineCallPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class LogOfflineCall_InboundAnsweredTest extends BaseTest {

	@Test

	public void logOfflineCall_InboundAnsweredTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		LogOfflineCallPage logOfflineCallPage = new LogOfflineCallPage(driver);

		//extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		// prop.getProperty("Log_OfflineCall_lead_id")

		adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6')), "All Leads");
		leadProfilePage.addPhoneNumber();
		Assert.assertEquals(getSuccessMSG(), "Lead updated successfully");
		//extentTest.get().log(Status.INFO, "Selecting Conducted sitevisit from more.........");
		leadProfilePage.selectLogOfflineCalls();

		//extentTest.get().log(Status.INFO, "Selecting Direction as Inbound.......");
		logOfflineCallPage.selectDirection_Inbound();

		//extentTest.get().log(Status.INFO, "Selecting Status as Answered.......");
		logOfflineCallPage.selectStatus_Answered();

		//extentTest.get().log(Status.INFO, "Selecting Date from calender.......");
		logOfflineCallPage.selectDate();

		//extentTest.get().log(Status.INFO, "Selecting Time.......");
		logOfflineCallPage.selectTime();

		Thread.sleep(2000);

		//extentTest.get().log(Status.INFO, "Entering Duration of call.......");
		logOfflineCallPage.enterDuration("2");
		//extentTest.get().log(Status.INFO, "Selecting Duration unit as Minutes......");
		logOfflineCallPage.selectDurationUnit_Minutes();

		String noteText = "This was an Inbound answered call";

		//extentTest.get().log(Status.INFO, "Entering some notes regarding call.......");
		logOfflineCallPage.enterNotes(noteText);

		//extentTest.get().log(Status.INFO, "Clicking on Save button.......");
		logOfflineCallPage.clickOnSaveButton();
		Assert.assertEquals(getSuccessMSG(), "Call details added successfully");

		Thread.sleep(2000);

		//extentTest.get().log(Status.INFO, "Clicking on Call link under activities section.......");
		leadProfilePage.clickOnCall_d();

		Thread.sleep(2000);

		//extentTest.get().log(Status.INFO, "Fetching the text appeared after adding log offline call....");
		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText();


		//extentTest.get().log(Status.INFO, "Verifying the text under Call activities....");
		Assert.assertTrue(text.contains("You answered the Lead's call"));

		//extentTest.get().log(Status.INFO, "Fetching Incoming text appeared after adding Inbound call....");
		String directionText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div:nth-child(2) > span"))
				.getText();
		System.out.println(directionText);
		System.out.println("Length Of leadId -> " + directionText.length());
		String croppedDirectionText = directionText.substring(0, +directionText.length() - 5);
		System.out.println(croppedDirectionText);
		//extentTest.get().log(Status.INFO, "Verifying that Incoming text appeared after adding Inbound call....");
		Assert.assertEquals(directionText.trim(), "Incoming  |  Offline  |  Answered", "text not matching");// [Incoming
																											// | Offline
																											// | Ans]
		//extentTest.get().log(Status.INFO, "Fetching text which shows it is an offline call....");
		String recordingText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > div:nth-child(2) > span"))
				.getText();
		System.out.println(recordingText);

		//extentTest.get().log(Status.INFO, "Verifying text which shows it is an offline call....");
		Assert.assertEquals(recordingText, "No recording available", "text not matching");

		//extentTest.get().log(Status.INFO, "Clicking on View Notes link.......");
		logOfflineCallPage.clickOnViewNotesLink();

		//extentTest.get().log(Status.INFO, "Fetching text under View notes....");
		Thread.sleep(500);
		String textUnderViewNotes = driver.findElement(By.xpath("(//div[contains(@class,'collapse show')])[3]"))
				.getText().trim();
		//extentTest.get().log(Status.INFO, "Verifying text under View notes....");
		Assert.assertEquals(textUnderViewNotes, noteText, "text not matching");


	}
}
