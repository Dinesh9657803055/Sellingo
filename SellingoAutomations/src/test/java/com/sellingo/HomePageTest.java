package com.sellingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page_base.Home_Page_POM;
import test_base.BaseClass;

public class HomePageTest extends BaseClass {
	Home_Page_POM homePagePom ;

	@BeforeMethod
	public void setUp() {
		driverSetup();
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

	//@Test
	public void verifyHomePageText() {

		List<String> actualMenuList =  homePagePom.headerMenuList();
		List<String> expectedMenuList = expectedHeader();

		Assert.assertEquals(actualMenuList, expectedMenuList);
		String actualRegiterText= homePagePom.registerText();
		String expectedRegiterText ="REGISTER";
		Assert.assertEquals(actualRegiterText, expectedRegiterText);

		String actualLoginText= 	homePagePom.loginText();
		String expectedLoginText = "LOGIN";
		Assert.assertEquals(actualLoginText, expectedLoginText);
	}

	//@Test
	public void verifySlides() {
		HashMap<String, String> actualSlides = homePagePom.verifySlide();
		HashMap<String, String>	expectedSlides = expectedSlideTitleAndSubtitle();	
		Assert.assertEquals(actualSlides, expectedSlides);
	}

	@Test (priority = 1)
	public void verifyFacebookLinkTest() {
		String actualFacebookURL = homePagePom.verifyFacebookLink();
		String expectedFacebookURL ="https://www.facebook.com/SellingoOnlineStore";
		Assert.assertEquals(actualFacebookURL, expectedFacebookURL);	
	}

	@Test (priority = 2)
	public void verifyTwitterLinkTest() {
		String actualTwitterURL = homePagePom.verifyTwitterLink();	
		Assert.assertTrue(actualTwitterURL.contains("x.com"));	
	}

	@Test (priority = 3)
	public void verifyInstagramLinkTest() {
		String actualInstagramURL=homePagePom.verifyInstagramLink();
		String expectedInstagramURL ="https://www.instagram.com/sellingo_onlinestore/";
		Assert.assertEquals(actualInstagramURL, expectedInstagramURL);
	}
	
	@Test (priority = 4)
	public void verifyLinkedinLinkTest() {
		String actualLinkedinURL= homePagePom.verifyLinkedinLink();
		Assert.assertTrue(actualLinkedinURL.contains("linkedin.com"));
	}
	
	@Test (priority = 5)
	public void verifyYouTubeLinkTest() {
		String actualYouTubeURL = homePagePom.verifyYouTubeLink();
		String expctedYouTubeURL ="https://www.youtube.com/channel/UCSoIdbOJxMmgPe1cm_L6nww";
		Assert.assertEquals(actualYouTubeURL, expctedYouTubeURL);
	}
	
	@Test
	public void test() {
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
