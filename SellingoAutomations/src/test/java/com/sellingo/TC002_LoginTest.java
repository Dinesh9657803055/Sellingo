package com.sellingo;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom_Pages.Home_Page_POM;
import pom_Pages.Login_Page;
import report.ExtentManager;
import test_utility.ReusableMethods;

public class TC002_LoginTest extends BeforeAfterMethods{
	Home_Page_POM homePagePom;
	Login_Page loginPage;

	@BeforeClass
	public void BeforeMethod() {
		homePagePom = new Home_Page_POM();
		loginPage = new Login_Page();
		homePagePom.LoginFlow();
	}

	@Test(priority = 1,enabled = true)
	public void TC002_SC001_errorMessgeMobileNumberTest() throws EncryptedDocumentException, Throwable {
		String actualMobileNumberErrorMessage= loginPage.mobileNumberFieldErrorMessge(ReusableMethods.ExcellDataFetching(1, 1));
		String expectedMobileNumberErrorMessage = ReusableMethods.ExcellDataFetching(25, 1);
		Assert.assertEquals(actualMobileNumberErrorMessage, expectedMobileNumberErrorMessage);
		ExtentManager.onTestPass("Verified Error Message for Mobile Number field on Login Pop Up");
	}

	@Test(priority = 2,enabled = true)
	public void TC002_SC002_errorMessgePasswordTest() throws EncryptedDocumentException, Throwable {
		String actualPasswordErrorMessage= loginPage.passwordFieldErrorMessage(ReusableMethods.ExcellDataFetching(0, 1));
		String expectedPasswordErrorMessage = ReusableMethods.ExcellDataFetching(26, 1);
		Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessage);
		ExtentManager.onTestPass("Verified Error Message for Password field on Login Pop Up");
	}

	@Test(priority = 3, enabled = true)
	public void TC002_SC003_forgotPasswordFlow() throws EncryptedDocumentException, Throwable {
		String actualForgotPassText = loginPage.clickForgotPassword();
		String expectedForgotPassText =ReusableMethods.ExcellDataFetching(35, 1);
		//loginPage.forgotPaaswordClose();
		Assert.assertEquals(actualForgotPassText, expectedForgotPassText);
		ExtentManager.onTestPass("Verified Forgot Passowrd Pop Up");
	}

	@Test(priority = 4,enabled = true)
	public void TC002_SC004_testErrorMessageForgotPassword() throws EncryptedDocumentException, Throwable {
		//loginPage.clickForgotPassword2();
		String actualErrorMSG =loginPage.forgotPassErrorMsgMobNumber();
		String expectedErrorMessage = ReusableMethods.ExcellDataFetching(27, 1);		
		Assert.assertEquals(actualErrorMSG, expectedErrorMessage);		
		ExtentManager.onTestPass("Verified Error Message for Mobile Number field on Forgot Password Pop Up");
	}

	@Test(priority = 5, enabled = true)
	public void TC002_SC005_verifySuccessMessageForMobField() throws EncryptedDocumentException, Throwable {
		String actualSucessMessage= loginPage.getSuucessMessage(ReusableMethods.ExcellDataFetching(0, 1));
		String expectedSuccessMessage = ReusableMethods.ExcellDataFetching(36, 1);
		Assert.assertEquals(actualSucessMessage, expectedSuccessMessage);
		ExtentManager.onTestPass("Verified Success Message for Sending OTP over Mobile Number on Forgot Password Pop Up");
	}

	@Test(priority = 6, enabled = true)
	public void TC002_SC006_testErrorMessageOTPfield() throws EncryptedDocumentException, Throwable {
		//loginPage.clickForgotPassword2();	
		String actualErrorMessageOTP = loginPage.forgotPassOtpErrorMessage();
		String expectedErrorMessageOTP = ReusableMethods.ExcellDataFetching(28, 1);
		Assert.assertEquals(actualErrorMessageOTP, expectedErrorMessageOTP);
		ExtentManager.onTestPass("Verified Error Message for OTP field on Forgot Password Pop Up");
		loginPage.forgotPaaswordClose();	
	}

	@Test(priority = 7,enabled = true)
	public void TC002_SC007_loginTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualLoggedInUrl= loginPage.loginFlow(ReusableMethods.ExcellDataFetching(0, 1), ReusableMethods.ExcellDataFetching(1, 1));
		String expectedLoggedInUrl = ReusableMethods.ExcellDataFetching(30, 1);
		Assert.assertEquals(actualLoggedInUrl, expectedLoggedInUrl);
		ExtentManager.onTestPass("Verified User has Logged in Successfully with valid credentials and on Dashboard Page");
	}

	@Test(priority = 8,enabled = true)
	public void TC002_SC008_createCatalogStep1() throws EncryptedDocumentException, Throwable {
		String actualTextTextonEnquiry = loginPage.createNewCatalogStep1(ReusableMethods.ExcellDataFetching(32, 1),ReusableMethods.ExcellDataFetching(31, 1),ReusableMethods.ExcellDataFetching(33, 1));
		String ExpectedTextTextonEnquiry = ReusableMethods.ExcellDataFetching(37, 1);
		Assert.assertEquals(actualTextTextonEnquiry, ExpectedTextTextonEnquiry);
		ExtentManager.onTestPass("Setp 1 for Creating Catalog is completed Successfully now you are on Step 2 page");	
	}

	@Test(priority = 9, enabled = true)
	public void TC002_SC009_createCatalogStep2() throws EncryptedDocumentException, Throwable {
		String actualTextCatalogStetting = loginPage.createCatalogStep2(ReusableMethods.ExcellDataFetching(34, 1));
		String expectedTextCatalogSetting = ReusableMethods.ExcellDataFetching(38, 1);
		Assert.assertEquals(actualTextCatalogStetting, expectedTextCatalogSetting);
		ExtentManager.onTestPass("Setp 2 for Catalog Settings is completed Successfully now you are on Step 3 page");
	}

	@Test(priority = 10, enabled = true)
	public void TC002_SC010_createCatalogStep3() throws EncryptedDocumentException, Throwable {
		String actualTotalViewstext = loginPage.createCatalogStep3();
		String expectedTotalViewstext = ReusableMethods.ExcellDataFetching(39, 1);
		Assert.assertEquals(actualTotalViewstext, expectedTotalViewstext);
		ExtentManager.onTestPass("Setp 3 for Publish Catalog is completed Successfully now you are on View and Edit Page");
	}

	@Test(priority = 11, enabled = true)
	public void TC002_SC011_editCreateCatalogStep1() throws EncryptedDocumentException, Throwable {
		String actualTextTextonEnquiryEdited = loginPage.EditCatalogFlowStep1(ReusableMethods.ExcellDataFetching(40, 1),ReusableMethods.ExcellDataFetching(41, 1));
		String ExpectedTextTextonEnquiryEdited = ReusableMethods.ExcellDataFetching(37, 1);
		Assert.assertEquals(actualTextTextonEnquiryEdited, ExpectedTextTextonEnquiryEdited);
		ExtentManager.onTestPass("Setp 1 for Creating Catalog is completed Successfully now you are on Step 2 page");
	}

	@Test (priority = 12, enabled = true)
	public void TC002_SC_012_editCreateCatalogStep2() throws EncryptedDocumentException, Throwable {
		String actualTextTextonEnquiryEdited=loginPage.editCreateCatalogStep2(ReusableMethods.ExcellDataFetching(34, 1));
		String ExpectedTextTextonEnquiryEdited = ReusableMethods.ExcellDataFetching(38, 1);
		Assert.assertEquals(actualTextTextonEnquiryEdited, ExpectedTextTextonEnquiryEdited);
		ExtentManager.onTestPass("Setp 2 for Edit catalog Settings is completed Successfully now you are on Step 3 page");
	}

	@Test (priority = 13, enabled = true)
	public void TC002_SC013_editeditCreateCatalogStep3() throws EncryptedDocumentException, Throwable {
		String actualTotalViewstextEdited =loginPage.editCreateCatalogStep3();
		String expectedTotalViewstextEdited = ReusableMethods.ExcellDataFetching(39, 1);
		Assert.assertEquals(actualTotalViewstextEdited, expectedTotalViewstextEdited);
		ExtentManager.onTestPass("Setp 3 for Edit & Publish Catalog is completed Successfully now you are on View and Edit Page");
	}

}
