package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.AddLeadFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class AddingNewLeadWithFilledForm_PresalesTest extends BaseTest {

	@Test
	public void addingNewLeadWithFilledForm_PresalesTest() throws Exception {

//		test = extent.createTest("addingNewLeadWithFilledForm_PresalesTest");
//		setExtentTest(test);
		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+pre02@sell.do", "amura@123");
		GetTestData getTestData = new GetTestData();

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on New Lead.......");
		salesPresalesDashboard.selectLeadActions(3);

		AddLeadFormPage addLeadForm = new AddLeadFormPage(driver);
		
		////Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Taking First Name.......");
		String firstNameObj = getTestData.firstName;
		addLeadForm.inputFirstName(firstNameObj);

		////Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Taking Last Name.......");
		String lastNameObj = getTestData.lastName;
		addLeadForm.inputLastName(lastNameObj);

		extentTest.get().log(Status.INFO, "Taking Primary Email.......");
		addLeadForm.inputPrimaryEmail(getTestData.email);

		extentTest.get().log(Status.INFO, "Taking Primary Phone.......");
		addLeadForm.inputPrimaryPhone(" " + getTestData.phoneNumber);

		////Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Selecting Interested project.......");
		// addLeadForm.selectingProjectsOfInterest();

		extentTest.get().log(Status.INFO, "Selecting Lead Stage.......");
		addLeadForm.selectLeadStage("Incoming");

		extentTest.get().log(Status.INFO, "Selecting Team from dropdown.......");
		// addLeadForm.selectTeam(property.getProperty("Team_addingNewLeadWithFilledForm_SalesTest"));

		extentTest.get().log(Status.INFO, "Selecting Campaign from dropdown.......");
		addLeadForm.selectCampaign("Walkin");

		extentTest.get().log(Status.INFO, "Selecting source from dropdown.......");
		addLeadForm.selectSource();

		extentTest.get().log(Status.INFO, "Selecting Project.......");
		addLeadForm.selectProject();

		extentTest.get().log(Status.INFO, "Taking Address.......");
		addLeadForm.inputAddress(getTestData.address);

		extentTest.get().log(Status.INFO, "Taking Street.......");
		addLeadForm.inputStreet(getTestData.street);

		extentTest.get().log(Status.INFO, "Taking City.......");
		addLeadForm.inputCity(getTestData.city);

		extentTest.get().log(Status.INFO, "Taking State.......");
		addLeadForm.inputState(getTestData.state);

		extentTest.get().log(Status.INFO, "Taking Zip.......");
		addLeadForm.inputZip(getTestData.zip);

		extentTest.get().log(Status.INFO, "Taking minimum and maximum budget.......");
		addLeadForm.inputBudget(getTestData.minBudget, getTestData.maxBudget);

		extentTest.get().log(Status.INFO, "Selecting minimum and maximum possession.......");
		addLeadForm.selectPossession();

		extentTest.get().log(Status.INFO, "Selecting Property types.......");
		addLeadForm.selectPropertyTypes();

		extentTest.get().log(Status.INFO, "Selecting Bedroom preferences.......");
		addLeadForm.selectBedroomPreferences();

		extentTest.get().log(Status.INFO, "Taking Location preferences.......");
		// addLeadForm.inputLocatioPreferences(property.getProperty("LocationPreferences_addingNewLeadWithFilledForm_PresalesTest"));

		extentTest.get().log(Status.INFO, "Clicking on Save button.......");
		addLeadForm.clickOnSaveButton();

		//Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Verifying Lead creation.......");
		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@name='first_name']")).getText(),
				firstNameObj + " " + lastNameObj, "Not matched");
		System.out.println("Completed verification");
	}

}
