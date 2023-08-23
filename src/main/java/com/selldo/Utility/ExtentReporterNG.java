package com.selldo.Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {

	public static ExtentReports getReportObject() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(System.getProperty("user.dir") + "/config.properties"));
		} catch (IOException e) {}

		// -----------------------------------------------------------------------------
		String path = System.getProperty("user.dir") + "//reports//AutomationReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Sell.do Web login test Results");
		reporter.config().setDocumentTitle("Sell.do Automation Report");
		reporter.config().setTheme(Theme.DARK);

		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aniket Khandizod");
		extent.setSystemInfo("Email", "aniket.khandizod@sell.do");
		extent.setSystemInfo("OS", "Ubuntu");
		extent.setSystemInfo("Environment", prop.getProperty("url"));
		return extent;

//

	}
}
