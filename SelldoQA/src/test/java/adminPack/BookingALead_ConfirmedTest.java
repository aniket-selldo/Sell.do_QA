package adminPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import inventory.AddingNewUnitTest;

public class BookingALead_ConfirmedTest extends BaseTest {

//	@BeforeTest //
//
//	public void appLogin() throws Exception {
//
//		// Add new unit before booking a lead
//		AddingNewUnitTest addingNewUnitTest = new AddingNewUnitTest();
//
//		addingNewUnitTest.sales_presalesLogin();
//
//		addingNewUnitTest.addingNewUnitTest();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		addingNewUnitTest.endingTest();
//	}
s
	@Test
	public void bookingALead_ConfirmedTest() throws Exception {

		AddingNewUnitTest addingNewUnitTest = new AddingNewUnitTest();

		addingNewUnitTest.addingNewUnitTest();

		addingNewUnitTest.endingTest();
	

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		LoginPage login = new LoginPage(driver);

		login.login(prop.getProperty("name") + "+" + prop.getProperty("user_email_bookingALead_ConfirmedTest"),
				prop.getProperty("password"));

		extentTest.get().log(Status.INFO, "Clicking on All Leads.......");
		salesPresalesDashboard.goToAllLeadsList();

		extentTest.get().log(Status.INFO, "Selecting Booked list......");
		salesPresalesDashboard.SelectList("Opportunity");

		extentTest.get().log(Status.INFO, "Opening Lead Details page of a lead under Booked stage......");
		salesPresalesDashboard.openLeadDetails(1);

		extentTest.get().log(Status.INFO, "Getting Lead Id whose stage is to be changed.......");
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println("Lead ID-" + leadIdObj);

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Adding Inventory of a project.......");
		leadProfilePage.addingInventory();

		jse.executeScript("window.scrollBy(0,-300)", "");

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Changing filter...........");
		leadProfilePage.changeFilters();

		extentTest.get().log(Status.INFO, "Selecting unit to be booked.......");
		leadProfilePage.selectingUnit();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Marking Booked from the dropdown options.......");
		leadProfilePage.bookingUnit();

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);

		extentTest.get().log(Status.INFO, "Adding Cost Details.......");
		leadBooking.addingCostDetails();

		extentTest.get().log(Status.INFO, "Clicking Basic Details.........");
		leadBooking.clickBasicDetails();

		extentTest.get().log(Status.INFO, "Adding and removing secondary booking name.......");
		leadBooking.addingAndRemovingSecondaryBookingName(prop.getProperty("SecondaryBookingName_BookingALead"));

		Thread.sleep(3000);

		jse.executeScript("window.scrollBy(0,250)", "");

		extentTest.get().log(Status.INFO, "Selecting stage as Confirmed.......");
		leadBooking.selectStage(prop.getProperty("Confirm_Booking"));

		extentTest.get().log(Status.INFO, "Taking Floor number.......");
		leadBooking.inputFloorNumber(prop.getProperty("FloorNumber_BookingALead"));

		extentTest.get().log(Status.INFO, "Taking Building name.......");
		leadBooking.inputBuildingName(prop.getProperty("BuildingName_BookingALead"));

		extentTest.get().log(Status.INFO, "Taking Carpet area.......");
		leadBooking.inputCarpetArea(prop.getProperty("CarpetArea_BookingALead"));

		extentTest.get().log(Status.INFO, "Taking Saleable area.......");
		leadBooking.inputSaleableArea(prop.getProperty("SaleableArea_BookingALead"));

		extentTest.get().log(Status.INFO, "Taking Parking number.......");
		leadBooking.inputParkingNumber(prop.getProperty("ParkingNumber_BookingALead"));

		extentTest.get().log(Status.INFO, "Selecting Bedroom preferences.......");
		leadBooking.inputBedroomPreferences(prop.getProperty("BedroomPreferences_BookingALead"));

		extentTest.get().log(Status.INFO, "Selecting Pan Number.......");
		leadBooking.inputPanNumber(prop.getProperty("PanNumber_BookingALead"));

		extentTest.get().log(Status.INFO, "Selecting Address and Street.......");
		leadBooking.inputAddressAndStreet(prop.getProperty("Address_BookingALead"),
				prop.getProperty("Street_BookingALead"));

		extentTest.get().log(Status.INFO, "Selecting City and State.......");
		leadBooking.inputCityAndState(prop.getProperty("City_BookingALead"),
				prop.getProperty("State_BookingALead"));

		extentTest.get().log(Status.INFO, "Selecting Country and Zip.......");
		leadBooking.inputCountryAndZip(prop.getProperty("Zip_BookingALead"));

		extentTest.get().log(Status.INFO, "Clicking on Save button............");
		leadBooking.clickOnSaveButton();

		Thread.sleep(4000);

		extentTest.get().log(Status.INFO, "Selecting Bookings from more options.......");
		leadProfilePage.selectBookings();

		Thread.sleep(2000);

		extentTest.get().log(Status.INFO, "Validating Stage of Booking.......");

		System.out.println("Started verification");
		String stage = driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText();
		System.out.println("Booking Stage-" + stage);
		Assert.assertEquals(stage, "confirmed", "Not matched");

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Validating 'Add new Booking' button is present..........");
		String addNewBookingButton = driver.findElement(By.xpath("//button[@class='btn btn-default add_booking_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + addNewBookingButton);
		Assert.assertEquals(addNewBookingButton, "add new booking", "Not matched");

		Thread.sleep(1000);

		extentTest.get().log(Status.INFO, "Validating 'Close' button is present..........");
		String closeButton = driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + closeButton);
		Assert.assertEquals(closeButton, "close", "Not matched");

		System.out.println("Completed verification");

		extentTest.get().log(Status.INFO, "Clicking on Close button of Booking details page.......");
		leadProfilePage.clickOnCloseButton_Bookingdetails();

		Thread.sleep(3000);

		extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		salesPresalesDashboard.searchLead(leadIdObj);

		extentTest.get().log(Status.INFO, "Verifying stage changed from Incoming to Prospect.......");
		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println("Stage changed-" + textDropdownObj);
		Assert.assertEquals(textDropdownObj, "Booked", "Not matched");

	}
}
