package com.mercury.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.qa.base.TestBase;
import com.mercury.qa.pages.HomePage;
import com.mercury.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		
		// This super() keyword will call the constructor of the base class which is 'TestBase'
		super();
	}
	
	@BeforeMethod
	
	public void setUp() {
		// This will call initialization() method from the base class but initialization() method
		//in the base class contains getProperty() method so to avoid the compiler to throw null pointer 
		//exception we have @Nullabledesigned the above constructor and called the base class constructor 
		//through super() keyword.
		initialization();
		//here we are creating object of LoginPage class
		loginPage = new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Welcome: Mercury Tours");
	}
	
	@Test(priority = 2)
	public void mercuryImageLogoTest() {
		boolean flag = loginPage.validateMercuryLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() {
		//HomePage homePage = new HomePage(); // same as return New HomePage() which is written in LoginPage.java class
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
