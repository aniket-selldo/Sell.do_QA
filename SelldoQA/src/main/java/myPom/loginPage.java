package myPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class loginPage extends ReusableUtils {

	public WebDriver driver;

	public loginPage(WebDriver driver)  {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.ID, using = "user_email")
	private WebElement userName;
	@FindBy(how = How.ID, using = "user_password")
	private WebElement password;
	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	private WebElement signIn;
	
	public LoginAsClient login(){
		Square(userName);
		userName.sendKeys(getGobalData().getProperty("id"));
		Square(password);
		password.sendKeys(getGobalData().getProperty("pswd"));
		Square(signIn);
		jsClick(signIn);
		return new LoginAsClient(driver);
	}
	public LoginAsClient login_suppoort(){
		Square(userName);
		userName.sendKeys(getGobalData().getProperty("SM"));
		Square(password);
		password.sendKeys(getGobalData().getProperty("pswd"));
		Square(signIn);
		jsClick(signIn);
		return new LoginAsClient(driver);
	}
	
}

