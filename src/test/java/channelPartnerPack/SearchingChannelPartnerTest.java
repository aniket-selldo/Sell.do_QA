package channelPartnerPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.EditPartnerFormPage;
import com.selldo.POM.adminPages.PartnersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class SearchingChannelPartnerTest extends BaseTest {

	@Test
	public void searchingChannelPartnerTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		PartnersPage PartnersPage = new PartnersPage(driver);

		EditPartnerFormPage editPartnerFormPage = new EditPartnerFormPage(driver);

		settingsPage.clickOnPartnersTab();

		settingsPage.clickOnManagePartnersTab();

		String partnerNameToBeSearched = driver.findElement(By.cssSelector("table > tbody > tr > td:nth-child(1)"))
				.getAttribute("innerHTML");
		System.out.println("Channel Partner Before Search-" + partnerNameToBeSearched);

		PartnersPage.searchPartner(partnerNameToBeSearched);

		String partnerNameAfterSearch = driver.findElement(By.xpath("//th[text()='Channel Partner']/following::td[1]"))
				.getAttribute("innerHTML");
		System.out.println("Channel Partner After Search-" + partnerNameAfterSearch);

		System.out.println("Started verification");
		Assert.assertEquals(partnerNameToBeSearched, partnerNameAfterSearch, "Not matched");
		System.out.println("Completed verification");
		Thread.sleep(2000);

		PartnersPage.selectEdit();
		Thread.sleep(2000);
		editPartnerFormPage.clickOnContactDetailsTab();
		String partnerEmailToBeSearched = driver
				.findElement(By.xpath("//label[@for='channel_partner_contact_email']/following::input[1]"))
				.getAttribute("value");
		System.out.println("Channel Partner Email Before Search-" + partnerEmailToBeSearched);

		String partnerPhoneNoToBeSearched = driver
				.findElement(By.xpath("//label[@for='channel_partner_contact_phone']/following::input[1]"))
				.getAttribute("value").replaceAll("\\s+", "").substring(3);
		System.out.println("Channel Partner Phone Before Search-" + partnerPhoneNoToBeSearched);

		editPartnerFormPage.closeForm();

		PartnersPage.searchPartner(partnerEmailToBeSearched);

		System.out.println("Started verification");
		Assert.assertEquals(partnerNameToBeSearched, partnerNameAfterSearch, "Not matched");
		System.out.println("Completed verification");

		PartnersPage.searchPartner(partnerPhoneNoToBeSearched);

		System.out.println("Started verification");
		Assert.assertEquals(partnerNameToBeSearched, partnerNameAfterSearch, "Not matched");
		System.out.println("Completed verification");

	}
}
