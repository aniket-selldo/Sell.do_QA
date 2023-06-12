package userManagementPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.EditTeamFormPage;
import com.selldo.POM.adminPages.ManageTeamsPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class EditTeamTest extends BaseTest {

	@Test

	public void editTeamTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("admin"), prop.getProperty("password"));
		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));

		GetTestData getTestData = new GetTestData();

		String newTeamName = getTestData.firstName;

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Setting Icon.......");
		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on User Management tab.......");
		settingsPage.clickOnUserManagementTab();

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Manage Team tab.......");
		userManagementPage.clickOnManageTeam();

		ManageTeamsPage manageTeamPage = new ManageTeamsPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on Action Bar.......");
		manageTeamPage.clickOnActionBar();

		extentTest.get().log(Status.INFO, "Clicking on Edit link.......");
		manageTeamPage.clickOnEdit();

		Thread.sleep(2000);

		EditTeamFormPage editTeamFormPage = new EditTeamFormPage(driver);

		extentTest.get().log(Status.INFO, "Changing Team name.......");
		editTeamFormPage.changeTeamName(newTeamName);

		extentTest.get().log(Status.INFO, "Changing Location.......");
		editTeamFormPage.changeLocation(getTestData.location);

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Clicking on Save Button.......");
		editTeamFormPage.clickOnSaveButton();

		Thread.sleep(5000);

		extentTest.get().log(Status.INFO, "Searching Team by name.......");
		manageTeamPage.searchTeam(newTeamName);

		extentTest.get().log(Status.INFO, "Validating Edited Team .......");
		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[1]")).getAttribute("innerHTML"),
				newTeamName, "Not matched");

	}

}
