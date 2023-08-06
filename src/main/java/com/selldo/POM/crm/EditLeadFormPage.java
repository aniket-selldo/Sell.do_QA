package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class EditLeadFormPage extends ReusableUtils {
	public WebDriver driver;

	public EditLeadFormPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//select[@name='salutation']")
	private WebElement salutation;
	@FindBy(how = How.XPATH, using = "//label[text()='Salutation & name']/following::input[1]")
	private WebElement firstName;
	@FindBy(how = How.XPATH, using = "//label[text()='Salutation & name']/following::input[2]")
	private WebElement lastName;
	@FindBy(how = How.XPATH, using = "//input[@name='primary_email_email']")
	private WebElement primaryEmail;
	@FindBy(how = How.CSS, using = "div[class='block_unblock_div']")
	private WebElement saveButton;

	// ................Methods for Basic profile section.....................

	public void clickOnMeetingLink() {
		waitUntilClickable(salutation).click();
	}

	public void clickOnSaveButton() {
		waitUntilClickable(saveButton).click();
	}

}
