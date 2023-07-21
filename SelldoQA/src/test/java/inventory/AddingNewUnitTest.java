package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.NewUnitFormPage;
import com.selldo.POM.inventory.UnitsPage;
import com.selldo.Utility.BaseTest;

import Enums.Project;

public class AddingNewUnitTest extends BaseTest {

	@Test
	public void addingNewUnitTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("admin"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		UnitsPage unitsPage = new UnitsPage(driver);
		NewUnitFormPage newUnitFormPage = new NewUnitFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		unitsPage.clickOnNewUnitButton();

		newUnitFormPage.enterDeveloperName("UTVQYWTZUS");

		newUnitFormPage.enterProjectName(Project.Aniket_Project_03);

		newUnitFormPage.enterProjectTowerName("Aniket");
		newUnitFormPage.enterUnitConfiguration("a");
		String unitName = Random("A", 10).toUpperCase();
		// newUnitFormPage.enterFloorPlanName("Floor Plan");

		newUnitFormPage.enterUnitName(unitName);

		newUnitFormPage.enterNumberOfFloors(prop.getProperty("numberOfFloors_addingNewUnitTest"));

		newUnitFormPage.enterUnitBaseRate(Random("N", 10));

		newUnitFormPage.selectNumberOfBedrooms();

		newUnitFormPage.selectNumberOfBathrooms();

		newUnitFormPage.selectCategory();

		newUnitFormPage.selectType();

		newUnitFormPage.enterSaleableArea(Random("N", 10));

		newUnitFormPage.enterCarpetArea(Random("N", 10));

		newUnitFormPage.enterNumberOfFloors(Random("N", 1));

		newUnitFormPage.clickOnSaveButton();

		Assert.assertTrue(newUnitFormPage.FindUnit(unitName));

	}

}
