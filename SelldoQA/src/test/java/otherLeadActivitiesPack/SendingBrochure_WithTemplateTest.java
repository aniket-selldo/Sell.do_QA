package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.BrochurePage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import API.CreateLead_POST;

public class SendingBrochure_WithTemplateTest extends BaseTest {

	@Test

	public void sendingBrochure_WithTemplateTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+cc@sell.do", "amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.loginAsUser("AniketPreSale00");

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.serchLeadGlobally(CreateLead_POST.createLeadByAPI(APIKey, PreSalesUserID));

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		test.log(Status.INFO, "Clicking on Email Link.......");
		leadProfilePage.clickOnEmailLink();

		Thread.sleep(1000);

		EmailPage emailPage = new EmailPage(driver);

		extentTest.get().log(Status.INFO, "Select brochure from dropdown.......");
		emailPage.selectBrochureOption();
		
		extentTest.get().log(Status.INFO, "Select Any Product......");
		emailPage.selectAnyProduct();
		
		extentTest.get().log(Status.INFO, "Select Any Tamplete......");
		emailPage.selectAnyTamplete();

		BrochurePage brochurePage = new BrochurePage(driver);

		String subjectText = "Subject By Automation " + random("", "AN", 100);
		brochurePage.writingSubject(subjectText);
		Thread.sleep(2000);
		brochurePage.writingSomeTextInBody("Body By Automation " + random("", "AN", 100));

		test.log(Status.INFO, "Clicking on Send Brochure Button.......");
		brochurePage.clickOnSendBrochureButton();

		Thread.sleep(2000);

		test.log(Status.INFO, "Clicking on Email Link under Activities section.......");
		leadProfilePage.openEmailActivities();

		Thread.sleep(2000);

		test.log(Status.INFO, "Verifying that Brochure is sent.......");

		Assert.assertEquals(driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText(), subjectText, "Not matched");

	}

}
