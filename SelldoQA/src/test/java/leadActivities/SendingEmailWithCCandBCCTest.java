package leadActivities;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class SendingEmailWithCCandBCCTest extends BaseTest {

	@Test
	public void sendingEmailWithCCandBCCTest() throws Exception {

//		login.login(
//		prop.getProperty("nameAA") + "+" + prop.getProperty("user_email_sendingEmailWithCCandBCCTest"),prop.getProperty("password"));
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+sae02@sell.do", "amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		//extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')),
				"All Leads");
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		//extentTest.get().log(Status.INFO, "Clicking on Email Link.......");
		leadProfilePage.clickOnEmailLink();

		EmailPage emailPage = new EmailPage(driver);

		//extentTest.get().log(Status.INFO, "Entering Email for CC.......");
		emailPage.enterCCEmail("aniket.khandizod+CC@sell.do");

		//extentTest.get().log(Status.INFO, "Entering Email for BCC.......");
		emailPage.enterBCCEmail("aniket.khandizod+BCC@sell.do");

		//extentTest.get().log(Status.INFO, "Entering Subject of Email.......");
		emailPage.enterSubject("Email Subject generated via Automation");

		//extentTest.get().log(Status.INFO, "Entering text in email body......");
		emailPage.entertextInBody("Body Of Email "+random("Body Of Email","AN",1000));

		//extentTest.get().log(Status.INFO, "Clicking on Send Email Button.......");
		emailPage.clickOnSendEmailButton();
		Assert.assertEquals(getSuccessMSG(), "Email sent successfully", "email not sended succesfully");

		Thread.sleep(500);

		//extentTest.get().log(Status.INFO, "Clicking on Email link under activities section.......");
		leadProfilePage.clickEmail_d();

		Thread.sleep(500);

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboardPage.pageRefresh();

		//extentTest.get().log(Status.INFO, "Fetching the text appeared after sending email....");
		String text =leadProfilePage.getEmailStatus();

		//extentTest.get().log(Status.INFO, "Verifying the text under Email activities....");
		String exp[] = {"outgoing  |  delivered","outgoing  |  -"};
		Assert.assertEquals(text, exp[1], "send mail status not as expected");

	}

}
