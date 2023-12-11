package adminPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class BookingALead_TentativeTest extends BaseTest {

	/*
	 * final static Logger logger =
	 * Logger.getLogger(BookingALead_TentativeTest.class);
	 * 
	 * // Description: Booking a lead by marking booked from opportunity and //
	 * filling the booking form
	 * 
	 * @BeforeTest
	 * 
	 * public void appLogin() throws Exception {
	 * 
	 * // Add new unit before booking a lead AddingNewUnitTest addingNewUnitTest =
	 * new AddingNewUnitTest();
	 * 
	 * logger.info("Logging into client page............");
	 * addingNewUnitTest.sales_presalesLogin();
	 * 
	 * logger.info("Adding new unit..........");
	 * addingNewUnitTest.addingNewUnitTest(); try { Thread.sleep(2000); } catch
	 * (InterruptedException e) { e.printStackTrace(); }
	 * 
	 * logger.info("Logging out with this user..........");
	 * addingNewUnitTest.endingTest(); }
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
	 * 
	 * logger.info("Closing Browser......"); driver.close(); }
	 */
	@Test

	public void bookingALead_TentativeTest() throws Exception {

		LoginPage login = new LoginPage(driver);
		//login.login(prop.getProperty("AniketAdmin"), prop.getProperty("password"));

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		login.login(prop("Sales_email"), prop("Password"));

		salesPresalesDashboard.goToAllLeadsList();

		salesPresalesDashboard.SelectList("Opportunity");
		
		salesPresalesDashboard.clearAllFilter();

		salesPresalesDashboard.openLeadDetails(1);

		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		Thread.sleep(4000);

		jse.executeScript("window.scrollBy(0,250)", "");

		leadProfilePage.addingInventory();

		jse.executeScript("window.scrollBy(0,-250)", "");

		Thread.sleep(2000);

		leadProfilePage.changeFilters();

		leadProfilePage.selectingUnit();

		Thread.sleep(2000);

		leadProfilePage.bookingUnit();

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);

		leadBooking.addingCostDetails();

		leadBooking.clickBasicDetails();

		leadBooking.addingAndRemovingSecondaryBookingName("ac");

		Thread.sleep(3000);

		jse.executeScript("window.scrollBy(0,250)", "");

		leadBooking.inputFloorNumber("3");

		leadBooking.inputBuildingName("sd");

		leadBooking.inputCarpetArea("12");

		leadBooking.inputSaleableArea("23");

		leadBooking.inputParkingNumber("34");

		leadBooking.inputBedroomPreferences("2");

		leadBooking.inputPanNumber("EXZPL1234J");

		leadBooking.inputAddressAndStreet("sd","sf");

		leadBooking.inputCityAndState("Pune","Pune");

		leadBooking.inputCountryAndZip("414003");

		leadBooking.clickOnSaveButton();

		Thread.sleep(4000);

		leadProfilePage.selectBookings();

		Thread.sleep(2000);

		System.out.println("Started verification");
		String status = driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText().toLowerCase();
		Assert.assertEquals(status, "tentative", "Not matched");
		System.out.println("Booking status-" + status);

		Assert.assertEquals(driver.findElement(By.xpath("//button[text()='Add new Booking']")).getText(),
				"Add new Booking", "Not matched");

		Assert.assertEquals(driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']"))
				.getText().toLowerCase(), "close", "Not matched");
		System.out.println("Completed verification");

		leadProfilePage.clickOnCloseButton_Bookingdetails();

		Thread.sleep(3000);

		salesPresalesDashboard.searchLead(leadIdObj);

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println(textDropdownObj);

		Assert.assertEquals(textDropdownObj, "Booked", "Not matched");

	}
}
