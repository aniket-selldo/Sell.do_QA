package com.selldo.Utility;

import com.aventstack.extentreports.ExtentTest;

public class ThreadLocal_POJO {
	 private ThreadLocal<ExtentTest> extentTest;

	public ThreadLocal<ExtentTest> getExtentTest() {
		return extentTest;
	}

	public void setExtentTest(ThreadLocal<ExtentTest> extentTest) {
		this.extentTest = extentTest;
	}
}
