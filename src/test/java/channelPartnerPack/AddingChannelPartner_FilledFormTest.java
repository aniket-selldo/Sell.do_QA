package channelPartnerPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.NewPartnerFormPage;
import com.selldo.POM.adminPages.PartnersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class AddingChannelPartner_FilledFormTest extends BaseTest {

	@Test
	public void addingChannelPartner_FilledFormTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		PartnersPage PartnersPage = new PartnersPage(driver);

		NewPartnerFormPage newPartnerFormPage = new NewPartnerFormPage(driver);

		settingsPage.clickOnPartnersTab();

		settingsPage.clickOnManagePartnersTab();

		PartnersPage.clickOnNewPartnerButton();

		String PartnerName = "MANDATORY_"+Random("A", 10).toUpperCase();
		newPartnerFormPage.enterPartnerName(PartnerName);

		newPartnerFormPage.selectDateOfJoining();

		newPartnerFormPage.enterSourceOfRecruitment("Online");

		newPartnerFormPage.clickOnContactDetailsTab();

		newPartnerFormPage.selectSalutation("Mrs.");

		newPartnerFormPage.enterFirstName(Random("A", 10));

		newPartnerFormPage.enterLastName(Random("A", 10));

		newPartnerFormPage.enterPhone(randomPhone());

		newPartnerFormPage.enterEmail(randomEmail());

		newPartnerFormPage.enterAlternatePhone(randomPhone());

		newPartnerFormPage.enterAlternateEmail(randomEmail());

		newPartnerFormPage.enterDesignation(Random("A", 10));

		newPartnerFormPage.enterPanNumber(randomPAN());
		
		newPartnerFormPage.enterAddress("Near Sell.do");
		
		newPartnerFormPage.enterStreet("Mumbai highWay");
		
		newPartnerFormPage.selectCountry("India");
		
		newPartnerFormPage.selectState("Maharashtra");
		
		newPartnerFormPage.entercity("Pune");
		
		newPartnerFormPage.enterZip("414002");

		newPartnerFormPage.clickOnSpecialization();

		newPartnerFormPage.selectChannelPartnerType();

		newPartnerFormPage.enterReraNumber();

		newPartnerFormPage.selectPropertyType();

		newPartnerFormPage.enterMinBudget(Random("N", 5));

		newPartnerFormPage.enterMaxBudget(Random("N", 10));

		newPartnerFormPage.clickOnSaveButton();

		String channelPartnerName = PartnerName;
		PartnersPage.searchPartner(channelPartnerName);

		String channelPartnerNameAfterSearch = driver
				.findElement(By.cssSelector("table tbody tr:nth-child(1) td:nth-child(1)")).getAttribute("innerHTML");
		System.out.println(channelPartnerNameAfterSearch);

		System.out.println("Started verification");
		Assert.assertEquals(channelPartnerName, channelPartnerNameAfterSearch, "Not matched");
		System.out.println("Completed verification");

	}
}
