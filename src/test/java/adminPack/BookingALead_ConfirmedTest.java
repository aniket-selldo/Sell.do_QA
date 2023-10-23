package adminPack;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadBookingFormPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.POM.crm.SalesPresalesDashboardPage;
import com.selldo.POM.inventory.NewUnitFormPage;
import com.selldo.POM.inventory.UnitsPage;
import com.selldo.Utility.BaseTest;

import API.APIs;
import API.UpdateLead_Project_Stage;
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

	@Test
	public void bookingALead_ConfirmedTest() throws Exception {

		AddingNewUnitTest addingNewUnitTest = new AddingNewUnitTest();
		SalesPresalesDashboardPage salesPresalesDashboard = new SalesPresalesDashboardPage(driver);

		String s = new UpdateLead_Project_Stage().CreateUpdateProjectAndStageOfLead("prospect",2);
	//	driver.get(System.getProperty("user.dir") + "/users/logout");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		LeadProfilePage leadProfilePage = new LeadProfilePage(driver);

		LoginPage login = new LoginPage(driver);

		login.login(prop("Sales_email"), prop("Password"));

		salesPresalesDashboard.searchLead(s);

		String leadIdObj = driver.findElement(By.cssSelector("span[name='lead_id']")).getText().replaceAll("\\s+", "");
		System.out.println("Lead ID-" + leadIdObj);

		Thread.sleep(1000);

		leadProfilePage.addingInventory();

		jse.executeScript("window.scrollBy(0,-300)", "");

		Thread.sleep(2000);

		leadProfilePage.changeFilters();

		leadProfilePage.selectingUnit();

		Thread.sleep(2000);

		leadProfilePage.bookingUnit();

		LeadBookingFormPage leadBooking = new LeadBookingFormPage(driver);

		leadBooking.addingCostDetails();

		leadBooking.clickBasicDetails();

		leadBooking.addingAndRemovingSecondaryBookingName("asd");

		Thread.sleep(3000);

		jse.executeScript("window.scrollBy(0,250)", "");

		leadBooking.selectStage("Tentetive");

		leadBooking.inputFloorNumber("5");

		leadBooking.inputBuildingName("Name Bu");

		leadBooking.inputCarpetArea("100");

		leadBooking.inputSaleableArea("100");

		leadBooking.inputParkingNumber("2");

		leadBooking.inputBedroomPreferences("3");

		leadBooking.inputPanNumber("ASERT1234E");

		leadBooking.inputAddressAndStreet("Ahmednager", "Pune");

		leadBooking.inputCityAndState("Pune", "Maharashtra");

		leadBooking.inputCountryAndZip("414003");

		leadBooking.clickOnSaveButton();

		Thread.sleep(4000);

		leadProfilePage.selectBookings();

		Thread.sleep(2000);

		System.out.println("Started verification");
		String stage = driver.findElement(By.xpath("//span[@class='badge badge-success']")).getText();
		System.out.println("Booking Stage-" + stage);
		Assert.assertEquals(stage, "confirmed", "Not matched");

		Thread.sleep(1000);

		String addNewBookingButton = driver.findElement(By.xpath("//button[@class='btn btn-default add_booking_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + addNewBookingButton);
		Assert.assertEquals(addNewBookingButton, "add new booking", "Not matched");

		Thread.sleep(1000);

		String closeButton = driver.findElement(By.xpath("//button[@class='btn btn-default close_profile_form']"))
				.getText().toLowerCase();
		System.out.println("Button text-" + closeButton);
		Assert.assertEquals(closeButton, "close", "Not matched");

		System.out.println("Completed verification");

		leadProfilePage.clickOnCloseButton_Bookingdetails();

		Thread.sleep(3000);

		salesPresalesDashboard.searchLead(leadIdObj);

		String textDropdownObj = driver
				.findElement(By.xpath("//button[@class='btn dropdown-toggle btn-sm btn-outline-primary']//span"))
				.getAttribute("innerHTML").trim();
		System.out.println("Stage changed-" + textDropdownObj);
		Assert.assertEquals(textDropdownObj, "Booked", "Not matched");

	}

	public void addNewUnit() throws Exception {
		LoginPage login = new LoginPage(driver);
		login.login(prop("Admin_id"), prop("Password"));

		ClientLoginPage clientLogin = new ClientLoginPage(driver);

		clientLogin.clientLogin(prop("Client_Name"));

		UnitsPage unitsPage = new UnitsPage(driver);
		NewUnitFormPage newUnitFormPage = new NewUnitFormPage(driver);

		WebElement element = driver.findElement(By.cssSelector("i.ion-cube"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.linkText("Units")).click();

		unitsPage.clickOnNewUnitButton();

		newUnitFormPage.enterDeveloperName("Aniket");

		newUnitFormPage.enterProjectName("Aniket Project 02");

		newUnitFormPage.enterProjectTowerName("su");

		newUnitFormPage.enterFloorPlanName("Floor Plan");

		String unitName = Random("A", 10).toUpperCase();

		newUnitFormPage.enterUnitName(unitName);

		newUnitFormPage.enterNumberOfFloors("7");

		newUnitFormPage.enterUnitBaseRate(Random("N", 10));

		newUnitFormPage.selectNumberOfBedrooms();

		newUnitFormPage.selectNumberOfBathrooms();

		newUnitFormPage.selectCategory();

		newUnitFormPage.selectType();

		newUnitFormPage.enterSaleableArea(Random("N", 10));

		newUnitFormPage.enterCarpetArea(Random("N", 10));

		newUnitFormPage.enterNumberOfFloors(Random("N", 1));

		newUnitFormPage.clickOnSaveButton();
	}



	public void mmm3() {
//		String s = new APIs().GetAllDevloperID()[2].get_id();
//		System.out.println(s);
//
//		String ss = new GetAllProjectIDAndName().getAllProjectID(1).get(0);
//		System.out.println(ss);
//		
//		String sss = new APIs().getAllProjectTowerID()[2].get_id();
//		System.out.println(sss);
//		
//		String ssss = new APIs().GetAllUnitConfigurationID()[0].get_id();
//		System.out.println(ssss);
		
		String sssss = new APIs().addUnit();
		System.out.println(sssss);
	}
}
