package com.selldo.POM.adminPages;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.BaseTest;
import com.selldo.Utility.ReusableUtils;

public class DocumentsPage extends ReusableUtils {

	public WebDriver driver;

	public DocumentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#back-button")
	private WebElement backButton;
	@FindBy(how = How.CSS, using = "#new_folder_form input[value=\"Create New Folder\"]")
	private WebElement createFolderButton;
	@FindBy(how = How.CSS, using = "input[placeholder=\"Search by file name\"]")
	private WebElement searchFileField;
	@FindBy(how = How.CSS, using = "a.btn.btn-primary.asset_search_term_btn")
	private WebElement searchButton;
	@FindBy(how = How.CSS, using = "div.btn.btn-outline-primary.fileinput-button")
	private WebElement uploadButton;
	@FindBy(how = How.CSS, using = "div.asset-icon.asset-icon-image")
	private WebElement fileDoc;
	@FindBy(how = How.CSS, using = "a[title='Delete']")
	private WebElement delete;
	@FindBy(how = How.XPATH, using = "//input[@class='fileupload_client']")
	private WebElement brows;
	@FindBy(how = How.CSS, using = ".progress-bar.progress-bar-primary")
	private WebElement loadingBar;

	public void backToFolder() {
		waitUntilClickable(backButton);
		backButton.click();
	}

	public void searchFile(String fileName) throws Exception {
		waitUntilVisiblity(searchFileField);
		searchFileField.sendKeys(fileName);
		waitUntilClickable(searchButton);
		searchButton.click();
	}

	public void uploadFile() {
		waitUntilClickable(uploadButton);
		uploadButton.click();
	}

	public String deleteFile(String fileName) throws InterruptedException {
		moveToElement(fileDoc);
		waitUntilClickable(delete,30).click();
		String text = driver.switchTo().alert().getText().trim();
		driver.switchTo().alert().accept();
		return text;
	}

	public void upload() throws Exception {
		String randomFile =new BaseTest().getScreenshot(new BaseTest().DateTime("HHmmss")+RandomStringUtils.randomAlphanumeric(10),driver);
		String claimZIP = System.getProperty("user.dir") + "/DataFile/" + "google-new-logo.png";
		// pass the path of the file to be uploaded using Sendkeys method
		//waitUntilVisiblity(brows);
		brows.sendKeys(randomFile);
		waitUntilInvisibility(loadingBar);

	}

}
