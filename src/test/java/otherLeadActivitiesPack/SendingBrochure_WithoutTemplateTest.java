package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.BrochurePage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SendingBrochure_WithoutTemplateTest extends BaseTest {

	@Test
	public void sendingBrochure_WithoutTemplateTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email"), prop("Password"));

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		String leadID = "#" + new APIs().createLead(prop("PreSales_id")).getSell_do_lead_id();
		adminDashboardPage.searchLead(leadID);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.addEmail();
		leadProfilePage.clickOnEmailLink();

		Thread.sleep(2000);

		EmailPage emailPage = new EmailPage(driver);

		emailPage.selectBrochureOption();
		emailPage.selectAnyProduct();
		emailPage.selectAnyTamplete();

		BrochurePage brochurePage = new BrochurePage(driver);

		String subjectText = "Subject By Automation " + Random( "AN", 1);
		brochurePage.writingSubject(subjectText);

		brochurePage.writingSomeTextInBody("Body By Automation " + Random( "AN", 1));

		brochurePage.clickOnSendBrochureButton();

		//Thread.sleep(10000);

		leadProfilePage.openEmailActivities();

		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText(), subjectText, "Not matched");
		System.out.println("Completed verification");

	}
}
