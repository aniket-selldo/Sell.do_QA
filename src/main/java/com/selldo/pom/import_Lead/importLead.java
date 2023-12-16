package com.selldo.pom.import_Lead;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.POM.adminPages.AdminDashboardPage;
import com.selldo.Utility.ReusableUtils;
import com.selldo.Utility.XLUtilsHSSF;

public class importLead extends ReusableUtils {
	public WebDriver driver;

	public importLead(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Choose Campaign']")
	private WebElement selectCampeign;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_source")
	private WebElement selectSource;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_sub_source")
	private WebElement selectSubSource;
	@FindBy(how = How.CSS, using = "#select2-drop input")
	private WebElement enterSelectSubSource;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_medium_type")
	private WebElement selectMediumType;
	@FindBy(how = How.XPATH, using = "//span[text()='Select department']")
	private WebElement selectDepartment;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-container select2-container-multi team form-control required']")
	private WebElement SelectTeam;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_sales_ids")
	private WebElement selectSales;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-container select2-container-multi form-control']")
	private WebElement selectProject;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_sv_project")
	private WebElement selectProjectforSV;
	@FindBy(how = How.XPATH, using = "(//label[@class='form-check-label'])[1]")
	private WebElement clickOnSendNotificationToLead;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_emails")
	private WebElement clickOnOwnEmail;
	@FindBy(how = How.CSS, using = "#s2id_bulk_upload_emails input")
	private WebElement EnterOwnEmail;
	@FindBy(how = How.XPATH, using = "(//label[@class='form-check-label'])[2]")
	private WebElement clickOnAllowToReengage;
	@FindBy(how = How.XPATH, using = "(//label[@class='form-check-label'])[3]")
	private WebElement clickOnFileContainHeader;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary check_validity']")
	private WebElement clickOnContinue;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-outline-primary previous_step']")
	private WebElement clickOnGoBack;
	@FindBy(how = How.XPATH, using = "//input[@value='Continue']")
	private WebElement clickOnContinueFinal;
	@FindBy(how = How.XPATH, using = "//a[@title='Refresh']")
	private WebElement clickOnRefreshButton;
	@FindBy(how = How.XPATH, using = "//div[@role='progressbar']")
	private WebElement getProgressBarValue;
	@FindBy(how = How.XPATH, using = "(//table[@class='table table-responsive bulk_uploads']//td[@width='10%'])[6]")
	private WebElement getUploadingStatus;
	@FindBy(how = How.CSS, using = "#select2-drop li")
	private List<WebElement> dropdownList;

	int scrollConst = 100;

	public void selectCampeign() {
		waitUntilClickable(selectCampeign, 1000000).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void selectSource() {
		scrollBy(scrollConst);
		waitUntilClickable(selectSource).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void selectSubSource() {
		scrollBy(scrollConst);
		waitUntilClickable(selectSubSource).click();
		waitUntilVisiblity(enterSelectSubSource).sendKeys("SubSource_Import");
		wait(1000);
		waitUntilVisiblity(enterSelectSubSource).sendKeys(Keys.ENTER);
	}

	public void selectMediumType() {
		scrollBy(scrollConst);
		waitUntilClickable(selectMediumType, 10000).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void selectDepartment() {
		scrollBy(scrollConst);
		waitUntilClickable(selectDepartment).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void SelectTeam() {
		scrollBy(scrollConst);
		waitUntilClickable(SelectTeam).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void selectSales() {
		scrollBy(scrollConst);
		waitUntilClickable(selectSales).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void selectProject() {
		scrollBy(scrollConst);
		waitUntilClickable(selectProject).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void selectProjectforSV() {
		scrollBy(scrollConst);
		waitUntilClickable(selectProjectforSV).click();
		waitUntilVisiblity(dropdownList.get(0)).click();
	}

	public void clickOnSendNotificationToLead() {
		scrollBy(scrollConst);
		waitUntilClickable(clickOnSendNotificationToLead).click();
	}

	public void EnterOwnEmail(String str) {
		scrollBy(scrollConst);
		waitUntilClickable(clickOnOwnEmail).click();
		waitUntilVisiblity(EnterOwnEmail).sendKeys(str);
		wait(1000);
		EnterOwnEmail.sendKeys(Keys.ENTER);
	}

	public void clickOnAllowToReengage() {
		scrollBy(scrollConst);
		waitUntilClickable(clickOnAllowToReengage).click();
	}

	public void clickOnFileContainHeader() {
		scrollBy(scrollConst);
		waitUntilClickable(clickOnFileContainHeader).click();
	}

	public void clickOnContinue() {
		scrollIntoView(clickOnContinue);
		waitUntilClickable(clickOnContinue).click();
	}

	public void clickOnGoBack() {
		scrollIntoView(clickOnGoBack);
		waitUntilClickable(clickOnGoBack).click();
	}

	public void clickOnContinueFinal() {
		waitUntilClickable(clickOnContinueFinal).click();
		wait(1000);
		driver.switchTo().alert().accept();
		wait(3000);
		try {
			for (;;) {
				wait(1000);
				jsClick(clickOnRefreshButton,2);

			}
		} catch (Exception e) {
			System.out.println("Out OF FOr Loop");
		}
		AdminDashboardPage adminDashboardPage = new AdminDashboardPage(driver);
		String path = System.getProperty("user.dir") + "/DataFile/Lead import.xls";
		XLUtilsHSSF xl = new XLUtilsHSSF(path);
		try {
			adminDashboardPage.searchLead(xl.getCellData("Sheet1", 1, 3));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait(10000);

	}

}
