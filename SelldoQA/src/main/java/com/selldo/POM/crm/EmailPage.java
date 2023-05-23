package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EmailPage extends ReusableUtils {
	public WebDriver driver;

	public EmailPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//label[text()='Subject']/following::input[1]")
	private WebElement subjectInputField;
	@FindBy(how = How.XPATH, using = "//div[@class='note-editable card-block']")
	private WebElement textBody;
	@FindBy(how = How.XPATH, using = "//button[text()='Send Email']")
	private WebElement sendEmailButton;
	@FindBy(how = How.CSS, using = ".select2-container.email_template_select.form-control")
	private WebElement templateDropdown;
	@FindBy(how = How.CSS, using = "#select2-drop > ul > li > div")
	private List<WebElement> template_dd;
	@FindBy(how = How.CSS, using = "a.btn.btn-light.mt-3.addCC.float-right.mr-1")
	private WebElement addCCLink;
	@FindBy(how = How.LINK_TEXT, using = "Add BCC")
	private WebElement addBCCLink;
	@FindBy(how = How.XPATH, using = "//label[text()='CC']/following::input[1]")
	private WebElement CCInputField;
	@FindBy(how = How.XPATH, using = "//label[text()='BCC']/following::input[1]")
	private WebElement BCCInputField;
	@FindBy(how = How.CSS, using = "select[name=\"email_template_type\"]")
	private WebElement generalEmailLink;
	@FindBy(how = How.CSS, using = "//a[text()=\"Compose Email\"]\"")
	private WebElement composeEmailLink;
	@FindBy(how = How.CSS, using = "select[name=\"email_template_type\"] option:nth-child(2)")
	private WebElement selectBrochure;
	@FindBy(how = How.CSS, using = "select[name=\"email_template_type\"] option:nth-child(3)")
	private WebElement selectQuote;

	public void enterSubject(String subject) {
		subjectInputField.sendKeys(subject);
	}

	public void entertextInBody(String body) {
		textBody.sendKeys(body);
	}

	public void clickOnSendEmailButton() {

		jsClick(sendEmailButton);
	}

	/*
	 * public void selectTemplate() throws Exception { Thread.sleep(2000);
	 * templateDropdown.click(); template_dd.click(); }
	 */

	public void selectTemplate(String templateName) {

		templateDropdown.click();
		List<WebElement> list = template_dd;

		for (WebElement ele : list) {
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Template

			if (ele.getAttribute("innerHTML").contains(templateName)) {

				// if yes then click on link

				ele.click();

				System.out.println("Clicked on Template");

				// break the loop or come out of loop

				break;
			}
		}

	}

	public void enterCCEmail(String cc) throws Exception {

		jsClick(addCCLink);
		CCInputField.sendKeys(cc);
		Thread.sleep(1000);
		CCInputField.sendKeys(Keys.RETURN);
	}

	public void enterBCCEmail(String bcc) throws Exception {

		jsClick(addBCCLink);
		BCCInputField.sendKeys(bcc);
		Thread.sleep(1000);
		BCCInputField.sendKeys(Keys.RETURN);
	}

	public void selectBrochureOption() throws Exception {

		generalEmailLink.click();
		// selectBrochure.click();
		selectBrochure.click();

	}

	public void selectPriceQuoteOption() throws Exception {

		generalEmailLink.click();
		// composeEmailLink.click();
		selectQuote.click();

	}

}
