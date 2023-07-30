import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.Utility.BaseTest;

import POM.clientCreationPage.PrepaidClientCreation;
import POM.clientCreationPage.createClientPage;
import myPom.loginPage;

public class CreateClinet extends BaseTest {
	
	@Test
	public void createPostpaidClient() {
		String ClientName = "Shyam_Sunder";
		String Email ="rajat.patil";
		createClientPage page = new createClientPage(driver);
		loginPage loginPage = new loginPage(driver);
		loginPage.login_suppoort();
		page.clickOnClientButton();
		page.enterFirstName(Random("A", 7));
		page.enterLastName(Random("A", 7));
		page.enterBuisnessName(ClientName);
		page.selectBuisnessType();
		page.shortName(Random("A", 6));
		page.enterClientWebsite(Random("AN", 7));
		page.enterclinetEmail(randomEmail(Email));
		page.uploadFile("nun");
		page.enterClientPhone(randomPhone());
		page.enterMask(Random("A", 6));
		page.selectIndustry(0);// 0) Real Estate 1) Education 2) BFSI 3) Generic
		page.enterAddres(Random("A", 6));
		page.enterCountry(1);
		page.enterState(1);
		page.enterCity("Pune");
		page.enterZip(414003);
		page.enterUserFirstName(ClientName);
		page.enterUserLasttName("user");
		page.enterUserPhone(randomPhone());
		page.enterEmail(randomEmail(Email));
		page.enterUserTeam(Random("A", 7));
		//page.selectVendores();
		String respone = page.clickOnsave();
		Assert.assertEquals(respone, "", "Success massage not as expected");
	}
	//@Test
	public void createPrepaidClient() throws InterruptedException {
		String BuisnessName="26july2023_PrePaid";
		String Email ="aniket.khandizod";
		driver.get(prop.getProperty("URL")+"/signup?plan=selection");
		PrepaidClientCreation page = new PrepaidClientCreation(driver);
		page.enterClientFirstName(Random("A",10));
		page.enterClientLastName(Random("A",10));
		page.enterPassword("amura@123");
		page.enterClientEmail(randomEmail(Email));
		page.enterClientPhone(randomPhone());
		page.enterBuisnessName(BuisnessName);
		String buisnessType[]= {"Developer","Broker"};
		page.selectBuisnessType(buisnessType[0]);
		String industryType[]= {"Real Estate","Education","BFSI","Generic"};
		page.selectIndustryType(industryType[0]);
		page.enterClientWebSite(Random("A",10));
		//page.selectPlan("Default Custom");
		page.clickOnAreYouBroker(false);
		page.switchToCapta();
		page.clickOnSignUp();
		page.user_first_name(Random("A",10));
		page.user_last_name(Random("A",10));
		page.user_email(randomEmail(Email));
		page.user_phone(randomPhone());
		page.clickOnSaveAndContinue();
		page.client_address_address1("Pune");
		page.client_address_address2("Baner High Street");
		page.selectClient_address_country();
		page.selectClient_country_state();
		page.client_address_city("Pune");
		page.client_address_zip(414003);
		page.promotional_sms_mask(Random("A",6));
		page.transactional_sms_mask(Random("A",6));
		page.client_image("nun");
		page.clickOnSaveAndContinue();
		page.clickOnContinue();
		Assert.assertTrue(page.validateClientName(BuisnessName));
		Thread.sleep(10000);
		driver.get(prop.getProperty("LogOut"));
	}
}
