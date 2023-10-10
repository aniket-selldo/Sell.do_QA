package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.EditLeadFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import API.APIs;

public class SearchingLeadByUserTest extends BaseTest {

	@Test
	public void searchingLeadByUserTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("PreSales_email"), prop("Password"));
		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		EditLeadFormPage editLeadFormPage = new EditLeadFormPage(driver);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		
		String leadID = "#" + new APIs().createLead(prop("PreSales_id")).getSell_do_lead_id();
		adminDashboardPage.searchLead(leadID);

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

		editLeadFormPage.clickOnSaveButton();

		salesPresalesDashboardPage.searchLead(leadId);

		// salesPresalesDashboardPage.openLeadDetails(0);
		Assert.assertEquals(leadProfilePage.getLeadId().replaceAll("[^a-zA-Z0-9]", " "),
				leadId.replaceAll("[^a-zA-Z0-9]", " "), "Not matched");

		salesPresalesDashboardPage.searchLead(leadPhoneNumber);

		Thread.sleep(2000);

//		try {
//			salesPresalesDashboardPage.openLeadDetails(0);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

		salesPresalesDashboardPage.searchLead(leadEmail);

//		try {
//			salesPresalesDashboardPage.openLeadDetails(0);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

		salesPresalesDashboardPage.searchLead(leadName);
		try {
			salesPresalesDashboardPage.openLeadDetails(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);

		Assert.assertEquals(leadProfilePage.getLeadName(), leadName, "Not matched");

	}

}
