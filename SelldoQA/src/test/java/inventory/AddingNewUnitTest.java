package inventory;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.NewUnitFormPage;
import com.selldo.POM.inventory.UnitsPage;
import com.selldo.Utility.BaseTest;

public class AddingNewUnitTest extends BaseTest {


	public void sales_presalesLogin() throws Exception {
		String userName =prop.getProperty("superadmin_name");
		String userNameExte =prop.getProperty("superadmin_email");
		String password =prop.getProperty("password");

		LoginPage login = new LoginPage(driver);
		login.login(userName + userNameExte,password);

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("client_name"));

	}



	public void endingTest() throws Exception {

		Thread.sleep(3000);

		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);

		adminDashboardPage.loggingOut();

		driver.close();
	}

	@Test
	public void addingNewUnitTest() throws Exception {
		sales_presalesLogin();


		Thread.sleep(3000);

		UnitsPage unitsPage = new UnitsPage(driver);
		NewUnitFormPage newUnitFormPage = new NewUnitFormPage(driver);

		SoftAssert assertion = new SoftAssert();

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		unitsPage.clickOnNewUnitButton();

		newUnitFormPage.enterDeveloperName(prop.getProperty("developer_name_addingNewUnitTest"));

		newUnitFormPage.enterProjectName(prop.getProperty("project_name_addingNewUnitTest"));

		newUnitFormPage.enterProjectTowerName(prop.getProperty("tower_name_addingNewUnitTest"));

		newUnitFormPage.enterFloorPlanName(prop.getProperty("floorPlan_name_addingNewUnitTest"));

		String unitName = prop.getProperty("unit_name_addingNewUnitTest");

		newUnitFormPage.enterUnitName(unitName);

		Thread.sleep(2000);

		newUnitFormPage.enterNumberOfFloors(prop.getProperty("numberOfFloors_addingNewUnitTest"));

		Thread.sleep(1000);

		newUnitFormPage.enterUnitBaseRate(prop.getProperty("baseRate_addingNewUnitTest"));

		newUnitFormPage.selectNumberOfBedrooms();

		newUnitFormPage.selectNumberOfBathrooms();

		newUnitFormPage.selectCategory();

		newUnitFormPage.selectType();

		newUnitFormPage.enterSaleableArea(prop.getProperty("saleableArea_addingNewUnitTest"));

		newUnitFormPage.enterCarpetArea(prop.getProperty("carpetArea_addingNewUnitTest"));

		Thread.sleep(2000);

		newUnitFormPage.enterNumberOfFloors(prop.getProperty("numberOfFloors_addingNewUnitTest"));

		newUnitFormPage.clickOnSaveButton();

		Thread.sleep(2000);

		AssertJUnit.assertEquals(driver.findElement(By.xpath("//a[text()='All Units']/following::label[1]")).getText(),
				unitName, "Not matched");
		assertion.assertAll();
	}

}
