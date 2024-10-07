package pom_Pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test_base.BaseClass;
import test_utility.ReusableMethods;

public class Home_Page_POM extends BaseClass{

	@FindBy(xpath = "//a[text()='Register']") private WebElement RegisterText;
	@FindBy(xpath = "//a[text()='Login']") private WebElement LoginText;
	@FindBy(xpath = "//nav[@class=\"nav-menu d-none d-lg-block\"]//li") private List<WebElement> HeaderMenu;
	@FindBy(xpath = "(//span[@aria-label=\"Next\"])[1]") private WebElement nextButton;
	@FindBy(xpath = "//div[@class=\"owl-stage\"]//div[@class=\"item\"]") private List<WebElement> slides;
	@FindBy(xpath = "//div[@class=\"text-center text-lg-left slide1-caption aos-init aos-animate\"]//h1") private List<WebElement> slideTitle;
	@FindBy(xpath = "//div[@class=\"text-center text-lg-left slide1-caption aos-init aos-animate\"]//h2") private List<WebElement> slideSubTitle;
	@FindBy(xpath = "//div[@class=\"phone share\"]") private WebElement ShareOn ;
	@FindBy(xpath = "//a[@href=\"https://www.facebook.com/Sellingo-107313954331563\"]")private WebElement FacebookLink;
	@FindBy(xpath = "//a[@href=\"https://twitter.com/sellingocatalog\"]") private WebElement TwitterLink; 
	@FindBy(xpath = "//a[@href=\"https://www.instagram.com/sellingo_onlinestore\"]")private WebElement InstagramLink;
	@FindBy(xpath = "//a[@href=\"https://www.linkedin.com/company/sellingocatalog\"]") private WebElement LinkedinLink;
	@FindBy(xpath = "//a[@href=\"https://www.youtube.com/channel/UCSoIdbOJxMmgPe1cm_L6nww\"]") private WebElement YoutubeLink;

	public Home_Page_POM() {
		PageFactory.initElements(driver, this);	
	}
	public List<String> headerMenuList() {
		List<String> headerMenuText = new ArrayList<String>();
		ReusableMethods.explicitWait(HeaderMenu.get(0));
		List<WebElement> headerMenuElement = HeaderMenu;
		for (WebElement element: headerMenuElement) {
			headerMenuText.add(element.getText());		 
		}
		return headerMenuText;
	}

	public String registerText() {
		return RegisterText.getText();
	}

	public String loginText() {
		return LoginText.getText();
	}

	public HashMap<String, String> verifySlide() {
		HashMap<String, String> map =  new HashMap<String, String>();
		for (int index =0; index<slides.size();index++) {
			ReusableMethods.explicitWait(slideTitle.get(index));
			String title = slideTitle.get(index).getText();
			String subTitle= slideSubTitle.get(index).getText();
			map.put(title, subTitle);
			if (index != (slides.size()-1)) {	
				ReusableMethods.explicitWait(nextButton);
				nextButton.click();
			}
		}
		return map;
	}

	public String switchToChildwindowhandles () {
		String mainWindow = driver.getWindowHandle();
		Set<String> windowID =driver.getWindowHandles();	
		Iterator<String > window=windowID.iterator();
		String currentURL1 ="";
		while(window.hasNext()) {
			String currentWindow =window.next();
			if (!currentWindow.equals(mainWindow)) {
				driver.switchTo().window(currentWindow);
				currentURL1 =driver.getCurrentUrl();
				driver.close();
			}
		}
		driver.switchTo().window(mainWindow);
		return currentURL1;
	}

	public String verifyFacebookLink() {
		ReusableMethods.scrollDown(ShareOn);
		ReusableMethods.explicitWait(FacebookLink);
		FacebookLink.click();
		String actualFacebookURL= switchToChildwindowhandles();
		return actualFacebookURL;
	}

	public String verifyTwitterLink() {
		ReusableMethods.scrollDown(ShareOn);
		ReusableMethods.explicitWait(TwitterLink);
		TwitterLink.click();
		String actualTwitterUrl = switchToChildwindowhandles();
		return actualTwitterUrl;
	}

	public String verifyInstagramLink() {
		ReusableMethods.scrollDown(ShareOn);
		ReusableMethods.explicitWait(InstagramLink);
		InstagramLink.click();
		String actualInstaramUrl = switchToChildwindowhandles ();
		return actualInstaramUrl;	
	}

	public String verifyLinkedinLink() {
		ReusableMethods.scrollDown(ShareOn);
		ReusableMethods.explicitWait(LinkedinLink);
		LinkedinLink.click();
		String actualLinkedinUrl =switchToChildwindowhandles();
		return actualLinkedinUrl;
	}

	public String verifyYouTubeLink() {
		ReusableMethods.scrollDown(ShareOn);
		ReusableMethods.explicitWait(YoutubeLink);
		YoutubeLink.click();
		String actualYouTubeUrl = switchToChildwindowhandles ();
		return actualYouTubeUrl;
	}

	public void LoginFlow() {
		ReusableMethods.explicitWait(LoginText);
		LoginText.click();
	}
}
