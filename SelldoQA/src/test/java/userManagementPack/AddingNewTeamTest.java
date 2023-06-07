package userManagementPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageTeamsPage;
import com.selldo.POM.adminPages.NewTeamFormPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class AddingNewTeamTest extends BaseTest {
	
	@Test
	public void addingNewTeamTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("admin"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));
		GetTestData getTestData = new GetTestData();

		String teamName = getTestData.firstName;

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

		extentTest.get().log(Status.INFO, "Clicking on Clicking on New Team Button.......");
		manageTeamPage.clickOnNewTeam();

		NewTeamFormPage newTeamFormPage = new NewTeamFormPage(driver);

		extentTest.get().log(Status.INFO, "Entering Team Name.......");
		newTeamFormPage.enterTeamName(teamName);

		extentTest.get().log(Status.INFO, "Entering Location.......");
		newTeamFormPage.enterLocation(getTestData.location);

		extentTest.get().log(Status.INFO, "Selecting Team Hierarchy.......");
		newTeamFormPage.selectTeamHierarchy();

		extentTest.get().log(Status.INFO, "Clicking on Save Button.......");
		newTeamFormPage.clickOnSaveButton();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Searching Team by name.......");
		manageTeamPage.searchTeam(teamName);

		extentTest.get().log(Status.INFO, "Validating new Team creation.......");
		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[1]")).getAttribute("innerHTML"),
				teamName, "Not matched");


	}

}
