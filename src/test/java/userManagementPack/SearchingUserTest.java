package userManagementPack;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageUsersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class SearchingUserTest extends BaseTest {

	@Test
	public void searchingUserTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Amura_Admin"), prop("Password"));

		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		adminDashboardPage.loginAsUser("Aniket");

		salesPresalesDashboardPage.editUserProfile();

		String firstName = salesPresalesDashboardPage.getFirstNameOfUser();
		System.out.println(firstName);

		String lastName = salesPresalesDashboardPage.getLastNameOfUser();
		System.out.println(lastName);

		String userNameToBeSearched = firstName + " " + lastName;

		String phoneNumber = salesPresalesDashboardPage.getPhoneOfUser();
		System.out.println(phoneNumber);
		System.out.println("Length Of leadId -> " + phoneNumber.length());
		String phoneNumberToBeSearched = phoneNumber.substring(4, +phoneNumber.length()).replaceAll("\\s+", "");
		System.out.println("Retrieving sub string from string -> " + phoneNumberToBeSearched);

		String email = salesPresalesDashboardPage.getEmailOfUser();
		System.out.println(email);

		String secondaryPhoneNumber = salesPresalesDashboardPage.getSecondaryPhoneOfUser();
		System.out.println(secondaryPhoneNumber);
		System.out.println("Length Of leadId -> " + secondaryPhoneNumber.length());
		String secondaryPhoneNumberToBeSearched = secondaryPhoneNumber.substring(4, +secondaryPhoneNumber.length())
				.replaceAll("\\s+", "");
		System.out.println("Retrieving sub string from string -> " + secondaryPhoneNumberToBeSearched);

		salesPresalesDashboardPage.closeEditProfile();

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		leadProfilePage.backToAdmin();

		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		settingsPage.clickOnUserManagementTab();

		userManagementPage.clickOnManageUsers();

		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);

		manageUsersPage.searchUser(userNameToBeSearched);

		Assert.assertEquals(manageUsersPage.getUserNameFromUserList().toLowerCase(), userNameToBeSearched.toLowerCase(), "Not matched");

		manageUsersPage.resettingFilter();

		manageUsersPage.searchUser(phoneNumberToBeSearched);

		Assert.assertEquals(manageUsersPage.getUserNameFromUserList().toLowerCase(), userNameToBeSearched.toLowerCase(), "Not matched");

		manageUsersPage.resettingFilter();

		manageUsersPage.searchUser(email);

		Assert.assertEquals(manageUsersPage.getUserNameFromUserList().toLowerCase(), userNameToBeSearched.toLowerCase(), "Not matched");

		manageUsersPage.resettingFilter();

		manageUsersPage.searchUser(secondaryPhoneNumberToBeSearched);

		Assert.assertEquals(manageUsersPage.getUserNameFromUserList().toLowerCase(), userNameToBeSearched.toLowerCase(), "Not matched");

	}
}
