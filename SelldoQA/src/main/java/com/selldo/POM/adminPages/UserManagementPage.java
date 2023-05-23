package com.selldo.POM.adminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class UserManagementPage extends ReusableUtils {
	public WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//span[text()='manage teams']")
	private WebElement manageTeam;
	@FindBy(how = How.XPATH, using = "//span[text()='manage users']")
	private WebElement manageUsers;

	public void clickOnManageTeam() {
		manageTeam.click();
	}

	public void clickOnManageUsers() {
		manageUsers.click();
	}
}
