package com.mercury.qa.testcases;
/*
 * 
 * Author - Vishal Gupta
 * 
 */
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.ContactPage;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactPage contactPage;
	
	public ContactPageTest() {
		super();
	}
	
	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactPage = homePage.clickOnContactLink();
	}
	
	@Test(priority = 1)
	public void verifyBackToHomeImgTest() {
		Assert.assertTrue(contactPage.verifyBackToHomeImg());
	}
	
	@Test(priority = 2)
	public void verifyFooterLabelTest() {
		Assert.assertTrue(contactPage.verifyFooterLabel());
	}
	
	@Test (priority = 3)
	public void verifyClickOnbackToHomeBtnTest() {
		loginPage = contactPage.verifyClickOnbackToHomeBtn();
	}
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
