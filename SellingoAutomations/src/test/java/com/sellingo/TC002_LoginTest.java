package com.sellingo;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom_Pages.Home_Page_POM;
import pom_Pages.Login_Page;
import report.ExtentManager;
import test_utility.ReusableMethods;

public class TC002_LoginTest extends BeforeAfterMethods{
	Home_Page_POM homePagePom;
	Login_Page loginPage;

	@BeforeMethod
	public void BeforeMethod() {
		homePagePom = new Home_Page_POM();
		loginPage = new Login_Page();	

	}

	//@Test(priority = 1,enabled = false)
	public void TC002_SC001_errorMessgeMobileNumberTest() throws EncryptedDocumentException, Throwable {
		//driverSetup();
		homePagePom.LoginFlow();
		String actualMobileNumberErrorMessage= loginPage.mobileNumberFieldErrorMessge(ReusableMethods.ExcellDataFetching(1, 1));
		String expectedMobileNumberErrorMessage = ReusableMethods.ExcellDataFetching(25, 1);
		Assert.assertEquals(actualMobileNumberErrorMessage, expectedMobileNumberErrorMessage);
		ExtentManager.onTestPass("Extent report checking");

	}

	//@Test(priority = 2,enabled = false)
	public void TC002_SC002_errorMessgePasswordTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualPasswordErrorMessage= loginPage.passwordFieldErrorMessage(ReusableMethods.ExcellDataFetching(0, 1));
		String expectedPasswordErrorMessage = ReusableMethods.ExcellDataFetching(26, 1);
		Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessage);
		ExtentManager.onTestPass("Extent report checking");
	}

	//@Test(priority = 3, enabled = false)
	public void TC002_SC005_forgotPasswordFlow() {
		homePagePom.LoginFlow();
		loginPage.clickForgotPassword();
		ExtentManager.onTestPass("Extent report checking");
	}

	//@Test(priority = 4,enabled = false)
	public void TC002_SC006_forgotPassCloseTest () {
		homePagePom.LoginFlow();
		loginPage.forgotPaaswordClose();
		ExtentManager.onTestPass("Extent report checking");
	}

	//@Test(priority = 5,enabled = false)
	public void TC002_SC005_testErrorMessageForgotPassword() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		loginPage.clickForgotPassword2();
		String actualErrorMSG =loginPage.forgotPassErrorMsgMobNumber();
		String expectedErrorMessage = ReusableMethods.ExcellDataFetching(27, 1);		
		Assert.assertEquals(actualErrorMSG, expectedErrorMessage);		
		ExtentManager.onTestPass("Extent report checking");
	}

	//@Test(priority = 6, enabled = false)
	public void TC002_SC006_testErrorMessageOTPfield() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		loginPage.clickForgotPassword2();
		String actualErrorMessageOTP = loginPage.forgotPassOtpErrorMessage();
		String expectedErrorMessageOTP = ReusableMethods.ExcellDataFetching(28, 1);
		Assert.assertEquals(actualErrorMessageOTP, expectedErrorMessageOTP);
		ExtentManager.onTestPass("Extent report checking");
	}

	//@Test(priority = 7, enabled = false)
	public void TC002_SC007_errorValidationsForgotPass() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		loginPage.clickForgotPassword2();
		String actualErrorMesssage = loginPage.forgotPassErrorMsgMobNumber();
		String expectedErrorMessage = ReusableMethods.ExcellDataFetching(29, 1);
		Assert.assertEquals(actualErrorMesssage, expectedErrorMessage);
		ExtentManager.onTestPass("Extent report checking");
	}

	//@Test(priority = 8,enabled = true)
	public void TC002_SC008_loginTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualLoggedInUrl= loginPage.loginFlow(ReusableMethods.ExcellDataFetching(0, 1), ReusableMethods.ExcellDataFetching(1, 1));
		String expectedLoggedInUrl = ReusableMethods.ExcellDataFetching(30, 1);
		Assert.assertEquals(actualLoggedInUrl, expectedLoggedInUrl);
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test(priority = 9,enabled = true)
	public void TC002_SC009_createCatalogWithAlreadyExistingProduct() throws EncryptedDocumentException, Throwable {
		Thread.sleep(3000);
		homePagePom.LoginFlow();
		loginPage.loginFlow(ReusableMethods.ExcellDataFetching(0, 1), ReusableMethods.ExcellDataFetching(1, 1));
		Thread.sleep(3000);
		loginPage.createNewCatalog();
		ExtentManager.onTestPass("Extent report checking");
		//driver.close();
	}




}
