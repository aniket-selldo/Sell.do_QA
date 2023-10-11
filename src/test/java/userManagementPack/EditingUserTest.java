package userManagementPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageUsersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.EditUserFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class EditingUserTest extends BaseTest {

	@Test
	public void editingUserTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Amura_Admin"), prop("Password"));

		GetTestData getTestData = new GetTestData();

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		settingsPage.clickOnUserManagementTab();

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		userManagementPage.clickOnManageUsers();

		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);

		String phoneObj = randomPhone();
		System.out.println("Phone update ->  "+phoneObj);
		// String phone_SearchObj = phoneObj;

		manageUsersPage.selectEdit();
		Thread.sleep(3000);

		EditUserFormPage editUserForm = new EditUserFormPage(driver);

		String firstNameObj = getTestData.firstName;
		editUserForm.changeFirstName(firstNameObj);

		String lastNameObj = getTestData.lastName;
		editUserForm.changeLastName(lastNameObj);

		editUserForm.changePhone(phoneObj);

		Thread.sleep(3000);

		String emailId = randomEmail();
		editUserForm.changeEmail(emailId);

		editUserForm.clickOnSaveButton();

		Thread.sleep(10000);

		manageUsersPage.searchUser(phoneObj);

		String adminNameObj = firstNameObj + " " + lastNameObj;

		Assert.assertEquals(manageUsersPage.getUserNameFromList(), adminNameObj, "Not matched");

	}
}
