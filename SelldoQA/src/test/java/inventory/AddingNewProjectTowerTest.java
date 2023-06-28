package inventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.NewProjectTowerFormPage;
import com.selldo.POM.inventory.ProjectTowersPage;
import com.selldo.Utility.BaseTest;

public class AddingNewProjectTowerTest extends BaseTest {

	@Test

	public void addingNewProjectTowerTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		ProjectTowersPage projectTowersPage = new ProjectTowersPage(driver);

		NewProjectTowerFormPage newProjectTowerFormPage = new NewProjectTowerFormPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Project Towers by mouse hovering over Inventory icon.......");
		newProjectTowerFormPage.clickOnProjectTower();

		extentTest.get().log(Status.INFO, "Cicking on New Project Tower button......");
		projectTowersPage.clickOnNewTower();

		String projectTowerName = Random("A", 10).toUpperCase();

		extentTest.get().log(Status.INFO, "Entering Project Tower name......");
		newProjectTowerFormPage.enterProjectTowerName(projectTowerName);

		extentTest.get().log(Status.INFO, "Entering Project name......");
		newProjectTowerFormPage.enterProjectName("aniket project 02");

		extentTest.get().log(Status.INFO, "Entering total floors number......");
		newProjectTowerFormPage.enterTotalFloorsNumber("8");

		extentTest.get().log(Status.INFO, "Clicking on Save button.....");
		newProjectTowerFormPage.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Verifying that project is added.......");
		Assert.assertEquals(newProjectTowerFormPage.getProjectName(), projectTowerName, "Not matched");

	}

}
