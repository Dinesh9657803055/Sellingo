package com.sellingo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom_Pages.Home_Page_POM;
import report.ExtentManager;
import test_utility.ReusableMethods;


public class TC001_HomePageTest extends BeforeAfterMethods {
	Home_Page_POM homePagePom ;
	
	@BeforeClass
	public void setUp() {
		homePagePom  = new Home_Page_POM();
	}
	
	public List<String> expectedHeader () throws EncryptedDocumentException, Throwable {
		List<String> expectedHeaderList = new ArrayList<String>();
		expectedHeaderList.add(ReusableMethods.ExcellDataFetching(2, 1));
		expectedHeaderList.add(ReusableMethods.ExcellDataFetching(3, 1));
		expectedHeaderList.add( ReusableMethods.ExcellDataFetching(4, 1));
		expectedHeaderList.add(ReusableMethods.ExcellDataFetching(5, 1));
		expectedHeaderList.add(ReusableMethods.ExcellDataFetching(6, 1));
		expectedHeaderList.add( ReusableMethods.ExcellDataFetching(7, 1));
		return expectedHeaderList;
	}

	public HashMap<String, String> expectedSlideTitleAndSubtitle() throws EncryptedDocumentException, Throwable {
		HashMap<String, String> hMap = new HashMap<String, String>();
		hMap.put(ReusableMethods.ExcellDataFetching(8, 1), ReusableMethods.ExcellDataFetching(13, 1));
		hMap.put(ReusableMethods.ExcellDataFetching(9, 1), ReusableMethods.ExcellDataFetching(14, 1));
		hMap.put(ReusableMethods.ExcellDataFetching(10, 1), ReusableMethods.ExcellDataFetching(15, 1));
		hMap.put(ReusableMethods.ExcellDataFetching(11, 1), ReusableMethods.ExcellDataFetching(16, 1));
		hMap.put(ReusableMethods.ExcellDataFetching(12, 1), ReusableMethods.ExcellDataFetching(17, 1));	
		return hMap;
	}

	@Test(priority = 1)
	public void TC001_SC001_verifyHomePageText() throws EncryptedDocumentException, Throwable {
		List<String> actualMenuList =  homePagePom.headerMenuList();
		List<String> expectedMenuList = expectedHeader();		
		Assert.assertEquals(actualMenuList, expectedMenuList);
		String actualRegiterText= homePagePom.registerText();
		String expectedRegiterText = ReusableMethods.ExcellDataFetching(18, 1);
		Assert.assertEquals(actualRegiterText, expectedRegiterText);
		ExtentManager.onTestPass("Verified Succesfully Register Text"); // insert message here for perticular task
		String actualLoginText= homePagePom.loginText();
		String expectedLoginText = ReusableMethods.ExcellDataFetching(19, 1);
		Assert.assertEquals(actualLoginText, expectedLoginText);
		ExtentManager.onTestPass("Verified Succesfully Login Text");
	}

	@Test (priority = 2)
	public void TC001_SC002_verifySlides() throws EncryptedDocumentException, Throwable {
		HashMap<String, String> actualSlides = homePagePom.verifySlide();
		HashMap<String, String>	expectedSlides = expectedSlideTitleAndSubtitle();	
		Assert.assertEquals(actualSlides, expectedSlides);
		ExtentManager.onTestPass("Successfully Verified Slides Tile and SubTile as well as Slides are sliding ");
	}

	@Test (priority = 3)
	public void TC001_SC003verifyFacebookLinkTest() throws EncryptedDocumentException, Throwable {
		String actualFacebookURL = homePagePom.verifyFacebookLink();
		String expectedFacebookURL =ReusableMethods.ExcellDataFetching(20, 1);
		Assert.assertEquals(actualFacebookURL, expectedFacebookURL);
		ExtentManager.onTestPass("Verified Facebook Link is working fine");
	}

	@Test (priority = 4)
	public void TC001_SC004_verifyTwitterLinkTest() throws EncryptedDocumentException, Throwable {
		String actualTwitterURL = homePagePom.verifyTwitterLink();	
		Assert.assertTrue(actualTwitterURL.contains(ReusableMethods.ExcellDataFetching(21, 1)));	
		ExtentManager.onTestPass("Verified Twitter Link is working fine");
	}

	@Test (priority = 5)
	public void TC001_SC005_verifyInstagramLinkTest() throws EncryptedDocumentException, Throwable {
		String actualInstagramURL=homePagePom.verifyInstagramLink();
		String expectedInstagramURL =  ReusableMethods.ExcellDataFetching(22, 1);
		Assert.assertEquals(actualInstagramURL, expectedInstagramURL);
		ExtentManager.onTestPass("Verified Instagram Link is working fine");
	}

	@Test (priority = 6)
	public void TC001_SC006_verifyLinkedinLinkTest() throws EncryptedDocumentException, Throwable {
		String actualLinkedinURL= homePagePom.verifyLinkedinLink();
		Assert.assertTrue(actualLinkedinURL.contains(ReusableMethods.ExcellDataFetching(23, 1)));
		ExtentManager.onTestPass("Verified LinkedIn Link is working fine");
	}

	@Test (priority = 7)
	public void TC001_SC007_verifyYouTubeLinkTest() throws EncryptedDocumentException, Throwable {
		String actualYouTubeURL = homePagePom.verifyYouTubeLink();
		String expctedYouTubeURL =ReusableMethods.ExcellDataFetching(24, 1);
		Assert.assertEquals(actualYouTubeURL, expctedYouTubeURL);
		ExtentManager.onTestPass("Verified Youtube Link is working fine");
	}
}
