package userManagementPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageUsersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.EditUserFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class EditingUserTest extends BaseTest {

	@Test

	public void editingUserTest() throws Exception {


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

		String phoneObj =  randomPhone();
		//String phone_SearchObj = phoneObj;

		extentTest.get().log(Status.INFO, "Selecting Edit from dropdown......");
		manageUsersPage.selectEdit();
		Thread.sleep(3000);

		EditUserFormPage editUserForm = new EditUserFormPage(driver);

		extentTest.get().log(Status.INFO, "Changing First name........");
		String firstNameObj = getTestData.firstName;
		editUserForm.changeFirstName(firstNameObj);

		extentTest.get().log(Status.INFO, "Changing Last Name........");
		String lastNameObj = getTestData.lastName;
		editUserForm.changeLastName(lastNameObj);

		extentTest.get().log(Status.INFO, "Changing Phone number........");
		editUserForm.changePhone(phoneObj);

		Thread.sleep(3000);

		String emailId =  randomEmail();
		extentTest.get().log(Status.INFO, "Changing Email Id.	.......");
		editUserForm.changeEmail(emailId);

		extentTest.get().log(Status.INFO, "Clicking on Save Button.......");
		editUserForm.clickOnSaveButton();

		Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Searching user by Email Id.......");
		manageUsersPage.searchUser(emailId);

		String adminNameObj = firstNameObj + " " + lastNameObj;

		extentTest.get().log(Status.INFO, "Validating user name.......");
		Assert.assertEquals(manageUsersPage.getUserNameFromList(),adminNameObj, "Not matched");

	}
}
