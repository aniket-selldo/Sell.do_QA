package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EditLeadFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class SearchingLeadByAdminTest extends BaseTest {

	@Test
	public void searchingLeadByAdminTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+cc@sell.do", "amura@123");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		EditLeadFormPage editLeadFormPage = new EditLeadFormPage(driver);

		extentTest.get().log(Status.INFO, "Signing in as a user to fetch lead email, name, Id and phone number.......");
		adminDashboardPage.loginAsUser("AniketPreSale00");

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(prop.getProperty("lead_id_to_Search"));

		extentTest.get().log(Status.INFO, "Clicking on Edit Icon to open lead edit form.......");
		leadProfilePage.clickOnEditIcon();

		String leadId = leadProfilePage.getLeadId();;
		System.out.println(leadId);

		String leadName = driver.findElement(By.xpath("//span[@name='first_name']")).getAttribute("innerHTML").trim();
		System.out.println(leadName);

		String leadEmail = driver.findElement(By.xpath("//input[@name='primary_email_email']"))
				.getAttribute("placeholder");
		System.out.println(leadEmail);

		String leadPhoneNumber = driver.findElement(By.xpath("//input[@name='primary_phone_ph_number']"))
				.getAttribute("placeholder");
		System.out.println(leadPhoneNumber);

		extentTest.get().log(Status.INFO, "Closing Lead edit form.......");
		editLeadFormPage.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(leadId);


		extentTest.get().log(Status.INFO, "Validating Lead Id......");
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//span[@name='lead_id']")).getAttribute("innerHTML")
				.replaceAll("\\s+", ""), leadId, "Not matched");

		extentTest.get().log(Status.INFO, "Searching lead by Phone number......");
		adminDashboardPage.searchLead(leadPhoneNumber);

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Validating Lead name......");
		AssertJUnit.assertEquals(driver.findElement(By.cssSelector("a.td-bold.goto_details")).getAttribute("innerHTML"),
				leadName, "Not matched");

		extentTest.get().log(Status.INFO, "Searching lead by Email......");
		adminDashboardPage.searchLead(leadEmail);

		extentTest.get().log(Status.INFO, "Validating Lead name......");
		AssertJUnit.assertEquals(driver.findElement(By.cssSelector("a.td-bold.goto_details")).getAttribute("innerHTML"),
				leadName, "Not matched");

		extentTest.get().log(Status.INFO, "Searching lead by name......");
		adminDashboardPage.searchLead(leadName);

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Validating Lead name......");
		Assert.assertEquals(driver.findElement(By.cssSelector("a.td-bold.goto_details")).getAttribute("innerHTML"),
				leadName, "Not matched");

		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
		salesPresalesDashboardPage.openLeadDetails(1);

		extentTest.get().log(Status.INFO, "Validating text which says admin have no access to edit.....");
		Assert.assertEquals(leadProfilePage.noAccessMessageText(),
				"You do not have access to make any changes to this lead.", "Not matched");

	}
}
