package inventory;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.FloorPlansPage;
import com.selldo.POM.inventory.NewFloorPlanFormPage;
import com.selldo.Utility.BaseTest;

import Enums.FloorPlanCategory;
import Enums.FloorPlanType;

public class AddingNewFloorPlanTest extends BaseTest {

//	final static Logger logger = Logger.getLogger(AddingNewFloorPlanextentTest.get().class);
//
//	// Description:
//
//	@BeforeTest
//
//	public void sales_presalesLogin() throws Exception {
//
//		mysetUp();
//
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//
//		Properties property = new Properties();
//		FileInputStream fileInputObj = new FileInputStream(
//				System.getProperty("user.dir") + "//src//main//java//Config File//global.properties");
//		prop.load(fileInputObj);
//
//		LoginPage login = new LoginPage(driver);
//
//		logger.info("Logging in to client page.......");
//		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
//				prop.getProperty("password"));
//
//		ClientLoginPage clientLogin = new ClientLoginPage(driver);
//
//		logger.info("Logging in to Admin/Support Home Page......");
//		clientLogin.clientLogin(prop.getProperty("client_name"));
//
//	}
//
//	@AfterTest
//
//	public void endingTest() throws Exception {
//
//		Thread.sleep(3000);
//
//		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
//
//		logger.info("Logging out of Selldo......");
//		adminDashboardPage.loggingOut();
//
//		logger.info("Closing Browser......");
//		driver.close();
//	}

	@Test

	public void addingNewFloorPlanTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		FloorPlansPage floorPlansPage = new FloorPlansPage(driver);

		NewFloorPlanFormPage newFloorPlanFormPage = new NewFloorPlanFormPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Floor Plans by mouse hovering over Inventory icon.......");
		newFloorPlanFormPage.clickOnFloorPlan();

		extentTest.get().log(Status.INFO, "Clicking on New Floor Plan button......");
		floorPlansPage.clickOnNewFloorPlanButton();

		extentTest.get().log(Status.INFO, "Entering Developer name to which floor plan belongs......");
		newFloorPlanFormPage.enterDeveloperName("AniketBuisnessNameMain");

		extentTest.get().log(Status.INFO, "Entering Project name to which floor plan belongs.....");
		newFloorPlanFormPage.enterProjectName("aniket project 02");

		extentTest.get().log(Status.INFO, "Entering Project Tower name to which floor plan belongs.....");
		newFloorPlanFormPage.enterProjectTowerName("su");

		String floorPlanName = prop.getProperty("floorPlan_name_addingNewFloorPlanTest");

		extentTest.get().log(Status.INFO, "Entering Floor Plan name.....");
		newFloorPlanFormPage.enterFloorPlanName(floorPlanName);
		extentTest.get().log(Status.INFO, "Selecting type......");
		newFloorPlanFormPage.selectType(FloorPlanType.penthouse);
		extentTest.get().log(Status.INFO, "Selecting number of bedrooms......");
		newFloorPlanFormPage.selectNumberOfBedrooms();
		extentTest.get().log(Status.INFO, "Selecting number of bathrooms......");
		newFloorPlanFormPage.selectNumberOfBathrooms();
		extentTest.get().log(Status.INFO, "Selecting Category......");
		newFloorPlanFormPage.selectCategory(FloorPlanCategory.corner);

		extentTest.get().log(Status.INFO, "Entering Carpet area......");
		newFloorPlanFormPage.enterCarpetArea(Random("N",5));

		extentTest.get().log(Status.INFO, "Entering Saleable area......");
		newFloorPlanFormPage.enterSaleableArea(Random("N",5));

		extentTest.get().log(Status.INFO, "Entering Covered area......");
		newFloorPlanFormPage.enterCoveredArea(Random("N",5));

		extentTest.get().log(Status.INFO, "Entering Terrace area......");
		newFloorPlanFormPage.enterTerraceArea(Random("N",5));

		extentTest.get().log(Status.INFO, "Entering Base rate.....");
		newFloorPlanFormPage.enterBaseRate(prop.getProperty("baserate_addingNewFloorPlanTest"));

		extentTest.get().log(Status.INFO, "......");
		newFloorPlanFormPage.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Verifying that project is added.......");
		Assert.assertEquals(newFloorPlanFormPage.getFloorName(),floorPlanName, "Not matched");

	}

}
