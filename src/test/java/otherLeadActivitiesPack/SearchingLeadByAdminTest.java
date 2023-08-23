package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EditLeadFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SearchingLeadByAdminTest extends BaseTest {

	@Test
	public void searchingLeadByAdminTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Clinet_Email"), prop("Password"));
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		EditLeadFormPage editLeadFormPage = new EditLeadFormPage(driver);

		adminDashboardPage.loginAsUser(prop("PreSales_Name"));

		String leadID = "#" + new APIs().createLead(prop("PreSales_id")).getSell_do_lead_id();
		adminDashboardPage.searchLead(leadID);

		String leadId = leadProfilePage.getLeadId();
		System.out.println(leadId);

		leadProfilePage.clickOnEditIcon();

		String leadName = driver.findElement(By.xpath("//span[@name='first_name']")).getAttribute("innerHTML").trim();
		System.out.println(leadName);

		String leadEmail = driver.findElement(By.xpath("//input[@name='primary_email_email']"))
				.getAttribute("placeholder");
		System.out.println(leadEmail);

		String leadPhoneNumber = driver.findElement(By.xpath("//input[@name='primary_phone_ph_number']"))
				.getAttribute("placeholder");
		System.out.println(leadPhoneNumber);

		editLeadFormPage.clickOnSaveButton();

		leadProfilePage.backToAdmin();

		adminDashboardPage.serchLeadGlobally(leadId);

		Assert.assertEquals(leadProfilePage.getLeadID(), leadId, "Not matched");

		adminDashboardPage.serchLeadGlobally(leadPhoneNumber);

		Thread.sleep(2000);
		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

		adminDashboardPage.serchLeadGlobally(leadEmail);

		//salesPresalesDashboardPage.openLeadDetails(0);
		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

		adminDashboardPage.serchLeadGlobally(leadId);

		Thread.sleep(2000);

		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

//		extentTest.get().log(Status.INFO, "Opening Lead Deatils Page.......");
//		salesPresalesDashboardPage.openLeadDetails(0);

		Assert.assertEquals(leadProfilePage.noAccessMessageText(),
				"You do not have access to make any changes to this lead.", "Not matched");

	}
}
