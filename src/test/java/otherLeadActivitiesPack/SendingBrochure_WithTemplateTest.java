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

public class SendingBrochure_WithTemplateTest extends BaseTest {

	@Test
	public void sendingBrochure_WithTemplateTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		String leadID = "#" + new APIs().createLead(prop("PreSales_id")).getSell_do_lead_id();
		adminDashboardPage.serchLeadGlobally(leadID);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.clickOnEmailLink();

		Thread.sleep(1000);

		EmailPage emailPage = new EmailPage(driver);

		emailPage.selectBrochureOption();

		emailPage.selectAnyProduct();

		emailPage.selectAnyTamplete();

		BrochurePage brochurePage = new BrochurePage(driver);

		String subjectText = "Subject By Automation " + Random("AN", 100);
		brochurePage.writingSubject(subjectText);
		Thread.sleep(2000);
		brochurePage.writingSomeTextInBody("Body By Automation " + Random("AN", 100));

		brochurePage.clickOnSendBrochureButton();

		Thread.sleep(2000);

		leadProfilePage.openEmailActivities();

		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText(), subjectText, "Not matched");

	}

}
