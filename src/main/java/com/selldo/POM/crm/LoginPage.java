package com.selldo.POM.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class LoginPage extends ReusableUtils {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "user_email")
	private WebElement Email;
	@FindBy(how = How.ID, using = "user_password")
	private WebElement Password;
	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	private WebElement SignIn;

	public void login(String myusername, String mypassword) {
		waitUntilVisiblity(Email).sendKeys(myusername.trim());// Taking email
		waitUntilVisiblity(Password).sendKeys(mypassword.trim());// Taking password
		jsClick(SignIn);// Clicking on Sign in button

	}

}
