package POM.clientCreationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class PrepaidClientCreation extends ReusableUtils {

	public WebDriver driver;

	public PrepaidClientCreation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//a[text()='New Developer']")
	private WebElement newDeveloperButton;
	@FindBy(how = How.CSS, using = "i.ion-funnel")
	private WebElement funnelIcon;
}
