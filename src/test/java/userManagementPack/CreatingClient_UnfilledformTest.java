package userManagementPack;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.CreateClientFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class CreatingClient_UnfilledformTest extends BaseTest {

	@Test
	public void creatingClient_UnfilledformTest() {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("support_manager_email"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		extentTest.get().log(Status.INFO, "Entering Business Name.......");
		clientLogin.clickOnCreateClientButton();

		CreateClientFormPage createClientForm = new CreateClientFormPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Save Button......");
		createClientForm.clickOnSaveButonWithoutWait();

		createClientForm.getAllReuireFieldMessage();
		createClientForm.getAllReuirefiledName();
		
		extentTest.get().log(Status.INFO, "Compare via size");
		Assert.assertTrue(createClientForm.requireFiledValidationBySize());
		
		extentTest.get().log(Status.INFO, "Compare via name");
		Assert.assertTrue(createClientForm.reqFiledValidationByName());
	}

	public void creatingClient_UnfilledformTest_DEPRICATED() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("support_manager_email"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		// clientLogin.clientLogin(prop.getProperty("client_name"));

		extentTest.get().log(Status.INFO, "Entering Business Name.......");
		clientLogin.clickOnCreateClientButton();

		CreateClientFormPage createClientForm = new CreateClientFormPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Save Button......");
		createClientForm.clickOnSaveButonWithoutWait();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Verifying error message below Business Name Field.......");
		Assert.assertEquals(createClientForm.getBusinessNameRequiredMessage(), "This field is required.",
				"Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Short name Field.......");
		Assert.assertEquals(createClientForm.getShortNameRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Website Field.......");
		Assert.assertEquals(createClientForm.getWebsiteFieldRequiredMessage(), "This field is required.",
				"Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Email Field.......");
		Assert.assertEquals(createClientForm.getEmailFieldRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Email Domain Field.......");
		Assert.assertEquals(createClientForm.getEmailDomainRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Upload Logo......");
		Assert.assertEquals(createClientForm.getUploadLogoRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Client Phone Field.......");
		Assert.assertEquals(createClientForm.getClientPhoneRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Address Field.......");
		Assert.assertEquals(createClientForm.getAddressFieldRequiredMessage(), "This field is required.",
				"Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below City Field.......");
		Assert.assertEquals(createClientForm.getCityFieldRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below State dropdown.......");
		Assert.assertEquals(createClientForm.getStateDropdownRequiredMessage(), "This field is required.",
				"Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Country dropdown.......");
		Assert.assertEquals(createClientForm.getCountryDropdownRequiredMessage(), "This field is required.",
				"Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Zip Field.......");
		Assert.assertEquals(createClientForm.getZipFieldRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below First name Field.......");
		Assert.assertEquals(createClientForm.getFirstNameRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Last name Field.......");
		Assert.assertEquals(createClientForm.getLastNameRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below User Email Field.......");
		Assert.assertEquals(createClientForm.getUserEmailRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Team Field.......");
		Assert.assertEquals(createClientForm.getTeamFieldRequiredMessage(), "This field is required.", "Not matched");

		extentTest.get().log(Status.INFO, "Verifying error message below Marketing Domain Field.......");
		Assert.assertEquals(createClientForm.getMarketingDomainRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getDomainMessage(),
				"Domains will be selected from promotional email vendor.", "Not matched");

	}

}
