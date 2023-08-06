package postSales;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.selldo.Utility.ReusableUtils;

public class TaskPage extends ReusableUtils {
	public WebDriver driver;

	public TaskPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// ....... Add Task ..........

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add A Task')]")
	private WebElement addaTask;
	@FindBy(how = How.XPATH, using = "//input[@name='task[title]']")
	private WebElement addaTitle;
	@FindBy(how = How.XPATH, using = "//textarea[@name='task[description]']")
	private WebElement addaDescription;
	@FindBy(how = How.CSS, using = "input[name='task[due_date]']")
	private WebElement DueDateField;
	@FindBy(how = How.CSS, using = "		")
	private WebElement ScheduleOnTimeField;
	@FindBy(how = How.CSS, using = "div.datepicker-days > table > tbody > tr > td.active.day")
	private WebElement selectToday;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker datepicker-dropdown dropdown-menu datepicker-orient-left datepicker-orient-top']//tr//td")
	private WebElement wholeCalender;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")
	private WebElement moveToNextMonth;
	@FindBy(how = How.XPATH, using = "//body[1]/div[29]/div[1]/table[1]/tbody[1]/tr[1]/td[4]")
	private WebElement selectDate;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-sm pull-right save']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//a[text()='Feed'][@href='#tab-activity']")
	private WebElement feedTab;
	@FindBy(how = How.XPATH, using = "//div[@class='col-sm-6 col-lg-6 pr-0']//a[@class='nav-link dropdown-toggle'][contains(text(),'More')]")
	private WebElement more_d;
	@FindBy(how = How.XPATH, using = "//span[text()='Select sales']")
	private WebElement SelectUserDropdown;
	@FindBy(how = How.XPATH, using = ".//*[@id='select2-drop']/div/input")
	private WebElement SelectUserTextField;
	@FindBy(how = How.XPATH, using = "//div[@class='select2-result-label']")
	private WebElement UserFromDropdown;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Upload attachment')]")
	private WebElement UploadattachmentButton;
	@FindBy(how = How.XPATH, using = "//a[@id='amura_folder']")
	private WebElement AmuraFolder;
	@FindBy(how = How.XPATH, using = "//div[@id=\"asset_uploading_5d42e1910c739221f5e51d7e\"]")
	private WebElement AttachmentFile;
	@FindBy(how = How.XPATH, using = "//*[@id='asset_uploading_5d42e1910c739221f5e51d7e']/div[2]/a[2]")
	private WebElement AttachmentNewFile;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary add_attachments']")
	private WebElement saveAttachment;
	@FindBy(how = How.XPATH, using = "//*[@name='task[priority]']")
	private WebElement PriorityField;
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'High')]")
	private WebElement Priority_dd;

	// Click Add A Task Link
	public void addingTask() throws Exception {
		Thread.sleep(2000);
		addaTask.click();
		Thread.sleep(2000);

	}

	// Selecting Task title and adding the title
	public void inputTasktitle(String title) {
		addaTitle.sendKeys(title);
	}

	// Selecting Task title and adding the title
	public void inputTaskDescription(String taskdescription) {
		addaDescription.sendKeys(taskdescription);
	}

	// Selecting current date from calendar
	public void selectDate() throws Exception {
			Thread.sleep(2000);
			DueDateField.click();
			Thread.sleep(2000);
			moveToNextMonth.click();
			Thread.sleep(2000);
			selectDate.click();
			Thread.sleep(2000);
			WebElement date = selectDate;
			
			String Data = date.getText();
			
		
			
			System.out.println(Data); 
			Thread.sleep(2000);
			
			//selectToday.click();
		}

	// Clicking on Schedule On Time field

	public String selectSalesUser(String salesUserName) throws Exception {
		driver.findElement(By.xpath("//span[@class='select2-chosen']")); // Clicking on User // dropdown

		return driver.findElement(By.xpath("//span[@class='select2-chosen']")).getText();

	}

	// Clicking on Schedule On Time field
	public void clickOnUploadAttachments() throws Exception {
		Thread.sleep(4000);

		jsClick(UploadattachmentButton);

		// By.linkText("Upload attachments").click();
		Thread.sleep(4000);
		// AmuraFolder.click();

		jsClick(AmuraFolder);

		jsClick(AttachmentFile);

		jsClick(AttachmentNewFile);

		jsClick(saveAttachment);

		Thread.sleep(3000);

	}

	// Clicking on Priority Field
	public void selectPriority() throws Exception {

		jsClick(PriorityField);
		Priority_dd.click();
	}

	// Clicking on Schedule On Time field
	public void clickOnSaveButton() {
		saveButton.click();
	}

	// Clicking on More Tab
	public void clickFeedTab() {
		more_d.click();
		feedTab.click();
	}

}
