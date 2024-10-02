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
	
	@Test(priority = 1,enabled = true)
	public void TC002_SC001_errorMessgeMobileNumberTest() throws EncryptedDocumentException, Throwable {
		//driverSetup();
		homePagePom.LoginFlow();
		String actualMobileNumberErrorMessage= loginPage.mobileNumberFieldErrorMessge(ReusableMethods.ExcellDataFetching(1, 1));
		String expectedMobileNumberErrorMessage = "Mobile Number is required";
		Assert.assertEquals(actualMobileNumberErrorMessage, expectedMobileNumberErrorMessage);
		ExtentManager.onTestPass("Extent report checking");

	}
	
	@Test(priority = 2,enabled = true)
	public void TC002_SC002_errorMessgePasswordTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualPasswordErrorMessage= loginPage.passwordFieldErrorMessage(ReusableMethods.ExcellDataFetching(0, 1));
		String expectedPasswordErrorMessage = "Password is required";
		Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessage);
		ExtentManager.onTestPass("Extent report checking");
	}
	
	@Test(priority = 4)
		public void TC002_SC005_forgotPasswordFlow() {
			homePagePom.LoginFlow();
			loginPage.clickForgotPassword();
			loginPage.forgotPaaswordClose();
		}

		@Test(priority = 5)
		public void errorValidationsForgotPass() {
			loginPage.clickForgotPassword();
			String actualErrorMesssage = loginPage.forgotPassErrorMsgMobNumber();
			String expectedErrorMessage = "Please enter mobile number.";
			Assert.assertEquals(actualErrorMesssage, expectedErrorMessage);
			ExtentManager.onTestPass("Extent report checking");
		}
	
	@Test(priority = 3,enabled = true)
	public void TC002_SC003_loginTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualLoggedInUrl= loginPage.loginFlow(ReusableMethods.ExcellDataFetching(0, 1), ReusableMethods.ExcellDataFetching(1, 1));
		String expectedLoggedInUrl ="https://www.sellingo.ai/";
		Assert.assertEquals(actualLoggedInUrl, expectedLoggedInUrl);
		ExtentManager.onTestPass("Extent report checking");
	}
	
	@Test(priority = 4)
	public void TC002_SC004_createCatalog() throws EncryptedDocumentException, Throwable {
		Thread.sleep(3000);
		homePagePom.LoginFlow();
		loginPage.loginFlow(ReusableMethods.ExcellDataFetching(0, 1), ReusableMethods.ExcellDataFetching(1, 1));
		Thread.sleep(3000);
		loginPage.createNewCatalog();
		//driver.close();
	}
	
	
	 
	
}
