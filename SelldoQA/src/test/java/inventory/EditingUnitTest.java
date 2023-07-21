package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.EditUnitPage;
import com.selldo.POM.inventory.UnitsPage;
import com.selldo.Utility.BaseTest;

public class EditingUnitTest extends BaseTest {

	@Test

	public void editingUnitTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		UnitsPage unitsPage = new UnitsPage(driver);

		EditUnitPage editUnitPage = new EditUnitPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		String unitName = unitsPage.getAnyUnitName();
		unitsPage.clickOnFunnelIcon();

		unitsPage.enterUnitName(unitName);

		unitsPage.clickOnApplyButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Units']/following::label[1]")).getText(),
				unitName, "Not matched");

		Thread.sleep(3000);

		String changedUnitName = Random("A", 15).toUpperCase();

		editUnitPage.changeUnitName(changedUnitName);

		editUnitPage.clickOnSaveButton();

		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Units']/following::label[1]")).getText(),
				changedUnitName, "Not matched");

		editUnitPage.clickOnDetailsLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[@for='s2id_autogen5']")).getAttribute("innerHTML").trim(),
				"Bedrooms", "Not matched");

		driver.navigate().back();

		editUnitPage.clickOnAreaAndCostingLink();

		Assert.assertEquals(driver.findElement(By.xpath("//button[@id='dropdownMenu1']")).getText().trim(), "Add cost",
				"Not matched");

		driver.navigate().back();

		editUnitPage.clickOnExtrasLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[@for='s2id_autogen3']")).getAttribute("innerHTML").trim(),
				"Category", "Not matched");

		driver.navigate().back();

		editUnitPage.clickOnCostTemplateLink();

		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Preview']")).getAttribute("innerHTML").trim(),
				"Preview Cost Sheet", "Not matched");

		driver.navigate().back();

		editUnitPage.clickOnViewFloorPlanLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='unit_configuration_developer']"))
				.getAttribute("innerHTML").trim(), "Developer", "Not matched");

		driver.navigate().back();

		editUnitPage.clickOnAllUnitsLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//a[@href='/client/project_units/new']")).getAttribute("innerHTML").trim(),
				"New Unit", "Not matched");

		driver.navigate().back();

		editUnitPage.clickOnAddUnitLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//a[text()='Add Another Unit']")).getAttribute("innerHTML").trim(),
				"Add Another Unit", "Not matched");

		driver.navigate().back();

	}
}
