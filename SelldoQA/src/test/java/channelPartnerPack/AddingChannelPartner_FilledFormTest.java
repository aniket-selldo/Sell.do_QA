package channelPartnerPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.NewPartnerFormPage;
import com.selldo.POM.adminPages.PartnersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingChannelPartner_FilledFormTest extends BaseTest {


	@Test
	public void addingChannelPartner_FilledFormTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("admin"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin("Aniket Automation");//prop.getProperty("Other_client_name")
		SettingsPage settingsPage = new SettingsPage(driver);

		PartnersPage PartnersPage = new PartnersPage(driver);

		NewPartnerFormPage newPartnerFormPage = new NewPartnerFormPage(driver);

		test.log(Status.INFO, "Clicking on Partners tab.......");
		settingsPage.clickOnPartnersTab();

		test.log(Status.INFO, "Clicking on Manage Partners tab.......");
		settingsPage.clickOnManagePartnersTab();

		test.log(Status.INFO, "Clicking on New Partner Tab.......");
		PartnersPage.clickOnNewPartnerButton();

		Thread.sleep(2000);

		test.log(Status.INFO, "Entering Channel Partner name.......");
		newPartnerFormPage
				.enterPartnerName(prop.getProperty("ChannelPartnerName_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Selecting date of joining from calender......");
		newPartnerFormPage.selectDateOfJoining();

		test.log(Status.INFO, "Entering Source of recruitment.......");
		newPartnerFormPage.enterSourceOfRecruitment(
				prop.getProperty("SourceOfRecruitment_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Clicking on Contact Details tab.......");
		newPartnerFormPage.clickOnContactDetailsTab();
		Thread.sleep(2000);

		test.log(Status.INFO, "Selecting Salutation from dropdown.......");
		newPartnerFormPage.selectSalutation();

		test.log(Status.INFO, "Entering First name of partner.......");
		newPartnerFormPage.enterFirstName(prop.getProperty("FirstName_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Last name of partner.......");
		newPartnerFormPage.enterLastName(prop.getProperty("LastName_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Phone number.......");
		newPartnerFormPage.enterPhone(" " + prop.getProperty("Phone_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Email.......");
		newPartnerFormPage.enterEmail(prop.getProperty("Email_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Alternate phone number.......");
		newPartnerFormPage
				.enterAlternatePhone(" " + prop.getProperty("AlternatePhone_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Alternate email.......");
		newPartnerFormPage
				.enterAlternateEmail(prop.getProperty("AlternateEmail_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Designation......");
		newPartnerFormPage.enterDesignation(prop.getProperty("Designation_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering PAN number.......");
		newPartnerFormPage.enterPanNumber(prop.getProperty("PanNumber_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Clicking on Specialization tab.......");
		newPartnerFormPage.clickOnSpecialization();

		Thread.sleep(2000);

		test.log(Status.INFO, "Selecting Channel Partner type......");
		newPartnerFormPage.selectChannelPartnerType();

		test.log(Status.INFO, "Entering Rera number.......");
		newPartnerFormPage.enterReraNumber();

		test.log(Status.INFO, "Selecting Property type.......");
		newPartnerFormPage.selectPropertyType();

		test.log(Status.INFO, "Entering Minimum Budget.......");
		newPartnerFormPage.enterMinBudget(prop.getProperty("MinBudget_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Entering Maximum Budget.......");
		newPartnerFormPage.enterMaxBudget(prop.getProperty("MaxBudget_addingChannelPartner_FilledFormTest"));

		test.log(Status.INFO, "Clicking on Save button.....");
		newPartnerFormPage.clickOnSaveButton();

		String channelPartnerName = prop.getProperty("ChannelPartnerName_addingChannelPartner_FilledFormTest");
		PartnersPage.searchPartner(channelPartnerName);

		test.log(Status.INFO, "Capturing Channel Partner name appeared at the top of the list......");
		String channelPartnerNameAfterSearch = driver
				.findElement(By.cssSelector("table tbody tr:nth-child(1) td:nth-child(1)")).getAttribute("innerHTML");
		System.out.println(channelPartnerNameAfterSearch);

		test.log(Status.INFO, "Validating Channel Partners name after adding new Partner.....");
		System.out.println("Started verification");
		Assert.assertEquals(channelPartnerName, channelPartnerNameAfterSearch, "Not matched");
		System.out.println("Completed verification");

	}
}
