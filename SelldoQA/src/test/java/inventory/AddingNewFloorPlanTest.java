package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.FloorPlansPage;
import com.selldo.POM.inventory.NewFloorPlanFormPage;
import com.selldo.Utility.BaseTest;

import Enums.FloorPlanCategory;
import Enums.FloorPlanType;
import Enums.Project;

public class AddingNewFloorPlanTest extends BaseTest {

	@Test
	public void addingNewFloorPlanTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		ClientLoginPage clientLogin = new ClientLoginPage(driver);
		FloorPlansPage floorPlansPage = new FloorPlansPage(driver);
		NewFloorPlanFormPage newFloorPlanFormPage = new NewFloorPlanFormPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));
		clientLogin.clientLogin(prop.getProperty("Client"));

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();
		// String getAnyDevloperName = newDeveloperFormPage.getAnyDevloperName();
		String getAnyDevloperName = "UTVQYWTZUS";
		newFloorPlanFormPage.clickOnFloorPlan();

		floorPlansPage.clickOnNewFloorPlanButton();

		newFloorPlanFormPage.enterDeveloperName(getAnyDevloperName);

		newFloorPlanFormPage.enterProjectName(Project.Aniket_Project_03);

		newFloorPlanFormPage.enterProjectTowerName("Aniket");
		String FloorPlanName = Random("A", 10).toUpperCase() + " " + DateTime("dd/MM/yyyy HH:mm:ss");
		newFloorPlanFormPage.enterFloorPlanName(FloorPlanName);
		newFloorPlanFormPage.selectType(FloorPlanType.villa);
		newFloorPlanFormPage.selectNumberOfBedrooms("3");
		newFloorPlanFormPage.selectNumberOfBathrooms("3");
		newFloorPlanFormPage.selectCategory(FloorPlanCategory.premium);
		newFloorPlanFormPage.enterLoading("11.11");
		newFloorPlanFormPage.enterCarpetArea(Random("N", 7).replaceAll("[0]", ""));

		newFloorPlanFormPage.enterSaleableArea(Random("N", 4).replaceAll("[0]", ""));

		newFloorPlanFormPage.enterCoveredArea(Random("N", 5).replaceAll("[0]", ""));

		newFloorPlanFormPage.enterTerraceArea(Random("N", 5).replaceAll("[0]", ""));

		newFloorPlanFormPage.enterBaseRate(Random("N", 5).replaceAll("[0]", ""));

		newFloorPlanFormPage.clickOnSaveButton();

		Assert.assertEquals(newFloorPlanFormPage.getFloorName(), FloorPlanName, "Not matched");

	}

}
