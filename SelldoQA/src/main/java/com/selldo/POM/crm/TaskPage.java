package com.selldo.POM.crm;

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

	// ...................Task Page........................

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-light task-edit-dropdown']")
	private WebElement editOption;
	@FindBy(how = How.XPATH, using = "//a[@class='dropdown-item edit_todo_task']")
	private WebElement editButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"form_container\"]/div/div/div/div/div[2]/form/div[6]/select/option[2]")
	private WebElement statusField;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Add A Task')]")
	private WebElement addTaskButton;
	@FindBy(how = How.XPATH, using = "//input[contains(@name,'task[title]')]")
	private WebElement addTaskTitle;
	@FindBy(how = How.XPATH, using = "//textarea[contains(@name,'task[description]')]")
	private WebElement addTaskDescription;
	@FindBy(how = How.XPATH, using = "//option[contains(text(),'Completed')]")
	private WebElement completeOption;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary btn-sm pull-right save']")
	private WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//label[text()='STATUS']/following::span[1]")
	private WebElement taskStatus;
	@FindBy(how = How.NAME, using = "task[status]")
	private WebElement selectTaskStatus;
	@FindBy(how = How.XPATH, using = "(//div[@class='timeline-item activity feeds']//span)[1]")
	private WebElement getTaskFeedText;
	
	public String getTaskFeedText() {
		return waitUntilVisiblity(scrollIntoViewUp(getTaskFeedText)).getText().trim();
	}
	public void AddTask() {
		scrollIntoView(driver.findElement(By.xpath("//div[contains(text(),'Requirement')]")));
		waitUntilClickable(addTaskButton);
		addTaskButton.click();

	}

	public String AddTaskTitle(String taskTitle) {
		addTaskTitle.sendKeys(taskTitle);
		return taskTitle;

	}

	public void addTaskDescription(String taskDescription) {
		addTaskDescription.sendKeys(taskDescription);

	}

	public void selectTask() {
		scrollIntoView(editOption);
		waitUntilClickable(editOption);
		editOption.click();
		waitUntilClickable(editButton);
		editButton.click();

	}

	public void OptionSelect() {
		waitUntilClickable(statusField);
		statusField.click();
	}

	public void clickOnSaveButton() throws Exception {
		waitUntilClickable(saveButton);
		saveButton.click();
	}
	public void selectTaskStatus(String str) {
		selectByVisibleText(selectTaskStatus,str);
	}
}
