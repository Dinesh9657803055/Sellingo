package pom_Pages;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_base.BaseClass;
import test_utility.ReusableMethods;

public class Login_Page extends BaseClass {
	
	@FindBy(xpath = "//input[@id=\"user_mobile_login\"]") private WebElement InputMobileNumber;
	@FindBy(xpath = "//input[@id=\"user_password_login\"]")private WebElement InsertPassword;
	@FindBy(xpath = "//span[@id=\"user_mobile_login-error\"]") private WebElement ErrorMessageMobileNumber;
	@FindBy(xpath = "//span[@id=\"user_password_login-error\"]")private WebElement ErrorMessagePassword;
	@FindBy(xpath = "//button[text()=\"LOGIN\"]") private WebElement LoginButton;
	@FindBy(xpath = "//a[text()=\"Forgot Password\"]") private WebElement ForgotPasswordLink;
	@FindBy(xpath = "//a[text()=\"REGISTER NOW!\"]") private WebElement RegisterNowButton;
	@FindBy(xpath = "//a[text()=\"Terms & conditions\"]") private WebElement TermsAndConditions;
	@FindBy(xpath = "//a[text()=\"Privacy policy\"]")private WebElement PrivacyPolicy ;
	@FindBy(xpath = "(//span[text()=\"×\"])[1]") private WebElement CloseButton;
	@FindBy(xpath = "//input[@id=\"user_mobile_forgot\"]")private WebElement FogotPasswordMobileField;
	@FindBy(xpath = "//input[@id=\"conf_otp\"]") private WebElement ConfirmOTP;
	@FindBy(xpath = "(//span[text()=\"×\"])[2]") private WebElement CloseButtonForgotPassword;
	@FindBy(xpath = "//button[text()=\"Send OTP\"]") private WebElement SendOTP;
	@FindBy(xpath = "//span[@id=\"id_forgot_otp_send_err\"]") private WebElement ErrorMessageForgotPassMobNumber;
	@FindBy(xpath = "//span[@id=\"id_invalid_forgot_err\"]") private WebElement ErrorMessageForgotPassOTP;
	@FindBy(xpath = "//a[@class=\"btn btn-a add-new-catalog-bt add_new_catalog_btn\"]") private WebElement AddNewCatalog;
	@FindBy(xpath = "//input[@id=\"catalog_image\"]") public WebElement CatalogImage;
	@FindBy(xpath = "//input[@class=\"form-control input-a\"]") public WebElement CatalogName;
	@FindBy(xpath = "//textarea[@id=\"catalog_description\"]")public WebElement CatalogDescription;
	@FindBy(xpath = "//button[@class=\"btn btn-a text-uppercase add_catalog\"]") public WebElement SaveAndContinueButton;
	
	public Login_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		ReusableMethods.explicitWait(InputMobileNumber);
		InputMobileNumber.sendKeys(mobileNumber);	
	}
	public void enterPassword(String password) {
		ReusableMethods.explicitWait(InsertPassword);
		InsertPassword.sendKeys(password);
	}
	
	public void clickLoginButton() {
		ReusableMethods.explicitWait(LoginButton);
		LoginButton.click();	
	}
	public String afterLoginURL() {
		return driver.getCurrentUrl();
		 
	}
	public String loginFlow(String mobileNumber, String password) {
		enterMobileNumber(mobileNumber);
		enterPassword(password);
		clickLoginButton();
		return afterLoginURL();	
	}
	
	public String mobileNumberFieldErrorMessge(String password ) {
		enterPassword(password );
		clickLoginButton();
		return ErrorMessageMobileNumber.getText();
	}
	
	public String passwordFieldErrorMessage(String mobileNumber) {
		enterMobileNumber(mobileNumber);
		clickLoginButton();
		return ErrorMessagePassword.getText();
	}
	
	public void clickForgotPassword() {
		ForgotPasswordLink.click();
	}
	
	public void forgotPaaswordClose(){
		ForgotPasswordLink.click();
		CloseButtonForgotPassword.click();
	}
	
	public String forgotPassErrorMsgMobNumber() {
		SendOTP.click();
		return ErrorMessageForgotPassMobNumber.getText();	
	}
	
	public String forgotPassOtpErrorMessage() {
		return ErrorMessageForgotPassOTP.getText();
		}
	
	public void createNewCatalog() throws InterruptedException {
		ReusableMethods.explicitWait(AddNewCatalog);
		
		AddNewCatalog.click();
		CatalogImage.sendKeys("C:\\Users\\dk209\\Downloads\\Narrow Chain Bracelet & Plain Bangle - Narrow Chain Bracelet &amp; Plain Bangle.jpeg");
		Thread.sleep(5000);
		CatalogName.sendKeys("TestCatalogName");
		CatalogDescription.sendKeys("Test Catalog Description");
		SaveAndContinueButton.click();
	}
	
	
	
	
}
