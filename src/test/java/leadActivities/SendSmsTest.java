package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SmsPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SendSmsTest extends BaseTest {

	@Test
	public void sendingSmsTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email_amura"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		String leadID = "#"
				+ new APIs().createLead(prop("Amura_website_api"), prop("PreSales_id_amura")).getSell_do_lead_id();
		adminDashboardPage.searchLead(leadID);

		leadProfilePage.clickOnSmsLink();

		SmsPage smsPage = new SmsPage(driver);

		smsPage.selectSmsTemplate("Test");// prop.getProperty("sms_template")

		smsPage.clickOnSendSmsButton();
		leadProfilePage.clickSms_d();

		String text = leadProfilePage.getEmailStatus();

		String msg[] = { "Outgoing Error", "Outgoing Success" };
		Assert.assertEquals(text, msg[0], "Fail outgoing SMS");

	}

}
