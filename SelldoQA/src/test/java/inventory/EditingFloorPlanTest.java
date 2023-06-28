package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.EditFloorPlanPage;
import com.selldo.POM.inventory.FloorPlansPage;
import com.selldo.Utility.BaseTest;

public class EditingFloorPlanTest extends BaseTest {

	@Test

	public void editingFloorPlanTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		FloorPlansPage floorPlansPage = new FloorPlansPage(driver);

		EditFloorPlanPage editFloorPlanPage = new EditFloorPlanPage(driver);

		extentTest.get().log(Status.INFO, "Selecting Floor Plans by mouse hovering over Inventory icon.......");
		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Floor Plans")).click();

		extentTest.get().log(Status.INFO, "Cicking on Funnel Icon.....");
		floorPlansPage.clickOnFunnelIcon();

		String floorPlanName = floorPlansPage.getAnyFloorPlanName();

		extentTest.get().log(Status.INFO, "Entering Floor Plan's name to be searched......");
		floorPlansPage.enterFloorPlanName(floorPlanName);

		extentTest.get().log(Status.INFO, "Cicking on Filter button.....");
		floorPlansPage.clickOnFilterButton();

		extentTest.get().log(Status.INFO, "Verifying that Floor plan is searched.......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Floor Plans']/following::label[1]")).getText(),
				floorPlanName, "Not matched");

		Thread.sleep(3000);

		String changedFloorPlanName = Random("A",10).toUpperCase();

		extentTest.get().log(Status.INFO, "Changing Project Tower's name......");
		editFloorPlanPage.changeProjectTowerName(changedFloorPlanName);

		extentTest.get().log(Status.INFO, "Clicking on Save Button......");
		editFloorPlanPage.clickOnSaveButton();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Verifying that Project Tower is changed by new name......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Floor Plans']/following::label[1]")).getText(),
				changedFloorPlanName, "Not matched");

		extentTest.get().log(Status.INFO, "Clicking on Area and Costing link......");
		editFloorPlanPage.clickOnAreaAndCostingLink();

		extentTest.get().log(Status.INFO, "Verifying Area and Costing link.......");

		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Areas']")).getText().trim(), "Areas",
				"Not matched");


		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Extras link......");
		editFloorPlanPage.clickOnExtrasLink();

		extentTest.get().log(Status.INFO, "Verifying Extras link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Category']")).getText().trim(), "CATEGORY",
				"Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Floor Plan Images link......");
		editFloorPlanPage.clickOnFloorPlanImagesLink();

		extentTest.get().log(Status.INFO, "Verifying Floor Plan Images link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='image[]']")).getText().trim(), "",
				"Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Price Quotes and Brochure link......");
		editFloorPlanPage.clickOnPriceQuotesAndBrochureLink();

		extentTest.get().log(Status.INFO, "Verifying Price Quotes and Brochure link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Add Brochure']")).getText().trim(), "Add Brochure",
				"Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Regions link......");
		editFloorPlanPage.clickOnRegionsLink();

		extentTest.get().log(Status.INFO, "Verifying Regions link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Region']")).getText().trim(), "New Region",
				"Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Cost Template link......");
		editFloorPlanPage.clickOnCostTemplateLink();

		extentTest.get().log(Status.INFO, "Verifying Cost Template link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Project cost template']")).getText().trim(),
				"Project cost template", "Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on View Available Project Units link......");
		editFloorPlanPage.clickOnViewUnitsLink();

		extentTest.get().log(Status.INFO, "Verifying View Available Project Units link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Unit']")).getText().trim(), "New Unit",
				"Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Add Unit link......");
		editFloorPlanPage.clickOnAddUnitLink();

		extentTest.get().log(Status.INFO, "Verifying Add Unit link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='project_unit_developer']")).getText().trim(),
				"DEVELOPER", "Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on All Floor Plans link......");
		editFloorPlanPage.clickOnAllFloorPlans();

		extentTest.get().log(Status.INFO, "Verifying All Floor Plans link.......");
		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Floor Plan']")).getText().trim(),
				"New Floor Plan", "Not matched");

		driver.navigate().back();

		extentTest.get().log(Status.INFO, "Clicking on Add Floor Plan link......");
		editFloorPlanPage.clickOnAddFloorPlan();

		extentTest.get().log(Status.INFO, "Verifying Add Floor Plan link.......");
		Assert.assertEquals(
				driver.findElement(By.xpath("//a[text()='Home']/following::a[3]")).getText().trim(),
				"All Floor Plans", "Not matched");
		
		driver.navigate().back();

		//driver.switchTo().alert().accept();

	}

}
