package inventory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.inventory.DevelopersPage;
import com.selldo.POM.inventory.NewDeveloperFormPage;
import com.selldo.Utility.BaseTest;

public class AddingNewDeveloperTest extends BaseTest {

	String developerName;

	@Test
	public void addingNewDeveloperTest() throws Exception {

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("id"), prop.getProperty("password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop.getProperty("Client"));

		DevelopersPage developersPage = new DevelopersPage(driver);

		NewDeveloperFormPage newDeveloperFormPage = new NewDeveloperFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Developers")).click();

		developersPage.clickOnNewDevekoperButton();

		developerName = Random("A", 5).toUpperCase() + " " + DateTime("dd/MM/yyyy HH:mm:ss");

		newDeveloperFormPage.enterDeveloperName(developerName);

		newDeveloperFormPage.enterDescription(Random("AN", 200));

		newDeveloperFormPage.enterAddress(prop.getProperty("address_addingNewDeveloperTest"));

		newDeveloperFormPage.enterStreet(prop.getProperty("street_addingNewDeveloperTest"));

		String city = prop.getProperty("city_addingNewDeveloperTest");

		newDeveloperFormPage.enterCity(city);

		newDeveloperFormPage.selectCountry(prop.getProperty("country_addingNewDeveloperTest"));

		newDeveloperFormPage.selectState(prop.getProperty("state_addingNewDeveloperTest"));

		newDeveloperFormPage.enterZip(Random("N", 6));

		newDeveloperFormPage.selectSalutation();

		newDeveloperFormPage.enterFirstName(Random("A", 10));

		newDeveloperFormPage.enterLastName(Random("A", 10));

		newDeveloperFormPage.enterPhoneNumber(randomPhone());

		newDeveloperFormPage.enterEmail(randomEmail());

		newDeveloperFormPage.alternateEmail(randomEmail());

		newDeveloperFormPage.enterAlternateNumber(randomPhone());

		newDeveloperFormPage.PAN("EXZPK1234R");

		newDeveloperFormPage.designation(Random("A", 5));

		newDeveloperFormPage.clickOnSaveButton();

		Thread.sleep(1000);
		Assert.assertEquals(newDeveloperFormPage.getDevlopersName2(), developerName, "Not matched");
		Assert.assertEquals(newDeveloperFormPage.getDevlopersName(), developerName, "Not matched");

	}
}
