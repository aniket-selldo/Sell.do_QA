package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.AddLeadFormPage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;
import com.selldo.Utility.GetTestData;

public class AddingNewLeadTest extends BaseTest {

	@Test
	public void addingNewLeadTest() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name"), prop.getProperty("password"));

		GetTestData getTestData = new GetTestData();

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		extentTest.get().log(Status.INFO, "Clicking on New Lead.......");
		salesPresalesDashboard.selectLeadActions(3);

		AddLeadFormPage addLeadForm = new AddLeadFormPage(driver);

		extentTest.get().log(Status.INFO, "Taking First Name.......");
		String firstNameObj = getTestData.firstName;
		System.out.println(firstNameObj);
		addLeadForm.inputFirstName(firstNameObj);

		//Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Taking Last Name.......");
		String lastNameObj = getTestData.lastName;
		addLeadForm.inputLastName(lastNameObj);

		extentTest.get().log(Status.INFO, "Taking Primary Email.......");
		addLeadForm.inputPrimaryEmail(getTestData.email);

		extentTest.get().log(Status.INFO, "Taking Primary Phone.......");
		addLeadForm.inputPrimaryPhone(" " + getTestData.phoneNumber);

		/* extentTest.get().log(Status.INFO, "Selecting Lead Stage.......");
		addLeadForm.selectLeadStageNewLead(); */
		
		extentTest.get().log(Status.INFO, "Selecting Project.......");
		addLeadForm.selectProject();
		addLeadForm.selectLeadStageNewLead("Incoming");
		extentTest.get().log(Status.INFO, "Clicking on Save button.......");
		addLeadForm.clickOnSaveButton();

		extentTest.get().log(Status.INFO, "Verifying Lead creation.......");
		System.out.println("Started verification");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@name='first_name']")).getText(),
				firstNameObj + " " + lastNameObj, "Not matched");
		System.out.println("Completed verification");

	}
}
