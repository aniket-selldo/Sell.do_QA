package userManagementPack;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageUsersPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class SearchingUserTest extends BaseTest {

	@Test

	public void searchingUserTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("admin"), prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));

		Properties property = new Properties();
		FileInputStream fileInputObj = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
		property.load(fileInputObj);

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		SalesPresalesDashboardPage salesPresalesDashboardPage = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Signing in as a sales user to which lead is to be pulled.......");
		adminDashboardPage.loginAsUser("Aniket");

		extentTest.get().log(Status.INFO, "Opening edit profile form of user....");
		salesPresalesDashboardPage.editUserProfile();

		extentTest.get().log(Status.INFO, "Capturing first name of user from its profile....");
		String firstName = salesPresalesDashboardPage.getFirstNameOfUser();
		System.out.println(firstName);

		extentTest.get().log(Status.INFO, "Capturing last name of user from its profile....");
		String lastName = salesPresalesDashboardPage.getLastNameOfUser();
		System.out.println(lastName);

		String userNameToBeSearched = firstName + " " + lastName;

		extentTest.get().log(Status.INFO, "Capturing phone number of user from its profile....");
		String phoneNumber = salesPresalesDashboardPage.getPhoneOfUser();
		System.out.println(phoneNumber);
		System.out.println("Length Of leadId -> " + phoneNumber.length());
		String phoneNumberToBeSearched = phoneNumber.substring(4, +phoneNumber.length()).replaceAll("\\s+", "");
		System.out.println("Retrieving sub string from string -> " + phoneNumberToBeSearched);

		extentTest.get().log(Status.INFO, "Capturing email of user from its profile....");
		String email = salesPresalesDashboardPage.getEmailOfUser();
		System.out.println(email);

		extentTest.get().log(Status.INFO, "Capturing secondary phone number of user from its profile....");
		String secondaryPhoneNumber = salesPresalesDashboardPage.getSecondaryPhoneOfUser();
		System.out.println(secondaryPhoneNumber);
		System.out.println("Length Of leadId -> " + secondaryPhoneNumber.length());
		String secondaryPhoneNumberToBeSearched = secondaryPhoneNumber.substring(4, +secondaryPhoneNumber.length())
				.replaceAll("\\s+", "");
		System.out.println("Retrieving sub string from string -> " + secondaryPhoneNumberToBeSearched);

		extentTest.get().log(Status.INFO, "Closing edit user profile form......");
		salesPresalesDashboardPage.closeEditProfile();

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		extentTest.get().log(Status.INFO, "Going back to Admin page.......");
		leadProfilePage.backToAdmin();

		extentTest.get().log(Status.INFO, "Clicking on Setting Icon.......");
		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on User Management tab.......");
		settingsPage.clickOnUserManagementTab();

		extentTest.get().log(Status.INFO, "Clicking on Manage Users tab.......");
		userManagementPage.clickOnManageUsers();

		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);

		extentTest.get().log(Status.INFO, "Searching user by name.......");
		manageUsersPage.searchUser(userNameToBeSearched);

		extentTest.get().log(Status.INFO, "Validating user name.......");
		Assert.assertEquals(manageUsersPage.getUserNameFromUserList(), userNameToBeSearched, "Not matched");

		extentTest.get().log(Status.INFO, "Resetting the filter.......");
		manageUsersPage.resettingFilter();

		extentTest.get().log(Status.INFO, "Searching user by Phone number.......");
		manageUsersPage.searchUser(phoneNumberToBeSearched);

		extentTest.get().log(Status.INFO, "Validating user name.......");
		Assert.assertEquals(manageUsersPage.getUserNameFromUserList(), userNameToBeSearched, "Not matched");

		extentTest.get().log(Status.INFO, "Resetting the filter.......");
		manageUsersPage.resettingFilter();

		extentTest.get().log(Status.INFO, "Searching user by email.......");
		manageUsersPage.searchUser(email);

		extentTest.get().log(Status.INFO, "Validating user name.......");
		Assert.assertEquals(manageUsersPage.getUserNameFromUserList(), userNameToBeSearched, "Not matched");

		extentTest.get().log(Status.INFO, "Resetting the filter.......");
		manageUsersPage.resettingFilter();

		extentTest.get().log(Status.INFO, "Searching user by secondary phone number.......");
		manageUsersPage.searchUser(secondaryPhoneNumberToBeSearched);

		extentTest.get().log(Status.INFO, "Validating user name.......");
		Assert.assertEquals(manageUsersPage.getUserNameFromUserList(), userNameToBeSearched, "Not matched");

	}
}
