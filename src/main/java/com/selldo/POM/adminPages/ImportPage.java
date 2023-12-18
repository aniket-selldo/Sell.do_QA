package com.selldo.POM.adminPages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class ImportPage extends ReusableUtils {
	public WebDriver driver;

	public ImportPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='import leads']")
	private WebElement importLeadsTab;
	@FindBy(how = How.XPATH, using = "//a[text()='New Upload']")
	private WebElement newUploadButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Continue']")
	private WebElement continueButton;
	@FindBy(how = How.XPATH, using = "//input[@class='bulk_upload_file']")
	private WebElement uploadButton;
	@FindBy(how = How.XPATH, using = "//span[text()='Choose Campaign']")
	private WebElement campaignField;
	@FindBy(how = How.XPATH, using = "//div[@id='select2-drop']//ul//li")
	private List<WebElement> dropDown;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_bulk_upload_emails']")
	private WebElement emailField;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_bulk_upload_field_order_0']")
	private WebElement nameField;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_bulk_upload_field_order_1']")
	private WebElement leadEmailField;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_bulk_upload_field_order_2']")
	private WebElement userId;
	@FindBy(how = How.XPATH, using = "//div[@id='s2id_bulk_upload_field_order_3']")
	private WebElement stageField;
	@FindBy(how = How.CSS, using = "input.select2-input")
	private WebElement emailId;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	private WebElement continuebutton;
	@FindBy(how = How.XPATH, using = "//span[@class='text text-success']")
	public WebElement sucessMessage;
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[6]")
	public WebElement importStatus;
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[4]")
	public WebElement assignedTo;
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[2]/div/div/div[2]/div/div[1]/table/tbody/tr[1]/td[2]")
	public WebElement leadUploadCount;
	@FindBy(how = How.XPATH, using = "//span[text()='Choose Campaign']")
	private WebElement chooseChampain;

	public void clickOnImportLeadsTab() {
		waitUntilClickable(importLeadsTab);
		importLeadsTab.click();
	}

	public void clickOnNewUploadButton() {
		waitUntilClickable(newUploadButton);
		newUploadButton.click();
	}

	public void clickOnContinueButton() {
		scrollIntoView(continueButton);
		scrollBy(-500);
		waitUntilClickable(continueButton);
		try {
			continueButton.click();

		} catch (Exception e) {
			wait(1000000);
		}
	}

	public void enterEmail(String email) {

		scrollBy(500);
		waitUntilVisiblity(emailField).sendKeys(randomEmail());
		wait(2000);
		emailField.sendKeys(Keys.ENTER);
	}

	public void enterName() {
		waitUntilVisiblity(nameField);
		moveToAndSendEnter(nameField);

	}

	public void clickOnContinue() {
		waitUntilClickable(continuebutton);
		continuebutton.click();
	}

	public void enterLeadEmail() {
		waitUntilVisiblity(leadEmailField);
		moveToAndSendEnter(leadEmailField);

	}

	public void enterStage() {
		waitUntilClickable(stageField);
		stageField.click();

		List<WebElement> list = dropDown;

		for (WebElement ele : list)

		{
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Last 7 Days

			if (ele.getAttribute("innerHTML").contains("Lead Stages")) {

				// if yes then click on link
				waitUntilClickable(ele);
				ele.click();

				// break the loop or come out of loop

				break;
			}
		}

	}

	public void enterSalesId() {
		scrollIntoView(userId);
		scrollBy(-500);
		waitUntilClickable(userId);
		wait(10000);
		userId.click();

		List<WebElement> list = dropDown;

		for (WebElement ele : list)

		{
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Last 7 Days

			if (ele.getAttribute("innerHTML").contains("Sales Ids")) {

				// if yes then click on link
				waitUntilClickable(ele);
				ele.click();

				// break the loop or come out of loop

				break;
			}
		}

	}

	public void clickOnUploadButton(String file) {
		// pass the path of the file to be uploaded using Sendkeys method
		wait(1000);
		(uploadButton).sendKeys(file);
		
	}

	public void selectCampaign() {

		waitUntilClickable(campaignField,300);
		campaignField.click();

		List<WebElement> list = dropDown;

		for (WebElement ele : list)

		{
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Last 7 Days

			if (ele.getAttribute("innerHTML").contains("organic")) {

				// if yes then click on link
				waitUntilClickable(ele);
				ele.click();

				System.out.println("Clicked on organic");

				// break the loop or come out of loop

				break;
			}
		}
	}

	public void pageRefresh() {
		wait(500);
		driver.navigate().refresh();
	}
	
}
