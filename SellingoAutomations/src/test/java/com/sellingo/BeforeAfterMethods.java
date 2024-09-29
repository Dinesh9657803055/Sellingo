package com.sellingo;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import report.ExtentManager;
import test_base.BaseClass;

public class BeforeAfterMethods extends BaseClass {

	@BeforeSuite
	public void beforeSuitMethod() {
		ExtentManager.onStart();

	}

	@BeforeTest
	public void beforeTest() {

	}

	@BeforeMethod 
	public void setup(ITestResult result) {
		ExtentManager.onTestSuccess(result.getMethod().getMethodName());
		driverSetup();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentManager.onTestFailure(result.getMethod().getMethodName());
			Assert.fail(result.getThrowable().getMessage());
		} else if (result.getStatus() == ITestResult.SKIP) {
			ExtentManager.onTestSkipped(result.getMethod().getMethodName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
		}
		driver.close();
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.onFlush();
	}

}
