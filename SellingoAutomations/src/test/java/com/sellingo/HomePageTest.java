package com.sellingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_base.Home_Page_POM;
import report.ExtentManager;


public class HomePageTest extends BeforeAfterMethods {
	Home_Page_POM homePagePom ;

	@BeforeMethod
	public void setUp() {
		homePagePom  = new Home_Page_POM();
	}
	public List<String> expectedHeader () {
		List<String> expectedHeaderList = new ArrayList<String>();
		expectedHeaderList.add("Why sellingo?");
		expectedHeaderList.add("Features");
		expectedHeaderList.add( "Tutorials");
		expectedHeaderList.add("Pricing");
		expectedHeaderList.add("Request Demo");
		expectedHeaderList.add( "FAQ");

		return expectedHeaderList;
	}

	public HashMap<String, String> expectedSlideTitleAndSubtitle() {
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put("Sell", "Your Product in 2 minutes");
		hMap.put("Create", "Your Online Store");
		hMap.put("Share", "Catalog On The Go");
		hMap.put("Track", "Customer's Activity");
		hMap.put("Increase Sales", "By Getting Quick Orders");	
		return hMap;
	}

	@Test(priority = 1)
	public void verifyHomePageText() {

		List<String> actualMenuList =  homePagePom.headerMenuList();
		List<String> expectedMenuList = expectedHeader();

		Assert.assertEquals(actualMenuList, expectedMenuList);
		String actualRegiterText= homePagePom.registerText();
		String expectedRegiterText ="REGISTER";
		Assert.assertEquals(actualRegiterText, expectedRegiterText);
		ExtentManager.onTestPass("Extent report checking"); // insert message here for perticular task

		String actualLoginText= 	homePagePom.loginText();
		String expectedLoginText = "LOGIN";
		Assert.assertEquals(actualLoginText, expectedLoginText);
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test (priority = 2)
	public void verifySlides() {
		HashMap<String, String> actualSlides = homePagePom.verifySlide();
		HashMap<String, String>	expectedSlides = expectedSlideTitleAndSubtitle();	
		Assert.assertEquals(actualSlides, expectedSlides);
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test (priority = 3)
	public void verifyFacebookLinkTest() {
		String actualFacebookURL = homePagePom.verifyFacebookLink();
		String expectedFacebookURL ="https://www.facebook.com/SellingoOnlineStore";
		Assert.assertEquals(actualFacebookURL, expectedFacebookURL);
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test (priority = 4)
	public void verifyTwitterLinkTest() {
		String actualTwitterURL = homePagePom.verifyTwitterLink();	
		Assert.assertTrue(actualTwitterURL.contains("x.com"));	
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test (priority = 5)
	public void verifyInstagramLinkTest() {
		String actualInstagramURL=homePagePom.verifyInstagramLink();
		String expectedInstagramURL ="https://www.instagram.com/sellingo_onlinestore/";
		Assert.assertEquals(actualInstagramURL, expectedInstagramURL);
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test (priority = 6)
	public void verifyLinkedinLinkTest() {
		String actualLinkedinURL= homePagePom.verifyLinkedinLink();
		Assert.assertTrue(actualLinkedinURL.contains("linkedin.com"));
		ExtentManager.onTestPass("Extent report checking");
	}

	@Test (priority = 7)
	public void verifyYouTubeLinkTest() {
		String actualYouTubeURL = homePagePom.verifyYouTubeLink();
		String expctedYouTubeURL ="https://www.youtube.com/channel/UCSoIdbOJxMmgPe1cm_L6nww";
		Assert.assertEquals(actualYouTubeURL, expctedYouTubeURL);
		ExtentManager.onTestPass("Extent report checking");
	}
}
