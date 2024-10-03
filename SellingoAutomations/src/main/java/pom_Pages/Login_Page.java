package pom_Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	@FindBy(xpath = "//select[@class=\"form-control select-a\"]") private WebElement DropdownTextOnExpiry;
	@FindBy(xpath = "//span[text()=\"Catalog Settings \"]") private WebElement CatalogSettingText;
	@FindBy(xpath = "//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"][1]") private WebElement ShowPriceToogle;
	@FindBy(xpath = "(//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"])[2]") private WebElement ShowQuantityToggle;
	@FindBy(xpath = "(//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"])[3]") private WebElement BackOrderingToggle;
	@FindBy(xpath = "(//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"])[4]")private WebElement BuyerMobVerification ;
	@FindBy(xpath = "//div[@class=\"toggle-switch\"]//a[text()='Select Theme']") private WebElement SelectThemeLink;
	@FindBy(xpath = "//label[text()=\"Elegance\"]" )private WebElement EleganceTheme;
	@FindBy(xpath = "//button[text()=\"Save & Continue\"]")private WebElement SaveAndContinuebuttonThemePage;
	@FindBy(xpath = "//button[text()=\"Save & Continue\"]")private WebElement SaveAndContinuebuttonStep2Page;
	@FindBy(xpath = "//a[text()=\"ADD NEW PRODUCT\"]")private WebElement AddNewProductButton;
	@FindBy(xpath = "//label[@class=\"label-b\"]") private WebElement AddExistingProductButton;
	@FindBy(xpath = "(//a[text()=\"PUBLISH CATALOG\"])[2]")private WebElement PublishCatalog;
	@FindBy(xpath = "class=\"sub-title-b text-center \"") private WebElement TotalViewstext;
	
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
		clickLoginButton();
		ReusableMethods.explicitWait(ForgotPasswordLink);
		ForgotPasswordLink.click();
	}
	
	public void clickForgotPassword2() {		
		ReusableMethods.explicitWait(ForgotPasswordLink);
		ForgotPasswordLink.click();
	}
	
	public void forgotPaaswordClose(){
		clickForgotPassword();
		ReusableMethods.explicitWait(CloseButtonForgotPassword);
		CloseButtonForgotPassword.click();
	}
	
	public String forgotPassErrorMsgMobNumber() {
		clickForgotPassword();
		ReusableMethods.explicitWait(SendOTP);	
		SendOTP.click();
		return ErrorMessageForgotPassMobNumber.getText();	
	}
	
	public String forgotPassOtpErrorMessage() {
		return ErrorMessageForgotPassOTP.getText();
		}
	
	public void createNewCatalog() throws InterruptedException {
		ReusableMethods.explicitWait(AddNewCatalog);	
		AddNewCatalog.click();
		Thread.sleep(5000);
		CatalogImage.sendKeys("C:\\Users\\dk209\\Downloads\\Narrow Chain Bracelet & Plain Bangle - Narrow Chain Bracelet &amp; Plain Bangle.jpeg");
		Thread.sleep(5000);
		CatalogName.sendKeys("TestCatalogName");
		CatalogDescription.sendKeys("Test Catalog Description");
		SaveAndContinueButton.click();
		System.out.println("Congrats...Step1 catalog information has completed successfully....!!!!");
		CatalogSettingText.getText();
		ReusableMethods.explicitWait(SelectThemeLink);
		SelectThemeLink.click();
		ReusableMethods.explicitWait(EleganceTheme);	
		EleganceTheme.click();
		SaveAndContinuebuttonThemePage.click();
		ReusableMethods.explicitWait(ShowPriceToogle);	
		Select s = new Select(DropdownTextOnExpiry);
		s.selectByVisibleText("Add to Cart");
		ShowPriceToogle.click();
		ShowQuantityToggle.click();
		BackOrderingToggle.click();
		BuyerMobVerification.click();
		SaveAndContinuebuttonStep2Page.click();
		System.out.println("Congrats...Step2 catalog Setting has completed successfully....!!!!");
		Thread.sleep(3000);
		ReusableMethods.explicitWait(AddExistingProductButton);
		//AddNewProductButton.click();
		//AddExistingProductButton.click();
		Actions act = new Actions(driver);
		//act.moveToElement(AddExistingProductButton);
		act.click(AddExistingProductButton);
		ReusableMethods.explicitWait(PublishCatalog);
		PublishCatalog.click();
		ReusableMethods.explicitWait(TotalViewstext);
		//return TotalViewstext.getText();

	}
	
	
	
	
}
