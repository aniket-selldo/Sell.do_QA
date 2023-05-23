package otherLeadActivitiesPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

public class LeadBooking_NonInventory_ConfirmedTest extends BaseTest {
	
	@Test 
	public void bookingALead_ConfirmedTest() throws Exception {
	

		LoginPage login = new LoginPage(driver);
		login.login("aniket.khandizod+pre02@sell.do", prop.getProperty("password"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		//extentTest.get().log(Status.INFO, "Clicking on All Leads.......");
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		adminDashboardPage.searchLead(Integer.parseInt(R('0','1', '2', '3', '4', '5', '6', '7', '8', '9')), "Incoming");

		//extentTest.get().log(Status.INFO, "Getting Lead Id whose stage is to be changed.......");
		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println(leadIdObj);

		//extentTest.get().log(Status.INFO, "Changing stage from Opportunity to Booked.......");
		leadProfilePage.changing_Stage("Booked");

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);
		//getExtTest().log(Status.INFO, "Selecting Project....");
		leadBooking.selectProject("Mamta Building");
		//extentTest.get().log(Status.INFO, "Adding Phone Number.......");
		leadBooking.addPhoneNumber(prop.getProperty("Applicant_Phone_Number"));

		jse.executeScript("window.scrollBy(0,250)", "");

		//extentTest.get().log(Status.INFO, "Selecting stage as Confirmed.......");
		leadBooking.selectStage(prop.getProperty("Confirm_Booking"));

	

		//extentTest.get().log(Status.INFO, "Selecting Unit Type from drop.......");
		leadBooking.selectUnitType(prop.getProperty("UnitType_BookingALead"));

		//extentTest.get().log(Status.INFO, "Taking Floor number.......");
		leadBooking.inputFloorNumber(prop.getProperty("FloorNumber_BookingALead"));

		//extentTest.get().log(Status.INFO, "Taking Unit number.......");
		leadBooking.inputUnitNumber(prop.getProperty("UnitNumber_BookingALead"));

		//extentTest.get().log(Status.INFO, "Taking Building name.......");
		leadBooking.inputBuildingName(prop.getProperty("BuildingName_BookingALead"));

		//extentTest.get().log(Status.INFO, "Taking Carpet area.......");
		leadBooking.inputCarpetArea(prop.getProperty("CarpetArea_BookingALead"));

		//extentTest.get().log(Status.INFO, "Taking Saleable area.......");
		leadBooking.inputSaleableArea(prop.getProperty("SaleableArea_BookingALead"));

		//extentTest.get().log(Status.INFO, "Taking Parking number.......");
		leadBooking.inputParkingNumber(prop.getProperty("ParkingNumber_BookingALead"));

		//extentTest.get().log(Status.INFO, "Selecting Bedroom preferences.......");
		leadBooking.inputBedroomPreferences(prop.getProperty("BedroomPreferences_BookingALead"));

		// logger.info("Selecting Booking date.......");
		// leadBooking.selectBookingDate();

		//extentTest.get().log(Status.INFO, "Selecting Pan Number.......");
		leadBooking.inputPanNumber(prop.getProperty("PanNumber_BookingALead"));

		//extentTest.get().log(Status.INFO, "Input Basic rate.......");
		leadBooking.inputBasicRate(prop.getProperty("BasicRate_BookingALead"));

		//extentTest.get().log(Status.INFO, "Input Effective rate.......");
		leadBooking.inputEffectiveRate(prop.getProperty("EffectiveRate_BookingALead"));

		//extentTest.get().log(Status.INFO, "Input offer.........");
		leadBooking.inputOffer(prop.getProperty("InputOffer_BookingALead"));

		//extentTest.get().log(Status.INFO, "Selecting Address and Street.......");
		leadBooking.inputAddressAndStreet(prop.getProperty("Address_BookingALead"),
				prop.getProperty("Street_BookingALead"));

		//extentTest.get().log(Status.INFO, "Selecting City and State.......");
		leadBooking.inputCityAndState(prop.getProperty("City_BookingALead"), prop.getProperty("State_BookingALead"));

		//extentTest.get().log(Status.INFO, "Selecting Country and Zip.......");
		leadBooking.inputCountryAndZip(prop.getProperty("Zip_BookingALead"));

		/*
		 * //getExtTest().log(Status.INFO, "Adding Parking Cost.......");
		 * leadBooking.addingParkingCost(property.getProperty(
		 * "ParkingAmount_BookingALead"),property.getProperty(
		 * "ParkingRemark_BookingALead"));
		 */

		/*
		 * //getExtTest().log(Status.INFO, "Adding Cost Details.......");
		 * leadBooking.addingCostDetails();
		 */

		//extentTest.get().log(Status.INFO, "Clicking on Save button............");
		leadBooking.clickOnSaveButton();

		// Thread.sleep(4000);

		//extentTest.get().log(Status.INFO, "Selecting Bookings from more.......");
		leadProfilePage.selectBookings();

		// Thread.sleep(2000);

		//extentTest.get().log(Status.INFO, "Validating Booking.......");
		System.out.println("Started verification");
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText(), "confirmed",
				"Not matched");
		AssertJUnit.assertEquals(driver.findElement(By.xpath("//button[text()='Add new Booking']")).getText(),
				"Add new Booking", "Not matched");
		AssertJUnit.assertEquals(
				driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']")).getText(),
				"Close", "Not matched");
		System.out.println("Completed verification");

		// Thread.sleep(1000);

		//extentTest.get().log(Status.INFO, "Clicking on Close button of Booking details page.......");
		leadProfilePage.clickOnCloseButton_Bookingdetails();

		// Thread.sleep(3000);

		//extentTest.get().log(Status.INFO, "Searching lead by Id.......");
		salesPresalesDashboard.searchLead(leadIdObj);

		//extentTest.get().log(Status.INFO, "Verifying stage changed from Opportunity to Booked.......");

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println(textDropdownObj);

		AssertJUnit.assertEquals(textDropdownObj, "Booked", "Not matched");

	}

}
