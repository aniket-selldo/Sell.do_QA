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

public class LogOfflineCall_OutboundNotAnsweredTest extends BaseTest {


	@Test
	public void logOfflineCall_OutboundNotAnsweredTest() throws Exception {


		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("AniketPreSaleUser"), prop.getProperty("password"));

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		LogOfflineCallPage logOfflineCallPage = new LogOfflineCallPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('1', '2', '3', '4', '5', '6')), "All Leads");

		extentTest.get().log(Status.INFO, "Selecting Conducted sitevisit from more.........");
		leadProfilePage.addPhoneNumber();
		
		leadProfilePage.selectLogOfflineCalls();

		extentTest.get().log(Status.INFO, "Selecting Direction as Outbound.......");
		logOfflineCallPage.selectDirection_Outbound();

		extentTest.get().log(Status.INFO, "Selecting Status as Not Answered.......");
		logOfflineCallPage.selectStatus_NotAnswered();

		extentTest.get().log(Status.INFO, "Selecting Date from calender.......");
		logOfflineCallPage.selectDate();

		extentTest.get().log(Status.INFO, "Selecting Time.......");
		logOfflineCallPage.selectTime();

		//Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Entering Duration of call.......");
		// logOfflineCallPage.enterDuration("2");

		extentTest.get().log(Status.INFO, "Selecting Duration unit as Minutes......");
		// logOfflineCallPage.selectDurationUnit_Minutes();

		extentTest.get().log(Status.INFO, "Clicking on Save button.......");
		logOfflineCallPage.clickOnSaveButton();
		Assert.assertEquals(getSuccessMSG(), "Call details added successfully");

		//Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Clicking on Call link under activities section button.......");
		leadProfilePage.clickOnCall_d();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Fetching the text appeared after adding log offline call....");
		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText();


		extentTest.get().log(Status.INFO, "Verifying the text under Call activities....");
		Assert.assertTrue(text.contains("You tried calling the Lead"));

		extentTest.get().log(Status.INFO, "Fetching Outgoing text appeared after adding Outbound call....");
		String directionText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div:nth-child(2) > span"))
				.getText();
		System.out.println(directionText);
		System.out.println("Length Of leadId -> " + directionText.length());
		String croppedDirectionText = directionText.substring(0, +directionText.length() - 5);
		System.out.println(croppedDirectionText);
		extentTest.get().log(Status.INFO, "Verifying that Outgoing text appeared after adding Outbound call....");
		Assert.assertEquals(directionText.trim(), "Outgoing  |  Offline  |  Not Answered", "text not matching");

		extentTest.get().log(Status.INFO, "Fetching text which shows it is an offline call....");
		String recordingText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > div:nth-child(2) > span"))
				.getText();
		System.out.println(recordingText);

		extentTest.get().log(Status.INFO, "Verifying text which shows it is an offline call....");
		Assert.assertEquals(recordingText, "No recording available", "text not matching");

	}

}
