package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.EditFloorPlanPage;
import com.selldo.POM.inventory.FloorPlansPage;
import com.selldo.Utility.BaseTest;

public class EditingFloorPlanTest extends BaseTest {

	@Test
	public void editingFloorPlanTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop("Clinet_Email"), prop("Password"));

		FloorPlansPage floorPlansPage = new FloorPlansPage(driver);

		EditFloorPlanPage editFloorPlanPage = new EditFloorPlanPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Floor Plans")).click();

		floorPlansPage.clickOnFunnelIcon();

		String floorPlanName = floorPlansPage.getAnyFloorPlanName();

		floorPlansPage.enterFloorPlanName(floorPlanName);

		floorPlansPage.clickOnFilterButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Floor Plans']/following::label[1]")).getText(),
				floorPlanName, "Not matched");

		Thread.sleep(3000);

		String changedFloorPlanName = Random("A", 10).toUpperCase();

		editFloorPlanPage.changeProjectTowerName(changedFloorPlanName);

		editFloorPlanPage.clickOnSaveButton();

		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Floor Plans']/following::label[1]")).getText(),
				changedFloorPlanName, "Not matched");

		editFloorPlanPage.clickOnAreaAndCostingLink();

		Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Areas']")).getText().trim(), "Areas",
				"Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnExtrasLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Category']")).getText().trim(), "CATEGORY",
				"Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnFloorPlanImagesLink();

		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='image[]']")).getText().trim(), "",
				"Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnPriceQuotesAndBrochureLink();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Add Brochure']")).getText().trim(), "Add Brochure",
				"Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnRegionsLink();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Region']")).getText().trim(), "New Region",
				"Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnCostTemplateLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Project cost template']")).getText().trim(),
				"Project cost template", "Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnViewUnitsLink();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Unit']")).getText().trim(), "New Unit",
				"Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnAddUnitLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='project_unit_developer']")).getText().trim(),
				"DEVELOPER", "Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnAllFloorPlans();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='New Floor Plan']")).getText().trim(),
				"New Floor Plan", "Not matched");

		driver.navigate().back();

		editFloorPlanPage.clickOnAddFloorPlan();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Home']/following::a[3]")).getText().trim(),
				"All Floor Plans", "Not matched");

		driver.navigate().back();

		// driver.switchTo().alert().accept();

	}

}
