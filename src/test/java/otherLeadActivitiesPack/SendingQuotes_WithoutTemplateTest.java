package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EmailPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.QuotesPage;
import com.selldo.Utility.BaseTest;

import API.CreateLead_POST;

public class SendingQuotes_WithoutTemplateTest extends BaseTest {

	@Test
	public void sendingQuotes_WithoutTemplateTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+cc@sell.do", "amura@123");
    	AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.loginAsUser("AniketPreSale00");

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		//adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7')), "Incoming");
		adminDashboardPage.serchLeadGlobally(CreateLead_POST.createLeadByAPI(APIKey, PreSalesUserID));

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		//leadProfilePage.addEmail();

		extentTest.get().log(Status.INFO, "Clicking on Email Link.......");
		leadProfilePage.clickOnEmailLink();
		
		Thread.sleep(2000);
		
		EmailPage emailPage = new EmailPage(driver);
		
		extentTest.get().log(Status.INFO, "Select Quotes from dropdown.......");
		emailPage.selectPriceQuoteOption();

		extentTest.get().log(Status.INFO, "Select Any Product......");
		emailPage.selectAnyProduct();
		emailPage.selectAnyTamplete();
		QuotesPage quotesPage = new QuotesPage(driver);


		extentTest.get().log(Status.INFO, "Writing Subject.......");
		String subjectText = "Subject By Automation " + random("", "AN", 1000);
		quotesPage.writingSubject(subjectText);

		extentTest.get().log(Status.INFO, "Writing some text in body.......");
		quotesPage.writingSomeTextInBody(prop.getProperty("email_sendingQuotes_WithoutTemplateTest"));

		extentTest.get().log(Status.INFO, "Clicking on Send Quote Button.......");
		quotesPage.clickOnSendPriceQuoteButton();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Clicking on Email Link under activities section.......");
		leadProfilePage.openEmailActivities();

		extentTest.get().log(Status.INFO, "Verifying that Quote is sent.......");

		SoftAssert assertion = new SoftAssert();
		System.out.println("Started verification");
		Assert.assertEquals(driver
				.findElement(By.cssSelector(
						"#tab-activity > div.activities_list > div:nth-child(1) > div > div.card > div > div:nth-child(1) > div.col-lg-11 > span"))
				.getText(),"TEst", "Not matched");
		System.out.println("Completed verification");
		assertion.assertAll();

	}

}
