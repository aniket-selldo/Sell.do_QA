package com.selldo.Utility;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listneers extends BaseTest implements ITestListener {

	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>(); // Thread safe
	ExtentReports extent = ExtentReporterNG.getReportObject();

	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);// unique thread id(ErrorValidationTest)->test
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());//
		try {
			driver = (ChromeDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
		}

		String filePath = null;
		String filePathTrimmed = null;
		try {

			filePath = getScreenshot(result.getMethod().getMethodName(), driver);
			filePathTrimmed = ".." + filePath.split(Paths.get(System.getProperty("user.dir")).getFileName().toString())[1];
		} catch (Exception e) {
		}
		extentTest.get().addScreenCaptureFromPath(filePathTrimmed, result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.get().log(Status.SKIP, "Retry Test");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		// extentTest.get().log(Status.INFO, "Test Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		extentTest.get().log(Status.INFO, "Test Start");
		extent.flush();
		String path = System.getProperty("user.dir") + "//reports//AutomationReport.html";
		File htmlFile = new File(path);
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
