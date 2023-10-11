package userManagementPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.CreateClientFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class CreatingClient_UnfilledformTest extends BaseTest {

	@Test
	public void creatingClient_UnfilledformTest() {
		LoginPage login = new LoginPage(driver);
		login.loginAsSuperAdmin_SM(prop("SM"), prop("Password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clickOnCreateClientButton();

		CreateClientFormPage createClientForm = new CreateClientFormPage(driver);

		createClientForm.clickOnSaveButonWithoutWait();

		createClientForm.getAllReuireFieldMessage();
		createClientForm.getAllReuirefiledName();

		Assert.assertTrue(createClientForm.requireFiledValidationBySize());

		Assert.assertTrue(createClientForm.reqFiledValidationByName());
	}

	public void creatingClient_UnfilledformTest_DEPRICATED() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("SM"), prop("Password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		// clientLogin.clientLogin(prop.getProperty("client_name"));

		clientLogin.clickOnCreateClientButton();

		CreateClientFormPage createClientForm = new CreateClientFormPage(driver);

		createClientForm.clickOnSaveButonWithoutWait();

		Thread.sleep(2000);

		Assert.assertEquals(createClientForm.getBusinessNameRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getShortNameRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getWebsiteFieldRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getEmailFieldRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getEmailDomainRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getUploadLogoRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getClientPhoneRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getAddressFieldRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getCityFieldRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getStateDropdownRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getCountryDropdownRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getZipFieldRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getFirstNameRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getLastNameRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getUserEmailRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getTeamFieldRequiredMessage(), "This field is required.", "Not matched");

		Assert.assertEquals(createClientForm.getMarketingDomainRequiredMessage(), "This field is required.",
				"Not matched");

		Assert.assertEquals(createClientForm.getDomainMessage(),
				"Domains will be selected from promotional email vendor.", "Not matched");

	}

}
