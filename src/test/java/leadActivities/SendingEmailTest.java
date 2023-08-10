package leadActivities;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SendingEmailTest extends BaseTest {

	@Test
	public void sendingEmailTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		String leadID = "#" + new APIs().createLead(prop("Sales_id")).getSell_do_lead_id();
		salesPresalesDashboard.searchLead(leadID);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnEmailLink();

		EmailPage emailPage = new EmailPage(driver);

		emailPage.enterSubject("Subject for email Generated via Automation");

		emailPage.entertextInBody("Body Of Email " + Random("AN", 1000));

		emailPage.clickOnSendEmailButton();

		leadProfilePage.clickEmail_d();

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboardPage.pageRefresh();

		String text = leadProfilePage.getEmailStatus();

		String exp[] = { "outgoing  |  delivered", "outgoing  |  -", "outgoing  |  failed" };
		Assert.assertEquals(text, exp[2], "send mail status not as expected");

	}
}
