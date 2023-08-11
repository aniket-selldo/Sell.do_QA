package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.selldo.POM.crm.ClientLoginPage;
import com.selldo.POM.crm.LeadProfilePage;
import com.selldo.POM.crm.LoginPage;
import com.selldo.Utility.GetTestData;
import com.selldo.Utility.ReusableUtils;

import Enums.AutoForwarding;
import Enums.Strategy;

public class AdminDashboardPage extends ReusableUtils {

	public WebDriver driver;

	public AdminDashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "i.ion-ios-people")
	private WebElement leadsIcon;
	@FindBy(how = How.XPATH, using = "//*[contains(@class,'select2-container form-control select2 c')]")
	private WebElement listField;
	@FindBy(how = How.CSS, using = "#select2-drop > div > input")
	private WebElement listSearch;
	@FindBy(how = How.CSS, using = "i.ion-chatbubbles")
	private WebElement chatIcon;
	@FindBy(how = How.CSS, using = "i.ion-android-calendar")
	private WebElement calenderIcon;
	@FindBy(how = How.CSS, using = "i.ion-pie-graph")
	private WebElement pieGraphIcon;
	@FindBy(how = How.CSS, using = "i.ion-cube")
	private WebElement inventoryIcon;
	@FindBy(how = How.CSS, using = "i.ion-ios-color-wand")
	private WebElement wandIcon;
	@FindBy(how = How.CSS, using = "i.ion-ios-folder")
	private WebElement documentIcon;
	@FindBy(how = How.CSS, using = "i.ion-android-settings")
	private WebElement settingIcon;
	@FindBy(how = How.CSS, using = "i.ion-android-unlock")
	private WebElement unlockIcon;
	@FindBy(how = How.CSS, using = "#s2id_id_signin")
	private WebElement loginAsField;
	@FindBy(how = How.CSS, using = "#select2-drop div input")
	private WebElement enterUserName;
	@FindBy(how = How.CLASS_NAME, using = "select2-result-label")
	private List<WebElement> selectUserDropdown;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Login")
	private WebElement userLoginButton;
	@FindBy(how = How.CSS, using = "i#user-account-icon")
	private WebElement userAccountIcon;
	@FindBy(how = How.XPATH, using = "//a[text()='Edit Profile']")
	private WebElement editProfile;
	@FindBy(how = How.XPATH, using = "//a[text()='Change Password']")
	private WebElement changePassword;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Logout")
	private WebElement logout;
	@FindBy(how = How.XPATH, using = "//span[text()='user management']")
	private WebElement userManagementTab;
	@FindBy(how = How.XPATH, using = "//span[text()='manage users']")
	private WebElement manageUsersTab;
	@FindBy(how = How.CSS, using = "#s2id_global_search_input span")
	private WebElement searchField;
	@FindBy(how = How.CSS, using = "#select2-drop > div > input")
	private WebElement searchTextBox;
	@FindBy(how = How.XPATH, using = "//span[text()='Developers']")
	private WebElement developers;
	@FindBy(how = How.CSS, using = "div.pending-invoices-alert.small.float-right.mr-2")
	private WebElement clientName;
	@FindBy(how = How.XPATH, using = "//div[text()='NEW ENQUIRIES ']")
	private WebElement newEnquiry;
	@FindBy(how = How.CSS, using = "[class='td-lead_id goto_details']") // tbody[@class='crm-leads']//a[contains(@class,'td-l')]
	private List<WebElement> getAnyLeadID;
	// ----------------- Select Stratgy----------------------
	@FindBy(how = How.CSS, using = "#main-menu-settings")
	private WebElement clickOnSetting;
	@FindBy(how = How.XPATH, using = "//span[text()='pre/sales configuration']")
	private WebElement clickOnPreSalesConfiguration;
	@FindBy(how = How.CSS, using = "#s2id_client_configuration_pre_sales_configuration_push_lead_strategy")
	private WebElement SelectStratgy;
	@FindBy(how = How.XPATH, using = "//li[contains(@class,'select2-results-dept-0 select2-result select2-result-selectable')]")
	private List<WebElement> SelectStratgydropdown;
	@FindBy(how = How.CSS, using = "#s2id_client_configuration_pre_sales_configuration_auto_forward")
	private WebElement ClickStratgyOnOff;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']/li")
	private List<WebElement> SelectStratgyOnOff;
	@FindBy(how = How.XPATH, using = "//input[@class='btn btn-primary save']")
	private WebElement ClickOnSave;
	@FindBy(how = How.CSS, using = "button[class='btn btn-light btn-icon toggle-filters']")
	private WebElement clickOnFilter;
	@FindBy(how = How.XPATH, using = "//a[text()='Clear All']")
	private WebElement clickOnClearAll;

	@FindBy(how = How.XPATH, using = "//span[text()='Search...']")
	private WebElement clickOnGlobalSearch;
	@FindBy(how = How.CSS, using = "#select2-drop input")
	private WebElement enterInGlobalSearch;
	@FindBy(how = How.CSS, using = "#select2-drop li:nth-child(1)")
	private WebElement clickOnSearchSuggation;
	@FindBy(how = How.CSS, using = "#stage-span")
	private WebElement leadStatus;
	// ################## Autoforwading On Off ###################

	public void AutoForwading(String admin, Strategy STRATEGY_FOR_LEAD_PUSH_TO_SALES, AutoForwarding flag) {
		LoginPage login = new LoginPage(driver);
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		ClientLoginPage clientLogin = new ClientLoginPage(driver);
		login.login(prop("Aniket_SM"), prop("Aniket_SM_PSWD"));

		try {
			waitUntilClickable(clickOnSetting, 1).isDisplayed();
			System.out.println("SM Alredy loggedIn");
			adminDashboardPage.loggingOut();
			login.login("ketan@amuratech.com", "amura@123");
		} catch (Exception e) {
			System.out.println("SM No Alredy loggedIn");

		}
		clientLogin.clientLogin(admin);
		waitUntilClickable(clickOnSetting).click();
		waitUntilClickable(clickOnPreSalesConfiguration).click();

		// Select Strategy
		waitUntilClickable(waitUntilVisiblity(SelectStratgy)).click();
		List<WebElement> ele = waitUntilVisibilityOfElements(SelectStratgydropdown);
		for (WebElement webElement : ele) {
			if (webElement.getText().equalsIgnoreCase(STRATEGY_FOR_LEAD_PUSH_TO_SALES.toString())) {
				waitUntilClickable(webElement).click();
				waitUntilInvisibility(webElement);
				break;
			}
		}
		// Select On/Off
		waitUntilClickable(ClickStratgyOnOff).click();
		List<WebElement> ele1 = waitUntilVisibilityOfElements(SelectStratgyOnOff);
		for (WebElement webElement : ele1) {
			if (webElement.getText().equalsIgnoreCase(flag.toString())) {
				waitUntilClickable(webElement).click();
				break;
			}
		}
		jsClick(ClickOnSave);
		// LogOut
		wait(2000);
		adminDashboardPage.loggingOut();
	}

	public void clearFilter() {
		waitUntilClickable(clickOnFilter).click();
		waitUntilClickable(clickOnClearAll).click();
	}

	// To Search Lead using random choose
	public void searchLead(int lead) throws InterruptedException {
		waitUntilClickable(newEnquiry).click();
		waitUntilVisiblity(
				driver.findElement(By.xpath("//*[contains(@class,'select2-container form-control select2 cl')]")))
				.click();
		waitUntilVisiblity(driver.findElement(By.xpath(".//div[@id='select2-drop']//input"))).sendKeys("All Leads");// Incoming
		waitUntilVisiblity(driver.findElement(By.xpath("//li[contains(@class,'select2-re')]"))).click();
		waitUntilVisibilityOfElements(getAnyLeadID);
		wait(1000);
		String leadId = waitUntilVisiblity(getAnyLeadID.get(lead)).getText();
		System.out.println("Selected Lead id >> " + leadId);
		waitUntilClickable(searchField).click();
		waitUntilVisiblity(searchTextBox).sendKeys(leadId);
		waitUntilVisiblity(driver.findElement(By.xpath("//div[@class='select2-result-label']"))).click();
	}

	public String searchLead(int lead, String leadStage) throws InterruptedException {
		waitUntilClickable(newEnquiry).click();
		wait(4000);
		waitUntilVisiblity(
				driver.findElement(By.xpath("//*[contains(@class,'select2-container form-control select2 cl')]")))
				.click();
		waitUntilVisiblity(driver.findElement(By.xpath(".//div[@id='select2-drop']//input"))).sendKeys(leadStage);// Incoming
		waitUntilVisiblity(driver.findElement(By.xpath(".//div[@id='select2-drop']//input"))).sendKeys(Keys.ENTER);// Incoming

		try {

			new LeadProfilePage(driver).clearFilter();

		} catch (Exception e) {
		}
		wait(5000);
		String leadId = waitUntilVisiblity(getAnyLeadID.get(lead)).getText();
		System.out.println("Selected Lead id >> " + leadId);
		waitUntilClickable(searchField).click();
		waitUntilVisiblity(searchTextBox).sendKeys(leadId);
		waitUntilVisiblity(driver.findElement(By.xpath("//div[@class='select2-result-label']"))).click();
		return leadId;
	}

	// TO search lead using lead id
	public String searchLead(String leadId) throws InterruptedException {
//		waitUntilClickable(newEnquiry).click();
//		wait(1000);
//		waitUntilVisiblity(
//				driver.findElement(By.xpath("//*[contains(@class,'select2-container form-control select2 cl')]")))
//				.click();
//		waitUntilVisiblity(driver.findElement(By.xpath(".//div[@id='select2-drop']//input"))).sendKeys("All Leads");// Incoming
//																													// All
//																													// Leads
//		waitUntilVisiblity(driver.findElement(By.xpath("//li[contains(@class,'select2-re')]"))).click();
//		waitUntilVisibilityOfElements(getAnyLeadID);
//		wait(1000);
//		// String leadId=getAnyLeadID.get(lead).getText();
//		System.out.println("Selected Lead id >> " + leadId);
		waitUntilClickable(searchField).click();
		waitUntilVisiblity(searchTextBox).sendKeys(leadId);
		waitUntilVisiblity(driver.findElement(By.xpath("//div[@class='select2-result-label']"))).click();
		System.out.println("Search lead id >> "+leadId);
		return leadId;
	}

	public void serchLeadGlobally(String leadId) {
		waitUntilClickable(clickOnGlobalSearch).click();
		waitUntilVisiblity(enterInGlobalSearch).sendKeys(leadId);
		wait(1000);
		waitUntilVisiblity(enterInGlobalSearch).sendKeys(Keys.ENTER);
		//waitUntilClickable(clickOnSearchSuggation).click();
	}
	public String getLeadURL_ID(String leadId) {
		waitUntilClickable(clickOnGlobalSearch).click();
		waitUntilVisiblity(enterInGlobalSearch).sendKeys(leadId);
		waitUntilClickable(clickOnSearchSuggation).click();
		waitUntilVisiblity(leadStatus);
		String out = driver.getCurrentUrl().split("/")[6];
		System.out.println("Lead ID > "+out);
		return out;
	}
	public void clickOnDocument() {
		waitUntilClickable(documentIcon);
		documentIcon.click();
	}

	// Login as User from Admin Dashboard
	public void loginAsUser(String userName) throws Exception {
		waitUntilClickable(unlockIcon).click();
		waitUntilVisiblity(loginAsField);
		waitUntilClickable(loginAsField);
		wait(500);
		loginAsField.click();
		waitUntilVisiblity(enterUserName).sendKeys(userName.split(" ")[0].trim());
		List<WebElement> ele = waitUntilVisibilityOfElements(selectUserDropdown);
		for (WebElement webElement : ele) {
			if (webElement.getText().startsWith(userName)) {
				webElement.click();
				break;
			}
		}

		waitUntilClickable(userLoginButton).click();
		System.out.println("Selected User >>> " + userName);

	}

	public void clickOnSettingIcon() {
		waitUntilClickable(settingIcon).click();
	}

	// To Select values from Lead Management Dropdown
	public void selectLeadActions(int value) {
		waitUntilClickable(leadsIcon).click();
		waitUntilClickable(leadsIcon).click();
		waitUntilClickable(driver.findElement(By.cssSelector(
				"body > div.main-nav-container > div > div:nth-child(2) > div > div:nth-child(" + value + ") > a")))
				.click();
	}

	public void selectInventoryActions(int value) {
		waitUntilClickable(inventoryIcon).click();
		waitUntilClickable(driver.findElement(By.cssSelector(
				"body > div.main-nav-item > div > div:nth-child(1) > div > div:nth-child(" + value + ") > a"))).click();
	}

	public void loggingOut() {
		waitUntilClickable(userAccountIcon).click();
		waitUntilClickable(logout).click();

	}

	public void adminlogOut() {
		waitUntilClickable(logout).click();
	}

	public void SelectList(String reassign) throws Exception {
		waitUntilClickable(listField).click();
		waitUntilVisiblity(listSearch).sendKeys(reassign);
		wait(1000);
		listSearch.sendKeys(Keys.ENTER);
	}

	public void openManageUsersPage() {
		waitUntilClickable(userManagementTab).click();
		waitUntilClickable(manageUsersTab).click();
	}

	public void verifyingClientLogin() {
		System.out.println("Started verification");
		Assert.assertEquals(driver.getTitle(), "Sell.Do - Market Smarter. Sell Faster.", "Title Not Matched");
		System.out.println("Completed verification");
	}

	public void verifyingClientCreation() {

		String businessName = new GetTestData().location;
		System.out.println("Started verification");
		Assert.assertEquals(waitUntilVisiblity(clientName).getText(), businessName);
		System.out.println("Completed verification");
	}

	public void clickOnWandIcon() {
		waitUntilClickable(wandIcon).click();
	}

	public void clickOnDevelopers() {
		waitUntilClickable(developers).click();
	}

}
