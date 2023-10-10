package com.selldo.POM.crm;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class QuotesPage extends ReusableUtils {
	public WebDriver driver;

	public QuotesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//input[@name='subject']")
	private WebElement Subject;
	@FindBy(how = How.XPATH, using = "//div[@class='note-editable card-block']")
	private WebElement Body;
	@FindBy(how = How.XPATH, using = ".//*[@id='form_container']/div/form/div[8]/div/a")
	private WebElement UploadAttachments;
	@FindBy(how = How.XPATH, using = "//button[text()='Send Price quote'][@type='submit']")
	private WebElement sendPriceQuoteButton;
	@FindBy(how = How.CSS, using = "select.form-control.project")
	private WebElement SelectProduct;
	@FindBy(how = How.CSS, using = "select.form-control.project option")
	private List<WebElement> SelectProduct_All;
	@FindBy(how = How.XPATH, using = "//label[text()='Choose Template']/following::span[@class='select2-chosen']")
	private WebElement ChooseTemplateDropdown;
	@FindBy(how = How.XPATH, using = "//ul[@class='select2-results']//li")
	private List<WebElement> ChooseTemplate_All;

	// Writing the subject for email
	public void writingSubject(String mysubject) {
		wait(3000);
		waitUntilVisiblity(Subject).clear();
		Subject.sendKeys(mysubject);
	}

	// Writing some text in the body of email
	public void writingSomeTextInBody(String contentOfMail) {
		Body.sendKeys(contentOfMail);
	}

	// Clicking on Upload Attachments button
	public void ClickOnUploadAttachmentsButton() {
		UploadAttachments.click();
	}

	// Clicking on Send Price Quote button
	public void clickOnSendPriceQuoteButton() {
		sendPriceQuoteButton.click();
	}

	// Select Product
	public void selectProduct(String projectName) {
		SelectProduct.click();

		List<WebElement> list = SelectProduct_All;

		for (WebElement ele : list) {
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Template1

			if (ele.getAttribute("innerHTML").contains(projectName)) {

				// if yes then click on link

				ele.click();

				System.out.println("Clicked on Template");

				// break the loop or come out of loop

				break;
			}
		}
	}

	public void selectTemplate(String templateName) {

		ChooseTemplateDropdown.click();
		List<WebElement> list = ChooseTemplate_All;

		for (WebElement ele : list) {
			// for every elements it will print the name using innerHTML

			System.out.println("Values " + ele.getAttribute("innerHTML"));

			// Here we will verify if link (item) is equal to Template1

			if (ele.getAttribute("innerHTML").contains(templateName)) {

				// if yes then click on link

				ele.click();

				System.out.println("Clicked on Template");

				// break the loop or come out of loop

				break;
			}
		}

	}

}
