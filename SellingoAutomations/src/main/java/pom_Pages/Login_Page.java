package pom_Pages;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
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
	@FindBy(xpath = "//h2[text()='Forgot Password']") private WebElement ForgotPasswordText;
	@FindBy(xpath = "//a[text()=\"REGISTER NOW!\"]") private WebElement RegisterNowButton;
	@FindBy(xpath = "//a[text()=\"Terms & conditions\"]") private WebElement TermsAndConditions;
	@FindBy(xpath = "//a[text()=\"Privacy policy\"]")private WebElement PrivacyPolicy ;
	@FindBy(xpath = "(//span[text()=\"×\"])[1]") private WebElement CloseButton;
	@FindBy(xpath = "//input[@id=\"user_mobile_forgot\"]")private WebElement FogotPasswordMobileField;
	@FindBy(xpath = "//input[@id=\"conf_otp\"]") private WebElement ConfirmOTP; 
	@FindBy(xpath = "//button[text()=\"CONFIRM OTP\"]") private WebElement ConfirmOTPButton;
	@FindBy(xpath = "(//span[text()=\"×\"])[2]") private WebElement CloseButtonForgotPassword;
	@FindBy(xpath = "//button[text()=\"Send OTP\"]") private WebElement SendOTP;
	@FindBy(xpath = "//input[@id=\"user_mobile_forgot\"]") private WebElement InserMobForgotPassword;
	@FindBy(xpath = "//span[@id=\"id_forgot_otp_send_err\"]") private WebElement ErrorMessageForgotPassMobNumber;
	@FindBy(xpath = "//span[text()=\"OTP is required\"]") private WebElement ErrorMessageForgotPassOTP;
	@FindBy(xpath = "//span[@id=\"id_forgot_otp_success\"]") private WebElement OTPSuccessMessage;
	@FindBy(xpath = "//a[@class=\"btn btn-a add-new-catalog-bt add_new_catalog_btn\"]") private WebElement AddNewCatalog;
	@FindBy(xpath = "//input[@id=\"catalog_image\"]") private WebElement CatalogImage;
	@FindBy(xpath = "//input[@class=\"form-control input-a\"]") private WebElement CatalogName;
	@FindBy(xpath = "//input[@class=\"form-control input-a valid\"]")private WebElement EditedCatalogNameField;
	@FindBy(xpath = "//textarea[@id=\"catalog_description\"]")private WebElement CatalogDescription;
	@FindBy(xpath = "//button[@class=\"btn btn-a text-uppercase add_catalog\"]") public WebElement SaveAndContinueButton;
	@FindBy(xpath = "//select[@class=\"form-control select-a\"]") private WebElement DropdownTextOnExpiry;
	@FindBy(xpath = "//span[text()=\"Catalog Settings \"]") private WebElement CatalogSettingText;
	@FindBy(xpath = "//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"][1]") private WebElement ShowPriceToogle;
	@FindBy(xpath = "(//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"])[2]") private WebElement ShowQuantityToggle;
	@FindBy(xpath = "(//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"])[3]") private WebElement BackOrderingToggle;
	@FindBy(xpath = "(//div[@class=\"input-side-right\"]//div[@class=\"toggle-switch\"])[4]")private WebElement BuyerMobVerification ;
	@FindBy(xpath = "//div[@class=\"toggle-switch\"]//a[text()='Select Theme']") private WebElement SelectThemeLink;
	@FindBy(xpath = "//label[text()=\"Elegance\"]" )private WebElement EleganceTheme;
	@FindBy(xpath = "//label[@for=\"inputtheme_id1\"]") private WebElement PrimeTheme;
	@FindBy(xpath = "//button[text()=\"Save & Continue\"]")private WebElement SaveAndContinuebuttonThemePage;
	@FindBy(xpath = "//button[text()=\"Save & Continue\"]")private WebElement SaveAndContinuebuttonStep2Page;
	@FindBy(xpath = "//a[text()=\"ADD NEW PRODUCT\"]")private WebElement AddNewProductButton;
	@FindBy(xpath = "//input[@id=\"arr_products_1\"]//following-sibling::label") private WebElement AddExistingProductButton;
	@FindBy(xpath = "(//a[text()=\"PUBLISH CATALOG\"])[1]")private WebElement PublishCatalog;
	@FindBy(xpath = "(//a[text()=\"PUBLISH CATALOG\"])[2]")private WebElement PublishCatalog2;
	@FindBy(xpath = "//h3[@class=\"sub-title-b text-center \"]") private WebElement TotalViewstext;
	@FindBy(xpath = "//nav[@class=\"nav-menu d-none d-lg-block\"]//ul//li//a[@href=\"https://www.sellingo.ai/merchant/mycatalog\"]") private WebElement MyCatalogHeader;
	@FindBy(xpath = "//span[@class=\"dele-buttons\"]") private WebElement deleteIcon;
	@FindBy(xpath = "//span[@class=\"or-circle\"]") private WebElement ORtext;
	@FindBy(xpath = "//label[text()=\"Text on Enquiry Button\"]") private WebElement Step2Text;
	@FindBy(xpath = "(//div[@class=\"col-4 px-1\"]//div[@class=\"prd-catalogfigure d-lg-flex align-items-center\"])//parent::a") private WebElement EditCatalog ;
	
	
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
		InsertPassword.clear();
		enterMobileNumber(mobileNumber);
		clickLoginButton();
		return ErrorMessagePassword.getText();
	}

	public String clickForgotPassword() {		
		//	clickLoginButton();
		ReusableMethods.explicitWait(ForgotPasswordLink);
		ForgotPasswordLink.click();
		ReusableMethods.explicitWait(ForgotPasswordText);
		return ForgotPasswordText.getText();
	}

	public void clickForgotPassword2() {		
		ReusableMethods.explicitWait(ForgotPasswordLink);
		ForgotPasswordLink.click();
	}

	public void forgotPaaswordClose(){
		//clickForgotPassword();
		ReusableMethods.explicitWait(CloseButtonForgotPassword);
		CloseButtonForgotPassword.click();
	}

	public String getSuucessMessage(String mobileNumberForgotPass) {
		InserMobForgotPassword.sendKeys(mobileNumberForgotPass);
		SendOTP.click();
		ReusableMethods.explicitWait(OTPSuccessMessage);
		return OTPSuccessMessage.getText();
	}

	public String forgotPassErrorMsgMobNumber() {
		ReusableMethods.explicitWait(SendOTP);	
		SendOTP.click();
		return ErrorMessageForgotPassMobNumber.getText();	
	}

	public String forgotPassOtpErrorMessage() {	
		ConfirmOTPButton.click();
		ReusableMethods.explicitWait(ErrorMessageForgotPassOTP);
		return ErrorMessageForgotPassOTP.getText();
	}

	public String createNewCatalogStep1(String CatalogImageUpload,String CatalogNameUpload, String CatalogDescriptionUpload) throws EncryptedDocumentException, Throwable {
		Thread.sleep(6000);
		ReusableMethods.explicitWait(AddNewCatalog);	
		AddNewCatalog.click();
		Thread.sleep(5000);
		CatalogImage.sendKeys(CatalogImageUpload);
		Thread.sleep(3000);
		CatalogName.sendKeys(CatalogNameUpload);
		CatalogDescription.sendKeys(CatalogDescriptionUpload);
		SaveAndContinueButton.click();
		System.out.println("Congrats...Step1 catalog information has completed successfully....!!!!");
		ReusableMethods.explicitWait(Step2Text);
		return Step2Text.getText();
	/*
		ReusableMethods.explicitWait(PublishCatalog);
		Thread.sleep(2000);
		PublishCatalog.click();
		ReusableMethods.explicitWait(TotalViewstext);
		TotalViewstext.getText();
		*/
	}	
	
	public String createCatalogStep2(String selectDropdownValue) throws EncryptedDocumentException, Throwable {
		ReusableMethods.explicitWait(SelectThemeLink);
		SelectThemeLink.click();
		ReusableMethods.explicitWait(EleganceTheme);	
		EleganceTheme.click();
		SaveAndContinuebuttonThemePage.click();
		ReusableMethods.explicitWait(ShowPriceToogle);	
		Select s = new Select(DropdownTextOnExpiry);
		s.selectByVisibleText(selectDropdownValue);
		Thread.sleep(2000);
		ShowPriceToogle.click();
		Thread.sleep(2000);
		ShowQuantityToggle.click();
		Thread.sleep(2000);
		BackOrderingToggle.click();
		Thread.sleep(2000);
		BuyerMobVerification.click();
		Thread.sleep(2000);
		SaveAndContinuebuttonStep2Page.click();
		System.out.println("Congrats...Step2 catalog Setting has completed successfully....!!!!");
		ReusableMethods.explicitWait(PublishCatalog2);
		return PublishCatalog2.getText();	
	}
	
	public String createCatalogStep3() throws InterruptedException {
		Thread.sleep(4000);
		ReusableMethods.scrollDown(PublishCatalog2);
		ReusableMethods.explicitWait(PublishCatalog);
		Thread.sleep(2000);
		PublishCatalog.click();
		ReusableMethods.explicitWait(TotalViewstext);
		// MyCatalogHeader.click();
		// deleteIcon.click();
		return TotalViewstext.getText();
	}
	
	public String EditCatalogFlowStep1(String EditedCatalogName, String EditedCatalogDescription) throws EncryptedDocumentException, Throwable {
		Thread.sleep(5000);
		ReusableMethods.explicitWait(EditCatalog);
		EditCatalog.click();
		ReusableMethods.explicitWait(CatalogName);
		CatalogName.clear();
		CatalogName.sendKeys(EditedCatalogName);
		ReusableMethods.explicitWait(CatalogDescription);
		CatalogDescription.clear();
		CatalogDescription.sendKeys(EditedCatalogDescription);
		SaveAndContinueButton.click();
		System.out.println("Congrats Edit done for Step 1... catalog information has completed successfully....!!!!");
		ReusableMethods.explicitWait(Step2Text);
		return Step2Text.getText();
	}
	
	public String editCreateCatalogStep2(String selectDropdownValue) throws EncryptedDocumentException, Throwable {
		Thread.sleep(3000);
		ReusableMethods.explicitWait(SelectThemeLink);
		SelectThemeLink.click();
		ReusableMethods.explicitWait(PrimeTheme);	
		PrimeTheme.click();
		SaveAndContinuebuttonThemePage.click();
		ReusableMethods.explicitWait(ShowPriceToogle);	
		Select s = new Select(DropdownTextOnExpiry);
		s.selectByVisibleText(selectDropdownValue);
		/*Thread.sleep(2000);
		ShowPriceToogle.click();
		Thread.sleep(2000);
		ShowQuantityToggle.click();
		Thread.sleep(2000);*/
		BackOrderingToggle.click();
		Thread.sleep(2000);
		BuyerMobVerification.click();
		Thread.sleep(2000);
		SaveAndContinuebuttonStep2Page.click();
		System.out.println("Congrats Edit for Step 2 is Completed...Step2 for Edit Catalog Setting has completed successfully....!!!!");
		ReusableMethods.explicitWait(PublishCatalog2);
		return PublishCatalog2.getText();	
	}
	
	public String editCreateCatalogStep3() throws InterruptedException {
		Thread.sleep(3000);
		ReusableMethods.scrollDown(PublishCatalog2);
		ReusableMethods.explicitWait(PublishCatalog);
		Thread.sleep(2000);
		PublishCatalog.click();
		ReusableMethods.explicitWait(TotalViewstext);
		// MyCatalogHeader.click();
		// deleteIcon.click();
		return TotalViewstext.getText();
	}
	
	
}
