package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.EditProjectFormPage;
import com.selldo.POM.inventory.ProjectsPage;
import com.selldo.Utility.BaseTest;

public class EditingProjectTest extends BaseTest {

	@Test
	public void editingProjectTest() throws Exception {
		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		ProjectsPage projectsPage = new ProjectsPage(driver);

		EditProjectFormPage editProjectFormPage = new EditProjectFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Projects")).click();

		projectsPage.clickOnFunnelIcon();

		String projectName = projectsPage.getAnyProjectName();

		projectsPage.enterProjectName(projectName);

		projectsPage.clickOnFilterButton();

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Projects']/following::label[1]")).getText(),
				projectName, "Not matched");

		Thread.sleep(3000);

		String changedProjectName = "CHANGE NAME" + DateTime("dd/MM/yyyy HH:mm:ss");

		editProjectFormPage.changeProjectName(changedProjectName);

		editProjectFormPage.clickOnSaveButton();

		Thread.sleep(2000);

		Assert.assertEquals(driver.findElement(By.xpath("//a[text()='All Projects']/following::label[1]")).getText(),
				changedProjectName, "Not matched");

		editProjectFormPage.clickOnAddressLink();

		Assert.assertEquals(driver.findElement(By.xpath("//label[@for='project_address_attributes_address1']"))
				.getAttribute("innerHTML").trim(), "Address", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnVirtualWalkThroughLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[@for='project_vr_id']")).getAttribute("innerHTML").trim(), "Vr",
				"Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnDetailsLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[@for='s2id_autogen3']")).getAttribute("innerHTML").trim(),
				"Construction Status", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnSpecificationAndAmenitiesLink();

		Assert.assertEquals(driver.findElement(By.xpath("//a[@class='add_spec btn btn-outline-primary']"))
				.getAttribute("innerHTML").trim(), "Add Specification", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnEditPriceQuotesAndBrochureLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Brochure templates']")).getAttribute("innerHTML").trim(),
				"Brochure templates", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnUploadImagesLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//a[@href='#elevations']	")).getAttribute("innerHTML").trim(),
				"Elevations", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnPortalIntegrationCodesLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[@for='project_portals']")).getAttribute("innerHTML").trim(),
				"Portals", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnCostTemplateLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//label[text()='Base rate']")).getAttribute("innerHTML").trim(),
				"Base rate", "Not matched");

		driver.navigate().back();

//		editProjectFormPage.clickOnEmailTemplateLink();
//
//		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='New']")).getAttribute("innerHTML").trim(),
//				"New Template", "Not matched");
//
//		driver.navigate().back();
//
//		editProjectFormPage.clickOnSmsTemplateLink();
//
//		Assert.assertEquals(driver.findElement(By.xpath("//a[@title='New']")).getAttribute("innerHTML").trim(),
//				"New Template", "Not matched");
//
//		driver.navigate().back();
//
//		editProjectFormPage.clickOnPreviousDemandLettersLink();
//
//		Assert.assertEquals(
//				driver.findElement(By.xpath("//button[@class='btn btn-primary send_demand_letters disabled']"))
//						.getAttribute("innerHTML").trim(),
//				"Send demand letters", "Not matched");
//
//		driver.navigate().back();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

		editProjectFormPage.clickOnViewDeveloperLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='card-footer']//a")).getAttribute("innerHTML").trim(),
				"Add Project", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnViewAvailableProjectTowersLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='btn-group']//a")).getAttribute("innerHTML").trim(),
				"New Tower", "Not matched");

		driver.navigate().back();

		editProjectFormPage.clickOnViewAvailableFloorPlansLink();

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='btn-group']//a")).getAttribute("innerHTML").trim(),
				"New Floor Plan", "Not matched");

	}

}
