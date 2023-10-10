package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.QuotesPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SendingQuotes_WithoutTemplateTest extends BaseTest {

	@Test
	public void sendingQuotes_WithoutTemplateTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		String leadID = "#" + new APIs().createLead(prop("PreSales_id")).getSell_do_lead_id();

		adminDashboardPage.serchLeadGlobally(leadID);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		// leadProfilePage.addEmail();

		leadProfilePage.clickOnEmailLink();

		Thread.sleep(2000);

		EmailPage emailPage = new EmailPage(driver);

		emailPage.selectPriceQuoteOption();

		emailPage.selectAnyProduct();
		emailPage.selectAnyTamplete();
		QuotesPage quotesPage = new QuotesPage(driver);

		String subjectText = "Subject By Automation " + Random( "AN", 1000);
		quotesPage.writingSubject(subjectText);

		quotesPage.writingSomeTextInBody(Random("AN",100));

		quotesPage.clickOnSendPriceQuoteButton();

		Thread.sleep(2000);

		leadProfilePage.openEmailActivities();

		SoftAssert assertion = new SoftAssert();
		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.cssSelector(
				"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText(), subjectText, "Not matched");
		assertion.assertAll();

	}

}
