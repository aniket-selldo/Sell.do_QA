package channelPartnerPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.NewPartnerFormPage;
import com.selldo.POM.adminPages.PartnersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingChannelPartner_MandatoryFillTest extends BaseTest {

	@Test

	public void addingChannelPartner_MandatoryFillTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("pswd"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		SettingsPage settingsPage = new SettingsPage(driver);

		PartnersPage PartnersPage = new PartnersPage(driver);

		NewPartnerFormPage newPartnerFormPage = new NewPartnerFormPage(driver);

		settingsPage.clickOnPartnersTab();

		settingsPage.clickOnManagePartnersTab();

		PartnersPage.clickOnNewPartnerButton();

		String CPName =("NonMandatory_"+ Random("A", 10)).toUpperCase();

		newPartnerFormPage.enterPartnerName(CPName);

		newPartnerFormPage.clickOnContactDetailsTab();

		newPartnerFormPage.selectSalutation("Mr.");

		newPartnerFormPage.enterFirstName(Random("A", 10));

		newPartnerFormPage.enterLastName(Random("A", 10));

		newPartnerFormPage.enterPhone(randomPhone());

		newPartnerFormPage.enterEmail(randomEmail());

		newPartnerFormPage.enterAddress("Near Sell.do");

		newPartnerFormPage.enterStreet("Mumbai highWay");

		newPartnerFormPage.selectCountry("India");

		newPartnerFormPage.selectState("Maharashtra");

		newPartnerFormPage.entercity("Pune");

		newPartnerFormPage.enterZip("414002");

		newPartnerFormPage.clickOnSaveButton();

		String channelPartnerNameAfterSearch =PartnersPage.searchPartner(CPName);

		Assert.assertEquals(CPName, channelPartnerNameAfterSearch, "Not matched");

	}

}
