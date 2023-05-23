package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selldo.Utility.ReusableUtils;

public class LeadBookingFormPage extends ReusableUtils {
	public WebDriver driver;

	public LeadBookingFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='+ add another']")
	private WebElement addAnotherLink;
	@FindBy(how = How.XPATH, using = "//a[text()='- remove']")
	private WebElement removeLink;
	@FindBy(how = How.NAME, using = "phone")
	private WebElement phoneNumber;
	@FindBy(how = How.XPATH, using = "//label[text()='Secondary booking name']/following::input[1]")
	private WebElement secondaryBookingNameField;
	@FindBy(how = How.XPATH, using = "//select[@name='stage']")
	private WebElement stageDropdown;
	@FindBy(how = How.XPATH, using = "(//span[text()='Select'])[1]")
	private WebElement projectDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement projectDropdownInputField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement project_dd;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']")
	private WebElement projectDropdown_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Floor number']/preceding::span[2]")
	private WebElement unitTypeDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement unitTypeInputField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[1]/div")
	private WebElement unitType_dd;
	@FindBy(how = How.XPATH, using = "//input[@name='floor_number']")
	private WebElement floorNumberField;
	@FindBy(how = How.XPATH, using = "//input[@name='unit_number']")
	private WebElement unitNumberField;
	@FindBy(how = How.XPATH, using = "//input[@name='building_name']")
	private WebElement buildingName;
	@FindBy(how = How.XPATH, using = "//input[@name='carpet_area']")
	private WebElement carpetAreaField;
	@FindBy(how = How.XPATH, using = "//input[@name='saleable_area']")
	private WebElement saleableAreaField;
	@FindBy(how = How.XPATH, using = "//label[text()='Parking number']/following::input[1]")
	private WebElement parkingNumberField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div")
	private WebElement parkingNumber_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Bedroom Preferences']/following::input[1]")
	private WebElement bedroomPreferencesDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div/span")
	private WebElement bedroomPreferences_dd;
	@FindBy(how = How.XPATH, using = "//input[@class='cancel_followups']")
	private WebElement cancelScheduledOrPendingFollowupOnThisLead_Checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='cancel_site_visits']")
	private WebElement cancelUnattendedSiteVisitsOnAllProjectsForThisLead_Checkbox;
	@FindBy(how = How.XPATH, using = "//input[@name='booking_date']")
	private WebElement bookingDate;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-bottom']//td")
	private List<WebElement> bookingDate_All;
	@FindBy(how = How.XPATH, using = "//input[@name='pan_number']")
	private WebElement panNumber;
	@FindBy(how = How.XPATH, using = "//input[@name='basic_rate']")
	private WebElement basicRateFeild;
	@FindBy(how = How.XPATH, using = "//input[@name='effective_rate']")
	private WebElement effectiveRate;
	@FindBy(how = How.XPATH, using = "//input[@name='offer']")
	private WebElement offerField;
	@FindBy(how = How.XPATH, using = "//select[@name='address_type']")
	private WebElement addressDropdown;
	@FindBy(how = How.XPATH, using = "//input[@name='address1']")
	private WebElement addressField;
	@FindBy(how = How.XPATH, using = "//input[@name='address2']")
	private WebElement streetField;
	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	private WebElement cityField;
	@FindBy(how = How.XPATH, using = "//select[@name='state']")
	private WebElement stateField;
	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	private WebElement countryDropdown;
	@FindBy(how = How.XPATH, using = "//input[@name='zip']")
	private WebElement zipField;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary dropdown-toggle']")
	private WebElement addCostDetailsDropdown;
	@FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu add_link cost_details']//li")
	private List<WebElement> addCDD_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Parking']")
	private WebElement parking;
	@FindBy(how = How.XPATH, using = "//label[text()='Parking']/following::input[@name='booking[cost_details][amount]']")
	private WebElement parking_a;
	@FindBy(how = How.XPATH, using = "//label[text()='Parking']/following::input[@name='booking[cost_details][remark]']")
	private WebElement parking_r;
	@FindBy(how = How.XPATH, using = "//label[text()='Premium']/following::input[1]")
	private WebElement premim_a;
	@FindBy(how = How.CSS, using = "#booking-detail-modal > div > div > div.modal-body.mt-4.booking_form > ul > li.show_lead_profile.nav-item")
	private WebElement costDetails;
	@FindBy(how = How.XPATH, using = "//span[text()='Select payment schedule']")
	private WebElement selectPaymentSchedule;
	@FindBy(how = How.XPATH, using = "//*[@id=\"select2-drop\"]/ul/li")
	private WebElement selectPaymentSchedule_dd;
	@FindBy(how = How.XPATH, using = "//button[@class='pull-right btn btn-primary save']/preceding::button[1]")
	private WebElement closeButton;
	@FindBy(how = How.XPATH, using = "//button[@class='pull-right btn btn-primary save save-booking-detail']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"booking-detail-modal\"]/div/div/div[2]/ul/li[1]/a")
	private WebElement basicDetails;
	@FindBy(how = How.XPATH, using = "//label[text()='Secondary booking name']")
	private WebElement secondaryBookingName;

	// Methods for searching User

	public void addingAndRemovingSecondaryBookingName(String bookingName) throws InterruptedException {
		waitUntilClickable(addAnotherLink).click();
		// Thread.sleep(2000);
		System.out.println("Started verification");
		Assert.assertEquals(secondaryBookingName.getText(), "Secondary booking name", "Not matched");
		System.out.println("Completed verification");
		waitUntilVisiblity(secondaryBookingNameField).sendKeys(bookingName);
		// Thread.sleep(2000);
		secondaryBookingNameField.clear();
		// Thread.sleep(2000);
		waitUntilClickable(removeLink).click();
	}

	public void selectStage(String bookingType) {
		selectByVisibleText(stageDropdown, "Confirmed");
	}

	public void addPhoneNumber(String phone) {
		waitUntilVisiblity(phoneNumber).sendKeys(phone);
	}

	public void selectProject(String project) {
		waitUntilClickable(projectDropdown).click();
		waitUntilVisiblity(projectDropdownInputField).sendKeys(project);
		waitUntilClickable(project_dd).click();
	}

	public void selectUnitType(String unit) {
		waitUntilClickable(unitTypeDropdown).click();
		waitUntilVisiblity(unitTypeInputField).sendKeys(unit);
		waitUntilClickable(unitType_dd).click();
	}

	public void inputFloorNumber(String floor) {
		waitUntilVisiblity(floorNumberField).sendKeys(floor);
	}

	public void inputUnitNumber(String unit) {
		waitUntilVisiblity(unitNumberField).sendKeys(unit);
	}

	public void inputBuildingName(String building) {
		waitUntilVisiblity(buildingName).sendKeys(building);
	}

	public void inputCarpetArea(String carpet) {
		waitUntilVisiblity(carpetAreaField).sendKeys(carpet);
	}

	public void inputSaleableArea(String saleable) {
		waitUntilVisiblity(saleableAreaField).sendKeys(saleable);
	}

	public void inputParkingNumber(String parking) {
		waitUntilVisiblity(parkingNumberField).sendKeys(parking);
		waitUntilClickable(parkingNumber_dd).click();
	}

	public void inputBedroomPreferences(String parking) {
		waitUntilVisiblity(bedroomPreferencesDropdown).sendKeys(parking);
		waitUntilClickable(bedroomPreferences_dd).click();
	}

	public void selectBookingDate() throws InterruptedException {
		waitUntilClickable(bookingDate).click();
		// Thread.sleep(2000);
		// It will store all web elements in List
		List<WebElement> dates = bookingDate_All;
		System.out.println("a");
		int total_node = dates.size();
		System.out.println("b");
		for (int i = 0; i < total_node; i++) {
			String date = dates.get(i).getText();
			System.out.println("c");
			if (date.equals("20")) {
				waitUntilClickable(dates.get(i)).click();// Clicking on date selected above
				break;
			}
		}
	}

	public void inputPanNumber(String pan) {
		waitUntilVisiblity(panNumber).sendKeys(pan);
	}

	public void inputBasicRate(String basicRate) {
		waitUntilVisiblity(basicRateFeild).sendKeys(basicRate);
	}

	public void inputEffectiveRate(String efectiveRate) {
		waitUntilVisiblity(effectiveRate).sendKeys(efectiveRate);
	}

	public void inputOffer(String offer) {
		waitUntilVisiblity(offerField).sendKeys(offer);
	}

	public void selectAddressType() {
		selectByVisibleText(addressDropdown, "Home");
	}

	public void inputAddressAndStreet(String address, String street) {
		waitUntilVisiblity(addressField).sendKeys(address);
		waitUntilVisiblity(streetField).sendKeys(street);
	}

	public void inputCityAndState(String city, String state) {
		waitUntilVisiblity(cityField).sendKeys(city);
		waitUntilVisiblity(stateField).sendKeys(state);
	}

	public void inputCountryAndZip(String zip) {
		selectByVisibleText(countryDropdown, "India");
		waitUntilVisiblity(zipField).sendKeys(zip);
	}

	public void addingParkingCost(String par_a, String par_r) {
		waitUntilClickable(addCostDetailsDropdown).click();
		List<WebElement> list = addCDD_All;

		for (WebElement ele : list) {
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Parking

			if (ele.getAttribute("innerHTML").contains("Parking")) {

				// if yes then click on link
				waitUntilClickable(ele).click();

				System.out.println("Clicked on Parking");

				// break the loop or come out of loop

				break;
			}
		}
		waitUntilVisiblity(parking_a).sendKeys(par_a);
		waitUntilVisiblity(parking_r).sendKeys(par_r);
	}

	public void addingPremiumCost(String pre_a, String pre_r) {
		waitUntilClickable(addCostDetailsDropdown).click();
		List<WebElement> list = addCDD_All;

		for (WebElement ele : list) {
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Premium

			if (ele.getAttribute("innerHTML").contains("Premium")) {

				// if yes then click on link
				waitUntilClickable(ele).click();

				System.out.println("Clicked on Premium");

				// break the loop or come out of loop

				break;
			}
		}

	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

	public void addingCostDetails() {
		waitUntilClickable(costDetails).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(selectPaymentSchedule);
		actions.click().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.moveToElement(selectPaymentSchedule_dd);
		actions.click().perform();

	}

	public void clickBasicDetails() {
		waitUntilClickable(basicDetails).click();
	}
}
