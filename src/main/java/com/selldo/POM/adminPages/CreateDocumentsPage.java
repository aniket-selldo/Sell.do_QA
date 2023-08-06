package com.selldo.POM.adminPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class CreateDocumentsPage extends ReusableUtils {

	public WebDriver driver;

	public CreateDocumentsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.CSS, using = "#new_folder_form input.form-control")
	private WebElement folderNameField;
	@FindBy(how = How.CSS, using = "#new_folder_form input[value=\"Create New Folder\"]")
	private WebElement createFolderButton;

	public void createNewFolder(String folderName) {
		folderNameField.sendKeys(folderName);
		createFolderButton.click();
	}

	public void openFolder(String folderName) {

		driver.findElement(By.cssSelector("#" + folderName + "_folder > div.folder-name")).click();

	}

}
