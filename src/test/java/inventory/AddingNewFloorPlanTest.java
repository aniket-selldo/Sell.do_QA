package inventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.FloorPlansPage;
import com.selldo.POM.inventory.NewDeveloperFormPage;
import com.selldo.POM.inventory.NewFloorPlanFormPage;
import com.selldo.Utility.BaseTest;

import Enums.FloorPlanCategory;
import Enums.FloorPlanType;
import Enums.Project;

public class AddingNewFloorPlanTest extends BaseTest {

	@Test
	public void addingNewFloorPlanTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		FloorPlansPage floorPlansPage = new FloorPlansPage(driver);
		NewFloorPlanFormPage newFloorPlanFormPage = new NewFloorPlanFormPage(driver);
		NewDeveloperFormPage newDeveloperFormPage = new NewDeveloperFormPage(driver);
		login.login(prop("Clinet_Email"), prop("Password"));

	
		String getAnyDevloperName = newDeveloperFormPage.getFirstDevloperName().split(" ")[0];
	
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
