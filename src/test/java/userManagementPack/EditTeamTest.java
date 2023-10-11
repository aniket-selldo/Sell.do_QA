package userManagementPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.EditTeamFormPage;
import com.selldo.POM.adminPages.ManageTeamsPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class EditTeamTest extends BaseTest {

	@Test
	public void editTeamTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Amura_Admin"), prop("Password"));

		GetTestData getTestData = new GetTestData();

		String newTeamName = getTestData.firstName;

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		settingsPage.clickOnUserManagementTab();

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		userManagementPage.clickOnManageTeam();

		ManageTeamsPage manageTeamPage = new ManageTeamsPage(driver);

		manageTeamPage.clickOnActionBar();

		manageTeamPage.clickOnEdit();

		Thread.sleep(2000);

		EditTeamFormPage editTeamFormPage = new EditTeamFormPage(driver);

		editTeamFormPage.changeTeamName(newTeamName);

		editTeamFormPage.changeLocation(getTestData.location);

		Thread.sleep(3000);

		editTeamFormPage.clickOnSaveButton();

		Thread.sleep(5000);

		manageTeamPage.searchTeam(newTeamName);

		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[1]")).getAttribute("innerHTML"),
				newTeamName, "Not matched");

	}

}
