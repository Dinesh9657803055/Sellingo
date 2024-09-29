package com.sellingo;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_base.Home_Page_POM;
import page_base.Login_Page;
import report.ExtentManager;
import test_utility.ReusableMethods;

public class LoginTest extends BeforeAfterMethods{
	Home_Page_POM homePagePom;
	Login_Page loginPage;
	@BeforeMethod
	public void BeforeMethod() {
		homePagePom = new Home_Page_POM();
		loginPage = new Login_Page();
		
	}

	@Test(priority = 1)
	public void loginTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualLoggedInUrl= loginPage.loginFlow(ReusableMethods.ExcellDataFetching(0, 1), ReusableMethods.ExcellDataFetching(1, 1));
		String expectedLoggedInUrl ="https://www.sellingo.ai/";
		Assert.assertEquals(actualLoggedInUrl, expectedLoggedInUrl);
		ExtentManager.onTestPass("Extent report checking");
	}
	
	@Test(priority = 2)
	public void errorMessgeMobileNumberTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualMobileNumberErrorMessage= loginPage.mobileNumberFieldErrorMessge(ReusableMethods.ExcellDataFetching(1, 1));
		String expectedMobileNumberErrorMessage = "Mobile Number is required";
		Assert.assertEquals(actualMobileNumberErrorMessage, expectedMobileNumberErrorMessage);
		ExtentManager.onTestPass("Extent report checking");

	}
	
	@Test(priority = 3)
	public void errorMessgePasswordTest() throws EncryptedDocumentException, Throwable {
		homePagePom.LoginFlow();
		String actualPasswordErrorMessage= loginPage.passwordFieldErrorMessage(ReusableMethods.ExcellDataFetching(0, 1));
		String expectedPasswordErrorMessage = "Password is required";
		Assert.assertEquals(actualPasswordErrorMessage, expectedPasswordErrorMessage);
		ExtentManager.onTestPass("Extent report checking");
	}

}
