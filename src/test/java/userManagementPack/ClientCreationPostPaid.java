package userManagementPack;

import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.CreateClientFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class ClientCreationPostPaid extends BaseTest {

	@Test
	public void creatingClientfromSupport() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.loginAsSuperAdmin_SM(prop("Aniket_SM"), prop("Aniket_SM_PSWD"));
	//	login.login(prop("Amura_Admin"), prop("Password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		AdminDashboardPage AdminDashboardPage = new AdminDashboardPage(driver);
		AdminDashboardPage.logOutFromSM();
		
		clientLogin.clickOnCreateClientButton();

		CreateClientFormPage createClientForm = new CreateClientFormPage(driver);

		GetTestData getTestData = new GetTestData();

		createClientForm.enterClientFirstName();

		createClientForm.enterClientLastName();

		createClientForm.enterClientPhoneNumber();

		String businessName = getTestData.location.replaceAll("\\s+", "")+Random("AN",10);
		createClientForm.enterBusinessName(businessName);

		createClientForm.enterShortName("sky");

		createClientForm.enterSMSmask(Random("AN", 6));

		createClientForm.selectBuisnessType();

		createClientForm.enterClientWebsite(businessName);

		createClientForm.enterClientEmail();

		createClientForm.uploadFile();

		// createClientForm.addClientPhoneNumber();
		createClientForm.enterAddress_NM(Random("AN", 10), Random("AN", 10), Random("AN", 10), "India",
				Random("N", 6));

		createClientForm.enterFirstName();

		createClientForm.enterLastName();

		createClientForm.enterUserPhoneNumber();

		createClientForm.enterUserEmail();

		createClientForm.enterUsersTeam();

		createClientForm.clickOnSaveButton();

		clientLogin.clientLogin(businessName);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.verifyingClientLogin();

		clientLogin.logout();

	}
}
