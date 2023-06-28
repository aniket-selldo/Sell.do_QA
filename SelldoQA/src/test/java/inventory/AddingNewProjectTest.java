package inventory;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.NewProjectFormPage;
import com.selldo.POM.inventory.ProjectsPage;
import com.selldo.Utility.BaseTest;

public class AddingNewProjectTest extends BaseTest {

	@Test
	public void addingNewProjectTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		ProjectsPage projectsPage = new ProjectsPage(driver);

		NewProjectFormPage newProjectFormPage = new NewProjectFormPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Projects by mouse hovering over Inventory icon.......");
		newProjectFormPage.clickOnProject();

		extentTest.get().log(Status.INFO, "Cicking on New Project button......");
		projectsPage.clickOnNewProjectButton();

		String projectName = "Aniket_Project_"+Random("A",5).toUpperCase();

		extentTest.get().log(Status.INFO, "Entering Project name......");
		newProjectFormPage.enterProjectName(projectName);

		String developerName = "AniketBuisnessNameMain";

		extentTest.get().log(Status.INFO, "Entering Developer name to which Project belongs......");
		newProjectFormPage.enterDeveloperName(developerName);

		extentTest.get().log(Status.INFO, "Entering some description......");
		newProjectFormPage.enterDescription(prop.getProperty("description_addingNewProjectTest"));


		extentTest.get().log(Status.INFO, "Selecting Sales user......");
		newProjectFormPage.selectSales();

		extentTest.get().log(Status.INFO, "Selecting presales user......");
		newProjectFormPage.selectPresales();

		//extentTest.get().log(Status.INFO, "Selecting Postsales user.....");
		//newProjectFormPage.selectPostsales();

		extentTest.get().log(Status.INFO, "Selecting Possession date......");
		newProjectFormPage.selectPossessionDate();

		extentTest.get().log(Status.INFO, "Selecting Project type......");
		newProjectFormPage.selectProjectType();

		extentTest.get().log(Status.INFO, "Entering Locality.....");
		newProjectFormPage.enterLocality(prop.getProperty("locality_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Entering Latitude.....");
		newProjectFormPage.enterLatitude(prop.getProperty("latitude_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Entering longitude......");
		newProjectFormPage.enterLongitude(prop.getProperty("longitude_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Entering Address......");
		newProjectFormPage.enterAddress(prop.getProperty("address_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Entering Street......");
		newProjectFormPage.enterStreet(prop.getProperty("street_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Entering City......");
		newProjectFormPage.enterCity(prop.getProperty("city_addingNewProjectTest"));
		
		extentTest.get().log(Status.INFO, "Selecting Country......");
		newProjectFormPage.selectCountry(prop.getProperty("country_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Selecting State......");
		newProjectFormPage.selectState(prop.getProperty("state_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Entering Zip......");
		newProjectFormPage.enterZip(prop.getProperty("zip_addingNewProjectTest"));

		extentTest.get().log(Status.INFO, "Clicking on Save button......");
		newProjectFormPage.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Verifying that project is added.......");
		Assert.assertEquals(newProjectFormPage.getProjectName(),projectName, "Not matched");

	}

}
