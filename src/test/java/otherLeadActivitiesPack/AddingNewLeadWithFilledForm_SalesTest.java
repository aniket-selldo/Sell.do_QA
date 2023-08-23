package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.AddLeadFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class AddingNewLeadWithFilledForm_SalesTest extends BaseTest {

	@Test
	public void addingNewLeadWithFilledForm_SalesTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		login.login(prop("Sales_email"), prop("Password"));
		GetTestData getTestData = new GetTestData();

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		salesPresalesDashboard.selectLeadActions(3);

		AddLeadFormPage addLeadForm = new AddLeadFormPage(driver);

		String firstNameObj = getTestData.firstName;
		addLeadForm.inputFirstName(firstNameObj);

		String lastNameObj = getTestData.lastName;
		addLeadForm.inputLastName(lastNameObj);

		addLeadForm.inputPrimaryEmail(getTestData.email);

		addLeadForm.inputPrimaryPhone(" " + getTestData.phoneNumber);

		addLeadForm.selectLeadStage("Incoming");

		addLeadForm.selectCampaign("Walkin");

		addLeadForm.selectSource();

		addLeadForm.selectProject();

		addLeadForm.inputAddress(getTestData.address);

		addLeadForm.inputStreet(getTestData.street);

		addLeadForm.inputCity(getTestData.city);

		addLeadForm.inputState(getTestData.state);

		addLeadForm.inputZip(getTestData.zip);

		addLeadForm.inputBudget(getTestData.minBudget, getTestData.maxBudget);

		addLeadForm.selectPossession();

		addLeadForm.selectPropertyTypes();

		addLeadForm.selectBedroomPreferences();

		addLeadForm.inputLocatioPreferences(getTestData.locationPreference);

		addLeadForm.clickOnSaveButton();

		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@name='first_name']")).getText(),
				firstNameObj + " " + lastNameObj, "Not matched");
		System.out.println("Completed verification");
	}
}
