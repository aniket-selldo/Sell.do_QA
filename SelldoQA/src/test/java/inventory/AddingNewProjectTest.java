package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.NewDeveloperFormPage;
import com.selldo.POM.inventory.NewProjectFormPage;
import com.selldo.POM.inventory.ProjectsPage;
import com.selldo.Utility.BaseTest;

public class AddingNewProjectTest extends BaseTest {

	@Test
	public void addingNewProjectTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		NewDeveloperFormPage newDeveloperFormPage = new NewDeveloperFormPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));
		
		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();
		String getAnyDevloperName = newDeveloperFormPage.getAnyDevloperName();

		ProjectsPage projectsPage = new ProjectsPage(driver);

		NewProjectFormPage newProjectFormPage = new NewProjectFormPage(driver);

		newProjectFormPage.clickOnProject();

		projectsPage.clickOnNewProjectButton();

		String projectName = Random("A",5).toUpperCase()+ " " + DateTime("dd/MM/yyyy HH:mm:ss");

		newProjectFormPage.enterProjectName(projectName);

		String developerName = getAnyDevloperName;

		newProjectFormPage.enterDeveloperName(developerName);

		newProjectFormPage.enterDescription(prop.getProperty("description_addingNewProjectTest"));

		newProjectFormPage.selectSales();

		newProjectFormPage.selectPresales();

		//newProjectFormPage.selectPostsales();

		newProjectFormPage.selectPossessionDate();

		newProjectFormPage.selectProjectType();

		newProjectFormPage.enterLocality(prop.getProperty("locality_addingNewProjectTest"));

		newProjectFormPage.enterLatitude(prop.getProperty("latitude_addingNewProjectTest"));

		newProjectFormPage.enterLongitude(prop.getProperty("longitude_addingNewProjectTest"));

		newProjectFormPage.enterAddress(prop.getProperty("address_addingNewProjectTest"));

		newProjectFormPage.enterStreet(prop.getProperty("street_addingNewProjectTest"));

		newProjectFormPage.enterCity(prop.getProperty("city_addingNewProjectTest"));
		
		newProjectFormPage.selectCountry(prop.getProperty("country_addingNewProjectTest"));

		newProjectFormPage.selectState(prop.getProperty("state_addingNewProjectTest"));

		newProjectFormPage.enterZip(prop.getProperty("zip_addingNewProjectTest"));

		newProjectFormPage.clickOnSaveButton();

		Assert.assertEquals(newProjectFormPage.getProjectName(),projectName, "Not matched");

	}

}
