package userManagementPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageUsersPage;
import com.selldo.POM.adminPages.NewUserFormPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class CreatingPostsalesUserTest extends BaseTest {

	@Test
	public void creatingPostsalesUserTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("admin"), prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));

		GetTestData getTestData = new GetTestData();

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Setting Icon.......");
		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on User Management tab.......");
		settingsPage.clickOnUserManagementTab();

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Manage Users tab.......");
		userManagementPage.clickOnManageUsers();

		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on New User Button......");
		manageUsersPage.clickOnNewUserButton();

		NewUserFormPage newUserFormPage = new NewUserFormPage(driver);

		extentTest.get().log(Status.INFO, "Entering First Name........");
		String adminFirstNameObj = getTestData.firstName;
		newUserFormPage.enterFirstName(adminFirstNameObj);

		extentTest.get().log(Status.INFO, "Entering Last Name........");
		String adminLastNameObj = getTestData.lastName;
		newUserFormPage.enterLastName(adminLastNameObj);

		extentTest.get().log(Status.INFO, "Entering Phone number........");
		String phoneObj = randomPhone();
		newUserFormPage.enterPhone(phoneObj);

		Thread.sleep(3000);

		String email = randomEmail();
		extentTest.get().log(Status.INFO, "Entering Email Id.	.......");
		newUserFormPage.enterEmail(email);

		extentTest.get().log(Status.INFO, "Clicking on Professional Details Tab......");
		newUserFormPage.clickOnProfessionalDetailsTab();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Selecting postsales department.......");
		newUserFormPage.selectDepartment_PostSales();

		extentTest.get().log(Status.INFO, "Selecting Postsales role.......");
		newUserFormPage.selectRole_PostSales();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Selecting Team from dropdown.......");
		newUserFormPage.selectTeam();

		extentTest.get().log(Status.INFO, "Clicking on Save Button.......");
		newUserFormPage.clickOnSaveButton();

		Thread.sleep(6000);

		extentTest.get().log(Status.INFO, "Searching user by Email Id.......");
		manageUsersPage.searchUser2(email);

		String adminNameObj = adminFirstNameObj + " " + adminLastNameObj;

		extentTest.get().log(Status.INFO, "Validating user name.......");
		Assert.assertEquals(manageUsersPage.getUserNameFromList(),
				adminNameObj, "Not matched");

		extentTest.get().log(Status.INFO, "Validating that status is unconfirmed.......");
		Assert.assertEquals(manageUsersPage.getUserStatus(),"Unconfirmed", "Not matched");

	}

}
