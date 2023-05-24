package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class SendingEmailTest extends BaseTest {

	@Test
	public void sendingEmailTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+sae02@sell.do", "amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
				"All Leads");

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Email Link.......");
		leadProfilePage.clickOnEmailLink();

		EmailPage emailPage = new EmailPage(driver);

		extentTest.get().log(Status.INFO, "Entering Subject of Email.......");
		emailPage.enterSubject("Subject for email Generated via Automation");

		extentTest.get().log(Status.INFO, "Entering text in email body......");
		emailPage.entertextInBody("Body Of Email "+random("Body Of Email","AN",1000));

		extentTest.get().log(Status.INFO, "Clicking on Send Email Button.......");
		emailPage.clickOnSendEmailButton();


		extentTest.get().log(Status.INFO, "Clicking on Email link under activities section.......");
		Assert.assertEquals(getSuccessMSG(), "Email sent successfully");
		leadProfilePage.clickEmail_d();
//

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboardPage.pageRefresh();

		extentTest.get().log(Status.INFO, "Fetching the text appeared after sending email....");
		String text =  leadProfilePage.getEmailStatus();


		extentTest.get().log(Status.INFO, "Verifying the text under Email activities....");
		String exp[] = {"outgoing  |  delivered","outgoing  |  -"};
		Assert.assertEquals(text, exp[1], "send mail status not as expected");

	}
}
