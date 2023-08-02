package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

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

		login.login(prop("Client_id"), prop("Password"));

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

		newProjectFormPage.enterDescription(Random("AN",100));

		newProjectFormPage.selectSales();

		newProjectFormPage.selectPresales();

		//newProjectFormPage.selectPostsales();

		newProjectFormPage.selectPossessionDate();

		newProjectFormPage.selectProjectType();

		newProjectFormPage.enterLocality(Random("AN",100));

		newProjectFormPage.enterLatitude(Random("N",2));

		newProjectFormPage.enterLongitude(Random("N",2));

		newProjectFormPage.enterAddress(Random("AN",100));

		newProjectFormPage.enterStreet(Random("AN",100));

		newProjectFormPage.enterCity(Random("AN",100));
		
		newProjectFormPage.selectCountry("India");

		newProjectFormPage.selectState("Maharashtra");

		newProjectFormPage.enterZip(Random("N",6));

		newProjectFormPage.clickOnSaveButton();

		Assert.assertEquals(newProjectFormPage.getProjectName(),projectName, "Not matched");

	}

}
