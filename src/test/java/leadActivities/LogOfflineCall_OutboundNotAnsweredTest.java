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

public class LogOfflineCall_OutboundNotAnsweredTest extends BaseTest {

	@Test
	public void logOfflineCall_OutboundNotAnsweredTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		LogOfflineCallPage logOfflineCallPage = new LogOfflineCallPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();

		adminDashboardPage.searchLead(leadID);

		leadProfilePage.selectLogOfflineCalls();

		logOfflineCallPage.selectDirection_Outbound();

		logOfflineCallPage.selectStatus_NotAnswered();

		logOfflineCallPage.selectDate();

		logOfflineCallPage.selectTime();

		logOfflineCallPage.clickOnSaveButton();

		leadProfilePage.clickOnCall_d();

		Thread.sleep(2000);

		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText();

		Assert.assertTrue(text.contains("You tried calling the Lead"));

		String directionText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div:nth-child(2) > span"))
				.getText();
		System.out.println(directionText);
		System.out.println("Length Of leadId -> " + directionText.length());
		String croppedDirectionText = directionText.substring(0, +directionText.length() - 5);
		System.out.println(croppedDirectionText);
		Assert.assertEquals(directionText.trim(), "Outgoing  |  Offline  |  Not Answered", "text not matching");

		String recordingText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > div:nth-child(2) > span"))
				.getText();
		System.out.println(recordingText);

		Assert.assertEquals(recordingText, "No recording available", "text not matching");

	}

}
