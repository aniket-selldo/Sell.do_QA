package otherLeadActivitiesPack;

import org.openqa.selenium.By;
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
	/*
	 * final static Logger logger = Logger.getLogger(AddingNewLeadTest.class);
	 * 
	 * // Description: Adding a new lead by filling only mandatory fields of Add //
	 * Lead form
	 * 
	 * @BeforeTest
	 * 
	 * public void appLogin() throws Exception {
	 * 
	 * mysetUp();
	 * 
	 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 * 
	 * Properties property = new Properties(); FileInputStream fileInputObj = new
	 * FileInputStream( System.getProperty("user.dir") +
	 * "//src//main//java//Config File//global.properties");
	 * property.load(fileInputObj);
	 * 
	 * LoginPage login = new LoginPage(driver); logger.info("Logging in.......");
	 * login.login(property.getProperty("name") + "+" +
	 * property.getProperty("user_email_addingNewLeadTest"),
	 * property.getProperty("password"));
	 * 
	 * }
	 * 
	 * @AfterTest
	 * 
	 * public void endingTest() throws Exception {
	 * 
	 * Thread.sleep(3000);
	 * 
	 * AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
	 * 
	 * logger.info("Logging out of Selldo......"); adminDashboardPage.loggingOut();
	 * 
	 * logger.info("Closing Browser......"); driver.close(); }
	 */

	@Test

	public void addingNewLeadTest() throws Exception {

		/*
		 * test = extent.createTest("addingNewLeadTest"); setExtentTest(test);
		 */
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
		SoftAssert assertion = new SoftAssert();
		System.out.println("Started verification");
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//span[@name='first_name']")).getText(),
				firstNameObj + " " + lastNameObj, "Not matched");
		System.out.println("Completed verification");
		assertion.assertAll();

	}
}
