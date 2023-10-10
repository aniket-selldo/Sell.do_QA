package userManagementPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.adminPages.ManageTeamsPage;
import com.selldo.POM.adminPages.NewTeamFormPage;
import com.selldo.POM.adminPages.SettingsPage;
import com.selldo.POM.adminPages.UserManagementPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class AddingNewTeamTest extends BaseTest {

	@Test
	public void addingNewTeamTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Clinet_Email"), prop("Password"));

		GetTestData getTestData = new GetTestData();

		String teamName = getTestData.firstName +""+Random("A",10);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.clickOnSettingIcon();

		SettingsPage settingsPage = new SettingsPage(driver);

		settingsPage.clickOnUserManagementTab();

		UserManagementPage userManagementPage = new UserManagementPage(driver);

		userManagementPage.clickOnManageTeam();

		ManageTeamsPage manageTeamPage = new ManageTeamsPage(driver);

		manageTeamPage.clickOnNewTeam();

		NewTeamFormPage newTeamFormPage = new NewTeamFormPage(driver);

		newTeamFormPage.enterTeamName(teamName);

		newTeamFormPage.enterLocation(getTestData.location);

		newTeamFormPage.selectTeamHierarchy();

		newTeamFormPage.clickOnSaveButton();

		Thread.sleep(3000);

		manageTeamPage.searchTeam(teamName);

		Assert.assertEquals(
				driver.findElement(By.xpath("//th[text()='name']/following::span[1]")).getAttribute("innerHTML"),
				teamName, "Not matched");
	}

}
