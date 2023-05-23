package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class AddLeadFormPage extends ReusableUtils {

	public WebDriver driver;

	public AddLeadFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#lead_profile > div > div > div.modal-body.mt-4 > form > ul > li:nth-child(1) > a")
	private WebElement BasicProfileTab;
	@FindBy(how = How.NAME, using = "first_name")
	private WebElement FistNameField;
	@FindBy(how = How.NAME, using = "last_name")
	private WebElement LastNameField;
	@FindBy(how = How.NAME, using = "primary_email_email")
	private WebElement PrimaryEmail;
	@FindBy(how = How.NAME, using = "primary_phone_ph_number")
	private WebElement PrimaryPhone;
	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-12 col-lg-12']//ul[@class='select2-choices']")
	private WebElement ScheduleAndConductSiteVisitForProjectField;
	@FindBy(how = How.XPATH, using = "//span[text()='Lead Stage']")
	private WebElement NewLeadCreationLeadStage;
	@FindBy(how = How.XPATH, using = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")
	private List<WebElement> NewLeadStage;
	@FindBy(how = How.CSS, using = "div.select2-drop.select2-drop-multi.select2-display-none.select2-drop-active ul li")
	private List<WebElement> Project_dd;
	@FindBy(how = How.XPATH, using = ".//*[@id='basic_info']/div/div[1]/div[1]/div[1]/")
	private WebElement Salutation;
	@FindBy(how = How.XPATH, using = "//label[text()='Primary Email']/following::a[1]")
	private WebElement addAnotherLink_pe;
	@FindBy(how = How.XPATH, using = "//label[text()='Secondary Email']/following::a[1]")
	private WebElement removeAnotherLink_se;
	@FindBy(how = How.XPATH, using = "//label[text()='Primary Phone']/following::a[1]")
	private WebElement addAnotherLink_pp;
	@FindBy(how = How.XPATH, using = "//label[text()='Secondary Phone']/following::a[1]")
	private WebElement removeAnotherLink_sp;
	@FindBy(how = How.XPATH, using = "//label[text()='Teams']/following::span[text()='Select team']")
	private WebElement TeamsField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement SelectTeamInputField;
	@FindBy(how = How.XPATH, using = "//*[@id='select2-drop']/ul/li/div/span")
	private WebElement TeamFrom_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Assign to']/following::span[1]")
	private WebElement AssignToField;
	@FindBy(how = How.XPATH, using = "//label[text()='Assign to']/following::span[1]/following::input[1]")
	private WebElement AssignToInputField;
	@FindBy(how = How.XPATH, using = "//label[text()='Assign to']/following::input[1]/ul")
	private WebElement AssignTo_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Source']/following::span[text()='Select']")
	private WebElement SourceDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[2]/div")
	private WebElement SourceFrom_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Campaign']/following::span[text()='Walkin']")
	private WebElement CampaignDropdown;
	@FindBy(how = How.CSS, using = "#select2-drop ul li")
	private List<WebElement> Campaign_dd;
	@FindBy(how = How.XPATH, using = "//span[text()='Lead Stage']")
	private WebElement LeadStageField;
	@FindBy(how = How.CSS, using = "#select2-drop ul li")
	private List<WebElement> LeadStages_dd;
	@FindBy(how = How.XPATH, using = "//input[@name='address1']")
	private WebElement AddressField;
	@FindBy(how = How.XPATH, using = "//input[@name='address2']")
	private WebElement StreetField;
	@FindBy(how = How.XPATH, using = "//input[@name='city']")
	private WebElement CityField;
	@FindBy(how = How.XPATH, using = "//select[@name='state']")
	private WebElement StateField;
	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	private WebElement CountryDropdown;
	@FindBy(how = How.XPATH, using = "")
	private WebElement CountryFrom_dd;
	@FindBy(how = How.XPATH, using = "//input[@name='zip']")
	private WebElement ZipField;
	@FindBy(how = How.XPATH, using = "//label[text()='Interested projects']/following::input[1]")
	private WebElement ProjectsOfInterest;
	@FindBy(how = How.CSS, using = "#select2-drop ul li:nth-child(1) div")
	private WebElement ProjectOfInterestFrom_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Budget']/following::input[1]")
	private WebElement MinBudgetInputField;
	@FindBy(how = How.XPATH, using = "//label[text()='Budget']/following::input[2]")
	private WebElement MaxBudgetInputField;
	@FindBy(how = How.CSS, using = "[href=\"#requirement\"]")
	private WebElement RequirementTab;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Min possession')]")
	private WebElement MinPossession;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[2]/div")
	private WebElement MinPossession_dd;
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Max possession')]")
	private WebElement MaxPossession;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[3]/div")
	private WebElement MaxPossession_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Property types']/following::input[1]")
	private WebElement PropertyTypes;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[3]/div")
	private WebElement PropertyTypes_dd;
	@FindBy(how = How.XPATH, using = "//input[@id='s2id_autogen78']")
	private WebElement BedroomPreferences;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li[4]/div")
	private WebElement BedroomPreferences_dd;
	@FindBy(how = How.XPATH, using = "//label[text()='Location preferences']/following::input[1]")
	private WebElement LocationPreferencesInputField;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/ul/li/div/span")
	private WebElement LocationPreferences_dd;
	@FindBy(how = How.XPATH, using = "//button[text()='Save'][@class='pull-right btn btn-primary save btn-sm']")
	private WebElement SaveButton;
	@FindBy(how = How.XPATH, using = "//button[text()='Save']/preceding::button[2]")
	private WebElement CloseButton;
	@FindBy(how = How.XPATH, using = "//button[@id='button-0']")
	private WebElement closeButton_popup;

	public void inputFirstName(String firstname) {
		waitUntilVisiblity(FistNameField);
		FistNameField.sendKeys(firstname);
	}

	public void inputLastName(String lastname) {
		waitUntilVisiblity(LastNameField);
		LastNameField.sendKeys(lastname);
	}

	public void inputPrimaryEmail(String pemail) {
		waitUntilVisiblity(PrimaryEmail);
		PrimaryEmail.sendKeys(pemail);
	}

	public void inputPrimaryPhone(String pphone) {
		waitUntilVisiblity(PrimaryPhone);
		PrimaryPhone.sendKeys(pphone);
	}

	public void selectTeam(String teamname) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", ScheduleAndConductSiteVisitForProjectField);
		waitUntilClickable(TeamsField);
		TeamsField.click();
		waitUntilVisiblity(SelectTeamInputField);
		SelectTeamInputField.sendKeys(teamname);
		////Thread.sleep(2000);
		waitUntilClickable(TeamFrom_dd);
		TeamFrom_dd.click();
	}

	public void selecAssignTo(String assign) throws InterruptedException {
		waitUntilClickable(AssignToField);
		AssignToField.click();
		waitUntilVisiblity(AssignToInputField);
		AssignToInputField.sendKeys(assign);
		// //Thread.sleep(2000);
		waitUntilClickable(AssignTo_dd);
		AssignTo_dd.click();
	}

	public void selectProject(String projectname) throws InterruptedException {
		waitUntilVisiblity(ScheduleAndConductSiteVisitForProjectField);
		ScheduleAndConductSiteVisitForProjectField.sendKeys(projectname);
		// //Thread.sleep(2000);
		waitUntilClickable(Project_dd.get(0));
		Project_dd.get(0).click();
	}

	public void selectProject() {

		scrollAction(driver.findElement(By.xpath("//*[text()=' Time zone']")), AddressField);
		waitUntilClickable(ScheduleAndConductSiteVisitForProjectField);
		ScheduleAndConductSiteVisitForProjectField.click();

		List<WebElement> list = Project_dd;
		for (WebElement ele : list) {
			if (ele.getAttribute("innerHTML").contains("Srujan")) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}

	}

	public void selectLeadStageNewLead(String str) {
		waitUntilClickable(NewLeadCreationLeadStage);
		NewLeadCreationLeadStage.click();
		List<WebElement> list = NewLeadStage;
		for (WebElement ele : list) {
			if (ele.getText().trim().equalsIgnoreCase(str)) {
				waitUntilClickable(ele);
				ele.click();
				System.out.println("Clicked on " + str);
				break;
			}
		}

	}

	public void selectCampaign(String str) {
		waitUntilClickable(CampaignDropdown);
		CampaignDropdown.click();
		List<WebElement> list = Campaign_dd;
		for (WebElement ele : list) {
			if (ele.getText().trim().equalsIgnoreCase(str)) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}

	}

	public void selectLeadStage(String str) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", ScheduleAndConductSiteVisitForProjectField);
		// scrollIntoView(ScheduleAndConductSiteVisitForProjectField);
		waitUntilClickable(LeadStageField);
		LeadStageField.click();
		List<WebElement> list = LeadStages_dd;
		for (WebElement ele : list) {
			if (ele.getText().trim().equalsIgnoreCase(str)) {
				waitUntilClickable(ele);
				ele.click();
				break;
			}
		}

	}

	public void selectSource() {
		waitUntilClickable(SourceDropdown);
		SourceDropdown.click();
		waitUntilClickable(SourceFrom_dd);
		SourceFrom_dd.click();
	}

	public void inputAddress(String address) {
		waitUntilVisiblity(AddressField);
		AddressField.sendKeys(address);
	}

	public void inputStreet(String street) {
		waitUntilVisiblity(StreetField);
		StreetField.sendKeys(street);
	}

	public void inputCity(String city) {
		waitUntilVisiblity(CityField);
		CityField.sendKeys(city);
	}

	public void inputState(String state) {
		waitUntilVisiblity(StateField);
		StateField.sendKeys(state);
	}

	public void inputZip(String zip) {
		waitUntilVisiblity(ZipField);
		ZipField.sendKeys(zip);
	}

	public void selectingProjectsOfInterest() {
		waitUntilClickable(ProjectsOfInterest);
		ProjectsOfInterest.click();
		waitUntilClickable(ProjectOfInterestFrom_dd);
		ProjectOfInterestFrom_dd.click();

	}

	public void inputBudget(String min, String max) throws InterruptedException {

		// This will scroll up the web page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false);", RequirementTab);

		waitUntilClickable(RequirementTab);
		RequirementTab.click();
		waitUntilVisiblity(MinBudgetInputField);
		MinBudgetInputField.sendKeys(min);
		waitUntilVisiblity(MaxBudgetInputField);
		MaxBudgetInputField.sendKeys(max);
	}

	public void selectPossession() {
		waitUntilClickable(MinPossession);
		MinPossession.click();
		waitUntilClickable(MinPossession_dd);
		MinPossession_dd.click();
		waitUntilClickable(MaxPossession);
		MaxPossession.click();
		waitUntilClickable(MaxPossession_dd);
		MaxPossession_dd.click();
	}

	public void selectPropertyTypes() {

		// This will scroll down the web page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", PropertyTypes);
		waitUntilClickable(PropertyTypes);
		PropertyTypes.click();
		waitUntilClickable(PropertyTypes_dd);
		PropertyTypes_dd.click();
	}

	public void selectBedroomPreferences() {

		// This will scroll down the web page

		scrollIntoView(LocationPreferencesInputField);
		waitUntilClickable(BedroomPreferences);
		BedroomPreferences.click();
		waitUntilClickable(BedroomPreferences_dd);
		BedroomPreferences_dd.click();
	}

	public void inputLocatioPreferences(String pref) {
		waitUntilVisiblity(LocationPreferencesInputField);
		LocationPreferencesInputField.sendKeys(pref);
		waitUntilClickable(LocationPreferences_dd);
		LocationPreferences_dd.click();
	}

	public void clickOnSaveButton() {
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	}

	public void clickOnCloseButton() {
		waitUntilClickable(CloseButton);
		CloseButton.click();
	}

	public void closeButton_popup() {
		waitUntilClickable(closeButton_popup);
		closeButton_popup.click();
	}

	public void clickOnSalutation_dd() {
		waitUntilClickable(Salutation);
		Salutation.click();
	}
}
