package inventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.NewProjectTowerFormPage;
import com.selldo.POM.inventory.ProjectTowersPage;
import com.selldo.Utility.BaseTest;

import Enums.Project;

public class AddingNewProjectTowerTest extends BaseTest {

	@Test

	public void addingNewProjectTowerTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		ProjectTowersPage projectTowersPage = new ProjectTowersPage(driver);

		NewProjectTowerFormPage newProjectTowerFormPage = new NewProjectTowerFormPage(driver);

		newProjectTowerFormPage.clickOnProjectTower();

		projectTowersPage.clickOnNewTower();

		String projectTowerName = Random("A", 10).toUpperCase();

		newProjectTowerFormPage.enterProjectTowerName(projectTowerName);

		newProjectTowerFormPage.enterProjectName(Project.Aniket_Project_03);

		newProjectTowerFormPage.enterTotalFloorsNumber(Random("N",2));

		newProjectTowerFormPage.clickOnSaveButton();

		Assert.assertEquals(newProjectTowerFormPage.getProjectName(), projectTowerName, "Not matched");

	}

}
