package adminPack;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.Utility.BaseTest;

import inventory.AddingNewUnitTest;

public class BookingALead_ConfirmedTest extends BaseTest {

	@Test
	public void bookingALead_ConfirmedTest() throws Exception {

		//client.logout();
//		LoginPage login = new LoginPage(driver);
//		login.login(prop.getProperty("superadmin_name") + prop.getProperty("superadmin_email"),
//				prop.getProperty("password"));
//		ClientLoginPage clientLogin = new ClientLoginPage(driver);
//		clientLogin.clientLogin(prop.getProperty("client_name"));
//		AddingNewUnitTest addingNewUnitTest = new AddingNewUnitTest();
//		addingNewUnitTest.addingNewUnitTest();
//		addingNewUnitTest.endingTest();
//
//		System.out.println("==============================");
//		
//
//
//		
//
//		addingNewUnitTest.sales_presalesLogin();
		SoftAssert assertion = new SoftAssert();
		LoginPage login = new LoginPage(driver);
		login.login(prop.getProperty("name") + "+" + prop.getProperty("user_email_bookingALead_ConfirmedTest"),
				prop.getProperty("password"));
		
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);
		salesPresalesDashboard.goToAllLeadsList();
		salesPresalesDashboard.SelectList("Opportunity");
		salesPresalesDashboard.openLeadDetails();

		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println("Lead ID-" + leadIdObj);
		
		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);
		leadProfilePage.addingInventory();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-300)", "");

		leadProfilePage.changeFilters();

		leadProfilePage.selectingUnit();

		leadProfilePage.bookingUnit();

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);

		leadBooking.addingCostDetails();

		leadBooking.clickBasicDetails();

		leadBooking.addingAndRemovingSecondaryBookingName(prop.getProperty("SecondaryBookingName_BookingALead"));

		jse.executeScript("window.scrollBy(0,250)", "");

		leadBooking.selectStage(prop.getProperty("Confirm_Booking"));

		leadBooking.inputFloorNumber(prop.getProperty("FloorNumber_BookingALead"));

		leadBooking.inputBuildingName(prop.getProperty("BuildingName_BookingALead"));

		leadBooking.inputCarpetArea(prop.getProperty("CarpetArea_BookingALead"));

		leadBooking.inputSaleableArea(prop.getProperty("SaleableArea_BookingALead"));

		leadBooking.inputParkingNumber(prop.getProperty("ParkingNumber_BookingALead"));

		leadBooking.inputBedroomPreferences(prop.getProperty("BedroomPreferences_BookingALead"));

		leadBooking.inputPanNumber(prop.getProperty("PanNumber_BookingALead"));

		leadBooking.inputAddressAndStreet(prop.getProperty("Address_BookingALead"),
				prop.getProperty("Street_BookingALead"));

		leadBooking.inputCityAndState(prop.getProperty("City_BookingALead"),
				prop.getProperty("State_BookingALead"));

		leadBooking.inputCountryAndZip(prop.getProperty("Zip_BookingALead"));

		leadBooking.clickOnSaveButton();

		leadProfilePage.selectBookings();

		System.out.println("Started verification");
		String stage = driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText();
		System.out.println("Booking Stage-" + stage);
		AssertJUnit.assertEquals(stage, "confirmed", "Not matched");

		String addNewBookingButton = driver.findElement(By.xpath("//button[@class='btn btn-default add_booking_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + addNewBookingButton);
		AssertJUnit.assertEquals(addNewBookingButton, "add new booking", "Not matched");

		String closeButton = driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + closeButton);
		AssertJUnit.assertEquals(closeButton, "close", "Not matched");

		System.out.println("Completed verification");

		leadProfilePage.clickOnCloseButton_Bookingdetails();

		salesPresalesDashboard.searchLead(leadIdObj);

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println("Stage changed-" + textDropdownObj);
		AssertJUnit.assertEquals(textDropdownObj, "Booked", "Not matched");

		assertion.assertAll();
	}
}
