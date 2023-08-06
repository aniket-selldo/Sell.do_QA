package myPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class AdminHomePage extends ReusableUtils {
	public WebDriver driver;

	public AdminHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "user-mngmnt")
	private WebElement userManagement;
	@FindBy(how = How.ID, using = "[class='ion-card text-secondary']")
	private WebElement billing;
	@FindBy(how = How.XPATH, using = "//span[text()='search lists']")
	private WebElement searchList;
	@FindBy(how = How.XPATH, using = "//span[text()='lead settings']")
	private WebElement leadSetting;
	@FindBy(how = How.XPATH, using = "//span[text()='import']")
	private WebElement importt;
	@FindBy(how = How.XPATH, using = "//span[text()='export']")
	private WebElement export;
	@FindBy(how = How.XPATH, using = "//span[text()='telephony']")
	private WebElement telephony;
	@FindBy(how = How.XPATH, using = "//span[text()='partners']")
	private WebElement partners;
	@FindBy(how = How.XPATH, using = "//span[text()='Routing Setup']")
	private WebElement routingSetup;
	@FindBy(how = How.XPATH, using = "//span[text()='Website']")
	private WebElement Website;
	@FindBy(how = How.XPATH, using = "//span[text()='Bulk Check Lead Presence']")
	private WebElement bulkCheckLeadPresence;

	public void clickuserManagement() {
		userManagement.click();
	}

	public void clickbilling() {
		billing.click();
	}

	public void clicksearchList() {
		searchList.click();
	}

	public void clickleadSetting() {
		leadSetting.click();
	}

	public void clickimportt() {
		importt.click();
	}

	public void clickexport() {
		export.click();
	}

	public void clicktelephony() {
		telephony.click();
	}

	public void clickpartners() {
		partners.click();
	}

	public void clickroutingSetup() {
		routingSetup.click();
	}

	public void clickWebsite() {
		Website.click();
	}

	public void clickbulkCheckLeadPresence() {
		bulkCheckLeadPresence.click();
	}

}
