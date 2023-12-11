package channelPartnerPack;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.EditPartnerFormPage;
import com.selldo.POM.adminPages.PartnersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;

public class EditingChannelPartnerTest extends BaseTest {

	@Test
	public void editingChannelPartnerTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		SettingsPage settingsPage = new SettingsPage(driver);

		PartnersPage PartnersPage = new PartnersPage(driver);

		EditPartnerFormPage editPartnerFormPage = new EditPartnerFormPage(driver);

		settingsPage.clickOnPartnersTab();

		settingsPage.clickOnManagePartnersTab();

		PartnersPage.selectEdit();

		Thread.sleep(2000);

		editPartnerFormPage.changePartnerName(Random("A",10)+"_Chnaged");

		editPartnerFormPage.selectDateOfJoining();

		editPartnerFormPage
				.changeSourceOfRecruitment("Online");

		editPartnerFormPage.clickOnContactDetailsTab();

		editPartnerFormPage.selectSalutation("mr.");

		editPartnerFormPage.changeFirstName(Random("A",10));

		editPartnerFormPage.changeLastName(Random("A",10));

		editPartnerFormPage.changePhone(randomPhone());

		editPartnerFormPage.changeEmail(randomEmail());

		editPartnerFormPage.changeAlternatePhone(randomPhone());

		editPartnerFormPage.changeAlternateEmail(randomEmail());

		editPartnerFormPage.changeDesignation(Random("A",10));

		editPartnerFormPage.changePanNumber(randomPAN());

		editPartnerFormPage.clickOnSpecialization();

		Thread.sleep(2000);

		editPartnerFormPage.changeChannelPartnerType();

		editPartnerFormPage.changeReraNumber();

		//editPartnerFormPage.changePropertyType();

		editPartnerFormPage.changeMinBudget(Random("N",5));

		editPartnerFormPage.changeMaxBudget(Random("N",10));

		editPartnerFormPage.clickOnSaveButton();

		String channelPartnerNameAfterSearch = driver
				.findElement(By.xpath("//th[text()='Channel Partner']/following::td[1]")).getAttribute("innerHTML");
		System.out.println(channelPartnerNameAfterSearch);
	}

}
