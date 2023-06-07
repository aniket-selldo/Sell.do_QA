package userManagementPack;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.CreateClientFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class ClientCreationPostPaid extends BaseTest {
	/*
	 * final static Logger logger = Logger.getLogger(ClientCreationPostPaid.class);
	 * 
	 * // Description: Creating a new Post paid client from Post Sales
	 * 
	 * @BeforeTest
	 * 
	 * public void adminLogin() throws Exception {
	 * 
	 * mysetUp();
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * LoginPage login = new LoginPage(driver);
	 * 
	 * logger.info("Logging in to client page.......");
	 * 
	 * Properties property = new Properties(); FileInputStream fileInputObj = new
	 * FileInputStream( System.getProperty("user.dir") +
	 * "//src//main//java//Config File//global.properties");
	 * property.load(fileInputObj);
	 * 
	 * login.login(property.getProperty("support_manager_email"),
	 * property.getProperty("password")); }
	 * 
	 * @AfterTest
	 * 
	 * public void endingTest() throws Exception {
	 * 
	 * logger.info("Closing Browser......"); driver.close(); }
	 */
	@Test
	public void creatingClientfromSupport() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("support_manager_email"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

//		clientLogin.clientLogin(prop.getProperty("client_name"));
//
//		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		if (!driver.findElements(By.cssSelector("#main-menu-support-dashboard > a > i")).isEmpty()) {

			extentTest.get().log(Status.INFO, "Logout and again login.......");
			clientLogin.logout();

		}

		extentTest.get().log(Status.INFO, "Clicking on Create client button.......");
		clientLogin.clickOnCreateClientButton();

		CreateClientFormPage createClientForm = new CreateClientFormPage(driver);

		GetTestData getTestData = new GetTestData();

		extentTest.get().log(Status.INFO, "Entering Clients First Name.......");
		createClientForm.enterClientFirstName();

		extentTest.get().log(Status.INFO, "Entering Clients Last Name.......");
		createClientForm.enterClientLastName();

		extentTest.get().log(Status.INFO, "Entering Clients Phone Number.......");
		createClientForm.enterClientPhoneNumber();

		String businessName = getTestData.location.replaceAll("\\s+", "");
		extentTest.get().log(Status.INFO, "Entering Business Name as " + businessName + ".......");
		createClientForm.enterBusinessName(businessName);

		extentTest.get().log(Status.INFO, "Entering Short Name.......");
		createClientForm.enterShortName("sky");

		extentTest.get().log(Status.INFO, "Entering Client website.......");
		createClientForm.enterClientWebsite(businessName);

		extentTest.get().log(Status.INFO, "Entering Client Email.......");
		createClientForm.enterClientEmail();

		extentTest.get().log(Status.INFO, "Uploading image for Client Logo.......");
		createClientForm.uploadFile();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Entering Client Phone Number.......");
		createClientForm.addClientPhoneNumber();

		extentTest.get().log(Status.INFO, "Entering Client Address.......");
		createClientForm.enterAddress_NM(prop.getProperty("Address_creatingAClient_FullyFilledFormTest"),
				prop.getProperty("Street_creatingAClient_FullyFilledFormTest"),
				prop.getProperty("City_creatingAClient_FullyFilledFormTest"),
				prop.getProperty("Country_creatingAClient_FullyFilledFormTest"),
				prop.getProperty("Zip_creatingAClient_FullyFilledFormTest"));

		extentTest.get().log(Status.INFO, "Entering Users First Name.......");
		createClientForm.enterFirstName();

		extentTest.get().log(Status.INFO, "Entering Users Last Name.......");
		createClientForm.enterLastName();

		extentTest.get().log(Status.INFO, "Entering Users Phone Number.......");
		createClientForm.enterUserPhoneNumber();

		extentTest.get().log(Status.INFO, "Entering Users Email..........");
		createClientForm.enterUserEmail();

		extentTest.get().log(Status.INFO, "Entering Team Name.......");
		createClientForm.enterUsersTeam();

		extentTest.get().log(Status.INFO, "Clicking on Save Button......");
		createClientForm.clickOnSaveButton();

		//Thread.sleep(10000);

		extentTest.get().log(Status.INFO, "Logging into newly created client " + businessName + "......");

		clientLogin.clientLogin(businessName);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Verifying Post paid client name from support Dashboard.......");
		adminDashboardPage.verifyingClientLogin();

		extentTest.get().log(Status.INFO, "Logging out from support Dashboard.......");
		clientLogin.logout();

	}
}
