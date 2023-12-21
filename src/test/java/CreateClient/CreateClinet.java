package CreateClient;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.selldo.Utility.BaseTest;

import POM.clientCreationPage.PrepaidClientCreation;
import POM.clientCreationPage.createClientPage;
import myPom.loginPage;

public class CreateClinet extends BaseTest {
	

	@Test
	public void createPostpaidClient() {
		String ClientName = "Sagar BOAT";
		Faker faker = new Faker();
		createClientPage page = new createClientPage(driver);
		loginPage loginPage = new loginPage(driver);
		loginPage.login_suppoort();
		page.clickOnClientButton();
		page.enterFirstName(faker.firstName());
		page.enterLastName(faker.lastName());
		page.enterBuisnessName(ClientName);
		page.selectBuisnessType();
		page.shortName(Random("A", 6));
		page.enterClientWebsite(Random("AN", 7));
		page.enterclinetEmail(randomEmail());
		page.enterSalesPersonName(faker.firstName());
		page.enterOnboardingPersonName(faker.firstName());
		page.uploadFile("nun");
		page.enterClientPhone(randomPhone());
		page.enterMask(Random("A", 6));
		page.selectIndustry(0);// 0) Real Estate 1) Education 2) BFSI 3) Generic
		page.enterAddres(faker.streetAddress(true));
		page.enterCountry(1);
		page.enterState(1);
		page.enterCity(faker.country());
		page.enterZip(414003);
		page.enterUserFirstName("Sales");
		page.enterUserLasttName("User");
		page.enterUserPhone(randomPhone());
		page.enterEmail(randomEmail());
		page.enterUserTeam("DeafultTeam");
		// page.selectVendores();
		String respone = page.clickOnsave();
		Assert.assertEquals(respone, "", "Success massage not as expected");
	}

	@Test
	public void createPrepaidClient() throws InterruptedException {
		String date = getDate(0,"D").trim();
		String month = getDate(0,"M2").trim();
		//String BuisnessName = date+month+"_Prepiad_02";
		String BuisnessName = "Sagar001";
		Faker faker = new Faker();
		driver.get(prop("URL") + "/signup?plan=selection");
		PrepaidClientCreation page = new PrepaidClientCreation(driver);
		page.enterClientFirstName("Admin");
		page.enterClientLastName("User");
		page.enterPassword("selldo@321");
		page.enterClientEmail(randomEmail());
		page.enterClientPhone(randomPhone());
		page.enterBuisnessName(BuisnessName);
		String buisnessType[] = { "Developer", "Broker" };
		page.selectBuisnessType(buisnessType[0]);
		String industryType[] = { "Real Estate", "Education", "BFSI", "Generic" };
		page.selectIndustryType(industryType[0]);
		page.enterClientWebSite(Random("A", 10));
		page.enterSalesPersonName(faker.firstName());
		page.enterOnboardingPersonName(faker.firstName());
		// page.selectPlan("Default Custom");
		page.clickOnAreYouBroker(false);
		page.switchToCapta();
		page.clickOnSignUp();
		page.user_first_name("Sales");
		page.user_last_name("User");
		page.user_email(randomEmail());
		page.user_phone(randomPhone());
		page.clickOnSaveAndContinue();
		page.client_address_address1(faker.streetAddress(false));
		page.client_address_address2(faker.streetAddress(true));
		page.selectClient_address_country();
		page.selectClient_country_state();
		page.client_address_city("Pune");
		page.client_address_zip(414003);
		page.promotional_sms_mask(Random("A", 6));
		page.transactional_sms_mask(Random("A", 6));
		page.client_image("nun");
		page.clickOnSaveAndContinue();
		page.clickOnContinue();
		Assert.assertTrue(page.validateClientName(BuisnessName));
		Thread.sleep(10000);
		driver.get(prop("Logout"));
	}
}
