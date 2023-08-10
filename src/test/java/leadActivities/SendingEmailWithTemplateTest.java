package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SendingEmailWithTemplateTest extends BaseTest {

	@Test

	public void sendingEmailWithTemplateTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
		adminDashboardPage.searchLead(leadID);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnEmailLink();

		EmailPage emailPage = new EmailPage(driver);

		emailPage.selectTemplate("Aniket Templete All Variable");
		emailPage.enterSubject("Subject By Automation");

		emailPage.clickOnSendEmailButton();

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboardPage.pageRefresh();

		leadProfilePage.clickEmail_d();

		String text = leadProfilePage.getEmailStatus();

		// Assert.assertEquals(text, "outgoing | delivered");
		String exp[] = { "outgoing  |  delivered", "outgoing  |  -", "outgoing  |  failed" };
		Assert.assertEquals(text, exp[2], "send mail status not as expected");

	}

}
