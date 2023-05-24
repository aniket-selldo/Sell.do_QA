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

public class SendSmsTest extends BaseTest {

	@Test

	public void sendingSmsTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+user033@sell.do", "amura@123");

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('0','1', '2', '3', '4', '5', '6', '7', '8', '9')), "All Leads");
		leadProfilePage.addPhoneNumber();

		extentTest.get().log(Status.INFO, "Clicking on Sms Link.......");
		leadProfilePage.clickOnSmsLink();
		


		SmsPage smsPage = new SmsPage(driver);

		extentTest.get().log(Status.INFO, "Selecting SMS template from dropdown.......");
		smsPage.selectSmsTemplate("Test");//prop.getProperty("sms_template")
		

		extentTest.get().log(Status.INFO, "Clicking on Send SMS Button.......");
		smsPage.clickOnSendSmsButton();
		Assert.assertEquals(getSuccessMSG(), "SMS sent successfully", "SMS not sended succesfully");


		extentTest.get().log(Status.INFO, "Clicking on SMS link under activities section.......");
		leadProfilePage.clickSms_d();


		extentTest.get().log(Status.INFO, "Fetching the text appeared after sending email....");
		String text =leadProfilePage.getEmailStatus();


		extentTest.get().log(Status.INFO, "Verifying the text under Email activities....");
		Assert.assertEquals(text, "Outgoing Success","Fail outgoing SMS"); //Outgoing Error

	}

}
