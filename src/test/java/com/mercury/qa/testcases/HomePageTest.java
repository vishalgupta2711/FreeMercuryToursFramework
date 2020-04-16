package com.mercury.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.ContactPage;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.IteneraryPage;
import com.mercury.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	IteneraryPage iteneraryPage;
	ContactPage contactPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		iteneraryPage = new IteneraryPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Find a Flight: Mercury Tours:","if assertion getting failed"
				+ "this message will be displayed");
	}
	
	@Test(priority = 2)
	public void verifyCorrectImageLabelTest() {
		Assert.assertTrue(homePage.verifyCorrectImageLabel());
	}
	
	@Test(priority = 3)
	public void clickOnIteneraryLinkTest() {
		iteneraryPage = homePage.clickOnIteneraryLink();
	}
	
	/*
	public void selectXpathByTextTest() {
		homePage.selectXpathByText("CONTACT");
		homePage.selectXpathByText("ITINERARY");
		homePage.selectXpathByText("PROFILE");
	}
	
*/	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
