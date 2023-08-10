package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SmsPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SendSmsTest extends BaseTest {

	@Test

	public void sendingSmsTest() throws Exception {
d
		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
		adminDashboardPage.searchLead(leadID);
		leadProfilePage.addPhoneNumber();

		leadProfilePage.clickOnSmsLink();

		SmsPage smsPage = new SmsPage(driver);

		smsPage.selectSmsTemplate("Test");// prop.getProperty("sms_template")

		smsPage.clickOnSendSmsButton();
		leadProfilePage.clickSms_d();

		String text = leadProfilePage.getEmailStatus();

		String msg[] = { "Outgoing Error", "Outgoing Success" };
		Assert.assertEquals(text, msg[0], "Fail outgoing SMS"); // Outgoing Error

	}

}
