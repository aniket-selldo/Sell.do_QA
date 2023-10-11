package userManagementPack;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageUsersPage;
import com.selldo.POM.adminPages.NewUserFormPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class CreatingAdminUserTest extends BaseTest {

	@Test
	public void creatingAdminUserTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Amura_Admin"),prop("Password"));

		GetTestData getTestData = new GetTestData();

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		settingsPage.clickOnUserManagementTab();

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		userManagementPage.clickOnManageUsers();

		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);

		manageUsersPage.clickOnNewUserButton();

		NewUserFormPage newUserFormPage = new NewUserFormPage(driver);

		String adminFirstNameObj = getTestData.firstName;
		newUserFormPage.enterFirstName(adminFirstNameObj);

		String adminLastNameObj = getTestData.lastName;
		newUserFormPage.enterLastName(adminLastNameObj);

		String phoneObj = randomPhone();
		newUserFormPage.enterPhone(phoneObj);
		String phone_SearchObj = phoneObj.replaceAll("\\s", "");

		newUserFormPage.enterEmail(randomEmail());

		newUserFormPage.clickOnProfessionalDetailsTab();

		newUserFormPage.selectRole_Admin();

		newUserFormPage.clickOnSaveButton();

		manageUsersPage.searchUser2(phone_SearchObj);
		String adminNameObj = adminFirstNameObj + " " + adminLastNameObj;

		Assert.assertEquals(manageUsersPage.getUserNameFromList(), adminNameObj, "Not matched");

		Assert.assertEquals(manageUsersPage.getUserStatus(), "Unconfirmed", "Not matched");
	}
}
