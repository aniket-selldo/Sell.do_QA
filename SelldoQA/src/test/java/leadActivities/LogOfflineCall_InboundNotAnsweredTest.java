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

public class LogOfflineCall_InboundNotAnsweredTest extends BaseTest {

	@Test
	public void logOfflineCall_InboundNotAnsweredTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		LogOfflineCallPage logOfflineCallPage = new LogOfflineCallPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage
		.searchLead("#" + new APIs().createLead(prop("Clinet_API_Res"), prop("Sales_id")).getSell_do_lead_id());
		
		leadProfilePage.selectLogOfflineCalls();

		logOfflineCallPage.selectDirection_Inbound();

		logOfflineCallPage.selectStatus_NotAnswered();

		logOfflineCallPage.selectDate();

		logOfflineCallPage.selectTime();

		logOfflineCallPage.clickOnSaveButton();

		leadProfilePage.clickOnCall_d();

		String text = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText();
		System.out.println(text);
		System.out.println("Length Of leadId -> " + text.length());
		String croppedText = text.substring(0, +text.length() - 43);
		System.out.println(croppedText);

		Assert.assertEquals(text.split("at")[0].trim(), "You missed call", "text not matching");

		String directionText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(3) > div:nth-child(2) > span"))
				.getText();
		System.out.println(directionText);
		System.out.println("Length Of leadId -> " + directionText.length());
		String croppedDirectionText = directionText.substring(0, +directionText.length() - 5);
		System.out.println(croppedText);

		Assert.assertEquals(croppedDirectionText.trim(), "Incoming  |  Offline  |  Not Ans", "text not matching");

		String recordingText = driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > div:nth-child(2) > span"))
				.getText();
		System.out.println(" ===" + recordingText);

		Assert.assertEquals(recordingText, "No recording available", "text not matching");
		Assert.assertEquals(leadProfilePage.getFeedTextCall(), "Incoming  |  Offline  |  Not Answered", "text not matching");

	}

}
