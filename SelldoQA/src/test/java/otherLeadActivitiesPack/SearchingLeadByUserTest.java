package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EditLeadFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class SearchingLeadByUserTest extends BaseTest {

	@Test
	public void searchingLeadByUserTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+cc@sell.do", "amura@123");
		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		EditLeadFormPage editLeadFormPage = new EditLeadFormPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		extentTest.get().log(Status.INFO, "Signing in as a user to fetch lead email, name, Id and phone number.......");
		adminDashboardPage.loginAsUser("AniketPreSale00");
		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		adminDashboardPage.searchLead(Integer.parseInt(R('0', '1', '2', '3', '4', '5', '6', '7')), "Incoming");

		extentTest.get().log(Status.INFO, "Clicking on Edit Icon to open lead edit form.......");
		leadProfilePage.clickOnEditIcon();

		String leadId = leadProfilePage.getLeadId();
		System.out.println(leadId);

		String leadName = driver.findElement(By.cssSelector("span[name='first_name']")).getAttribute("innerHTML")
				.trim();
		System.out.println(leadName);

		String leadEmail = driver.findElement(By.xpath("//input[@name='primary_email_email']"))
				.getAttribute("placeholder");
		System.out.println(leadEmail);

		String leadPhoneNumber = driver.findElement(By.xpath("//input[@name='primary_phone_ph_number']"))
				.getAttribute("placeholder");
		System.out.println(leadPhoneNumber);

		extentTest.get().log(Status.INFO, "Closing Lead edit form.......");
		editLeadFormPage.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		salesPresalesDashboardPage.searchLead(leadId);

		extentTest.get().log(Status.INFO, "Validating Lead Id......");
		// salesPresalesDashboardPage.openLeadDetails(0);
		Assert.assertEquals(leadProfilePage.getLeadId().replaceAll("[^a-zA-Z0-9]", " "),
				leadId.replaceAll("[^a-zA-Z0-9]", " "), "Not matched");

		extentTest.get().log(Status.INFO, "Searching lead by Phone number......");
		salesPresalesDashboardPage.searchLead(leadPhoneNumber);

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Validating Lead name......");
		try {
			salesPresalesDashboardPage.openLeadDetails(0);
		} catch (Exception e) {
			// TODO: handle exception
		}

		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

		extentTest.get().log(Status.INFO, "Searching lead by Email......");
		salesPresalesDashboardPage.searchLead(leadEmail);

		extentTest.get().log(Status.INFO, "Validating Lead name......");
		try {
			salesPresalesDashboardPage.openLeadDetails(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

		extentTest.get().log(Status.INFO, "Searching lead by name......");
		salesPresalesDashboardPage.searchLead(leadName);
		try {
			salesPresalesDashboardPage.openLeadDetails(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Validating Lead name......");
		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

	}

}
